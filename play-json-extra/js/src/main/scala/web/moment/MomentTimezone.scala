package web.moment

import scala.scalajs.js


trait MomentZone extends js.Object {
  var name: String = js.native
  var abbrs: js.Array[String] = js.native
  var untils: js.Array[Double] = js.native
  var offsets: js.Array[Double] = js.native
  def abbr(timestamp: Double): String = js.native
  def offset(timestamp: Double): Double = js.native
  def parse(timestamp: Double): Double = js.native
}

trait MomentTimezone extends js.Object {
  def apply(date: Double, timezone: String): Moment = js.native
  def apply(date: String, format: String, timezone: String): Moment = js.native
  def zone(timezone: String): MomentZone = js.native
  def add(packedZoneString: String): Unit = js.native
  def link(packedLinkString: String): Unit = js.native
  def load(data: js.Any): Unit = js.native
  def names(): js.Array[String] = js.native
}
