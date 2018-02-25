package play.json.extra

import org.joda.time.DateTime
import org.scalatest.FunSuite
import play.api.libs.json.Json
import boopickle.Default._
import play.json.extra.Picklers._

class DatetimeTests extends FunSuite {
  final case class TestDataTime(dt:DateTime)
  implicit val jsonFmt=Json.format[TestDataTime]

  test("basic datetime test") {
    val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
    assert(dt.year.get === 2015)
    assert(dt.monthOfYear.get === 8)
    assert(dt.dayOfMonth.get === 11)
    assert(dt.hourOfDay.get === 12)
    assert(dt.minuteOfHour.get === 1)
    assert(dt.secondOfMinute.get === 2)
    assert(dt.millisOfSecond.get === 3)
  }

  test("play json serialization/deserialization") {
    val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
    val ts=TestDataTime(dt)
    val json = Json.stringify(Json.toJson(ts))
    println(json)
    val ts2=Json.parse(json).as[TestDataTime]
    println(s"${ts.toString} ${ts2.toString}")
    println(s"${ts.dt.toString()} ${ts2.dt.toString()}")

//    assert(ts === ts2)
    assert(ts2.dt.year.get === 2015)
    assert(ts2.dt.monthOfYear.get === 8)
    assert(ts2.dt.dayOfMonth.get === 11)
    assert(ts2.dt.hourOfDay.get === 12)
    assert(ts2.dt.minuteOfHour.get === 1)
    assert(ts2.dt.secondOfMinute.get === 2)
  }

//  test("boopickle json serialization/deserialization") {
//    import boopickle._
//    import boopickle.Default._
//    import org.joda.time.DateTime._
//    val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
//    val ts=TestDataTime(dt)
//    val bb = Pickle.intoBytes(ts)
//    assert(bb.array().length == 1400)

//    val json = Json.stringify(Json.toJson(ts))
//    println(json)
//    val ts2=Json.parse(json).as[TestDataTime]
//    println(s"${ts.toString} ${ts2.toString}")
//
//    //    assert(ts === ts2)
//    assert(ts2.dt.year.get === 2015)
//    assert(ts2.dt.monthOfYear.get === 8)
//    assert(ts2.dt.dayOfMonth.get === 1)
//    assert(ts2.dt.hourOfDay.get === 12)
//    assert(ts2.dt.minuteOfHour.get === 1)
//    assert(ts2.dt.secondOfMinute.get === 2)
//  }


}