package play.json.extra

import org.scalatest.FunSuite
import play.api.libs.json._

final case class IndexSettings(version: Map[String, String]=Map.empty[String,String])


final case class ClusterIndex(state: Option[String]=None, aliases: List[String]=Nil)
final case class Metadata(templates: Option[JsObject]=None, indices: Map[String, ClusterIndex]= Map.empty[String, ClusterIndex],
                    repositories: Option[JsObject]=None)

class MapManagementTest extends FunSuite {
  test("json default map serialize/deserialize") {
    import play.json.extra.implicits.optionWithNull

    implicit def fmt1 = Jsonx.formatCaseClassUseDefaults[IndexSettings]
    val t1=IndexSettings()

    assert(Json.stringify(Json.toJson(t1)) === """{"version":{}}""")

    assert(t1 === Json.parse("{}").as[IndexSettings])

    implicit def ciJson = Jsonx.formatCaseClassUseDefaults[ClusterIndex]

    implicit def fmt2 = Jsonx.formatCaseClassUseDefaults[Metadata]
    val m1=Metadata()

    assert(Json.stringify(Json.toJson(m1)) === """{"indices":{}}""")

    assert(m1 === Json.parse("{}").as[Metadata])

  }


}
