package org.joda.time

import java.time.OffsetDateTime

import org.joda.Wraps
import org.joda.time.chrono.ChronoLocalDateTime
import org.joda.time.format.DateTimeFormatter
import org.joda.time.temporal.{TemporalAccessor, TemporalAdjuster, TemporalAmount, TemporalField, TemporalUnit}
import com.zoepepper.facades.jsjoda.{LocalDateTime => LocalDateTimeF}

object DateTime {
  def from(temporal: TemporalAccessor): DateTime = LocalDateTimeF.from(temporal)
  def now(): DateTime = LocalDateTimeF.now()
  def now(clock: Clock): DateTime = LocalDateTimeF.now(clock)
  def now(zone: ZoneId): DateTime = LocalDateTimeF.now(zone)
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int): DateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute)
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int): DateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second)
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanoOfSecond: Int): DateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond)
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int): DateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute)
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int): DateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second)
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanoOfSecond: Int): DateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond)
  def of(date: LocalDate, time: LocalTime): DateTime = LocalDateTimeF.of(date, time)
  def ofEpochSecond(epochSecond: Long, nanoOfSecond: Int, offset: ZoneOffset): DateTime =
    LocalDateTimeF.ofEpochSecond(epochSecond, nanoOfSecond, offset)
  def ofInstant(instant: Instant, zone: ZoneId): DateTime = LocalDateTimeF.ofInstant(instant, zone)
  def parse(text: CharSequence): DateTime = LocalDateTimeF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): DateTime = LocalDateTimeF.parse(text.toString, formatter)

  val MAX: DateTime = LocalDateTimeF.MAX
  val MIN: DateTime = LocalDateTimeF.MIN
}

class DateTime protected[time](f: LocalDateTimeF) extends Wraps(f) with ChronoLocalDateTime[LocalDate] {
  def atOffset(offset: ZoneOffset): OffsetDateTime = ???
  def atZone(zone: ZoneId): ZonedDateTime = ???
  def compareTo(other: ChronoLocalDateTime[_]): Int = f.compareTo(other.asInstanceOf[DateTime])
  def format(formatter: DateTimeFormatter): String = f.format(formatter)
  def getDayOfMonth(): Int = f.dayOfMonth
  def getDayOfWeek(): DayOfWeek = f.dayOfWeek
  def getDayOfYear(): Int = f.dayOfYear
  def getHour(): Int = f.hour
  def getMinute(): Int = f.minute
  def getMonth(): Month = f.month
  def getMonthValue(): Int = f.monthValue
  def getNano(): Int = f.nano
  def getSecond(): Int = f.second
  def getYear(): Int = f.year
  def isAfter(other: ChronoLocalDateTime[_]): Boolean = f.isAfter(other.asInstanceOf[DateTime])
  def isBefore(other: ChronoLocalDateTime[_]): Boolean = f.isBefore(other.asInstanceOf[DateTime])
  def isEqual(other: ChronoLocalDateTime[_]): Boolean = f.isEqual(other.asInstanceOf[DateTime])
  def isSupported(unit: TemporalUnit): Boolean = f.isSupported(unit)
  def minus(amount: TemporalAmount): DateTime = f.minus(amount)
  def minus(amount: Long, unit: TemporalUnit): DateTime = f.minus(amount, unit)
  def minusYears(yearsToSubtract: Long): DateTime = f.minusYears(yearsToSubtract)
  def minusMonths(monthsToSubtract: Long): DateTime = f.minusMonths(monthsToSubtract)
  def minusWeeks(weeksToSubtract: Long): DateTime = f.minusWeeks(weeksToSubtract)
  def minusDays(daysToSubtract: Long): DateTime = f.minusDays(daysToSubtract)
  def minusHours(hoursToSubtract: Long): DateTime = f.minusHours(hoursToSubtract)
  def minusMinutes(minutesToSubtract: Long): DateTime = f.minusMinutes(minutesToSubtract)
  def minusSeconds(secondsToSubtract: Long): DateTime = f.minusSeconds(secondsToSubtract)
  def minusNanos(nanosToSubtract: Long): DateTime = f.minusNanos(nanosToSubtract)
  def plus(amount: TemporalAmount): DateTime = f.plus(amount)
  def plus(amount: Long, unit: TemporalUnit): DateTime = f.plus(amount, unit)
  def plusYears(yearsToAdd: Long): DateTime = f.plusYears(yearsToAdd)
  def plusMonths(monthsToAdd: Long): DateTime = f.plusMonths(monthsToAdd)
  def plusWeeks(weeksToAdd: Long): DateTime = f.plusWeeks(weeksToAdd)
  def plusDays(daysToAdd: Long): DateTime = f.plusDays(daysToAdd)
  def plusHours(hoursToAdd: Long): DateTime = f.plusHours(hoursToAdd)
  def plusMinutes(minutesToAdd: Long): DateTime = f.plusMinutes(minutesToAdd)
  def plusSeconds(secondsToAdd: Long): DateTime = f.plusSeconds(secondsToAdd)
  def plusNanos(nanosToAdd: Long): DateTime = f.plusNanos(nanosToAdd)
  def toLocalDate(): LocalDate = f.toLocalDate()
  def toLocalTime(): LocalTime = f.toLocalTime()
  def truncatedTo(unit: TemporalUnit): DateTime = f.truncatedTo(unit)
  def `with`(adjuster: TemporalAdjuster): DateTime = f.`with`(adjuster)
  def `with`(field: TemporalField, newValue: Long): DateTime = f.`with`(field, newValue)
  def withYear(year: Int): DateTime = f.withYear(year)
  def withMonth(month: Int): DateTime = f.withMonth(month)
  def withDayOfMonth(dayOfMonth: Int): DateTime = f.withDayOfMonth(dayOfMonth)
  def withDayOfYear(dayOfYear: Int): DateTime = f.withDayOfYear(dayOfYear)
  def withHour(hour: Int): DateTime = f.withHour(hour)
  def withMinute(minute: Int): DateTime = f.withMinute(minute)
  def withSecond(second: Int): DateTime = f.withSecond(second)
  def withNano(nanoOfSecond: Int): DateTime = f.withNano(nanoOfSecond)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
