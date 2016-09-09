package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal.{TemporalField, _}

import scala.scalajs.js.annotation.JSName
import scalajs.js

@js.native
@JSName("JSJoda.MonthDay")
object MonthDay extends js.Object {
  def now(clock: Clock = ???): MonthDay = js.native
  def now(zone: ZoneId): MonthDay = js.native
  def of(month: Int, dayOfMonth: Int): MonthDay = js.native
  def of(month: Month, dayOfMonth: Int): MonthDay = js.native
  def from(temporal: TemporalAccessor): MonthDay = js.native
  def parse(text: String, formatter: DateTimeFormatter = ???): MonthDay = js.native
}

@js.native
class MonthDay extends Temporal {
  def monthValue(): Int = js.native
  def month(): Month = js.native
  def dayOfMonth(): Int = js.native
  def isValidYear(year: Int): Boolean = js.native
  def `with`(month: Month): MonthDay = js.native
  def withMonth(month: Int): MonthDay = js.native
  def withDayOfMonth(dayOfMonth: Int): MonthDay = js.native
  def adjustInto(temporal: Temporal): Temporal = js.native
  def atYear(year: Int): LocalDate = js.native
  def compareTo(other: MonthDay): Int = js.native
  def isAfter(other: MonthDay): Boolean = js.native
  def isBefore(other: MonthDay): Boolean = js.native
  def format(formatter: DateTimeFormatter): String = js.native

  def minus(amountToSubtract: Double, unit: TemporalUnit): MonthDay = js.native
  def minus(amount: TemporalAmount): MonthDay = js.native
  def plus(amountToAdd: Double, unit: TemporalUnit): MonthDay = js.native
  def plus(amount: TemporalAmount): MonthDay = js.native
  def `with`(adjuster: TemporalAdjuster): MonthDay = js.native
  def `with`(field: TemporalField, newValue: Double): MonthDay = js.native
}
