package java.time.temporal

import java.Wraps

import com.zoepepper.facades.jsjoda.temporal.{ChronoUnit => ChronoUnitF}

object ChronoUnit {
  val NANOS: ChronoUnit = ChronoUnitF.NANOS
  val MICROS: ChronoUnit = ChronoUnitF.MICROS
  val MILLIS: ChronoUnit = ChronoUnitF.MILLIS
  val SECONDS: ChronoUnit = ChronoUnitF.SECONDS
  val MINUTES: ChronoUnit = ChronoUnitF.MINUTES
  val HOURS: ChronoUnit = ChronoUnitF.HOURS
  val HALF_DAYS: ChronoUnit = ChronoUnitF.HALF_DAYS
  val DAYS: ChronoUnit = ChronoUnitF.DAYS
  val WEEKS: ChronoUnit = ChronoUnitF.WEEKS
  val MONTHS: ChronoUnit = ChronoUnitF.MONTHS
  val YEARS: ChronoUnit = ChronoUnitF.YEARS
  val DECADES: ChronoUnit = ChronoUnitF.DECADES
  val CENTURIES: ChronoUnit = ChronoUnitF.CENTURIES
  val MILLENNIA: ChronoUnit = ChronoUnitF.MILLENNIA
  val ERAS: ChronoUnit = ChronoUnitF.ERAS
  val FOREVER: ChronoUnit = ChronoUnitF.FOREVER
}

class ChronoUnit protected[time](f: ChronoUnitF) extends Wraps(f) with Comparable[ChronoUnit] with TemporalUnit {
  def compareTo(other: ChronoUnit): Int = f.compareTo(unwrapF(other)) // Disambuates implicits.
}
