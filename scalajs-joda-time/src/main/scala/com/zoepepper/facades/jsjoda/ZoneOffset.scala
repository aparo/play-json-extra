package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.temporal.{Temporal, TemporalField, TemporalQuery}
import com.zoepepper.facades.jsjoda.zone.ZoneRules

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.ZoneOffset")
object ZoneOffset extends js.Object {
  def of(offsetId: String): ZoneOffset = js.native
  def ofHours(hours: Int): ZoneOffset = js.native
  def ofHoursMinutes(hours: Int, minutes: Int): ZoneOffset = js.native
  def ofHoursMinutesSeconds(hours: Int, minutes: Int, seconds: Int): ZoneOffset = js.native
  def ofTotalMinutes(totalMinutes: Int): ZoneOffset = js.native
  def ofTotalSeconds(totalSeconds: Int): ZoneOffset = js.native

  val UTC: ZoneOffset = js.native
  val MIN: ZoneOffset = js.native
  val MAX: ZoneOffset = js.native
}

@js.native
trait ZoneOffset extends ZoneId {
  def totalSeconds(): Int = js.native
  def id(): String = js.native
  def get(field: TemporalField): Int = js.native
  def query[T](query: TemporalQuery[T]): T = js.native
  def adjustInto(temporal: Temporal): Temporal = js.native
  def compareTo(other: ZoneOffset): Int = js.native
}
