package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.chrono.{ChronoLocalDate, ChronoLocalDateTime, ChronoZonedDateTime}
import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal._

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.ZonedDateTime")
object ZonedDateTime extends js.Object {
  def now(clock: Clock = ???): ZonedDateTime = js.native
  def now(zone: ZoneId): ZonedDateTime = js.native
  def ofInstant(instant: Instant, zone: ZoneId): ZonedDateTime = js.native
  def ofInstant(localDateTime: LocalDateTime, offset: ZoneOffset, zone: ZoneId): ZonedDateTime = js.native
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanoOfSecond: Int, zone: ZoneId): ZonedDateTime = js.native
  def of(date: LocalDate, time: LocalTime, zone: ZoneId): ZonedDateTime = js.native
  def of(localDateTime: LocalDateTime, zone: ZoneId): ZonedDateTime = js.native
  def ofLocal(localDateTime: LocalDateTime, zone: ZoneId, preferredOffsetZoneOffset: ZoneOffset): ZonedDateTime = js.native
  def ofStrict(localDateTime: LocalDateTime, offset: ZoneOffset, zone: ZoneId): ZonedDateTime = js.native
  def from(temporal: TemporalAccessor): ZonedDateTime = js.native
  def parse(text: String, formatter: DateTimeFormatter = ???): ZonedDateTime = js.native
}

@js.native
class ZonedDateTime protected[jsjoda]() extends ChronoZonedDateTime[ChronoLocalDate] {
  def year(): Int = js.native
  def month(): Month = js.native
  def monthValue(): Int = js.native
  def dayOfMonth(): Int = js.native
  def dayOfYear(): Int = js.native
  def dayOfWeek(): DayOfWeek = js.native
  def hour(): Int = js.native
  def minute(): Int = js.native
  def second(): Int = js.native
  def nano(): Int = js.native
  def offset(): ZoneOffset = js.native
  def zone(): ZoneId = js.native
  def isSupported(unit: TemporalUnit): Boolean = js.native
  def withZoneSameLocal(zone: ZoneId): ZonedDateTime = js.native
  def withZoneSameInstant(zone: ZoneId): ZonedDateTime = js.native
  def withFixedOffsetZone(): ZonedDateTime = js.native
  def `with`(adjuster: TemporalAdjuster): ZonedDateTime = js.native
  def `with`(field: TemporalField, newValue: Double): ZonedDateTime = js.native
  def withYear(year: Int): ZonedDateTime = js.native
  def withMonth(month: Int): ZonedDateTime = js.native
  def withDayOfMonth(dayOfMonth: Int): ZonedDateTime = js.native
  def withDayOfYear(dayOfYear: Int): ZonedDateTime = js.native
  def withHour(hour: Int): ZonedDateTime = js.native
  def withMinute(minute: Int): ZonedDateTime = js.native
  def withSecond(second: Int): ZonedDateTime = js.native
  def withNano(nanoOfSecond: Int): ZonedDateTime = js.native
  def truncatedTo(unit: TemporalUnit): ZonedDateTime = js.native
  def plus(amount: TemporalAmount): ZonedDateTime = js.native
  def plus(amount: Double, unit: TemporalUnit): ZonedDateTime = js.native
  def plusYears(yearsToAdd: Double): ZonedDateTime = js.native
  def plusMonths(monthsToAdd: Double): ZonedDateTime = js.native
  def plusWeeks(weeksToAdd: Double): ZonedDateTime = js.native
  def plusDays(daysToAdd: Double): ZonedDateTime = js.native
  def plusHours(hoursToAdd: Double): ZonedDateTime = js.native
  def plusMinutes(minutesToAdd: Double): ZonedDateTime = js.native
  def plusSeconds(secondsToAdd: Double): ZonedDateTime = js.native
  def plusNanos(nanosToAdd: Double): ZonedDateTime = js.native
  def minus(amount: TemporalAmount): ZonedDateTime = js.native
  def minus(amount: Double, unit: TemporalUnit): ZonedDateTime = js.native
  def minusYears(yearsToSubtract: Double): ZonedDateTime = js.native
  def minusMonths(monthsToSubtract: Double): ZonedDateTime = js.native
  def minusWeeks(weeksToSubtract: Double): ZonedDateTime = js.native
  def minusDays(daysToSubtract: Double): ZonedDateTime = js.native
  def minusHours(hoursToSubtract: Double): ZonedDateTime = js.native
  def minusMinutes(minutesToSubtract: Double): ZonedDateTime = js.native
  def minusSeconds(secondsToSubtract: Double): ZonedDateTime = js.native
  def minusNanos(nanosToSubtract: Double): ZonedDateTime = js.native
  def toLocalDateTime(): LocalDateTime = js.native
  def toLocalDate(): LocalDate = js.native
  def toLocalTime(): LocalTime = js.native
//  def toOffsetDateTime(): OffsetDateTime = js.native
}
