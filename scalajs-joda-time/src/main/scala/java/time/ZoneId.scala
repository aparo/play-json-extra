package java.time

import java.Wrapper
import java.time.format.TextStyle
import java.time.temporal.TemporalAccessor
import java.time.zone.ZoneRules
import java.util.Locale

import com.zoepepper.facades.jsjoda.{ZoneId => ZoneIdF}
import com.zoepepper.facades.jsjoda.{ZoneOffset => ZoneOffsetF}

object ZoneId {
  def from(temporal: TemporalAccessor): ZoneId = ???
  def getAvailableZoneIds(): java.util.Set[ZoneId] = ???
  def of(zoneId: String): ZoneId = ???
  def of(zoneId: String, aliasMap: java.util.Map[String, String]): ZoneId = ???
  def ofOffset(prefix: String, offset: ZoneOffset): ZoneId = ???
  def systemDefault(): ZoneId = ???

  val SHORT_IDS: java.util.Map[String, String] = ???
}

trait ZoneId { self: Wrapper =>
  protected[time] val zoneIdF = self.f.asInstanceOf[ZoneIdF]

  def getDisplayName(style: TextStyle, locale: Locale): String = ???
  def getId(): String
  def getRules(): ZoneRules = zoneIdF.rules
  def normalized(): ZoneId = zoneIdF.normalized.asInstanceOf[ZoneOffsetF] // Review once there are actual ZoneIds.

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
