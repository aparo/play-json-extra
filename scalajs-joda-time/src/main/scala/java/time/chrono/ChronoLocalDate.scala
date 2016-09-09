package java.time.chrono

import java.Wrapper
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.{Temporal, TemporalAccessor, TemporalAdjuster, TemporalUnit}
import java.util.Comparator

import com.zoepepper.facades.jsjoda.chrono.{ChronoLocalDate => ChronoLocalDateF}

object ChronoLocalDate {
  def from(temporal: TemporalAccessor): ChronoLocalDate = ???
  def timeLineOrder(): Comparator[ChronoLocalDate] = ???
}

trait ChronoLocalDate extends Comparable[ChronoLocalDate] with Temporal with TemporalAdjuster {
  self: Wrapper =>
  protected[time] val chronoLocalDateF = self.f.asInstanceOf[ChronoLocalDateF]

  def atTime(localTime: LocalTime): ChronoLocalDateTime[_]
  def compareTo(other: ChronoLocalDate): Int
  def format(formatter: DateTimeFormatter): String
  def getChronology(): Chronology
  def getEra(): Era
  def isAfter(other: ChronoLocalDate): Boolean
  def isBefore(other: ChronoLocalDate): Boolean
  def isEqual(other: ChronoLocalDate): Boolean
  def isLeapYear(): Boolean
  def isSupported(unit: TemporalUnit): Boolean
  def lengthOfMonth(): Int
  def lengthOfYear(): Int
  def toEpochDay(): Long
  def until(endDateExclusive: ChronoLocalDate): ChronoPeriod
}
