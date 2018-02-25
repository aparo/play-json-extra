package java.time.chrono

import java.time.{Clock, Instant, LocalDate, LocalDateTime, Period, ZoneId, ZonedDateTime}
import java.time.temporal.{ChronoField, TemporalAccessor, ValueRange}
import java.util.Locale

object Chronology {
  def from(temporal: TemporalAccessor): Chronology = ???
  def getAvailableChronologies(): java.util.Set[Chronology] = ???
  def of(id: String): Chronology = ???
  def ofLocale(locale: Locale): Chronology = ???
}

trait Chronology extends Comparable[Chronology] {
  def compareTo(other: Chronology): Int
  def date(era: Era, yearOfEra: Int, month: Int, dayOfMonth: Int): LocalDate
  def date(prolepticYear: Int, month: Int, dayOfMonth: Int): LocalDate
  def date(temporal: TemporalAccessor): LocalDate
  def dateEpochDay(epochDay: Long): LocalDate
  def dateNow(): LocalDate
  def dateNow(clock: Clock): LocalDate
  def dateNow(zone: ZoneId): LocalDate
  def dateYearDay(era: Era, yearOfEra: Int, dayOfYear: Int): LocalDate
  def dateYearDay(prolepticYear: Int, dayOfYear: Int): LocalDate
  def eraOf(eraValue: Int): IsoEra
  def eras(): java.util.List[Era]
  def getCalendarType(): String
  def getId(): String
  def isLeapYear(prolepticYear: Long): Boolean
  def localDateTime(temporal: TemporalAccessor): LocalDateTime
  def period(years: Int, months: Int, days: Int): Period
  def prolepticYear(era: Era, yearOfEra: Int): Int
  def range(field: ChronoField): ValueRange
  def zonedDateTime(instant: Instant, zone: ZoneId): ZonedDateTime
  def zonedDateTime(temporal: TemporalAccessor): ZonedDateTime
}
