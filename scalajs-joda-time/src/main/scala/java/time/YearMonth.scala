package java.time

import java.Wraps
import java.time.format.DateTimeFormatter
import java.time.temporal.{Temporal, TemporalAccessor, TemporalAdjuster, TemporalAmount, TemporalField, TemporalUnit}

import com.zoepepper.facades.jsjoda.{YearMonth => YearMonthF}

object YearMonth {
  def from(temporal: TemporalAccessor): YearMonth = YearMonthF.from(temporal)
  def now(): YearMonth = YearMonthF.now()
  def now(clock: Clock): YearMonth = YearMonthF.now(clock)
  def now(zone: ZoneId): YearMonth = YearMonthF.now(zone)
  def of(year: Int, month: Int): YearMonth = YearMonthF.of(year, month)
  def of(year: Int, month: Month): YearMonth = YearMonthF.of(year, month)
  def parse(text: CharSequence): YearMonth = YearMonthF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): YearMonth = YearMonthF.parse(text.toString, formatter)
}

class YearMonth protected[time](f: YearMonthF) extends Wraps(f) with Comparable[YearMonth]
  with Temporal with TemporalAdjuster {
  def atDay(dayOfMonth: Int): LocalDate = f.atDay(dayOfMonth)
  def atEndOfMonth(): LocalDate = f.atEndOfMonth()
  def compareTo(other: YearMonth): Int = f.compareTo(other)
  def format(formatter: DateTimeFormatter): String = f.format(formatter)
  def getMonth(): Month = f.month
  def getMonthValue(): Int = f.monthValue
  def getYear(): Int = f.year
  def isAfter(other: YearMonth): Boolean = f.isAfter(other)
  def isBefore(other: YearMonth): Boolean = f.isBefore(other)
  def isLeapYear(): Boolean = f.isLeapYear
  def isSupported(unit: TemporalUnit): Boolean = f.isSupported(unit)
  def isValidDay(dayOfMonth: Int): Boolean = f.isValidDay(dayOfMonth)
  def lengthOfMonth(): Int = f.lengthOfMonth
  def lengthOfYear(): Int = f.lengthOfYear
  def minus(amountToSubtract: Long, unit: TemporalUnit): YearMonth = f.minus(amountToSubtract, unit)
  def minus(amountToSubtract: TemporalAmount): YearMonth = f.minus(amountToSubtract)
  def minusMonths(monthsToSubtract: Long): YearMonth = f.minusMonths(monthsToSubtract)
  def minusYears(yearsToSubtract: Long): YearMonth = f.minusYears(yearsToSubtract)
  def plus(amountToAdd: Long, unit: TemporalUnit): YearMonth = f.plus(amountToAdd, unit)
  def plus(amountToAdd: TemporalAmount): YearMonth = f.plus(amountToAdd)
  def plusMonths(monthsToAdd: Long): YearMonth = f.plusMonths(monthsToAdd)
  def plusYears(yearsToAdd: Long): YearMonth = f.plusYears(yearsToAdd)
  def `with`(adjuster: TemporalAdjuster): YearMonth = f.`with`(adjuster)
  def `with`(field: TemporalField, newValue: Long): YearMonth = f.`with`(field, newValue)
  def withMonth(month: Int): YearMonth = f.withMonth(month)
  def withYear(year: Int): YearMonth = f.withYear(year)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
