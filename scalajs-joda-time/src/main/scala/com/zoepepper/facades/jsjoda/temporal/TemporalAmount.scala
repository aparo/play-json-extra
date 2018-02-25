package com.zoepepper.facades.jsjoda.temporal

import scalajs.js

@js.native
trait TemporalAmount extends js.Object {
  def get(unit: TemporalUnit): Double = js.native
  def getUnits(): js.Array[TemporalUnit] = js.native
  def addTo(temporal: Temporal): Temporal = js.native
  def subtractFrom(temporal: Temporal): Temporal = js.native
}