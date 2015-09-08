package org.joda.time

import org.joda.time.format.DateTimeFormatter
import web.moment._

class DateTime(datetime:Moment) {
  def this(l: Long) = this(moment.moment.apply(l))

  def this(year: Int, month: Int, day: Int, hour: Int = 0, minutes: Int = 0, seconds: Int = 0, milliseconds: Int = 0) = {
    this(moment.moment.apply(f"$year%04d-$month%02d-$day%02d'T'$hour%02d:$minutes%02d:$seconds%02d.$milliseconds%03d",
      format = DateTime.millis))
//    println(f"$year%04d-$month%02d-$day%02d'T'$hour%02d:$minutes%02d:$seconds%02d.$milliseconds%03d")
  }


  def getMillis: Long = datetime.milliseconds().toLong

  def toString(pattern: String): String = {
    datetime.format(pattern)
  }

  def toString(pattern: DateTimeFormatter): String = {
    datetime.format(pattern.pattern)
  }

  def toStringISO = datetime.format(DateTime.millis)

  def year(): Option[Int] = Some(datetime.year().toInt)

  def monthOfYear(): Option[Int] = Some(datetime.month().toInt + 1)

  def dayOfMonth(): Option[Int] = Some(datetime.date().toInt)

  def hourOfDay(): Option[Int] = Some(datetime.hours().toInt)

  def minuteOfHour(): Option[Int] = Some(datetime.minutes().toInt)

  def secondOfMinute(): Option[Int] = Some(datetime.seconds().toInt)

  def millisOfSecond(): Option[Int] = Some(datetime.millisecond().toInt)

}

object DateTime {
  val mini = "yyyy-MM-ddTHH:mm:ss"
  val millis = "yyyy-MM-ddTHH:mm:ss.SSS"

  def parse(input:String, formatter:DateTimeFormatter):DateTime={
    new DateTime(moment.moment.apply(input, format = formatter.pattern))
  }

  def parse(input:String):DateTime={
    new DateTime(moment.moment.apply(input, format = millis))
  }

  def now():DateTime={
    new DateTime(moment.moment.utc())
  }



}