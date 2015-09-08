package java.time

import java.time.temporal.{TemporalUnit, TemporalField, Temporal}

case class Instant(seconds: Long=0L, nanos: Int=0) extends Temporal {
  /**
   * Converts this instant to the number of milliseconds from the epoch
   * of 1970-01-01T00:00:00Z.
   * <p>
   * If this instant represents a point on the time-line too far in the future
   * or past to fit in a {@code long} milliseconds, then an exception is thrown.
   * <p>
   * If this instant has greater than millisecond precision, then the conversion
   * will drop any excess precision information as though the amount in nanoseconds
   * was subject to integer division by one million.
   *
   * @return the number of milliseconds since the epoch of 1970-01-01T00:00:00Z
   * @throws ArithmeticException if numeric overflow occurs
   */
  def toEpochMilli: Long = {
    val millis: Long = Math.multiplyExact(seconds, 1000)
     millis + nanos / 1000000
  }

  override def isSupported(unit: TemporalUnit): Boolean = ???

  override def plus(amountToAdd: Long, unit: TemporalUnit): Temporal = ???

  override def until(endExclusive: Temporal, unit: TemporalUnit): Long = ???

  override def `with`(field: TemporalField, newValue: Long): Temporal = ???

  override def isSupported(field: TemporalField): Boolean = ???

  override def getLong(field: TemporalField): Long = ???
}

object Instant {
  /**
   * Obtains an instance of {@code Instant} using milliseconds from the
   * epoch of 1970-01-01T00:00:00Z.
   * <p>
   * The seconds and nanoseconds are extracted from the specified milliseconds.
   *
   * @param epochMilli  the number of milliseconds from 1970-01-01T00:00:00Z
   * @return an instant, not null
   * @throws DateTimeException if the instant exceeds the maximum or minimum instant
   */
  def ofEpochMilli(epochMilli: Long): Instant = {
    val secs: Long = Math.floorDiv(epochMilli, 1000)
    val mos: Int = Math.floorMod(epochMilli, 1000).toInt
    new Instant(secs, mos * 1000000)
  }

  //-----------------------------------------------------------------------
  /**
   * Obtains an instance of {@code Instant} from a text string such as
   * {@code 2007-12-03T10:15:30.00Z}.
   * <p>
   * The string must represent a valid instant in UTC and is parsed using
   * {@link DateTimeFormatter#ISO_INSTANT}.
   *
   * @param text  the text to parse, not null
   * @return the parsed instant, not null
   * @throws DateTimeParseException if the text cannot be parsed
   */
  def parse(text: CharSequence): Instant = {
    new Instant(moment.moment.apply(text.toString).unix().toLong)
//     DateTimeFormatter.ISO_INSTANT.parse(text, Instant.from)
  }

  def parse(text: String): Instant = {
    new Instant(moment.moment.apply(text).unix().toLong)
    //     DateTimeFormatter.ISO_INSTANT.parse(text, Instant.from)
  }

  def now():Instant=new Instant(0,0)
}