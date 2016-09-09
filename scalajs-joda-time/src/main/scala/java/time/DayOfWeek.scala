package java.time

import java.Wraps
import java.time.format.TextStyle
import java.time.temporal.{TemporalAccessor, TemporalAdjuster}
import java.util.Locale

import com.zoepepper.facades.jsjoda.{DayOfWeek => DayOfWeekF}

object DayOfWeek {
  def values(): Array[DayOfWeek] = DayOfWeekF.values
  def valueOf(name: String): DayOfWeek = DayOfWeekF.valueOf(name)
  def of(dayOfWeek: Int): DayOfWeek = DayOfWeekF.of(dayOfWeek)
  def from(temporal: TemporalAccessor): DayOfWeek = DayOfWeekF.from(temporal)

  val MONDAY: DayOfWeek = DayOfWeekF.MONDAY
  val TUESDAY: DayOfWeek = DayOfWeekF.TUESDAY
  val WEDNESDAY: DayOfWeek = DayOfWeekF.WEDNESDAY
  val THURSDAY: DayOfWeek = DayOfWeekF.THURSDAY
  val FRIDAY: DayOfWeek = DayOfWeekF.FRIDAY
  val SATURDAY: DayOfWeek = DayOfWeekF.SATURDAY
  val SUNDAY: DayOfWeek = DayOfWeekF.SUNDAY
}

class DayOfWeek protected[time](f: DayOfWeekF) extends Wraps(f) with Comparable[DayOfWeek]
  with TemporalAccessor with TemporalAdjuster {
  def getDisplayName(style: TextStyle, locale: Locale): String = ???
  def getValue(): Int = f.getValue()
  def plus(days: Long): DayOfWeek = f.plus(days)
  def minus(days: Long): DayOfWeek = f.minus(days)
  def compareTo(other: DayOfWeek): Int = ???

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
