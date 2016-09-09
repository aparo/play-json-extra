package com.zoepepper.facades.jsjoda

import java.time.temporal.{ChronoUnit, TemporalUnit}

import com.zoepepper.facades.jsjoda.temporal.{Temporal, TemporalAmount}

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.Duration")
object Duration extends js.Object {
  def ofDays(days: Double): Duration = js.native
  def ofHours(hours: Double): Duration = js.native
  def ofMinutes(minutes: Double): Duration = js.native
  def ofSeconds(seconds: Double, nanoAdjustment: Double = ???): Duration = js.native
  def ofMillis(millis: Double): Duration = js.native
  def ofNanos(nanos: Double): Duration = js.native
  def of(amount: Double, unit: TemporalUnit): Duration = js.native
  def from(amount: TemporalAmount): Duration = js.native
  def between(startInclusive: Temporal, endExclusive: Temporal): Duration = js.native
  def parse(text: String): Duration = js.native

  val ZERO: Duration = js.native
}

@js.native
class Duration protected[jsjoda]() extends TemporalAmount {
  def seconds(): Double = js.native
  def nano(): Int = js.native
  def isZero(): Boolean = js.native
  def isNegative(): Boolean = js.native
  def withSeconds(seconds: Double): Duration = js.native
  def withNanos(nanoOfSecond: Int): Duration = js.native
  def plus(duration: Duration): Duration = js.native
  def plus(amountToAdd: Double, unit: ChronoUnit): Duration = js.native
  def plusDays(daysToAdd: Double): Duration = js.native
  def plusHours(hoursToAdd: Double): Duration = js.native
  def plusMinutes(minutesToAdd: Double): Duration = js.native
  def plusSeconds(secondsToAdd: Double): Duration = js.native
  def plusMillis(millisToAdd: Double): Duration = js.native
  def plusNanos(nanosToAdd: Double): Duration = js.native
  def minus(duration: Duration): Duration = js.native
  def minus(amountToSubtract: Double, unit: ChronoUnit): Duration = js.native
  def minusDays(daysToSubtract: Double): Duration = js.native
  def minusHours(hoursToSubtract: Double): Duration = js.native
  def minusMinutes(minutesToSubtract: Double): Duration = js.native
  def minusSeconds(secondsToSubtract: Double): Duration = js.native
  def minusMillis(millisToSubtract: Double): Duration = js.native
  def minusNanos(nanosToSubtract: Double): Duration = js.native
  def multipliedBy(multiplicand: Double): Duration = js.native
  def dividedBy(divisor: Double): Duration = js.native
  def negated(): Duration = js.native
  def abs(): Duration = js.native
  def toDays(): Double = js.native
  def toHours(): Double = js.native
  def toMinutes(): Double = js.native
  def toMillis(): Double = js.native
  def toNanos(): Double = js.native
  def compareTo(otherDuration: Duration): Int = js.native
}
