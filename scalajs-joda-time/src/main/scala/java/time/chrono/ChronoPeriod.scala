package java.time.chrono

import java.Wrapper
import java.time.temporal.TemporalAmount

object ChronoPeriod {
  def between(startDateInclusive: ChronoLocalDate, endDateExclusive: ChronoLocalDate): ChronoPeriod = ???
}

trait ChronoPeriod extends TemporalAmount { self: Wrapper =>
  protected[time] val chronoPeriodF = self.f.asInstanceOf[AnyRef]

  def getChronology(): Chronology
  def isNegative(): Boolean
  def isZero(): Boolean
  def minus(amountToSubtract: TemporalAmount): ChronoPeriod
  def multipliedBy(scalar: Int): ChronoPeriod
  def negated(): ChronoPeriod
  def normalized(): ChronoPeriod
  def plus(amountToAdd: TemporalAmount): ChronoPeriod
}
