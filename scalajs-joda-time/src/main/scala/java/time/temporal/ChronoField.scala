package java.time.temporal

import java.Wraps

import com.zoepepper.facades.jsjoda.temporal.{ChronoField => ChronoFieldF}

object ChronoField {
  val NANO_OF_SECOND: ChronoField = ChronoFieldF.NANO_OF_SECOND
  val NANO_OF_DAY: ChronoField = ChronoFieldF.NANO_OF_DAY
  val MICRO_OF_SECOND: ChronoField = ChronoFieldF.MICRO_OF_SECOND
  val MICRO_OF_DAY: ChronoField = ChronoFieldF.MICRO_OF_DAY
  val MILLI_OF_SECOND: ChronoField = ChronoFieldF.MILLI_OF_SECOND
  val MILLI_OF_DAY: ChronoField = ChronoFieldF.MILLI_OF_DAY
  val SECOND_OF_MINUTE: ChronoField = ChronoFieldF.SECOND_OF_MINUTE
  val SECOND_OF_DAY: ChronoField = ChronoFieldF.SECOND_OF_DAY
  val MINUTE_OF_HOUR: ChronoField = ChronoFieldF.MINUTE_OF_HOUR
  val MINUTE_OF_DAY: ChronoField = ChronoFieldF.MINUTE_OF_DAY
  val HOUR_OF_AMPM: ChronoField = ChronoFieldF.HOUR_OF_AMPM
  val CLOCK_HOUR_OF_AMPM: ChronoField = ChronoFieldF.CLOCK_HOUR_OF_AMPM
  val HOUR_OF_DAY: ChronoField = ChronoFieldF.HOUR_OF_DAY
  val CLOCK_HOUR_OF_DAY: ChronoField = ChronoFieldF.CLOCK_HOUR_OF_DAY
  val AMPM_OF_DAY: ChronoField = ChronoFieldF.AMPM_OF_DAY
  val DAY_OF_WEEK: ChronoField = ChronoFieldF.DAY_OF_WEEK
  val ALIGNED_DAY_OF_WEEK_IN_MONTH: ChronoField = ChronoFieldF.ALIGNED_DAY_OF_WEEK_IN_MONTH
  val ALIGNED_DAY_OF_WEEK_IN_YEAR: ChronoField = ChronoFieldF.ALIGNED_DAY_OF_WEEK_IN_YEAR
  val DAY_OF_MONTH: ChronoField = ChronoFieldF.DAY_OF_MONTH
  val DAY_OF_YEAR: ChronoField = ChronoFieldF.DAY_OF_YEAR
  val EPOCH_DAY: ChronoField = ChronoFieldF.EPOCH_DAY
  val ALIGNED_WEEK_OF_MONTH: ChronoField = ChronoFieldF.ALIGNED_WEEK_OF_MONTH
  val ALIGNED_WEEK_OF_YEAR: ChronoField = ChronoFieldF.ALIGNED_WEEK_OF_YEAR
  val MONTH_OF_YEAR: ChronoField = ChronoFieldF.MONTH_OF_YEAR
  val PROLEPTIC_MONTH: ChronoField = ChronoFieldF.PROLEPTIC_MONTH
  val YEAR_OF_ERA: ChronoField = ChronoFieldF.YEAR_OF_ERA
  val YEAR: ChronoField = ChronoFieldF.YEAR
  val ERA: ChronoField = ChronoFieldF.ERA
  val INSTANT_SECONDS: ChronoField = ChronoFieldF.INSTANT_SECONDS
  val OFFSET_SECONDS: ChronoField = ChronoFieldF.OFFSET_SECONDS
}

class ChronoField protected[time](f: ChronoFieldF) extends Wraps(f) with Comparable[ChronoField] with TemporalField {
  def compareTo(other: ChronoField): Int = ???
}
