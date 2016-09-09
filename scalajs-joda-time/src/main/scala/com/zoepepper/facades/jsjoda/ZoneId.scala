package com.zoepepper.facades.jsjoda

import com.zoepepper.facades.jsjoda.zone.ZoneRules

import scalajs.js

@js.native
trait ZoneId extends js.Object {
  def rules(): ZoneRules = js.native
  def normalized(): ZoneId = js.native
}
