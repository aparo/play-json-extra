package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal._

import scala.scalajs.js.annotation.JSName
import scalajs.js

@js.native
@JSName("JSJoda.Year")
object Year extends js.Object {
  def now(clock: Clock = ???): Year = js.native
  def now(zone: ZoneId): Year = js.native
  def of(isoYear: Int): Year = js.native
  def from(temporal: TemporalAccessor): Year = js.native
  def parse(text: String, formatter: DateTimeFormatter = ???): Year = js.native
  def isLeap(year: Double): Boolean = js.native

  val MAX_VALUE: Year = js.native
  val MIN_VALUE: Year = js.native
}

@js.native
class Year extends Temporal {
  def value(): Int = js.native
  def isLeap(): Boolean = js.native
  def isSupported(field: TemporalUnit): Boolean = js.native
  def minus(amountToSubtract: Double, unit: TemporalUnit): Year = js.native
  def minus(amount: TemporalAmount): Year = js.native
  def minusYears(yearsToSubtract: Double): Year = js.native
  def plus(amountToAdd: Double, unit: TemporalUnit): Year = js.native
  def plus(amount: TemporalAmount): Year = js.native
  def plusYears(yearsToAdd: Double): Year = js.native
  def adjustInto(temporal: Temporal): Temporal = js.native
  def isValidMonthDay(monthDay: MonthDay): Boolean = js.native
  def length(): Int = js.native
  def atDay(dayOfYear: Int): LocalDate = js.native
  def atMonth(month: Int): YearMonth = js.native
  def atMonth(month: Month): YearMonth = js.native
  def atMonthDay(monthDay: MonthDay): LocalDate = js.native
  def compareTo(other: Year): Int = js.native
  def isAfter(other: Year): Boolean = js.native
  def isBefore(other: Year): Boolean = js.native
  def format(formatter: DateTimeFormatter): String = js.native
  def `with`(adjuster: TemporalAdjuster): Year = js.native
  def `with`(field: TemporalField, newValue: Double): Year = js.native
}
