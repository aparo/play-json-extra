package java.time.chrono

import java.Wrapper
import java.time.format.DateTimeFormatter

import com.zoepepper.facades.jsjoda.chrono.{ChronoLocalDateTime => ChronoLocalDateTimeF}
import java.time.{Instant, LocalDateTime, LocalTime, ZoneId, ZoneOffset, ZonedDateTime}
import java.time.temporal.{Temporal, TemporalAccessor, TemporalAdjuster, TemporalUnit}
import java.util.Comparator

object ChronoLocalDateTime {
  def from(temporal: TemporalAccessor): ChronoLocalDateTime[_] = ???
  def timeLineOrder(): Comparator[ChronoLocalDateTime[_]] = ???
}

trait ChronoLocalDateTime[D <: ChronoLocalDate] extends Comparable[ChronoLocalDateTime[_]] with Temporal with TemporalAdjuster {
  self: Wrapper =>
  protected[time] val chronoLocalDateTimeF = self.f.asInstanceOf[ChronoLocalDateTimeF[_]]

  def atZone(zone: ZoneId): ZonedDateTime
  def compareTo(other: ChronoLocalDateTime[_]): Int
  def format(formatter: DateTimeFormatter): String
  def getChronology(): Chronology = chronoLocalDateTimeF.chronology
  def isAfter(other: ChronoLocalDateTime[_]): Boolean
  def isBefore(other: ChronoLocalDateTime[_]): Boolean
  def isEqual(other: ChronoLocalDateTime[_]): Boolean
  def isSupported(unit: TemporalUnit): Boolean
  def toEpochSecond(offset: ZoneOffset): Long = chronoLocalDateTimeF.toEpochSecond(offset)
  def toInstant(offset: ZoneOffset): Instant = chronoLocalDateTimeF.toInstant(offset)
  def toLocalDate(): D
  def toLocalTime(): LocalTime
}
