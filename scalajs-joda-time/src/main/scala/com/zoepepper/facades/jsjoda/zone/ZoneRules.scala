package com.zoepepper.facades.jsjoda.zone

import com.zoepepper.facades.jsjoda.{Instant, LocalDateTime, LocalTime, ZoneOffset}

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.ZoneRules")
object ZoneRules extends js.Object {
  def of(offset: ZoneOffset): ZoneRules = js.native
}

@js.native
trait ZoneRules extends js.Object {
  def isFixedOffset(): Boolean = js.native
  def offset(instant: Instant): ZoneOffset = js.native
  def offset(localDateTime: LocalDateTime): ZoneOffset = js.native
  def isValidOffset(localDateTime: LocalDateTime, offset: ZoneOffset): Boolean = js.native
}