package play.json.extra

import org.scalatest.FunSuite
import play.api.libs.json._

case class IndexSettings(version: Map[String, String]=Map.empty[String,String])


case class ClusterIndex(state: Option[String]=None, aliases: List[String]=Nil)
case class Metadata(templates: Option[JsObject]=None, indices: Map[String, ClusterIndex]= Map.empty[String, ClusterIndex],
                    repositories: Option[JsObject]=None)

class MapManagementTest extends FunSuite {
  test("json default map serialize/deserialize") {
    import play.json.extra.implicits.optionWithNull

    implicit def fmt1 = Jsonx.formatCaseClass[IndexSettings]
    val t1=IndexSettings()

    assert(Json.stringify(Json.toJson(t1)) === """{"version":{}}""")

    assert(t1 === Json.parse("{}").as[IndexSettings])

    implicit def ciJson = Jsonx.formatCaseClass[ClusterIndex]

    implicit def fmt2 = Jsonx.formatCaseClass[Metadata]
    val m1=Metadata()

    assert(Json.stringify(Json.toJson(m1)) === """{"indices":{}}""")

    assert(m1 === Json.parse("{}").as[Metadata])

  }


}
