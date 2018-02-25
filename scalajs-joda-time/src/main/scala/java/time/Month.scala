package java.time

import java.Wraps
import java.time.format.TextStyle
import java.time.temporal.{TemporalAccessor, TemporalAdjuster}
import java.util.Locale

import com.zoepepper.facades.jsjoda.{Month => MonthF}

object Month {
  def from(temporal: TemporalAccessor): Month = MonthF.from(temporal)
  def of(month: Int): Month = MonthF.of(month)
  def valueOf(name: String): Month = ???
  def values(): Array[Month] = MonthF.values

  val JANUARY: Month = MonthF.JANUARY
  val FEBRUARY: Month = MonthF.FEBRUARY
  val MARCH: Month = MonthF.MARCH
  val APRIL: Month = MonthF.APRIL
  val MAY: Month = MonthF.MAY
  val JUNE: Month = MonthF.JUNE
  val JULY: Month = MonthF.JULY
  val AUGUST: Month = MonthF.AUGUST
  val SEPTEMBER: Month = MonthF.SEPTEMBER
  val OCTOBER: Month = MonthF.OCTOBER
  val NOVEMBER: Month = MonthF.NOVEMBER
  val DECEMBER: Month = MonthF.DECEMBER
}

class Month protected[time](f: MonthF) extends Wraps(f) with Comparable[Month]
  with TemporalAccessor with TemporalAdjuster {
  def firstDayOfYear(leapYear: Boolean): Int = f.firstDayOfYear(leapYear)
  def firstMonthOfQuarter(): Month = f.firstMonthOfQuarter
  def getDisplayName(style: TextStyle, locale: Locale): String = ???
  def getValue(): Int = f.value
  def length(leapYear: Boolean): Int = f.length(leapYear)
  def maxLength(): Int = f.maxLength
  def minLength(): Int = f.minLength
  def minus(months: Long): Month = f.minus(months)
  def plus(months: Long): Month = f.plus(months)
  def compareTo(other: Month): Int = ???

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
