package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal.{TemporalAdjuster, _}

import scala.scalajs.js.annotation.JSName
import scalajs.js

@js.native
@JSName("JSJoda.YearMonth")
object YearMonth extends js.Object {
  def now(clock: Clock = ???): YearMonth = js.native
  def now(zone: ZoneId): YearMonth = js.native
  def of(year: Int, month: Int): YearMonth = js.native
  def of(year: Int, month: Month): YearMonth = js.native
  def from(temporal: TemporalAccessor): YearMonth = js.native
  def parse(text: String, formatter: DateTimeFormatter = ???): YearMonth = js.native
}

@js.native
class YearMonth extends Temporal {
  def year(): Int = js.native
  def monthValue(): Int = js.native
  def month(): Month = js.native
  def isLeapYear(): Boolean = js.native
  def isValidDay(dayOfMonth: Int): Boolean = js.native
  def lengthOfMonth(): Int = js.native
  def lengthOfYear(): Int = js.native
  def isSupported(field: TemporalUnit): Boolean = js.native
  def withYear(year: Int): YearMonth = js.native
  def withMonth(month: Int): YearMonth = js.native
  def plusMonths(monthsToAdd: Double): YearMonth = js.native
  def minusMonths(monthsToSubtract: Double): YearMonth = js.native
  def plusYears(yearsToAdd: Double): YearMonth = js.native
  def minusYears(yearsToSubtract: Double): YearMonth = js.native
  def adjustInto(temporal: Temporal): Temporal = js.native
  def atDay(dayOfMonth: Int): LocalDate = js.native
  def atEndOfMonth(): LocalDate = js.native
  def compareTo(other: YearMonth): Int = js.native
  def isAfter(other: YearMonth): Boolean = js.native
  def isBefore(other: YearMonth): Boolean = js.native

  def minus(amountToSubtract: Double, unit: TemporalUnit): YearMonth = js.native
  def minus(amount: TemporalAmount): YearMonth = js.native
  def plus(amountToAdd: Double, unit: TemporalUnit): YearMonth = js.native
  def plus(amount: TemporalAmount): YearMonth = js.native
  def `with`(adjuster: TemporalAdjuster): YearMonth = js.native
  def `with`(field: TemporalField, newValue: Double): YearMonth = js.native
}
