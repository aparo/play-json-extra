package java.time.chrono

import java.Wrapper
import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalTime, ZoneId, ZoneOffset}
import java.time.temporal.{Temporal, TemporalAccessor, TemporalAdjuster, TemporalField, TemporalUnit}
import java.util.Comparator

import com.zoepepper.facades.jsjoda.chrono.{ChronoZonedDateTime => ChronoZonedDateTimeF}

object ChronoZonedDateTime {
  def from(temporal: TemporalAccessor): ChronoZonedDateTime[_] = ???
  def timeLineOrder(): Comparator[ChronoZonedDateTime[_]] = ???
}

trait ChronoZonedDateTime[D <: ChronoLocalDate] extends Comparable[ChronoZonedDateTime[_]] with Temporal {
  self: Wrapper =>
  protected[time] val chronoZonedDateTimeF = self.f.asInstanceOf[ChronoZonedDateTimeF[_]]

  def compareTo(other: ChronoZonedDateTime[_]): Int = chronoZonedDateTimeF.compareTo(other)
  def format(formatter: DateTimeFormatter): String = chronoZonedDateTimeF.format(formatter)
  def getChronology(): Chronology = ???
  def getOffset(): ZoneOffset
  def getZone(): ZoneId
  def isAfter(other: ChronoZonedDateTime[_]): Boolean = chronoZonedDateTimeF.isAfter(other)
  def isBefore(other: ChronoZonedDateTime[_]): Boolean = chronoZonedDateTimeF.isBefore(other)
  def isEqual(other: ChronoZonedDateTime[_]): Boolean = chronoZonedDateTimeF.isEqual(other)
  def isSupported(unit: TemporalUnit): Boolean
  def toEpochSecond(): Long = chronoZonedDateTimeF.toEpochSecond().toLong
  def toInstant(): Instant = chronoZonedDateTimeF.toInstant()
  def toLocalDate(): D
  def toLocalDateTime(): ChronoLocalDateTime[D]
  def toLocalTime(): LocalTime
  def `with`(adjuster: TemporalAdjuster): ChronoZonedDateTime[D]
  def `with`(field: TemporalField, newValue: Long): ChronoZonedDateTime[D]
  def withEarlierOffsetAtOverlap(): ChronoZonedDateTime[D]
  def withLaterOffsetAtOverlap(): ChronoZonedDateTime[D]
  def withZoneSameInstant(zone: ZoneId): ChronoZonedDateTime[D]
  def withZoneSameLocal(zone: ZoneId): ChronoZonedDateTime[D]
}
