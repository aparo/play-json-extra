package com.zoepepper.facades.jsjoda.temporal

import scalajs.js

@js.native
class TemporalAccessor protected[jsjoda]() extends js.Object {
  def query[T](query: TemporalQuery[T]): T = js.native
  def get(field: TemporalField): Int = js.native
  def getLong(unit: TemporalUnit): Double = js.native
  def range(field: TemporalField): ValueRange = js.native
  def isSupported(field: TemporalField): Boolean = js.native
}