package java.time.temporal

import java.Wrapper

import com.zoepepper.facades.jsjoda.temporal.{Temporal => TemporalF}

trait Temporal extends TemporalAccessor { self: Wrapper =>
  protected[time] val temporalF = self.f.asInstanceOf[TemporalF]

  def minus(amountToSubtract: Long, unit: TemporalUnit): Temporal
  def minus(amount: TemporalAmount): Temporal
  def plus(amountToAdd: Long, unit: TemporalUnit): Temporal
  def plus(amount: TemporalAmount): Temporal
  def until(endExclusive: Temporal, unit: TemporalUnit): Long = temporalF.until(endExclusive, unit).toLong
  def `with`(adjuster: TemporalAdjuster): Temporal
  def `with`(field: TemporalField, newValue: Long): Temporal
}