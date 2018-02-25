package java.time

import java.Wraps
import java.time.chrono.{ChronoPeriod, IsoChronology}
import java.time.temporal.TemporalAmount

import com.zoepepper.facades.jsjoda.{Period => PeriodF}

object Period {
  def between(startDateInclusive: LocalDate, endDateExclusive: LocalDate): Period = PeriodF.between(startDateInclusive, endDateExclusive)
  def from(amount: TemporalAmount): Period = PeriodF.from(amount)
  def of(years: Int, months: Int, days: Int): Period = PeriodF.of(years, months, days)
  def ofDays(days: Int): Period = PeriodF.ofDays(days)
  def ofMonths(months: Int): Period = PeriodF.ofMonths(months)
  def ofWeeks(weeks: Int): Period = PeriodF.ofWeeks(weeks)
  def ofYears(years: Int): Period = PeriodF.ofYears(years)
  def parse(text: CharSequence): Period = PeriodF.parse(text.toString)

  val ZERO: Period = PeriodF.ZERO
}

class Period protected[time](f: PeriodF) extends Wraps(f) with ChronoPeriod {
  def getChronology(): IsoChronology = f.chronology
  def getDays(): Int = f.days
  def getMonths(): Int = f.months
  def getYears(): Int = f.years
  def isNegative(): Boolean = f.isNegative
  def isZero(): Boolean = f.isZero
  def minus(amountToSubtract: TemporalAmount): Period = f.minus(amountToSubtract)
  def minusDays(daysToSubtract: Long): Period = f.minusDays(daysToSubtract)
  def minusMonths(monthsToSubtract: Long): Period = f.minusMonths(monthsToSubtract)
  def minusYears(yearsToSubtract: Long): Period = f.minusYears(yearsToSubtract)
  def multipliedBy(scalar: Int): Period = f.multipliedBy(scalar)
  def negated(): Period = f.negated()
  def normalized(): Period = f.normalized()
  def plus(amountToAdd: TemporalAmount): Period = f.plus(amountToAdd)
  def plusDays(daysToAdd: Long): Period = f.plusDays(daysToAdd)
  def plusMonths(monthsToAdd: Long): Period = f.plusMonths(monthsToAdd)
  def plusYears(yearsToAdd: Long): Period = f.plusYears(yearsToAdd)
  def withDays(days: Int): Period = f.withDays(days)
  def withMonths(months: Int): Period = f.withMonths(months)
  def withYears(years: Int): Period = f.withYears(years)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
