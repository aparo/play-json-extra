package java.time

import java.Wraps

import com.zoepepper.facades.jsjoda.{Clock => ClockF}
import com.zoepepper.facades.jsjoda.{ZoneOffset => ZoneOffsetF}

object Clock extends {
  def fixed(fixedInstant: Instant, zone: ZoneId): Clock = ClockF.fixed(fixedInstant, zone.asInstanceOf[ZoneOffset])
  def offset(baseClock: Clock, offsetDuration: Duration): Clock = ???
  def systemUTC(): Clock = ClockF.systemUTC()
  def systemDefaultZone(): Clock = ClockF.systemDefaultZone()
  def system(zone: ZoneId): Clock = ClockF.system(zone)
  def tick(baseClock: Clock, tickDuration: Duration): Clock = ???
  def tickMinutes(zone: ZoneId): Clock = ???
  def tickSeconds(zone: ZoneId): Clock = ???
}

class Clock protected[time](f: ClockF) extends Wraps(f) {
  def millis(): Long = f.millis.toLong
  def instant(): Instant = f.instant
  def getZone(): ZoneId = f.zone.asInstanceOf[ZoneOffsetF]
  def withZone(zone: ZoneId): Clock = ???

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
