package com.zoepepper.facades.jsjoda.temporal

import java.time.chrono.Chronology

import com.zoepepper.facades.jsjoda.{LocalDate, LocalTime, ZoneId, ZoneOffset}

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.TemporalQueries")
object TemporalQueries extends js.Object {
  def zoneId(): TemporalQuery[ZoneId] = js.native
  def chronology(): TemporalQuery[Chronology] = js.native
  def precision(): TemporalQuery[TemporalUnit] = js.native
  def zone(): TemporalQuery[ZoneId] = js.native
  def offset(): TemporalQuery[ZoneOffset] = js.native
  def localDate(): TemporalQuery[LocalDate] = js.native
  def localTime(): TemporalQuery[LocalTime] = js.native
}