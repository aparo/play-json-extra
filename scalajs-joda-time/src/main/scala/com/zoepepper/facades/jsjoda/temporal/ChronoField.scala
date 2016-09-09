package com.zoepepper.facades.jsjoda.temporal

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.ChronoField")
object ChronoField extends js.Object {
  val NANO_OF_SECOND: ChronoField = js.native
  val NANO_OF_DAY: ChronoField = js.native
  val MICRO_OF_SECOND: ChronoField = js.native
  val MICRO_OF_DAY: ChronoField = js.native
  val MILLI_OF_SECOND: ChronoField = js.native
  val MILLI_OF_DAY: ChronoField = js.native
  val SECOND_OF_MINUTE: ChronoField = js.native
  val SECOND_OF_DAY: ChronoField = js.native
  val MINUTE_OF_HOUR: ChronoField = js.native
  val MINUTE_OF_DAY: ChronoField = js.native
  val HOUR_OF_AMPM: ChronoField = js.native
  val CLOCK_HOUR_OF_AMPM: ChronoField = js.native
  val HOUR_OF_DAY: ChronoField = js.native
  val CLOCK_HOUR_OF_DAY: ChronoField = js.native
  val AMPM_OF_DAY: ChronoField = js.native
  val DAY_OF_WEEK: ChronoField = js.native
  val ALIGNED_DAY_OF_WEEK_IN_MONTH: ChronoField = js.native
  val ALIGNED_DAY_OF_WEEK_IN_YEAR: ChronoField = js.native
  val DAY_OF_MONTH: ChronoField = js.native
  val DAY_OF_YEAR: ChronoField = js.native
  val EPOCH_DAY: ChronoField = js.native
  val ALIGNED_WEEK_OF_MONTH: ChronoField = js.native
  val ALIGNED_WEEK_OF_YEAR: ChronoField = js.native
  val MONTH_OF_YEAR: ChronoField = js.native
  val PROLEPTIC_MONTH: ChronoField = js.native
  val YEAR_OF_ERA: ChronoField = js.native
  val YEAR: ChronoField = js.native
  val ERA: ChronoField = js.native
  val INSTANT_SECONDS: ChronoField = js.native
  val OFFSET_SECONDS: ChronoField = js.native
}

@js.native
class ChronoField protected[jsjoda]() extends TemporalField {
  def name(): String = js.native
  def baseUnit(): TemporalUnit = js.native
  def rangeUnit(): TemporalUnit = js.native
  def range(): ValueRange = js.native
  def displayName(): String = js.native
  def checkValidValue(value: Double): Double = js.native
  def checkValidIntValue(value: Double): Int = js.native
  def isDateBased(): Boolean = js.native
  def isTimeBased(): Boolean = js.native
  def rangeRefinedBy(temporal: TemporalAccessor): ValueRange = js.native
  def getFrom(temporal: TemporalAccessor): Double = js.native
}
