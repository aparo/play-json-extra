package java.time

import java.Wraps
import java.time.format.DateTimeFormatter
import java.time.temporal.{Temporal, TemporalAccessor, TemporalAdjuster, TemporalAmount, TemporalField, TemporalUnit}

import com.zoepepper.facades.jsjoda.{LocalTime => LocalTimeF}

object LocalTime {
  def from(temporal: TemporalAccessor): LocalTime = LocalTimeF.from(temporal)
  def now(): LocalTime = LocalTimeF.now()
  def now(clock: Clock): LocalTime = LocalTimeF.now(clock)
  def now(zone: ZoneId): LocalTime = LocalTimeF.now(zone)
  def of(hour: Int, minute: Int): LocalTime = LocalTimeF.of(hour, minute)
  def of(hour: Int, minute: Int, second: Int): LocalTime = LocalTimeF.of(hour, minute, second)
  def of(hour: Int, minute: Int, second: Int, nanoOfSecond: Int): LocalTime = LocalTimeF.of(hour, minute, second, nanoOfSecond)
  def ofNanoOfDay(nanoOfDay: Long): LocalTime = LocalTimeF.ofNanoOfDay(nanoOfDay)
  def ofSecondOfDay(secondOfDay: Long): LocalTime = LocalTimeF.ofSecondOfDay(secondOfDay)
  def parse(text: CharSequence): LocalTime = LocalTimeF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): LocalTime = LocalTimeF.parse(text.toString, formatter)

  val MAX: LocalTime = LocalTimeF.MAX
  val MIN: LocalTime = LocalTimeF.MIN
  val MIDNIGHT: LocalTime = LocalTimeF.MIDNIGHT
  val NOON: LocalTime = LocalTimeF.NOON
}

class LocalTime protected[time](f: LocalTimeF) extends Wraps(f) with Comparable[LocalTime]
  with Temporal with TemporalAdjuster {
  def atDate(date: LocalDate): LocalDateTime = f.atDate(date)
  def atOffset(offset: ZoneOffset): OffsetTime = ???
  def compareTo(other: LocalTime): Int = f.compareTo(other)
  def format(formatter: DateTimeFormatter): String = f.format(formatter)
  def getHour(): Int = f.hour
  def getMinute(): Int = f.minute
  def getSecond(): Int = f.second
  def getNano(): Int = f.nano
  def isAfter(other: LocalTime): Boolean = f.isAfter(other)
  def isBefore(other: LocalTime): Boolean = f.isBefore(other)
  def isSupported(unit: TemporalUnit): Boolean = f.isSupported(unit)
  def minus(amount: TemporalAmount): LocalTime = f.minus(amount)
  def minus(amount: Long, unit: TemporalUnit): LocalTime = f.minus(amount, unit)
  def minusHours(hoursToSubtract: Long): LocalTime = f.minusHours(hoursToSubtract)
  def minusMinutes(minutesToSubtract: Long): LocalTime = f.minusMinutes(minutesToSubtract)
  def minusSeconds(secondsToSubtract: Long): LocalTime = f.minusSeconds(secondsToSubtract)
  def minusNanos(nanosToSubtract: Long): LocalTime = f.minusNanos(nanosToSubtract)
  def plus(amount: TemporalAmount): LocalTime = f.plus(amount)
  def plus(amount: Long, unit: TemporalUnit): LocalTime = f.plus(amount, unit)
  def plusHours(hoursToAdd: Long): LocalTime = f.plusHours(hoursToAdd)
  def plusMinutes(minutesToAdd: Long): LocalTime = f.plusMinutes(minutesToAdd)
  def plusSeconds(secondsToAdd: Long): LocalTime = f.plusSeconds(secondsToAdd)
  def plusNanos(nanosToAdd: Long): LocalTime = f.plusNanos(nanosToAdd)
  def toNanoOfDay(): Long = f.toNanoOfDay()
  def toSecondOfDay(): Int = f.toSecondOfDay()
  def truncatedTo(unit: TemporalUnit): LocalTime = f.truncatedTo(unit)
  def `with`(adjuster: TemporalAdjuster): LocalTime = f.`with`(adjuster)
  def `with`(field: TemporalField, newValue: Long): LocalTime = f.`with`(field, newValue)
  def withHour(hour: Int): LocalTime = f.withHour(hour)
  def withMinute(minute: Int): LocalTime = f.withMinute(minute)
  def withSecond(second: Int): LocalTime = f.withSecond(second)
  def withNano(nano: Int): LocalTime = f.withNano(nano)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
