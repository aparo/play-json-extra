package play.json.extra

import org.scalatest.FunSuite
import play.api.libs.json.{JsSuccess, JsError, Json, Reads}

final case class KeyTestClass(@key("ok-field") field:String="p")

class KeyChangeTest extends FunSuite {
  test("json key serialize/deserialize") {

    implicit def fmt1 = Jsonx.formatCaseClassUseDefaults[KeyTestClass]
    val t1=KeyTestClass("t1")

    assert(Json.stringify(Json.toJson(t1)) === """{"ok-field":"t1"}""")

    assert(JsSuccess(t1) === Json.fromJson[KeyTestClass](Json.toJson(t1)))

  }


}
