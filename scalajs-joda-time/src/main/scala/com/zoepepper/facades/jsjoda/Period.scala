package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.chrono.IsoChronology
import com.zoepepper.facades.jsjoda.temporal.{ChronoUnit, TemporalAmount}

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.Period")
object Period extends js.Object {
  def ofYears(years: Int): Period = js.native
  def ofMonths(months: Int): Period = js.native
  def ofWeeks(weeks: Int): Period = js.native
  def ofDays(days: Int): Period = js.native
  def of(years: Int, months: Int, days: Int): Period = js.native
  def from(amount: TemporalAmount): Period = js.native
  def between(startDate: LocalDate, endDate: LocalDate): Period = js.native
  def parse(text: String): Period = js.native

  val ZERO: Period = js.native
}

@js.native
class Period extends TemporalAmount {
  def units(): Array[ChronoUnit] = js.native
  def chronology(): IsoChronology = js.native
  def isZero(): Boolean = js.native
  def isNegative(): Boolean = js.native
  def years(): Int = js.native
  def months(): Int = js.native
  def days(): Int = js.native
  def withYears(years: Int): Period = js.native
  def withMonths(months: Int): Period = js.native
  def withDays(days: Int): Period = js.native
  def plus(amountToAdd: TemporalAmount): Period = js.native
  def plusYears(yearsToAdd: Double): Period = js.native
  def plusMonths(monthsToAdd: Double): Period = js.native
  def plusDays(daysToAdd: Double): Period = js.native
  def minus(amountToSubtract: TemporalAmount): Period = js.native
  def minusYears(yearsToSubtract: Double): Period = js.native
  def minusMonths(monthsToSubtract: Double): Period = js.native
  def minusDays(daysToSubtract: Double): Period = js.native
  def multipliedBy(scalar: Int): Period = js.native
  def negated(): Period = js.native
  def normalized(): Period = js.native
  def toTotalMonths(): Double = js.native
  
}
