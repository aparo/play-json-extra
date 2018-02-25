package play.json.extra

import scala.annotation.StaticAnnotation
import scala.collection.mutable.ListBuffer
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

class JsonFormat() extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro JsonFormatMacro.jsonFormat
}

object JsonFormatMacro {

  import MacroCommons._

  def jsonFormat(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._
    import Flag._

    class ModDesc(var mods: Modifiers,
                  name: TermName,
                  var parents: List[Tree],
                  self: ValDef,
                  body: List[Tree],
                  var esArguments: Map[String, Any]) {
      val extraMethods: ListBuffer[Tree] = ListBuffer()

      def getTree: Tree =
        ModuleDef(
            mods,
            name,
            Template(
                parents,
                self,
                q"""import play.json.extra.implicits.optionWithNull"""
                  .asInstanceOf[Tree] ::
                  q"""import play.api.libs.json._ ;// JSON library"""
                    .asInstanceOf[Tree] ::
                    q"""import play.api.libs.json.Reads._ ; // Custom validation helpers"""
                      .asInstanceOf[Tree] ::
                      q"""import play.api.libs.functional.syntax._ ; // Combinator syntax"""
                        .asInstanceOf[Tree] ::
                        body ++ extraMethods))

      def addMethod(tree: Tree) = {
        extraMethods += tree
      }

      def existsImplicit(name: String): Boolean =
        body.exists {
          case ValDef(_, nameDef, _, _)
              if nameDef.decodedName.toString == name =>
            true
          case _ => false
        }

    }

    object ModDesc {
      def apply(tree: Tree, esArguments: Map[String, Any]): ModDesc = {
        tree match {
          case ModuleDef(mods, name, Template(parents, self, body)) =>
            new ModDesc(mods,
                        name,
                        parents,
                        self,
                        body,
                        esArguments = esArguments)
        }
      }
    }

    def jsonNamespace(name: String): Tree = {
      Select(Ident(TermName("play.api.libs.json")), TypeName(name))
    }

    def getFields(body: List[Tree]): List[FldDesc] =
      body.flatMap {
        case DefDef(mods, name, tparams, vparamss, tpt, rhs)
            if name.decodedName.toString == "<init>" =>
          vparamss.head.map(f => FldDesc(f)).toList
        case _ => None
      }
    class FldDesc(val name: String,
                  val fullTypeName: String,
                  val typeName: String,
                  val typeTree: Tree,
                  val cls: Option[ClsDesc],
                  val tree: Tree,
                  val default: Tree,
                  val annotations: List[Tree],
                  val foreignType: Option[String] = None,
                  val key: Option[String] = None) {
      var isOption = false
      var isMultiple = false
      var multipleType = ""

      internalType

      lazy val internalType: Tree = typeTree match {
        case AppliedTypeTree(Ident(option), tpe :: Nil)
            if option.decodedName.toString == "Option" =>
          isOption = true
          tpe
        case AppliedTypeTree(Ident(list), tpe :: Nil)
            if multipleClasses.contains(list.decodedName.toString) =>
          isMultiple = true
          multipleType = list.decodedName.toString
          tpe

        case _ => typeTree
      }

      val fieldName = Literal(Constant(key.getOrElse(name)))

      def getReads(recursiveName: String, recursiveBuilder: String): Tree = {
        //        println(s"$isMultiple $multipleType $recursiveName $recursiveBuilder $typeName")

        if (isOption) {
          return q"""(__ \ $fieldName).readNullable[$internalType]"""
        }
        if (recursiveName == internalType.toString()) {
          val recursiveBuilderTerm = TermName(recursiveBuilder)

          if (isMultiple) {
            if (multipleType.toLowerCase == "list")
              return q"""(__ \ $fieldName).lazyRead(Reads.list[$internalType]($recursiveBuilderTerm))"""
            if (multipleType.toLowerCase == "seq")
              return q"""(__ \ $fieldName).lazyRead(Reads.seq[$internalType]($recursiveBuilderTerm))"""
            if (multipleType.toLowerCase == "set")
              return q"""(__ \ $fieldName).lazyRead(Reads.set[$internalType]($recursiveBuilderTerm))"""

          } else {
            return q"""(__ \ $fieldName).lazyRead[$internalType]($recursiveBuilderTerm)"""
          }
        }

        q"""(__ \  $fieldName).read[$typeTree]"""
      }

      def getWrites(recursiveName: String, recursiveBuilder: String): Tree = {
        if (isOption) {
          return q"""(__ \  $fieldName).writeNullable[$internalType]"""
        }
        if (recursiveName == internalType.toString()) {
          val recursiveBuilderTerm = TermName(recursiveBuilder)

          if (isMultiple) {
            val typeLow = multipleType.toLowerCase

            typeLow match {
              case "list" =>
                return q"""(__ \ $fieldName).lazyWrite(Writes.list[$internalType]($recursiveBuilderTerm))"""
              case "seq" =>
                return q"""(__ \ $fieldName).lazyWrite(Writes.seq[$internalType]($recursiveBuilderTerm))"""
              case "set" =>
                return q"""(__ \ $fieldName).lazyWrite(Writes.set[$internalType]($recursiveBuilderTerm))"""

            }
          } else {
            return q"""(__ \ $fieldName).lazyWrite[$internalType]($recursiveBuilderTerm)"""
          }
        }

        q"""(__ \  $fieldName).write[$typeTree]"""
      }

    }

    object FldDesc {
      def apply(fieldTree: Tree) = {
        val ValDef(mod, name, tpt, rhs) = fieldTree
        val defaultValue: Tree = q"""None"""
        def buildTypeName(tree: Tree): String = {
          tree match {
            case Select(subtree, name) =>
              buildTypeName(subtree) + "." + name.decodedName.toString
            case AppliedTypeTree(subtree, args) =>
              buildTypeName(subtree) + "[" + args
                .map(it => buildTypeName(it))
                .mkString(",") + "]"
            case Ident(x) =>
              x.decodedName.toString
            case other => other.toString
          }
        }
        val fullTypeName: String = buildTypeName(tpt)
        val typeName = fullTypeName
        val clsDesc: Option[ClsDesc] = None

        var key: Option[String] = None
        mod.annotations.foreach {
          case Apply(Select(New(Ident(index)), _),
                     List(Literal(Constant(unique)))) =>
            //if (index.toString == "Parent") parent = Some(ParentMeta(unique.toString, name.decodedName.toString))
            //              println(s"$index $unique")

            if (index.toString == "key") key = Some(unique.toString)
          case extra =>
          //println(s"annotation extra: ${showRaw(extra)}")
        }

        new FldDesc(name.decodedName.toString,
                    fullTypeName,
                    typeName,
                    tpt,
                    clsDesc,
                    fieldTree,
                    defaultValue,
                    mod.annotations,
                    key = key)
      }
    }

    class ClsDesc(val mods: Modifiers,
                  val name: TypeName,
                  types: List[TypeDef],
                  var parents: List[Tree],
                  self: ValDef,
                  var body: List[Tree],
                  esArguments: Map[String, Any]) {
      val objectName = TermName(name.decodedName.toString)
      val extraMethods: ListBuffer[Tree] = ListBuffer()
      val fields = getFields(body)

      def getTree: Tree =
        ClassDef(mods,
                 name,
                 types,
                 Template(parents, self, body ++ extraMethods))

      def addMethod(tree: Tree) = {
        extraMethods += tree
      }
    }

    object ClsDesc {
      def apply(tree: Tree, esArguments: Map[String, Any]) = {
        val ClassDef(mods, name, types, Template(parents, self, body)) = tree
        if (!mods.hasFlag(CASE))
          c.abort(
              c.enclosingPosition,
              s"Only case classes allowed here ${name.decodedName.toString}")
        val annotations = mods.annotations.map(_.children.head.toString)
        val result = new ClsDesc(mods,
                                 name,
                                 types,
                                 parents,
                                 self,
                                 body,
                                 esArguments = esArguments)
        result
      }
    }

    def typeToType(myType: String): Tree = {
      if (myType.contains("[")) {
        val operator = myType.split("\\[")(0)
        val remainer = myType.split("\\[")(1).stripSuffix("]")
        return AppliedTypeTree(
            Ident(TypeName(operator)),
            remainer.split(",").map(a => typeToType(a.trim)).toList)
      }
      val tokens = myType.split("\\.")
      if (tokens.length == 1)
        return Ident(TypeName(tokens.head))

      var tree: Tree = Ident(TermName(tokens.head))
      tokens.tail.foreach { name =>
        if (name == tokens.last)
          tree = Select(tree, TypeName(name))
        else
          tree = Select(tree, TermName(name))
      }
      tree
    }

    class ClsModClass(cls: ClsDesc, mod: ModDesc, arguments: Map[String, Any]) {
      def getTrees: List[Tree] = List(cls.getTree, mod.getTree)

      def inject = {

        val typeName = cls.name
        val varTypeName = cls.name.decodedName.toString
            .take(1)
            .toLowerCase + cls.name.decodedName.toString.drop(1)

        val formatName = varTypeName + "Format"

        if (!mod.existsImplicit("jsonFmt")) {

          mod.addMethod(q"""import play.json.extra._;""")
          mod.addMethod(q"""import play.json.extra.tuples._;""")
          mod.addMethod(
              q"""implicit def jsonFmt: play.api.libs.json.Format[${typeToType(
              typeName.toString)}] = Jsonx.formatCaseClassUseDefaults[${typeToType(
              typeName.toString)}];""")
        }

      }
    }

    object ClsModClass {
      def apply(cls: Option[ClsDesc] = None,
                mod: Option[ModDesc] = None,
                arguments: Map[String, Any]): ClsModClass = {
        var module = mod
        if (module.isEmpty) {
          val className = TermName(cls.get.name.decodedName.toString)

          module = Some(q"""object $className {}""" match {
            case ModuleDef(mods, name, Template(parents, self, body)) =>
              new ModDesc(mods, name, Nil, self, body, esArguments = arguments)
          })
        }

        new ClsModClass(cls.get, module.get, arguments)
      }
    }

    var myClass: Option[ClsDesc] = None
    var myModule: Option[ModDesc] = None
    val arguments = extractArguments(c)
    annottees.map(_.tree).toList.foreach {
      case it @ ModuleDef(mods, name, Template(parents, self, body)) =>
        myModule = Some(ModDesc(it, arguments))
      case it @ ClassDef(mods, name, types, Template(parents, self, body)) =>
        myClass = Some(ClsDesc(it, arguments))
    }

    val esObject = ClsModClass(myClass, myModule, arguments = arguments)
    esObject.inject
//        esObject.getTrees.foreach(println)
    c.Expr[Any](Block(esObject.getTrees, Literal(Constant(()))))
  }

  private def extractArguments(c: Context): Map[String, Any] = {
    import c.universe._
    var result: Map[String, Any] = Map.empty

    c.prefix.tree.foreach {
      case Apply(_, values) =>
        values.foreach {
          case AssignOrNamedArg(Ident(ident), Literal(Constant(v))) =>
            result += (ident.decodedName.toString -> v)
        }
      case _ =>
    }
    result
  }

}
