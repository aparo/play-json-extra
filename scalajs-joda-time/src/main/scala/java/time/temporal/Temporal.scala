package java.time.temporal

import _root_.java.time.{Clock, ZoneId}

/**
 * Created by alberto on 07/06/15.
 */
trait Temporal {
  def isSupported(unit: TemporalUnit): Boolean=true

  def plus(amountToAdd: Long, unit: TemporalUnit): Temporal=null

  def until(endExclusive: Temporal, unit: TemporalUnit): Long

  def `with`(field: TemporalField, newValue: Long): Temporal=null

  def getZone: ZoneId=null

  def withZone(zone: ZoneId): Clock=null

  def isSupported(field: TemporalField): Boolean=true

  def getLong(field: TemporalField): Long=0L
}

trait TemporalUnit {

}

trait TemporalField {

}
