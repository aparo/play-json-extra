package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.chrono.{ChronoLocalDate, ChronoLocalDateTime}
import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal._

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.LocalDateTime")
object LocalDateTime extends js.Object {
  def now(clock: Clock = ???): LocalDateTime = js.native
  def now(zone: ZoneId): LocalDateTime = js.native
  def ofInstant(instant: Instant, zone: ZoneId = ???): LocalDateTime = js.native
  def of(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int = ???, nanoOfSecond: Int = ???): LocalDateTime = js.native
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int): LocalDateTime = js.native
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int): LocalDateTime = js.native
  def of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanoOfSecond: Int): LocalDateTime = js.native
  def of(date: LocalDate, time: LocalTime): LocalDateTime = js.native
  def ofEpochSecond(epochSecond: Double, nanoOfSecond: Int, offset: ZoneOffset): LocalDateTime = js.native
  def from(temporal: TemporalAccessor): LocalDateTime = js.native
  def parse(text: String, formatter: DateTimeFormatter = ???): LocalDateTime = js.native

  val MAX: LocalDateTime = js.native
  val MIN: LocalDateTime = js.native
}

@js.native
class LocalDateTime protected[jsjoda]() extends ChronoLocalDateTime[ChronoLocalDate] {
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
  def isSupported(unit: TemporalUnit): Boolean = js.native
  def `with`(adjuster: TemporalAdjuster): LocalDateTime = js.native
  def `with`(field: TemporalField, newValue: Double): LocalDateTime = js.native
  def withYear(year: Int): LocalDateTime = js.native
  def withMonth(month: Int): LocalDateTime = js.native
  def withDayOfMonth(dayOfMonth: Int): LocalDateTime = js.native
  def withDayOfYear(dayOfYear: Int): LocalDateTime = js.native
  def withHour(hour: Int): LocalDateTime = js.native
  def withMinute(minute: Int): LocalDateTime = js.native
  def withSecond(second: Int): LocalDateTime = js.native
  def withNano(nanoOfSecond: Int): LocalDateTime = js.native
  def truncatedTo(unit: TemporalUnit): LocalDateTime = js.native
  def plus(amount: TemporalAmount): LocalDateTime = js.native
  def plus(amount: Double, unit: TemporalUnit): LocalDateTime = js.native
  def plusYears(yearsToAdd: Double): LocalDateTime = js.native
  def plusMonths(monthsToAdd: Double): LocalDateTime = js.native
  def plusWeeks(weeksToAdd: Double): LocalDateTime = js.native
  def plusDays(daysToAdd: Double): LocalDateTime = js.native
  def plusHours(hoursToAdd: Double): LocalDateTime = js.native
  def plusMinutes(minutesToAdd: Double): LocalDateTime = js.native
  def plusSeconds(secondsToAdd: Double): LocalDateTime = js.native
  def plusNanos(nanosToAdd: Double): LocalDateTime = js.native
  def minus(amount: TemporalAmount): LocalDateTime = js.native
  def minus(amount: Double, unit: TemporalUnit): LocalDateTime = js.native
  def minusYears(yearsToSubtract: Double): LocalDateTime = js.native
  def minusMonths(monthsToSubtract: Double): LocalDateTime = js.native
  def minusWeeks(weeksToSubtract: Double): LocalDateTime = js.native
  def minusDays(daysToSubtract: Double): LocalDateTime = js.native
  def minusHours(hoursToSubtract: Double): LocalDateTime = js.native
  def minusMinutes(minutesToSubtract: Double): LocalDateTime = js.native
  def minusSeconds(secondsToSubtract: Double): LocalDateTime = js.native
  def minusNanos(nanosToSubtract: Double): LocalDateTime = js.native
  def atZone(zone: ZoneId): ZonedDateTime = js.native
  def toLocalDate(): LocalDate = js.native
  def toLocalTime(): LocalTime = js.native
  def compareTo(other: LocalDateTime): Int = js.native
  def isAfter(other: LocalDateTime): Boolean = js.native
  def isBefore(other: LocalDateTime): Boolean = js.native
  def isEqual(other: LocalDateTime): Boolean = js.native
  def format(formatter: DateTimeFormatter): String = js.native
}
