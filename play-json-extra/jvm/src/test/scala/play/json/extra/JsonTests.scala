package play.json.extra

import org.scalatest.FunSuite
import play.api.libs.json._

class JsonTests extends FunSuite{
  test("json optionWithNull"){
    object JsonTestClasses extends JsonTestClasses{
      implicit def option[A](implicit reads: Reads[A]): Reads[Option[A]] = implicits.optionWithNull[A]
    }
    import JsonTestClasses._

    assert((Json.parse("""{}""") \ "s").validate[Option[String]].isInstanceOf[JsError])
    assert(Some("foo") === (Json.parse("""{"s": "foo"}""") \ "s").validate[Option[String]].get)
    assert(None === (Json.parse("""{}""") \ "s").validateOpt[String].get)
    assert(Some("foo") === (Json.parse("""{"s": "foo"}""") \ "s").validateOpt[String].get)
    assert(None === (Json.parse("""{}""") \ "s").validateAuto[Option[String]].get)
    assert(Some("foo") === (Json.parse("""{"s": "foo"}""") \ "s").validateAuto[Option[String]].get)

    assert(Json.fromJson[Option[String]](Json.parse("""5""")).isInstanceOf[JsError])
    assert(Json.fromJson[Option[String]](Json.parse("""{}""")).isInstanceOf[JsError])

    assert(Json.fromJson[B](Json.parse("""{"s": {}}""")).isInstanceOf[JsError])

    assert(A("foo") ===  Json.fromJson[A](Json.parse("""{"s": "foo"}""")).get)
    assert(B(Some("foo")) === Json.fromJson[B](Json.parse("""{"s": "foo"}""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""{"s": null}""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""{}""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""5""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""null""")).get)

    assert(Json.fromJson[B](Json.parse("""{"s": {}}""")).isInstanceOf[JsError])
    assert(A2("foo") === Json.fromJson[A2](Json.parse("""{"s": "foo"}""")).get)
    assert(B2(Some("foo")) === Json.fromJson[B2](Json.parse("""{"s": "foo"}""")).get)
    assert(B2(None) === Json.fromJson[B2](Json.parse("""{"s": null}""")).get)
    assert(B2(None) === Json.fromJson[B2](Json.parse("""{}""")).get)
//    assert(B2(None) === Json.fromJson[B2](Json.parse("""null""")).get)
//    assert(B2(None) === Json.fromJson[B2](Json.parse("""5""")).get)

    assert(Optional(None) === Json.fromJson[Optional](Json.parse("""{}""")).get)
    assert(Optional(Some(Mandatory(List("test")))) === Json.fromJson[Optional](Json.parse("""{"o":{"s":["test"]}}""")).get)
    assert(Json.parse("""{"o":{}}""").validate[Optional].isInstanceOf[JsError])

    assert(Optional2(None) === Json.fromJson[Optional2](Json.parse("""{}""")).get)
    assert(Optional2(Some(Mandatory2(List("test")))) === Json.fromJson[Optional2](Json.parse("""{"o":{"s":["test"]}}""")).get)
    assert(Json.parse("""{"o":{}}""").validate[Optional2].isInstanceOf[JsError])

    assert(ClassOuter(Nil) === Json.fromJson[ClassOuter](Json.parse("""{"outer": []}""")).get)
    assert(ClassOuter2(Nil) === Json.fromJson[ClassOuter2](Json.parse("""{"outer": []}""")).get)
  }

  test("json optionNoError"){
    object JsonTestClasses extends JsonTestClasses{
      implicit def option[A](implicit reads: Reads[A]): Reads[Option[A]] = implicits.optionNoError[A]
    }
    import JsonTestClasses._

    assert((Json.parse("""{}""") \ "s").validate[Option[String]].isInstanceOf[JsError])
    assert(Some("foo") === (Json.parse("""{"s": "foo"}""") \ "s").validate[Option[String]].get)
    assert(None === (Json.parse("""{}""") \ "s").validateOpt[String].get)
    assert(Some("foo") === (Json.parse("""{"s": "foo"}""") \ "s").validateOpt[String].get)
    assert(None === (Json.parse("""{}""") \ "s").validateAuto[Option[String]].get)
    assert(Some("foo") === (Json.parse("""{"s": "foo"}""") \ "s").validateAuto[Option[String]].get)

    assert(None === Json.fromJson[Option[String]](Json.parse("""5""")).get)
    assert(None === Json.fromJson[Option[String]](Json.parse("""{}""")).get)

    assert(Json.fromJson[B](Json.parse("""{"s": {}}""")).isInstanceOf[JsError])
    assert(A("foo") === Json.fromJson[A](Json.parse("""{"s": "foo"}""")).get)
    assert(B(Some("foo")) === Json.fromJson[B](Json.parse("""{"s": "foo"}""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""{"s": null}""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""{}""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""5""")).get)
    assert(B(None) === Json.fromJson[B](Json.parse("""null""")).get)

    assert(Json.fromJson[B2](Json.parse("""{"s": {}}""")).isInstanceOf[JsError])
    assert(A2("foo") === Json.fromJson[A2](Json.parse("""{"s": "foo"}""")).get)
    assert(B2(Some("foo")) === Json.fromJson[B2](Json.parse("""{"s": "foo"}""")).get)
    assert(B2(None) === Json.fromJson[B2](Json.parse("""{"s": null}""")).get)
    assert(B2(None) === Json.fromJson[B2](Json.parse("""{}""")).get)
//    assert(B2(None) === Json.fromJson[B2](Json.parse("""5""")).get)
//    assert(B2(None) === Json.fromJson[B2](Json.parse("""null""")).get)

    assert(Optional(None) === Json.fromJson[Optional](Json.parse("""{}""")).get)
    assert(Optional(Some(Mandatory(List("test")))) === Json.fromJson[Optional](Json.parse("""{"o":{"s":["test"]}}""")).get)
    assert(Json.fromJson[Optional](Json.parse("""{"o":{}}""")).isInstanceOf[JsError])

    assert(Optional2(None) === Json.fromJson[Optional2](Json.parse("""{}""")).get)
    assert(Optional2(Some(Mandatory2(List("test")))) === Json.fromJson[Optional2](Json.parse("""{"o":{"s":["test"]}}""")).get)
    assert(Json.parse("""{"o":{}}""").validate[Optional2].isInstanceOf[JsError])

    assert(ClassOuter(Nil) === Json.fromJson[ClassOuter](Json.parse("""{"outer": []}""")).get)
    assert(ClassOuter2(Nil) === Json.fromJson[ClassOuter2](Json.parse("""{"outer": []}""")).get)
  }

