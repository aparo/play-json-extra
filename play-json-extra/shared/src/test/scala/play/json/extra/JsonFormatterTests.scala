package play.json.extra

import java.time.LocalDateTime

import org.scalatest.FunSuite
import play.api.libs.json.{JsObject, Json}

class JsonFormatterTests extends FunSuite {

  @JsonFormat
  final case class TestDataTime(dt: LocalDateTime, children: List[TestDataTime] = Nil)

  @JsonFormat
  final case class DefaultTest(@key("ok1") a1: Int = 1, @key("ok2") a2: Int = 2, @key("ok3") a3: Int = 3, @key("ok4") a4: Int = 4,
                         @key("ok5") a5: Int = 5, @key("ok6") a6: Int = 6, @key("ok7") a7: Int = 7, @key("ok8") a8: Int = 8,
                         @key("ok9") a9: Int = 9, @key("ok10") a10: Int = 10,
                         @key("ok11") a11: Int = 11, @key("ok12") a12: Int = 12, @key("ok13") a13: Int = 13, @key("ok14") a14: Int = 14,
                         @key("ok15") a15: Int = 15, @key("ok16") a16: Int = 16, @key("ok17") a17: Int = 17, @key("ok18") a18: Int = 18,
                         @key("ok19") a19: Int = 19, @key("ok20") a20: Int = 20,
                         @key("ok21") a21: Int = 21, @key("ok22") a22: Int = 22, @key("ok23") a23: Int = 23, @key("ok24") a24: Int = 24,
                         @key("ok25") a25: Int = 25, @key("ok26") a26: Int = 26, @key("ok27") a27: Int = 27, @key("ok28") a28: Int = 28,
                         @key("ok29") a29: Int = 29
                          )

  test("basic datetime test") {
    val dt = LocalDateTime.of(2015, 8, 11, 12, 1, 2, 3)
    val ts = TestDataTime(dt)
    val json = Json.toJson(ts)
    println(Json.stringify(json))
    assert(Json.stringify(json) === """{"dt":"2015-08-11T12:01:02.000000003","children":[]}""")
    assert(json.as[TestDataTime].dt === dt)
  }

  test("default test key + >21 fields + des/ser") {
    val ts = DefaultTest()
    val json = Json.toJson(ts).as[JsObject]
//    println(Json.stringify(json))
    assert(json.fields.length === 29)
    val fieldNames=List(
      "ok1", "ok2", "ok3", "ok4", "ok5", "ok6", "ok7", "ok8",  "ok9", "ok10",
      "ok10", "ok11", "ok12", "ok13", "ok14", "ok15", "ok16", "ok17", "ok18",  "ok19",
      "ok20", "ok21", "ok22", "ok23", "ok24", "ok25", "ok26", "ok27", "ok28",  "ok29"
    )

    fieldNames.foreach(value => assert(json.fields.map(_._1).contains(value) === true))
    val json2=Json.parse("""{"ok27":27,"ok16":16,"ok4":4,"ok25":25,"ok14":14,"ok10":10,"ok17":17,"ok21":21,"ok24":24,"ok28":28,"ok3":3,"ok20":20,"ok15":15,"ok7":7,"ok11":11,"ok1":1,"ok23":23,"ok12":12,"ok8":8,"ok29":29,"ok19":19,"ok2":2,"ok5":5,"ok26":26,"ok13":13,"ok18":18,"ok9":9,"ok6":6,"ok22":22}""")
    val ts2 = json2.as[DefaultTest]
    assert(ts2.a29 === 29)
  }

}


