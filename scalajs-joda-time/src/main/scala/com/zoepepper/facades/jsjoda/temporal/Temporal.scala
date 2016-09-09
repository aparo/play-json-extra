package com.zoepepper.facades.jsjoda.temporal

import scalajs.js

@js.native
trait Temporal extends TemporalAccessor {
  def minus(amountToSubtract: Double, unit: TemporalUnit): Temporal
  def minus(amount: TemporalAmount): Temporal
  def plus(amountToAdd: Double, unit: TemporalUnit): Temporal
  def plus(amount: TemporalAmount): Temporal
  def until(endExclusive: Temporal, unit: TemporalUnit): Double = js.native
  def `with`(adjuster: TemporalAdjuster): Temporal
  def `with`(field: TemporalField, newValue: Double): Temporal
}