package play.json.extra

import org.scalatest.FunSuite
import play.api.libs.json.{JsSuccess, JsError, Json, Reads}

case class IndexSettings(version: Map[String, String]=Map.empty[String,String])


class MapManagementTest extends FunSuite {
  test("json default map serialize/deserialize") {
    import play.json.extra.implicits.optionWithNull

    implicit def fmt1 = Jsonx.formatCaseClass[IndexSettings]
    val t1=IndexSettings()

    assert(Json.stringify(Json.toJson(t1)) === """{"version":{}}""")

    assert(t1 === Json.parse("{}").as[IndexSettings])

  }


}
