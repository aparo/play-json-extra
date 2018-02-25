package play.json.extra

import org.scalatest.FunSuite

import play.api.libs.json._

case class RecursiveClass(o: Option[RecursiveClass], s:String)
object RecursiveClass{
  import implicits.optionWithNull
  implicit def jsonFormat: Format[RecursiveClass] = Jsonx.formatCaseClass[RecursiveClass]   
}
sealed trait RecursiveAdt
case class RecursiveChild(o: Option[RecursiveAdt], s:String) extends RecursiveAdt
object RecursiveFormat{
  import implicits.optionWithNull
  implicit def jsonFormat: Format[RecursiveAdt] = Jsonx.formatSealed[RecursiveAdt]
  implicit def jsonFormat2: Format[RecursiveChild] = Jsonx.formatCaseClass[RecursiveChild]   
}
object Adt{
  sealed trait SomeAdt
  case object ChoiceA extends SomeAdt
  case object ChoiceB extends SomeAdt
  case object `Choice.C` extends SomeAdt
  case class X(i: Int, s: String) extends SomeAdt
  object X{
    implicit def jsonFormat = Jsonx.formatCaseClass[X]
  }
  case class Y(i: Int, s: String) extends SomeAdt
  object Y{
    implicit def jsonFormat = Jsonx.formatCaseClass[Y]
    def apply = "making sure overloaded apply doesn't break"
  }
}
object AdtWithEmptyLeafs{
  sealed trait SomeAdt
  case class A() extends SomeAdt
  object A{
    implicit def jsonFormat = Jsonx.formatCaseClass[A]
  }
  case class B() extends SomeAdt
  object B{
    implicit def jsonFormat = Jsonx.formatCaseClass[B]
  }
}

sealed trait SealedTrait
case class CaseClassChild(i: Int) extends SealedTrait

object FailureTest{
  import implicits.optionWithNull
  import org.scalatest.Assertions._
  type AbstractType
  implicit val childFormat = Jsonx.formatCaseClass[CaseClassChild]
  Jsonx.formatSealed[SealedTrait]
  assertTypeError("Jsonx.formatSealed[Foo#X]")
}

sealed trait OP
case class Ua(i: Int) extends OP
case class Unknown(json: JsValue) extends OP
case class Uzzzzzzz(s: String) extends OP

