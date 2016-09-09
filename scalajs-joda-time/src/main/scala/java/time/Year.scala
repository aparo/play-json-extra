package java.time

import java.Wraps
import java.time.format.DateTimeFormatter
import java.time.temporal.{Temporal, TemporalAccessor, TemporalAdjuster, TemporalAmount, TemporalField, TemporalUnit}

import com.zoepepper.facades.jsjoda.{Year => YearF}

object Year {
  def from(temporal: TemporalAccessor): Year = YearF.from(temporal)
  def isLeap(year: Long): Boolean = YearF.isLeap(year)
  def now(): Year = YearF.now()
  def now(clock: Clock): Year = YearF.now(clock)
  def now(zone: ZoneId): Year = YearF.now(zone)
  def of(isoYear: Int): Year = YearF.of(isoYear)
  def parse(text: CharSequence): Year = YearF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): Year = YearF.parse(text.toString, formatter)

  val MAX_VALUE: Year = YearF.MAX_VALUE
  val MIN_VALUE: Year = YearF.MIN_VALUE
}

class Year protected[time](f: YearF) extends Wraps(f) with Comparable[Year]
  with Temporal with TemporalAdjuster {
  def atDay(dayOfYear: Int): LocalDate = f.atDay(dayOfYear)
  def atMonth(month: Int): YearMonth = f.atMonth(month)
  def atMonth(month: Month): YearMonth = f.atMonth(month)
  def atMonthDay(monthDay: MonthDay): LocalDate = f.atMonthDay(monthDay)
  def compareTo(other: Year): Int = f.compareTo(other)
  def format(formatter: DateTimeFormatter): String = f.format(formatter)
  def getValue(): Int = f.value
  def isAfter(other: Year): Boolean = f.isAfter(other)
  def isBefore(other: Year): Boolean = f.isBefore(other)
  def isLeap(): Boolean = f.isLeap
  def isSupported(unit: TemporalUnit): Boolean = f.isSupported(unit)
  def isValidMonthDay(monthDay: MonthDay): Boolean = f.isValidMonthDay(monthDay)
  def length(): Int = f.length
  def minus(amountToSubtract: Long, unit: TemporalUnit): Year = f.minus(amountToSubtract, unit)
  def minus(amountToSubtract: TemporalAmount): Year = f.minus(amountToSubtract)
  def minusYears(yearsToSubtract: Long): Year = f.minusYears(yearsToSubtract)
  def plus(amountToAdd: Long, unit: TemporalUnit): Year = f.plus(amountToAdd, unit)
  def plus(amountToAdd: TemporalAmount): Year = f.plus(amountToAdd)
  def plusYears(yearsToAdd: Long): Year = f.plusYears(yearsToAdd)
  def `with`(adjuster: TemporalAdjuster): Year = f.`with`(adjuster)
  def `with`(field: TemporalField, newValue: Long): Year = f.`with`(field, newValue)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
