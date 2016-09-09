package com.zoepepper.facades.jsjoda.chrono

import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal.{Temporal, TemporalField, TemporalUnit}

import scalajs.js

@js.native
trait ChronoLocalDate extends Temporal {
  def isSupported(unit: TemporalUnit): Boolean
  def adjustInto(temporal: Temporal): Temporal
  def format(formatter: DateTimeFormatter): String
}
