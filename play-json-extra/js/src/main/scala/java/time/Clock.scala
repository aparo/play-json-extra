package java.time

import temporal.{TemporalUnit, TemporalField, Temporal}

trait Clock {
  def instant:Instant
  def getZone():ZoneId
}

object Clock {
  def fixed(instant: Instant, zone: ZoneId)=  new FixedClock(instant, zone)
  def system(zone: ZoneId)=  new FixedClock(Instant.now(), zone)

}

case class FixedClock(instant: Instant, zone: ZoneId) extends Temporal with Clock {

  def getZone: ZoneId = zone

  def withZone(zone: ZoneId): Clock = new FixedClock(this.instant, zone)

  def isSupported(unit: TemporalUnit): Boolean = ???

  def plus(amountToAdd: Long, unit: TemporalUnit): Temporal = ???

  def until(endExclusive: Temporal, unit: TemporalUnit): Long = ???

  def `with`(field: TemporalField, newValue: Long): Temporal = ???

  def isSupported(field: TemporalField): Boolean = ???

  def getLong(field: TemporalField): Long = ???

}
