package java.time

import java.Wraps
import java.time.format.DateTimeFormatter
import java.time.temporal.{TemporalAccessor, TemporalAdjuster}

import com.zoepepper.facades.jsjoda.{MonthDay => MonthDayF}

object MonthDay {
  def from(temporal: TemporalAccessor): MonthDay = MonthDayF.from(temporal)
  def now(): MonthDay = MonthDayF.now()
  def now(clock: Clock): MonthDay = MonthDayF.now(clock)
  def now(zone: ZoneId): MonthDay = MonthDayF.now(zone)
  def of(month: Int, dayOfMonth: Int): MonthDay = MonthDayF.of(month, dayOfMonth)
  def of(month: Month, dayOfMonth: Int): MonthDay = MonthDayF.of(month, dayOfMonth)
  def parse(text: CharSequence): MonthDay = MonthDayF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): MonthDay = MonthDayF.parse(text.toString, formatter)
}

class MonthDay protected[time](f: MonthDayF) extends Wraps(f) with Comparable[MonthDay]
  with TemporalAccessor with TemporalAdjuster {
  def atYear(year: Int): LocalDate = f.atYear(year)
  def compareTo(other: MonthDay): Int = f.compareTo(other)
  def format(formatter: DateTimeFormatter): String = f.format(formatter)
  def getDayOfMonth(): Int = f.dayOfMonth
  def getMonth(): Month = f.month
  def getMonthValue(): Int = f.monthValue
  def isAfter(other: MonthDay): Boolean = f.isAfter(other)
  def isBefore(other: MonthDay): Boolean = f.isBefore(other)
  def isValidYear(year: Int): Boolean = f.isValidYear(year)
  def `with`(month: Month): MonthDay = f.`with`(unwrapF(month)) // We unwrap here to disambiguate.
  def withDayOfMonth(dayOfMonth: Int): MonthDay = f.withDayOfMonth(dayOfMonth)
  def withMonth(month: Int): MonthDay = f.withMonth(month)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
