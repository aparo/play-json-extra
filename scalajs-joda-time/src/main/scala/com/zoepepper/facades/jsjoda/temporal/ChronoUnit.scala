package com.zoepepper.facades.jsjoda.temporal

import com.zoepepper.facades.jsjoda.Duration

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.ChronoUnit")
object ChronoUnit extends js.Object {
  val NANOS: ChronoUnit = js.native
  val MICROS: ChronoUnit = js.native
  val MILLIS: ChronoUnit = js.native
  val SECONDS: ChronoUnit = js.native
  val MINUTES: ChronoUnit = js.native
  val HOURS: ChronoUnit = js.native
  val HALF_DAYS: ChronoUnit = js.native
  val DAYS: ChronoUnit = js.native
  val WEEKS: ChronoUnit = js.native
  val MONTHS: ChronoUnit = js.native
  val YEARS: ChronoUnit = js.native
  val DECADES: ChronoUnit = js.native
  val CENTURIES: ChronoUnit = js.native
  val MILLENNIA: ChronoUnit = js.native
  val ERAS: ChronoUnit = js.native
  val FOREVER: ChronoUnit = js.native
}

@js.native
class ChronoUnit protected[jsjoda]() extends TemporalUnit {
  def duration(): Duration = js.native
  def isDurationEstimated(): Boolean = js.native
  def isDateBased(): Boolean = js.native
  def isTimeBased(): Boolean = js.native
  def isSupportedBy(temporal: Temporal): Boolean = js.native
  def addTo(temporal: Temporal, amount: Double): Temporal = js.native
  def between(temporal1: Temporal, temporal2: Temporal): Double = js.native
  def compareTo(other: TemporalUnit): Int = js.native
}
