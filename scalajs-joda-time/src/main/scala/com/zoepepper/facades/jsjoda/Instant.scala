package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.temporal._

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.Instant")
object Instant extends js.Object {
  def now(clock: Clock = ???): Instant = js.native
  def ofEpochSecond(epochSecond: Double, nanoAdjustment: Double = ???): Instant = js.native
  def ofEpochMilli(epochMilli: Double): Instant = js.native
  def from(temporal: Temporal): Instant = js.native
  def parse(text: String): Instant = js.native

  val EPOCH: Instant = js.native
  val MAX: Instant = js.native
  val MIN: Instant = js.native
}

@js.native
class Instant protected[jsjoda]() extends Temporal {
  def epochSecond(): Double = js.native
  def nano(): Int = js.native
  def isSupported(unit: TemporalUnit): Boolean = js.native
  def `with`(adjuster: TemporalAdjuster): Instant = js.native
  def `with`(field: TemporalField, newValue: Double): Instant = js.native
  def truncatedTo(unit: TemporalUnit): Instant = js.native
  def plus(amount: TemporalAmount): Instant = js.native
  def plus(amount: Double, unit: TemporalUnit): Instant = js.native
  def plusSeconds(secondsToAdd: Double): Instant = js.native
  def plusMillis(millisToAdd: Double): Instant = js.native
  def plusNanos(nanosToAdd: Double): Instant = js.native
  def minus(amount: TemporalAmount): Instant = js.native
  def minus(amount: Double, unit: TemporalUnit): Instant = js.native
  def minusSeconds(secondsToSubtract: Double): Instant = js.native
  def minusMillis(millisToSubtract: Double): Instant = js.native
  def minusNanos(nanosToSubtract: Double): Instant = js.native
  def adjustInto(temporal: Temporal): Temporal = js.native
  def toEpochMilli(): Double = js.native
  def compareTo(otherInstant: Instant): Int = js.native
  def isAfter(otherInstant: Instant): Boolean = js.native
  def isBefore(otherInstant: Instant): Boolean = js.native
}
