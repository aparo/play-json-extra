package org.joda

import org.joda.time.DateTime
import org.scalatest.FunSuite


class DatetimeTests extends FunSuite {

   test("basic datetime test") {
     val dt = new DateTime(2015, 8, 11, 12, 1, 2, 3)
     assert(dt.toString === "2015-08-11T12:01:02.003")
     assert(dt.year.get === 2015)
     assert(dt.monthOfYear.get === 8)
     assert(dt.dayOfMonth.get === 11)
     assert(dt.hourOfDay.get === 12)
     assert(dt.minuteOfHour.get === 1)
     assert(dt.secondOfMinute.get === 2)
     assert(dt.millisOfSecond.get === 3)
   }
 }