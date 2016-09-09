package java.time

import java.Wraps
import java.time.chrono.{ChronoLocalDateTime, Chronology}
import java.time.format.DateTimeFormatter
import java.time.temporal.{TemporalAccessor, TemporalAdjuster, TemporalAmount, TemporalField, TemporalUnit}

import com.zoepepper.facades.jsjoda.{LocalDateTime => LocalDateTimeF}

object LocalDateTime {
  def from(temporal: TemporalAccessor): LocalDateTime = LocalDateTimeF.from(temporal)
  def now(): LocalDateTime = LocalDateTimeF.now()
  def now(clock: Clock): LocalDateTime = LocalDateTimeF.now(clock)
  def now(zone: ZoneId): LocalDateTime = LocalDateTimeF.now(zone)
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int): LocalDateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute)
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int): LocalDateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second)
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanoOfSecond: Int): LocalDateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond)
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int): LocalDateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute)
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int): LocalDateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second)
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanoOfSecond: Int): LocalDateTime =
    LocalDateTimeF.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond)
  def of(date: LocalDate, time: LocalTime): LocalDateTime = LocalDateTimeF.of(date, time)
  def ofEpochSecond(epochSecond: Long, nanoOfSecond: Int, offset: ZoneOffset): LocalDateTime =
    LocalDateTimeF.ofEpochSecond(epochSecond, nanoOfSecond, offset)
  def ofInstant(instant: Instant, zone: ZoneId): LocalDateTime = LocalDateTimeF.ofInstant(instant, zone)
  def parse(text: CharSequence): LocalDateTime = LocalDateTimeF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): LocalDateTime = LocalDateTimeF.parse(text.toString, formatter)

  val MAX: LocalDateTime = LocalDateTimeF.MAX
  val MIN: LocalDateTime = LocalDateTimeF.MIN
}

class LocalDateTime protected[time](f: LocalDateTimeF) extends Wraps(f) with ChronoLocalDateTime[LocalDate] {
  def atOffset(offset: ZoneOffset): OffsetDateTime = ???
  def atZone(zone: ZoneId): ZonedDateTime = ???
  def compareTo(other: ChronoLocalDateTime[_]): Int = f.compareTo(other.asInstanceOf[LocalDateTime])
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
  def isAfter(other: ChronoLocalDateTime[_]): Boolean = f.isAfter(other.asInstanceOf[LocalDateTime])
  def isBefore(other: ChronoLocalDateTime[_]): Boolean = f.isBefore(other.asInstanceOf[LocalDateTime])
  def isEqual(other: ChronoLocalDateTime[_]): Boolean = f.isEqual(other.asInstanceOf[LocalDateTime])
  def isSupported(unit: TemporalUnit): Boolean = f.isSupported(unit)
  def minus(amount: TemporalAmount): LocalDateTime = f.minus(amount)
  def minus(amount: Long, unit: TemporalUnit): LocalDateTime = f.minus(amount, unit)
  def minusYears(yearsToSubtract: Long): LocalDateTime = f.minusYears(yearsToSubtract)
  def minusMonths(monthsToSubtract: Long): LocalDateTime = f.minusMonths(monthsToSubtract)
  def minusWeeks(weeksToSubtract: Long): LocalDateTime = f.minusWeeks(weeksToSubtract)
  def minusDays(daysToSubtract: Long): LocalDateTime = f.minusDays(daysToSubtract)
  def minusHours(hoursToSubtract: Long): LocalDateTime = f.minusHours(hoursToSubtract)
  def minusMinutes(minutesToSubtract: Long): LocalDateTime = f.minusMinutes(minutesToSubtract)
  def minusSeconds(secondsToSubtract: Long): LocalDateTime = f.minusSeconds(secondsToSubtract)
  def minusNanos(nanosToSubtract: Long): LocalDateTime = f.minusNanos(nanosToSubtract)
  def plus(amount: TemporalAmount): LocalDateTime = f.plus(amount)
  def plus(amount: Long, unit: TemporalUnit): LocalDateTime = f.plus(amount, unit)
  def plusYears(yearsToAdd: Long): LocalDateTime = f.plusYears(yearsToAdd)
  def plusMonths(monthsToAdd: Long): LocalDateTime = f.plusMonths(monthsToAdd)
  def plusWeeks(weeksToAdd: Long): LocalDateTime = f.plusWeeks(weeksToAdd)
  def plusDays(daysToAdd: Long): LocalDateTime = f.plusDays(daysToAdd)
  def plusHours(hoursToAdd: Long): LocalDateTime = f.plusHours(hoursToAdd)
  def plusMinutes(minutesToAdd: Long): LocalDateTime = f.plusMinutes(minutesToAdd)
  def plusSeconds(secondsToAdd: Long): LocalDateTime = f.plusSeconds(secondsToAdd)
  def plusNanos(nanosToAdd: Long): LocalDateTime = f.plusNanos(nanosToAdd)
  def toLocalDate(): LocalDate = f.toLocalDate()
  def toLocalTime(): LocalTime = f.toLocalTime()
  def truncatedTo(unit: TemporalUnit): LocalDateTime = f.truncatedTo(unit)
  def `with`(adjuster: TemporalAdjuster): LocalDateTime = f.`with`(adjuster)
  def `with`(field: TemporalField, newValue: Long): LocalDateTime = f.`with`(field, newValue)
  def withYear(year: Int): LocalDateTime = f.withYear(year)
  def withMonth(month: Int): LocalDateTime = f.withMonth(month)
  def withDayOfMonth(dayOfMonth: Int): LocalDateTime = f.withDayOfMonth(dayOfMonth)
  def withDayOfYear(dayOfYear: Int): LocalDateTime = f.withDayOfYear(dayOfYear)
  def withHour(hour: Int): LocalDateTime = f.withHour(hour)
  def withMinute(minute: Int): LocalDateTime = f.withMinute(minute)
  def withSecond(second: Int): LocalDateTime = f.withSecond(second)
  def withNano(nanoOfSecond: Int): LocalDateTime = f.withNano(nanoOfSecond)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
