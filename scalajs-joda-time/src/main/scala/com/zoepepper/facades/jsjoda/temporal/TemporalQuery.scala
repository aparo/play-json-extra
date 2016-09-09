package com.zoepepper.facades.jsjoda.temporal

import com.zoepepper.facades.jsjoda.Enum

import scalajs.js

@js.native
trait TemporalQuery[T] extends Enum {
  def queryFrom(temporal: TemporalAccessor): T
}