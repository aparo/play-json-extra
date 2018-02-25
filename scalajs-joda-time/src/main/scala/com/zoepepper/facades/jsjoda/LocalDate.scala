package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.chrono.{ChronoLocalDate, IsoChronology}
import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal._

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.LocalDate")
object LocalDate extends js.Object {
  def now(clock: Clock = ???): LocalDate = js.native
  def now(zone: ZoneId): LocalDate = js.native
  def ofInstant(instant: Instant, zone: ZoneId = ???): LocalDate = js.native
  def of(year: Int, month: Int, dayOfMonth: Int): LocalDate = js.native
  def of(year: Int, month: Month, dayOfMonth: Int): LocalDate = js.native
  def ofYearDay(year: Int, dayOfYear: Int): LocalDate = js.native
  def ofEpochDay(epochDay: Double): LocalDate = js.native
  def from(temporal: TemporalAccessor): LocalDate = js.native
  def parse(text: String, formatter: format.DateTimeFormatter = ???): LocalDate = js.native

  val MAX: LocalDate = js.native
  val MIN: LocalDate = js.native
}

@js.native
class LocalDate protected[jsjoda]() extends ChronoLocalDate {
  def year(): Int = js.native
  def month(): Month = js.native
  def monthValue(): Int = js.native
  def dayOfMonth(): Int = js.native
  def dayOfYear(): Int = js.native
  def dayOfWeek(): DayOfWeek = js.native
  def chronology(): IsoChronology = js.native
  def isLeapYear(): Boolean = js.native
  def lengthOfMonth(): Int = js.native
  def lengthOfYear(): Int = js.native
  def `with`(adjuster: TemporalAdjuster): LocalDate = js.native
  def `with`(field: TemporalField, newValue: Double): LocalDate = js.native
  def withYear(year: Int): LocalDate = js.native
  def withMonth(month: Int): LocalDate = js.native
  def withDayOfMonth(dayOfMonth: Int): LocalDate = js.native
  def withDayOfYear(dayOfYear: Int): LocalDate = js.native
  def plus(amount: TemporalAmount): LocalDate = js.native
  def plus(amount: Double, unit: TemporalUnit): LocalDate = js.native
  def plusYears(yearsToAdd: Double): LocalDate = js.native
  def plusMonths(monthsToAdd: Double): LocalDate = js.native
  def plusWeeks(weeksToAdd: Double): LocalDate = js.native
  def plusDays(daysToAdd: Double): LocalDate = js.native
  def minus(amount: TemporalAmount): LocalDate = js.native
  def minus(amount: Double, unit: TemporalUnit): LocalDate = js.native
  def minusYears(yearsToSubtract: Double): LocalDate = js.native
  def minusMonths(monthsToSubtract: Double): LocalDate = js.native
  def minusWeeks(weeksToSubtract: Double): LocalDate = js.native
  def minusDays(daysToSubtract: Double): LocalDate = js.native
  def until(endDate: ChronoLocalDate): Period = js.native
  def atTime(time: LocalTime): LocalDateTime = js.native
  def atTime(hour: Int, minute: Int, second: Int = ???, nanoOfSecond: Int = ???): LocalDateTime = js.native
  def atStartOfDay(zone: ZoneId = ???): LocalDateTime = js.native
  def toEpochDay(): Double = js.native
  def compareTo(other: LocalDate): Int = js.native
  def isAfter(other: LocalDate): Boolean = js.native
  def isBefore(other: LocalDate): Boolean = js.native
  def isEqual(other: LocalDate): Boolean = js.native
  def isSupported(unit: TemporalUnit): Boolean = js.native
  def adjustInto(temporal: Temporal): Temporal = js.native
  def format(formatter: DateTimeFormatter): String = js.native
}
