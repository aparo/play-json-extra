package org.joda.time.temporal

import org.joda.Wrapper

import com.zoepepper.facades.jsjoda.temporal.{ChronoUnit => ChronoUnitF, TemporalAmount => TemporalAmountF}

trait TemporalAmount { self: Wrapper =>
  protected[time] val temporalAmountF = self.f.asInstanceOf[TemporalAmountF]

  def addTo(temporal: Temporal): Temporal = f2Temporal(temporalAmountF.addTo(temporal), temporal)
  def get(unit: TemporalUnit): Long = temporalAmountF.get(unit).toLong
  def getUnits(): java.util.List[TemporalUnit] = (temporalAmountF.getUnits.map(_.asInstanceOf[ChronoUnitF]): java.util.List[ChronoUnit]).asInstanceOf[java.util.List[TemporalUnit]]
  def subtractFrom(temporal: Temporal): Temporal = f2Temporal(temporalAmountF.subtractFrom(temporal), temporal)
}