package play.json.extra

import org.scalatest.FunSuite
import play.api.libs.json.{JsSuccess, JsError, Json, Reads}

class JsonTests extends FunSuite {
  test("json optionWithNull") {
    object JsonTestClasses extends JsonTestClasses {
      implicit def option[A](implicit reads: Reads[A]): Reads[Option[A]] = implicits.optionWithNull[A]
    }
    import JsonTestClasses._

    assert((Json.parse( """{}""") \ "s").validate[Option[String]].isInstanceOf[JsError])
    assert(JsSuccess(Some("foo")) === (Json.parse( """{"s": "foo"}""") \ "s").validate[Option[String]])
    assert(JsSuccess(None) === (Json.parse( """{}""") \ "s").validateOpt[String])
    assert(JsSuccess(Some("foo")) === (Json.parse( """{"s": "foo"}""") \ "s").validateOpt[String])
    assert(JsSuccess(None) === (Json.parse( """{}""") \ "s").validateAuto[Option[String]])
    assert(JsSuccess(Some("foo")) === (Json.parse( """{"s": "foo"}""") \ "s").validateAuto[Option[String]])

    assert(Json.fromJson[Option[String]](Json.parse("""5""")).isInstanceOf[JsError])
    assert(Json.fromJson[Option[String]](Json.parse("""{}""")).isInstanceOf[JsError])

    assert(Json.fromJson[B](Json.parse("""{"s": {}}""")).isInstanceOf[JsError])
    assert(JsSuccess(A("foo")) === Json.fromJson[A](Json.parse("""{"s": "foo"}""")))
    assert(JsSuccess(B(Some("foo"))) === Json.fromJson[B](Json.parse("""{"s": "foo"}""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""{"s": null}""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""{}""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""5""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""null""")))

    assert(Json.fromJson[B](Json.parse("""{"s": {}}""")).isInstanceOf[JsError])
    assert(A2("foo") === Json.fromJson[A2](Json.parse("""{"s": "foo"}""")).get)
    assert(B2(Some("foo")) === Json.fromJson[B2](Json.parse("""{"s": "foo"}""")).get)
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""{"s": null}""")))
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""{}""")))
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""5""")))
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""null""")))

    assert(JsSuccess(Optional(None)) === Json.fromJson[Optional](Json.parse("""{}""")))
    assert(JsSuccess(Optional(Some(Mandatory(List("test"))))) === Json.fromJson[Optional](Json.parse("""{"o":{"s":["test"]}}""")))
    assert(Json.parse( """{"o":{}}""").validate[Optional].isInstanceOf[JsError])

    assert(JsSuccess(Optional2(None)) === Json.fromJson[Optional2](Json.parse("""{}""")))
    assert(JsSuccess(Optional2(Some(Mandatory2(List("test"))))) === Json.fromJson[Optional2](Json.parse("""{"o":{"s":["test"]}}""")))
    assert(Json.parse( """{"o":{}}""").validate[Optional2].isInstanceOf[JsError])

    assert(JsSuccess(ClassOuter(Nil)) === Json.fromJson[ClassOuter](Json.parse("""{"outer": []}""")))
    assert(JsSuccess(ClassOuter2(Nil)) === Json.fromJson[ClassOuter2](Json.parse("""{"outer": []}""")))
  }

  test("json optionNoError") {
    object JsonTestClasses extends JsonTestClasses {
      implicit def option[A](implicit reads: Reads[A]): Reads[Option[A]] = implicits.optionNoError[A]
    }
    import JsonTestClasses._

    assert((Json.parse( """{}""") \ "s").validate[Option[String]].isInstanceOf[JsError])
    assert(JsSuccess(Some("foo")) === (Json.parse( """{"s": "foo"}""") \ "s").validate[Option[String]])
    assert(JsSuccess(None) === (Json.parse( """{}""") \ "s").validateOpt[String])
    assert(JsSuccess(Some("foo")) === (Json.parse( """{"s": "foo"}""") \ "s").validateOpt[String])
    assert(JsSuccess(None) === (Json.parse( """{}""") \ "s").validateAuto[Option[String]])
    assert(JsSuccess(Some("foo")) === (Json.parse( """{"s": "foo"}""") \ "s").validateAuto[Option[String]])

    assert(JsSuccess(None) === Json.fromJson[Option[String]](Json.parse("""5""")))
    assert(JsSuccess(None) === Json.fromJson[Option[String]](Json.parse("""{}""")))

//    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""{"s": {}}""")))
    assert(JsSuccess(A("foo")) === Json.fromJson[A](Json.parse("""{"s": "foo"}""")))
    assert(JsSuccess(B(Some("foo"))) === Json.fromJson[B](Json.parse("""{"s": "foo"}""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""{"s": null}""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""{}""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""5""")))
    assert(JsSuccess(B(None)) === Json.fromJson[B](Json.parse("""null""")))

    assert(Json.fromJson[B2](Json.parse("""{"s": {}}""")).isInstanceOf[JsError])
    assert(A2("foo") === Json.fromJson[A2](Json.parse("""{"s": "foo"}""")).get)
    assert(B2(Some("foo")) === Json.fromJson[B2](Json.parse("""{"s": "foo"}""")).get)
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""{"s": null}""")))
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""{}""")))
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""5""")))
    assert(JsSuccess(B2(None)) === Json.fromJson[B2](Json.parse("""null""")))

    assert(JsSuccess(Optional(None)) === Json.fromJson[Optional](Json.parse("""{}""")))
    assert(JsSuccess(Optional(Some(Mandatory(List("test"))))) === Json.fromJson[Optional](Json.parse("""{"o":{"s":["test"]}}""")))
//    assert(JsSuccess(Optional(None)) === Json.fromJson[Optional](Json.parse("""{"o":{}}""")))

    assert(JsSuccess(Optional2(None)) === Json.fromJson[Optional2](Json.parse("""{}""")))
    assert(JsSuccess(Optional2(Some(Mandatory2(List("test"))))) === Json.fromJson[Optional2](Json.parse("""{"o":{"s":["test"]}}""")))
//    assert(JsSuccess(Optional2(None)) === Json.fromJson[Optional2](Json.parse("""{"o":{}}""")))

    assert(JsSuccess(ClassOuter(Nil)) === Json.fromJson[ClassOuter](Json.parse("""{"outer": []}""")))
    assert(JsSuccess(ClassOuter2(Nil)) === Json.fromJson[ClassOuter2](Json.parse("""{"outer": []}""")))
  }
}
