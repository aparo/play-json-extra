package play.json.extra

import java.time.LocalDateTime

import org.scalatest.FunSuite
import play.api.libs.json.Json


class LocalDatetimeTests extends FunSuite {
  final case class TestDataTime(dt:LocalDateTime)
  implicit val jsonFmt=Json.format[TestDataTime]

  test("basic LocalDateTime test") {
    val dt = LocalDateTime.of(2015, 8, 11, 12, 1, 2, 3)
    assert(dt.getYear === 2015)
    assert(dt.getMonthValue === 8)
    assert(dt.getDayOfMonth === 11)
    assert(dt.getHour === 12)
    assert(dt.getMinute === 1)
    assert(dt.getSecond === 2)
  }

  test("play json serialization/deserialization") {
    val dt = LocalDateTime.of(2015, 8, 11, 12, 1, 2, 3)
    val ts=TestDataTime(dt)
    val json = Json.stringify(Json.toJson(ts))
    println(json)
    val ts2=Json.parse(json).as[TestDataTime]
    println(s"${ts.toString} ${ts2.toString}")
    println(s"${ts.dt.toString()} ${ts2.dt.toString()}")

//    assert(ts === ts2)
    assert(ts2.dt.getYear === 2015)
    assert(ts2.dt.getMonthValue === 8)
    assert(ts2.dt.getDayOfMonth === 11)
    assert(ts2.dt.getHour === 12)
    assert(ts2.dt.getMinute === 1)
    assert(ts2.dt.getSecond === 2)
  }

//  test("boopickle json serialization/deserialization") {
//    import boopickle._
//    import boopickle.Default._
//    import org.joda.time.LocalDateTime._
//    val dt = new LocalDateTime(2015, 8, 11, 12, 1, 2, 3)
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