class PlayJsonExtensionsTest extends FunSuite{
  import implicits.optionWithNull
  test("de/serialize case class > 22"){
    case class Bar(a: Int, b:Float)
    case class Foo(_1:Bar,_2:String,_3:Int,_4:Int,_5:Int,_21:Int,_22:Int,_23:Int,_24:Int,_25:Int,_31:Int,_32:Int,_33:Int,_34:Int,_35:Int,_41:Int,_42:Int,_43:Int,_44:Int,_45:Int,_51:Int,_52:Int,_53:Int,_54:Int,_55:Int)
    val foo = Foo(Bar(5,1.0f),"sdf",3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5)
    implicit def fmt1 = Jsonx.formatCaseClass[Bar]
    implicit def fmt2 = Jsonx.formatCaseClass[Foo]
    val json = Json.toJson( foo )
    assert(foo === json.as[Foo])
  }
  test("de/serialize empty case class"){
    case class Bar()
    implicit def fmt1 = Jsonx.formatCaseClass[Bar]
    val bar = Bar()
    val json = Json.toJson( bar )
    assert(bar === json.as[Bar])
  }
  case class BarWithDefault(s: String, i: Int = 6)
  test("de/serialize case class default value"){
    implicit def fmt1 = Jsonx.formatCaseClassUseDefaults[BarWithDefault]
    assert(BarWithDefault("asd",6) === Json.parse("""{"s":"asd"}""").validate[BarWithDefault].get)
  }
  test("don't de/serialize case class default value by default"){
    implicit def fmt1 = Jsonx.formatCaseClass[BarWithDefault]
    assert(Json.parse("""{"s":"asd"}""").validate[BarWithDefault].isInstanceOf[JsError])
  }
  test("formatCaseClass with explicit return type"){
    case class Bar()
    implicit def fmt1: Format[Bar] = Jsonx.formatCaseClass[Bar]
    val bar = Bar()
    val json = Json.toJson( bar )
    assert(bar === json.as[Bar])
  }
  test("serializing None skips fields"){
    // note, using null for a Scala String doesn't work with play Json
    case class Bar(a: Option[String], b: String, d: Option[String])
    val bar = Bar(None,"foo",Some("foo"))
    implicit def fmt1 = Jsonx.formatCaseClass[Bar]
    val json = Json.parse(Json.stringify( // <- otherwise c = JsString(null), not JsNull
      Json.toJson(bar)
    ))
    assert(bar === json.validate[Bar].get)
    assert(
      Set("b"->JsString("foo"), "d"->JsString("foo"))
      === json.as[JsObject].fields.toSet
    )
  }
  test("require to JsError"){
    // note, using null for a Scala String doesn't work with play Json
    case class Bar(a: Int){
      require(a > 5, "a needs to be larger than 5")
    }
    case class Baz(bar: Bar)
    implicit def fmt1 = Jsonx.formatCaseClass[Bar]
    implicit def fmt2 = Jsonx.formatCaseClass[Baz]
    assert(Baz(Bar(6)) === Json.parse("""{"bar":{"a":6}}""").validate[Baz].get)
    val capturedFailedRequire = Json.parse("""{"bar":{"a":5}}""").validate[Baz]
    assert(
      capturedFailedRequire.asInstanceOf[JsError].errors.head._2.head.message contains "requirement failed: a needs to be larger than 5"
    )
    assert(
      capturedFailedRequire.asInstanceOf[JsError].errors.head._1.toString === "/bar"
    )
  }
  test("serialize Adt"){
    import Adt._
    implicit def simpleName = SingletonEncoder.simpleName
    import implicits.formatSingleton
    implicit val jsonFormat = Jsonx.formatSealed[SomeAdt]
    val a: SomeAdt = ChoiceA
    val b: SomeAdt = ChoiceB
    val c: SomeAdt = `Choice.C`
    val x = X(99,"Chris")
    val y = Y(99,"Chris")
    assert("ChoiceA" === Json.toJson(ChoiceA).as[JsString].value)
    assert("ChoiceB" === Json.toJson(ChoiceB).as[JsString].value)
    assert("Choice.C" === Json.toJson(`Choice.C`).as[JsString].value)
    assert("ChoiceA" === Json.toJson(a).as[JsString].value)
    assert("ChoiceB" === Json.toJson(b).as[JsString].value)
    assert("Choice.C" === Json.toJson(c).as[JsString].value)

    assert(x !== y)
    assert(ChoiceA === Json.fromJson[SomeAdt](Json.toJson(ChoiceA)).get)
    assert(ChoiceB === Json.fromJson[SomeAdt](Json.toJson(ChoiceB)).get)
    assert(`Choice.C` === Json.fromJson[SomeAdt](Json.toJson(`Choice.C`)).get)

    /* disabling tests for ambiguity, not supported at the moment
    assert(x === Json.fromJson[SomeAdt](Json.toJson[SomeAdt](x)).get)
    assert(y === Json.fromJson[SomeAdt](Json.toJson[SomeAdt](y)).get)
    assert(x === Json.fromJson[SomeAdt](Json.toJson(x)).get)
    assert(y === Json.fromJson[SomeAdt](Json.toJson(y)).get)
    */
  }
  test("serialize Adt with empty leafs"){
    import AdtWithEmptyLeafs._
    implicit val jsonFormat = Jsonx.formatSealed[SomeAdt]
    val x = A()
    val y = B()
    /* disabling tests for ambiguity, not supported at the moment
    assert(x === Json.fromJson[SomeAdt](Json.toJson[SomeAdt](x)).get)
    assert(y === Json.fromJson[SomeAdt](Json.toJson[SomeAdt](y)).get)
    assert(x === Json.fromJson[SomeAdt](Json.toJson(x)).get)
    assert(y === Json.fromJson[SomeAdt](Json.toJson(y)).get)
    */
  }
  test("serialize Adt with fallback"){
    implicit val OPFormat: Format[OP] = {
      implicit val UaFormat: Format[Ua] = Jsonx.formatCaseClass[Ua]
      implicit val UnknownFormat: Format[Unknown] = Jsonx.formatInline[Unknown]
      implicit val UzzzzzzzFormat: Format[Uzzzzzzz] = Jsonx.formatCaseClass[Uzzzzzzz]
      Jsonx.formatSealedWithFallback[OP,Unknown]
    }
    assert(JsSuccess(Ua(5)) === Json.fromJson[OP](Json.parse(""" {"i":5} """)))
    assert(JsSuccess(Uzzzzzzz("x")) === Json.fromJson[OP](Json.parse(""" {"s":"x"} """)))
    val json = """{"foo": "asdf"}"""
    assert(JsSuccess(Unknown(Json.parse(json))) === Json.fromJson[OP](Json.parse(json)))
  }
  test("serialize recursive class"){
    val x = RecursiveClass(Some(RecursiveClass(Some(RecursiveClass(None,"c")),"b")),"a")
    val json = Json.toJson[RecursiveClass](x)(implicitly[Format[RecursiveClass]])
    val res = Json.fromJson[RecursiveClass](json)(implicitly[Format[RecursiveClass]])
    assert(x === res.get)
  }
  test("serialize recursive child"){
    import RecursiveFormat._
    val x = RecursiveChild(Some(RecursiveChild(Some(RecursiveChild(None,"c")),"b")),"a")
    val json = Json.toJson[RecursiveChild](x)(implicitly[Format[RecursiveChild]])
    val res = Json.fromJson[RecursiveChild](json)(implicitly[Format[RecursiveChild]])
    assert(x === res.get)
  }
  test("serialize recursive Adt"){
    import RecursiveFormat._
    val x = RecursiveChild(Some(RecursiveChild(Some(RecursiveChild(None,"c")),"b")),"a")
    val json = Json.toJson[RecursiveAdt](x)(implicitly[Format[RecursiveAdt]])
    val res = Json.fromJson[RecursiveAdt](json)(implicitly[Format[RecursiveAdt]])
    assert(x === res.get)
  }
  test("deserialize case class error messages"){
    val json = Json.parse("""{"i":"test"}""")
    val res = Json.fromJson[Adt.X](json)
    res match {
      case JsError(_errors) =>
        val errors = _errors.map{case (k,v) => (k.toString,v)}.toMap
        assert(
          2 === _errors.size
        )
        assert(
          "error.expected.jsnumber" === errors("/i").head.message
        )
        assert(
          "error.path.missing" === errors("/s").head.message
        )
      case _ => assert(false)
    }
  }
  test("deserialize tuple"){
    val json = Json.parse("""[1,1.0,"Test"]""")
    val res = Json.fromJson[(Int,Double,String)](json)
    assert((1,1.0,"Test") === res.get)
    assert((1,1.0,"Test") === Json.toJson(res.get).validate[(Int,Double,String)].get)
  }
  test("deserialize tuple wrong size"){
    case class Foo(bar: (Int,Double,String))
    implicit def jsonFoo = Jsonx.formatCaseClass[Foo]
    val json = Json.parse("""{"bar": [1,1.1]}""")
    val res = Json.fromJson[Foo](json)
    res match {
      case JsError(_errors) =>
        val errors = _errors.map{case (k,v) => (k.toString,v)}.toMap
        assert(
          "Expected array of 3 elements" === errors("/bar").head.message
        )
      case _ => assert(false)
    }
  }
}

