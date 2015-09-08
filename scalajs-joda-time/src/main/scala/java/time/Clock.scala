package java.time

import temporal.{TemporalUnit, TemporalField, Temporal}

trait Clock {
  def instant:Instant
  def getZone():ZoneId
  def withZone(zone: ZoneId): Clock
  def isSupported(unit: TemporalUnit): Boolean
  def plus(amountToAdd: Long, unit: TemporalUnit): Temporal
  def until(endExclusive: Temporal, unit: TemporalUnit): Long
  def `with`(field: TemporalField, newValue: Long): Temporal
  def isSupported(field: TemporalField): Boolean
  def getLong(field: TemporalField): Long
}

object Clock {
  def fixed(instant: Instant, zone: ZoneId)=  new FixedClock(instant, zone)
  def system(zone: ZoneId)=  new FixedClock(Instant.now(), zone)

}

case class FixedClock(instant: Instant, zone: ZoneId) extends Temporal with Clock {

  override def getZone: ZoneId = zone
  override def withZone(zone: ZoneId): Clock = new FixedClock(this.instant, zone)
  override def isSupported(unit: TemporalUnit): Boolean = ???
  override def plus(amountToAdd: Long, unit: TemporalUnit): Temporal = ???
  override def until(endExclusive: Temporal, unit: TemporalUnit): Long = ???
  override def `with`(field: TemporalField, newValue: Long): Temporal = ???
  override def isSupported(field: TemporalField): Boolean = ???
  override def getLong(field: TemporalField): Long = ???

}
