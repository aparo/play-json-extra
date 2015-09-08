package java.time

import web.moment._

import _root_.java.time.format.DateTimeFormatter
import java.time.temporal.{TemporalUnit, TemporalField, Temporal}

case class LocalDateTime(datetime: Moment) extends Temporal {
  def this(l: Long) = this(moment.moment.apply(l))

  def getMillis: Long = datetime.milliseconds().toLong

  def toString(pattern: String): String = {
    datetime.format(pattern)
  }

  def toString(pattern: DateTimeFormatter): String = {

    datetime.format(pattern.toString())

  }

  def atZone(zoneid:ZoneId)= ZonedDateTime.of(this, zoneid)

  override def isSupported(unit: TemporalUnit): Boolean = ???

  override def plus(amountToAdd: Long, unit: TemporalUnit): Temporal = ???

  override def until(endExclusive: Temporal, unit: TemporalUnit): Long = ???

  override def `with`(field: TemporalField, newValue: Long): Temporal = ???

  override def isSupported(field: TemporalField): Boolean = ???

  override def getLong(field: TemporalField): Long = ???
}

object LocalDateTime {
  def parse(input: String, formatter: DateTimeFormatter): LocalDateTime = {
    new LocalDateTime(moment.moment.apply(input, format = formatter.toString()))
  }

  def ofInstant(instant:Instant, zoneId:ZoneId=ZoneId.systemDefault)=LocalDateTime(moment.moment.apply(instant.toEpochMilli / 1000))
//    def ofInstant(millis:Long, zoneId:ZoneId=ZoneId.systemDefault)=LocalDateTime(moment.moment.apply(millis))
  /**
   * Obtains the current date-time from the system clock in the specified time-zone.
   * <p>
   * This will query the {@link Clock#system(ZoneId) system clock} to obtain the current date-time.
   * Specifying the time-zone avoids dependence on the default time-zone.
   * <p>
   * Using this method will prevent the ability to use an alternate clock for testing
   * because the clock is hard-coded.
   *
   * @param zone  the zone ID to use, not null
   * @return the current date-time using the system clock, not null
   */
  def now(zone: ZoneId): LocalDateTime = {
    return now(Clock.system(zone))
  }

  /**
   * Obtains the current date-time from the specified clock.
   * <p>
   * This will query the specified clock to obtain the current date-time.
   * Using this method allows the use of an alternate clock for testing.
   * The alternate clock may be introduced using {@link Clock dependency injection}.
   *
   * @param clock  the clock to use, not null
   * @return the current date-time, not null
   */
  def now(clock: Clock): LocalDateTime = {
//    Objects.requireNonNull(clock
// , "clock")
    val now: Instant = clock.asInstanceOf[FixedClock].instant
//    val offset: Nothing = clock.getZone.getRules.getOffset(now)
//    return ofEpochSecond(now.getEpochSecond, now.getNano, offset)
    ofInstant(now, clock.getZone)
  }
}