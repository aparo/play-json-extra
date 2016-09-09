package java.time.chrono

import java.Wraps
import java.time.format.ResolverStyle
import java.time.temporal.{ChronoField, TemporalAccessor, TemporalField, ValueRange}
import java.time.{Clock, Instant, LocalDate, LocalDateTime, Period, ZoneId, ZonedDateTime}

import com.zoepepper.facades.jsjoda.chrono.{IsoChronology => IsoChronologyF}

import scalajs.js.JSConverters._
import scala.collection.JavaConverters._

object IsoChronology {
  val INSTANCE: IsoChronology = IsoChronologyF.INSTANCE
}

class IsoChronology protected[time](f: IsoChronologyF) extends Wraps(f) with Chronology {
  def compareTo(other: Chronology): Int = ???
  def date(era: Era, yearOfEra: Int, month: Int, dayOfMonth: Int): LocalDate = ???
  def date(prolepticYear: Int, month: Int, dayOfMonth: Int): LocalDate = ???
  def date(temporal: TemporalAccessor): LocalDate = ???
  def dateEpochDay(epochDay: Long): LocalDate = ???
  def dateNow(): LocalDate = ???
  def dateNow(clock: Clock): LocalDate = ???
  def dateNow(zone: ZoneId): LocalDate = ???
  def dateYearDay(era: Era, yearOfEra: Int, dayOfYear: Int): LocalDate = ???
  def dateYearDay(prolepticYear: Int, dayOfYear: Int): LocalDate = ???
  def eraOf(eraValue: Int): IsoEra = ???
  def eras(): java.util.List[Era] = ???
  def getCalendarType(): String = ???
  def getId(): String = ???
  def isLeapYear(prolepticYear: Long): Boolean = IsoChronologyF.isLeapYear(prolepticYear)
  def localDateTime(temporal: TemporalAccessor): LocalDateTime = ???
  def period(years: Int, months: Int, days: Int): Period = ???
  def prolepticYear(era: Era, yearOfEra: Int): Int = ???
  def range(field: ChronoField): ValueRange = ???
  def resolveDate(fieldValues: java.util.Map[TemporalField, Long], resolverStyle: ResolverStyle): LocalDate =
    f.resolveDate(fieldValues.asScala.map{ case(k, v) => k.toString -> v}.toJSDictionary, resolverStyle)
  def zonedDateTime(instant: Instant, zone: ZoneId): ZonedDateTime = ???
  def zonedDateTime(temporal: TemporalAccessor): ZonedDateTime = ???
}
