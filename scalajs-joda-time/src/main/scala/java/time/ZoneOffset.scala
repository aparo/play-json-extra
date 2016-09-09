package java.time

import java.Wraps
import java.time.temporal.{TemporalAccessor, TemporalAdjuster}

import com.zoepepper.facades.jsjoda.{ZoneOffset => ZoneOffsetF}

object ZoneOffset {
  def from(temporal: TemporalAccessor): ZoneOffset = ???
  def of(offsetId: String): ZoneOffset = ZoneOffsetF.of(offsetId)
  def ofHours(hours: Int): ZoneOffset = ZoneOffsetF.ofHours(hours)
  def ofHoursMinutes(hours: Int, minutes: Int): ZoneOffset = ZoneOffsetF.ofHoursMinutes(hours, minutes)
  def ofHoursMinutesSeconds(hours: Int, minutes: Int, seconds: Int): ZoneOffset = ZoneOffsetF.ofHoursMinutesSeconds(hours, minutes, seconds)
  def ofTotalSeconds(totalSeconds: Int): ZoneOffset = ZoneOffsetF.ofTotalSeconds(totalSeconds)

  val UTC: ZoneOffset = ZoneOffsetF.UTC
  val MIN: ZoneOffset = ZoneOffsetF.MIN
  val MAX: ZoneOffset = ZoneOffsetF.MAX
}

class ZoneOffset protected[time](f: ZoneOffsetF) extends Wraps(f) with Comparable[ZoneOffset]
  with ZoneId with TemporalAccessor with TemporalAdjuster {
  def compareTo(other: ZoneOffset): Int = f.compareTo(other)
  def getId(): String = f.id
  def getTotalSeconds(): Int = f.totalSeconds

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
