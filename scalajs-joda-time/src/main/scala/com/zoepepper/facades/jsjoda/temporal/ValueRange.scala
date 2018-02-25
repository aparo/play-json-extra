package com.zoepepper.facades.jsjoda.temporal

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.ValueRange")
object ValueRange extends js.Object {
  def of(min: Double, max: Double): ValueRange = js.native
  def of(min: Double, maxSmallest: Double, maxLargest: Double): ValueRange = js.native
  def of(minSmallest: Double, minLargest: Double, maxSmallest: Double, maxLargest: Double): ValueRange = js.native
}

@js.native
class ValueRange protected[jsjoda]() extends js.Object {
  def isFixed(): Boolean = js.native
  def minimum(): Double = js.native
  def largestMinimum(): Double = js.native
  def maximum(): Double = js.native
  def smallestMaximum(): Double = js.native
  def isValidValue(value: Double): Boolean = js.native
  def isValidIntValue(value: Double): Boolean = js.native
  def checkValidValue(value: Double, field: TemporalField): Double = js.native
  def checkValidIntValue(value: Double, field: TemporalField): Int = js.native
  def isIntValue(): Boolean = js.native
}
