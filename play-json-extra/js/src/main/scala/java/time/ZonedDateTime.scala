package java.time

import _root_.java.time.format.DateTimeFormatter
import java.time.temporal.{TemporalUnit, TemporalField, Temporal}

import web.moment._

case class ZonedDateTime(datetime: Moment, zoneId:ZoneId=ZoneId.systemDefault) extends Temporal {
  def this(l: Long) = this(moment.moment.apply(l))

  def getMillis: Long = datetime.milliseconds().toLong

  def toString(pattern: String): String = {
    datetime.format(pattern)
  }

  def toString(pattern: DateTimeFormatter): String = {
    datetime.format(pattern.toString())
  }

  def toInstant: Instant = {
    //  datetime.unix()???
//    new Instant(datetime.seconds().toLong, datetime.millisecond().toInt)
    null

  }

  override def isSupported(unit: TemporalUnit): Boolean = ???

  override def plus(amountToAdd: Long, unit: TemporalUnit): Temporal = ???

  override def until(endExclusive: Temporal, unit: TemporalUnit): Long = ???

  override def `with`(field: TemporalField, newValue: Long): Temporal = ???

  override def isSupported(field: TemporalField): Boolean = ???

  override def getLong(field: TemporalField): Long = ???
}

object ZonedDateTime {
  def parse(input: String, formatter: DateTimeFormatter): ZonedDateTime = {
    new ZonedDateTime(moment.moment.apply(input, format = formatter.toString()))
  }

  def ofInstant(instant:Instant, zoneId:ZoneId=ZoneId.systemDefault)=new ZonedDateTime(moment.moment.apply(instant.toEpochMilli / 1000), zoneId)

  def of (localDateTime: LocalDateTime, zone: ZoneId):ZonedDateTime = {
//    new ZonedDateTime(localDateTime.datetime, zone)
    null

  }
}