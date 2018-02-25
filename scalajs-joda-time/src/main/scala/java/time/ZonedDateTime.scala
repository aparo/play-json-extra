package java.time

import java.Wraps
import java.time.chrono.ChronoZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.{TemporalAccessor, TemporalAdjuster, TemporalAmount, TemporalField, TemporalUnit}

import com.zoepepper.facades.jsjoda.{ZonedDateTime => ZonedDateTimeF}
import com.zoepepper.facades.jsjoda.{ZoneOffset => ZoneOffsetF}

object ZonedDateTime {
  def from(temporal: TemporalAccessor): ZonedDateTime = ZonedDateTimeF.from(temporal)
  def now(): ZonedDateTime = ZonedDateTimeF.now()
  def now(clock: Clock): ZonedDateTime = ZonedDateTimeF.now(clock)
  def now(zone: ZoneId): ZonedDateTime = ZonedDateTimeF.now(zone)
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanoOfSecond: Int, zone: ZoneId): ZonedDateTime =
    ZonedDateTimeF.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone)
  def of(date: LocalDate, time: LocalTime, zone: ZoneId): ZonedDateTime = ZonedDateTimeF.of(date, time, zone)
  def of(localDateTime: LocalDateTime, zone: ZoneId): ZonedDateTime = ZonedDateTimeF.of(localDateTime, zone)
  def ofInstant(instant: Instant, zone: ZoneId): ZonedDateTime = ZonedDateTimeF.ofInstant(instant, zone)
  def ofInstant(localDateTime: LocalDateTime, offset: ZoneOffset, zone: ZoneId): ZonedDateTime =
    ZonedDateTimeF.ofInstant(localDateTime, offset, zone)
  def ofLocal(localDateTime: LocalDateTime, zone: ZoneId, preferredOffsetZoneOffset: ZoneOffset): ZonedDateTime =
    ZonedDateTimeF.ofLocal(localDateTime, zone, preferredOffsetZoneOffset)
  def ofStrict(localDateTime: LocalDateTime, offset: ZoneOffset, zone: ZoneId): ZonedDateTime =
    ZonedDateTimeF.ofStrict(localDateTime, offset, zone)
  def parse(text: CharSequence): ZonedDateTime = ZonedDateTimeF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): ZonedDateTime = ZonedDateTimeF.parse(text.toString, formatter)
}

class ZonedDateTime protected[time](f: ZonedDateTimeF) extends Wraps(f) with ChronoZonedDateTime[LocalDate] {
  def getDayOfMonth(): Int = f.dayOfMonth
  def getDayOfWeek(): DayOfWeek = f.dayOfWeek
  def getDayOfYear(): Int = f.dayOfYear
  def getHour(): Int = f.hour
  def getMinute(): Int = f.minute
  def getMonth(): Month = f.month
  def getMonthValue(): Int = f.monthValue
  def getNano(): Int = f.nano
  def getOffset(): ZoneOffset = f.offset
  def getSecond(): Int = f.second
  def getYear(): Int = f.year
  def getZone(): ZoneId = f.zone.asInstanceOf[ZoneOffsetF]
  def isSupported(unit: TemporalUnit): Boolean = f.isSupported(unit)
  def minus(amount: TemporalAmount): ZonedDateTime = f.minus(amount)
  def minus(amount: Long, unit: TemporalUnit): ZonedDateTime = f.minus(amount, unit)
  def minusYears(yearsToSubtract: Long): ZonedDateTime = f.minusYears(yearsToSubtract)
  def minusMonths(monthsToSubtract: Long): ZonedDateTime = f.minusMonths(monthsToSubtract)
  def minusWeeks(weeksToSubtract: Long): ZonedDateTime = f.minusWeeks(weeksToSubtract)
  def minusDays(daysToSubtract: Long): ZonedDateTime = f.minusDays(daysToSubtract)
  def minusHours(hoursToSubtract: Long): ZonedDateTime = f.minusHours(hoursToSubtract)
  def minusMinutes(minutesToSubtract: Long): ZonedDateTime = f.minusMinutes(minutesToSubtract)
  def minusSeconds(secondsToSubtract: Long): ZonedDateTime = f.minusSeconds(secondsToSubtract)
  def minusNanos(nanosToSubtract: Long): ZonedDateTime = f.minusNanos(nanosToSubtract)
  def plus(amount: TemporalAmount): ZonedDateTime = f.plus(amount)
  def plus(amount: Long, unit: TemporalUnit): ZonedDateTime = f.plus(amount, unit)
  def plusYears(yearsToAdd: Long): ZonedDateTime = f.plusYears(yearsToAdd)
  def plusMonths(monthsToAdd: Long): ZonedDateTime = f.plusMonths(monthsToAdd)
  def plusWeeks(weeksToAdd: Long): ZonedDateTime = f.plusWeeks(weeksToAdd)
  def plusDays(daysToAdd: Long): ZonedDateTime = f.plusDays(daysToAdd)
  def plusHours(hoursToAdd: Long): ZonedDateTime = f.plusHours(hoursToAdd)
  def plusMinutes(minutesToAdd: Long): ZonedDateTime = f.plusMinutes(minutesToAdd)
  def plusSeconds(secondsToAdd: Long): ZonedDateTime = f.plusSeconds(secondsToAdd)
  def plusNanos(nanosToAdd: Long): ZonedDateTime = f.plusNanos(nanosToAdd)
  def toLocalDate(): LocalDate = f.toLocalDate()
  def toLocalDateTime(): LocalDateTime = f.toLocalDateTime()
  def toLocalTime(): LocalTime = f.toLocalTime()
  def toOffsetDateTime(): OffsetDateTime = ???
  def truncatedTo(unit: TemporalUnit): ZonedDateTime = f.truncatedTo(unit)
  def `with`(adjuster: TemporalAdjuster): ZonedDateTime = f.`with`(adjuster)
  def `with`(field: TemporalField, newValue: Long): ZonedDateTime = f.`with`(field, newValue)
  def withDayOfMonth(dayOfMonth: Int): ZonedDateTime = f.withDayOfMonth(dayOfMonth)
  def withDayOfYear(dayOfYear: Int): ZonedDateTime = f.withDayOfYear(dayOfYear)
  def withEarlierOffsetAtOverlap(): ZonedDateTime = ???
  def withFixedOffsetZone(): ZonedDateTime = f.withFixedOffsetZone()
  def withLaterOffsetAtOverlap(): ZonedDateTime = ???
  def withYear(year: Int): ZonedDateTime = f.withYear(year)
  def withMonth(month: Int): ZonedDateTime = f.withMonth(month)
  def withHour(hour: Int): ZonedDateTime = f.withHour(hour)
  def withMinute(minute: Int): ZonedDateTime = f.withMinute(minute)
  def withSecond(second: Int): ZonedDateTime = f.withSecond(second)
  def withNano(nanoOfSecond: Int): ZonedDateTime = f.withNano(nanoOfSecond)
  def withZoneSameInstant(zone: ZoneId): ZonedDateTime = f.withZoneSameInstant(zone)
  def withZoneSameLocal(zone: ZoneId): ZonedDateTime = f.withZoneSameLocal(zone)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
