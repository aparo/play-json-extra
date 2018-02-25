package java.time.temporal

import java.Wrapper
import java.time.Duration

import com.zoepepper.facades.jsjoda.temporal.{ChronoUnit => ChronoUnitF}

trait TemporalUnit { self: Wrapper =>
  protected[time] val temporalUnitF = self.f.asInstanceOf[ChronoUnitF]

  def addTo[R <: Temporal](temporal: R, amount: Long): R = temporalUnitF.addTo(temporal, amount).asInstanceOf[R]
  def isDateBased(): Boolean = temporalUnitF.isDateBased
  def isDurationEstimated(): Boolean = temporalUnitF.isDurationEstimated
  def between(temporal1Inclusive: Temporal, temporal2Exclusive: Temporal): Long = temporalUnitF.between(temporal1Inclusive, temporal2Exclusive).toLong
  def isTimeBased(): Boolean = temporalUnitF.isTimeBased
  def getDuration(): Duration = temporalUnitF.duration
  def isSupportedBy(temporal: Temporal): Boolean = temporalUnitF.isSupportedBy(temporal)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