abstract class JsonTestClasses{
  implicit def option[A](implicit reads: Reads[A]): Reads[Option[A]]
  case class A(s: String)
  object A{ implicit def jsonFormat = Jsonx.formatCaseClass[A] }
  case class B(s: Option[String])
  object B{ implicit def jsonFormat = Jsonx.formatCaseClass[B] }
  case class C(i: Int, b: Option[B])
  object C{ implicit def jsonFormat = Jsonx.formatCaseClass[C] }
  case class A2(s: String)
  object A2{ implicit def jsonFormat = Json.format[A2] }
  case class B2(s: Option[String])
  object B2{ implicit def jsonFormat = Json.format[B2] }
  case class C2(i: Int, b: Option[B2])
  object C2{ implicit def jsonFormat = Json.format[C2] }

  case class Mandatory(s: List[String])
  object Mandatory{ implicit def jsonFormat = Jsonx.formatCaseClass[Mandatory] }
  case class Optional(o: Option[Mandatory])
  object Optional{ implicit def jsonFormat = Jsonx.formatCaseClass[Optional] }

  case class Mandatory2(s: List[String])
  object Mandatory2{ implicit def jsonFormat = Jsonx.formatCaseClass[Mandatory2] }
  case class Optional2(o: Option[Mandatory2])
  object Optional2{ implicit def jsonFormat = Jsonx.formatCaseClass[Optional2] }

  case class ListInner(string: String)
  object ListInner{ implicit def jsonFormat = Jsonx.formatCaseClass[ListInner] }
  case class ListOuter(inner: List[ListInner])
  object ListOuter{ implicit def jsonFormat = Jsonx.formatCaseClass[ListOuter] }
  case class ClassOuter(outer: List[ListOuter])
  object ClassOuter{ implicit def jsonFormat = Jsonx.formatCaseClass[ClassOuter] }

  case class ListInner2(string: String)
  object ListInner2{ implicit def jsonFormat = Jsonx.formatCaseClass[ListInner2] }
  case class ListOuter2(inner: List[ListInner2])
  object ListOuter2{ implicit def jsonFormat = Jsonx.formatCaseClass[ListOuter2] }
  case class ClassOuter2(outer: List[ListOuter2])
  object ClassOuter2{ implicit def jsonFormat = Jsonx.formatCaseClass[ClassOuter2] }
}

class Bar(val i: Int) extends AnyVal