  test("test formatInline"){
    case class Foo(i: Int)
    implicit def fmt = Jsonx.formatInline[Foo]
    val f = Foo(1)
    assert(f === Json.parse("1").validate[Foo].get)
    assert(f === Json.toJson(f).validate[Foo].get)

    implicit def fmt2 = Jsonx.formatInline[Bar]
    val b = new Bar(1)
    assert(b === Json.parse("1").validate[Bar].get)
    assert(b === Json.toJson(b).validate[Bar].get)
  }
  case class DontInline(a: Int)
  object DontInline{
    implicit def format = Jsonx.formatCaseClass[DontInline]
  }
  case class Inline(a: Int)
  test("formatAuto"){
    sealed trait SomeAdt
    case object A extends SomeAdt
    case class X(i: Int, s: String/*, recursion: SomeAdt*/) extends SomeAdt
    object Baz
    case class Bar(a: Int, b:Float, foo: Baz.type, o: Option[Int])
    case class Foo(_1:Bar,_11:SomeAdt, _2:String,_3:Int,_4:Int,_5:Int,_21:Int,_22:Int,_23:Int,_24:Int,_25:Int,_31:Int,_32:Int,_33:Int,_34:Int,_35:Int,_41:Int,_42:Int,_43:Int,_44:Int,_45:Int,_51:Int,_52:Int,_53:Int,_54:Int,_55:Int)
    val foo = Foo(Bar(5,1.0f, Baz, Some(4): Option[Int]),A,"sdf",3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5)
    val foo2 = Foo(Bar(5,1.0f, Baz, None: Option[Int]),X(5,"x"/*,X(4,"z",A)*/),"sdf",3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5)

    import play.json.extra.implicits.optionWithNull
    ;{
      val fmt: Format[SomeAdt] = Jsonx.formatAuto[SomeAdt]
    };{
      val fmt: Format[Option[SomeAdt]] = Jsonx.formatAuto[Option[SomeAdt]]
    };{
      val fmt: Format[A.type] = Jsonx.formatAuto[A.type]
    };{
      val fmt: Format[Option[A.type]] = Jsonx.formatAuto[Option[A.type]]
    };{
      val fmt: Format[X] = Jsonx.formatAuto[X]
    };{
      val fmt: Format[Option[X]] = Jsonx.formatAuto[Option[X]]
    };{
      val fmt: Format[Baz.type] = Jsonx.formatAuto[Baz.type]
    };{
      val fmt: Format[Option[Baz.type]] = Jsonx.formatAuto[Option[Baz.type]]
    };{
      val fmt: Format[Bar] = Jsonx.formatAuto[Bar]
    };{
      val fmt: Format[Option[Bar]] = Jsonx.formatAuto[Option[Bar]]
    };{
      val fmt: Format[Int] = Jsonx.formatAuto[Int]
    };{
      val fmt: Format[Option[Int]] = Jsonx.formatAuto[Option[Int]]
    };{
      val fmt: Format[Foo] = Jsonx.formatAuto[Foo]
    };{
      val fmt: Format[Option[Foo]] = Jsonx.formatAuto[Option[Foo]]
    }

    val fmt2: Format[Foo] = Jsonx.formatAuto[Foo] // not implicit to avoid infinite recursion

    {
      implicit def fmt3: Format[Foo] = fmt2
      val json = Json.toJson( foo )
      assert(foo === json.as[Foo])
      assert(Some(foo) === json.validateAuto[Option[Foo]].get)
      val json2 = Json.toJson( foo2 )
      assert(foo2 === json2.as[Foo])
    }

    def fmt3: Format[DontInline] = Jsonx.formatAuto[DontInline]
    def fmt4: Format[Inline] = Jsonx.formatAuto[Inline]
    assert("5" ===  Json.toJson( Inline(5) )(fmt4).toString)
    assert("""{"a":5}""" ===  Json.toJson( DontInline(5) )(fmt3).toString)

  }
  case class CaseClassWithDefaults(foobar: Int = 5)
  test("defaults error test"){

    implicit val childFormat = Jsonx.formatCaseClassUseDefaults[CaseClassWithDefaults]

    val string = """{ "foobar" : 10 } """
    val string2 = """{ "foobar": "test"} """
    val string3 = """{} """
    val json = Json.parse( string )
    val json2 = Json.parse( string2 )
    val json3 = Json.parse( string3 )
    assert( json.validateAuto[CaseClassWithDefaults] === JsSuccess(CaseClassWithDefaults(10)) )
    assert( json2.validateAuto[CaseClassWithDefaults].isInstanceOf[JsError] )
    assert( json3.validateAuto[CaseClassWithDefaults] === JsSuccess(CaseClassWithDefaults(5)) )
  }

  FailureTest // needed to initialize object
}