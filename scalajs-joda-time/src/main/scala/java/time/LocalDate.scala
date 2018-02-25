package java.time

import java.Wraps
import java.time.chrono.{ChronoLocalDate, ChronoPeriod, Era, IsoChronology}
import java.time.format.DateTimeFormatter
import java.time.temporal.{Temporal, TemporalAccessor, TemporalAdjuster, TemporalAmount, TemporalField, TemporalUnit}
import java.util.Comparator

import com.zoepepper.facades.jsjoda.{LocalDate => LocalDateF}

object LocalDate {
  def from(temporal: TemporalAccessor): LocalDate = LocalDateF.from(temporal)
  def now(): LocalDate = LocalDateF.now()
  def now(clock: Clock): LocalDate = LocalDateF.now(clock)
  def now(zone: ZoneId): LocalDate = LocalDateF.now(zone)
  def of(year: Int, month: Int, dayOfMonth: Int): LocalDate = LocalDateF.of(year, month, dayOfMonth)
  def of(year: Int, month: Month, dayOfMonth: Int): LocalDate = LocalDateF.of(year, month, dayOfMonth)
  def ofEpochDay(epochDay: Double): LocalDate = LocalDateF.ofEpochDay(epochDay)
  def ofYearDay(year: Int, dayOfYear: Int): LocalDate = LocalDateF.ofYearDay(year, dayOfYear)
  def parse(text: CharSequence): LocalDate = LocalDateF.parse(text.toString)
  def parse(text: CharSequence, formatter: DateTimeFormatter): LocalDate = LocalDateF.parse(text.toString, formatter)

  val MAX: LocalDate = LocalDateF.MAX
  val MIN: LocalDate = LocalDateF.MIN
}

class LocalDate protected[time](f: LocalDateF) extends Wraps(f) with ChronoLocalDate {
  def atStartOfDay(): LocalDateTime = f.atStartOfDay()
  def atStartOfDay(zone: ZoneId): LocalDateTime = f.atStartOfDay(zone)
  def atTime(hour: Int, minute: Int): LocalDateTime = f.atTime(hour, minute)
  def atTime(hour: Int, minute: Int, second: Int): LocalDateTime = f.atTime(hour, minute, second)
  def atTime(hour: Int, minute: Int, second: Int, nanoOfSecond: Int): LocalDateTime = f.atTime(hour, minute, second, nanoOfSecond)
  def atTime(time: LocalTime): LocalDateTime = f.atTime(time)
  def atTime(time: OffsetTime): OffsetDateTime = ???
  def compareTo(other: ChronoLocalDate): Int = f.compareTo(other.asInstanceOf[LocalDate])
  def format(formatter: DateTimeFormatter): String = f.format(formatter)
  def getChronology(): IsoChronology = f.chronology
  def getDayOfMonth(): Int = f.dayOfMonth
  def getDayOfWeek(): DayOfWeek = f.dayOfWeek
  def getDayOfYear(): Int = f.dayOfYear
  def getEra(): Era = ???
  def getMonth(): Month = f.month
  def getMonthValue(): Int = f.monthValue
  def getYear(): Int = f.year
  def isAfter(other: ChronoLocalDate): Boolean = f.isAfter(other.asInstanceOf[LocalDate])
  def isBefore(other: ChronoLocalDate): Boolean = f.isBefore(other.asInstanceOf[LocalDate])
  def isEqual(other: ChronoLocalDate): Boolean = f.isEqual(other.asInstanceOf[LocalDate])
  def isLeapYear(): Boolean = f.isLeapYear()
  def isSupported(unit: TemporalUnit): Boolean = f.isSupported(unit)
  def lengthOfMonth(): Int = f.lengthOfMonth()
  def lengthOfYear(): Int = f.lengthOfYear()
  def minus(amountToSubtract: Long, unit: TemporalUnit): LocalDate = f.minus(amountToSubtract, unit)
  def minus(amount: TemporalAmount): LocalDate = f.minus(amount)
  def minusDays(daysToSubtract: Double): LocalDate = f.minusDays(daysToSubtract)
  def minusMonths(monthsToSubtract: Double): LocalDate = f.minusMonths(monthsToSubtract)
  def minusWeeks(weeksToSubtract: Double): LocalDate = f.minusWeeks(weeksToSubtract)
  def minusYears(yearsToSubtract: Double): LocalDate = f.minusYears(yearsToSubtract)
  def plus(amountToAdd: Long, unit: TemporalUnit): LocalDate = f.plus(amountToAdd, unit)
  def plus(amount: TemporalAmount): LocalDate = f.plus(amount)
  def plusDays(daysToAdd: Long): LocalDate = f.plusDays(daysToAdd)
  def plusMonths(monthsToAdd: Long): LocalDate = f.plusMonths(monthsToAdd)
  def plusWeeks(weeksToAdd: Long): LocalDate = f.plusWeeks(weeksToAdd)
  def plusYears(yearsToAdd: Long): LocalDate = f.plusYears(yearsToAdd)
  def toEpochDay(): Long = f.toEpochDay().toLong
  def until(endDateExclusive: ChronoLocalDate): Period = f.until(endDateExclusive)
  def `with`(adjuster: TemporalAdjuster): LocalDate = f.`with`(adjuster)
  def `with`(field: TemporalField, newValue: Long): LocalDate = f.`with`(field, newValue)
  def withDayOfMonth(dayOfMonth: Int): LocalDate = f.withDayOfMonth(dayOfMonth)
  def withDayOfYear(dayOfYear: Int): LocalDate = f.withDayOfYear(dayOfYear)
  def withMonth(month: Int): LocalDate = f.withMonth(month)
  def withYear(year: Int): LocalDate = f.withYear(year)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
