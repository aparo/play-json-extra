package com.zoepepper.facades.jsjoda.chrono

import com.zoepepper.facades.jsjoda.{Instant, ZoneOffset}
import com.zoepepper.facades.jsjoda.temporal.Temporal

import scalajs.js

@js.native
trait ChronoLocalDateTime[D <: ChronoLocalDate] extends Temporal {
  def chronology(): IsoChronology = js.native
  def adjustInto(temporal: Temporal): Temporal = js.native
  def toInstant(offset: ZoneOffset): Instant = js.native
  def toEpochSecond(offset: ZoneOffset): Long = js.native
}
