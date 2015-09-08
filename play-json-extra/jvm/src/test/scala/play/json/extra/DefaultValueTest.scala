package play.json.extra

import org.scalatest.FunSuite
import play.api.libs.json.{JsSuccess, Json}

case class DefaultValueTestClass(@key("ok-field") field:String="p", lp:List[String],
                                 l1:Option[Option[Int]])

class DefaultValueTest extends FunSuite {
  test("json default serialize/deserialize") {
    import play.json.extra.implicits.optionWithNull

    implicit def fmt1 = Jsonx.formatCaseClass[DefaultValueTestClass]
    val t1=DefaultValueTestClass(lp=Nil, l1=None)

//    println(Json.stringify(Json.toJson(t1)))
    assert(Json.stringify(Json.toJson(t1)) === """{"ok-field":"p","lp":[]}""")

    assert(t1 === Json.parse("{}").as[DefaultValueTestClass])

  }

}
