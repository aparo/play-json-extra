// test file without imports to avoid regressions with missing imports in macros
sealed trait Modifier
case object early extends Modifier
case object mid extends Modifier
case object late extends Modifier
final case class Foo(i: Int)
object a{
  import play.json.extra.SingletonEncoder.simpleName
  import play.json.extra.implicits.formatSingleton
  implicit def jsonFormat = play.json.extra.Jsonx.formatSealed[Modifier]
  implicit def jsonFormat2 = play.json.extra.Jsonx.formatCaseClass[Foo]
  implicit def jsonFormat3 = play.json.extra.Jsonx.formatInline[Foo]
}
object b{  
  implicit def jsonFormat4 = play.json.extra.Jsonx.formatAuto[Foo]
}
