package java.time.format

import java.Wraps
import java.text.Format
import java.time.{Period, ZoneId}
import java.time.chrono.{Chronology, IsoChronology}
import java.time.temporal.{ChronoField, TemporalAccessor, TemporalField, TemporalQuery}
import java.util.Locale

import com.zoepepper.facades.jsjoda.format.{ParsePosition, DateTimeFormatter => DateTimeFormatterF}
import com.zoepepper.facades.jsjoda.{ZoneOffset => ZoneOffsetF}

object DateTimeFormatter {
  def ofLocalizedDate(dateStyle: FormatStyle): DateTimeFormatter = ???
  def ofLocalizedDateTime(dateTimeStyle: FormatStyle): DateTimeFormatter = ???
  def ofLocalizedDateTime(dateStyle: FormatStyle, timeStyle: FormatStyle): DateTimeFormatter = ???
  def ofLocalizedTime(timeStyle: FormatStyle): DateTimeFormatter = ???
  def ofPattern(pattern: String): DateTimeFormatter = DateTimeFormatterF.ofPattern(pattern)
  def ofPattern(pattern: String, locale: Locale): DateTimeFormatter = ???
  def parsedExcessDays(): TemporalQuery[Period] = ???
  def parsedLeapSecond(): TemporalQuery[Boolean] = ???


  val ISO_LOCAL_DATE: DateTimeFormatter = DateTimeFormatterF.ISO_LOCAL_DATE
  val ISO_LOCAL_TIME: DateTimeFormatter = DateTimeFormatterF.ISO_LOCAL_TIME
  val ISO_LOCAL_DATE_TIME: DateTimeFormatter = DateTimeFormatterF.ISO_LOCAL_DATE_TIME
  val ISO_INSTANT: DateTimeFormatter = DateTimeFormatterF.ISO_INSTANT
  val ISO_OFFSET_DATE_TIME: DateTimeFormatter = DateTimeFormatterF.ISO_OFFSET_DATE_TIME
  val ISO_ZONED_DATE_TIME: DateTimeFormatter = DateTimeFormatterF.ISO_ZONED_DATE_TIME

  // If we declare these as unimplemented we have trouble. For example, if we call ISO_LOCAL_DATE then
  // BASIC_ISO_DATE gets called and an exception is thrown.
//  val BASIC_ISO_DATE: DateTimeFormatter = ???
//  val ISO_DATE: DateTimeFormatter = ???
//  val ISO_DATE_TIME: DateTimeFormatter = ???
//  val ISO_OFFSET_DATE: DateTimeFormatter = ???
//  val ISO_OFFSET_TIME: DateTimeFormatter = ???
//  val ISO_ORDINAL_DATE: DateTimeFormatter = ???
//  val ISO_TIME: DateTimeFormatter = ???
//  val RFC_1123_DATE_TIME: DateTimeFormatter = ???
}

class DateTimeFormatter protected[time](f: DateTimeFormatterF) extends Wraps(f) {
  def format(temporal: TemporalAccessor): String = f.format(temporal)
  def formatTo(temporal: TemporalAccessor, appendable: Appendable): Unit = ???
  def getChronology(): Chronology = f.chronology
  def getDecimalStyle(): DecimalStyle = f.decimalStyle
  def getLocale(): Locale = ???
  def getResolverFields(): java.util.Set[TemporalField] = f.resolverFields.asInstanceOf[scalajs.js.Array[ChronoField]]
  def getResolverStyle(): ResolverStyle = f.resolverStyle
  def getZone(): ZoneId = f.zone.asInstanceOf[ZoneOffsetF]
  // How do we wrap the result?
  def parse(text: CharSequence): TemporalAccessor = ???
  // How do we wrap the result?
  def parse(text: CharSequence, parsePosition: ParsePosition): TemporalAccessor = ???
  // How do we wrap the result?
  def parse[T](text: String, query: TemporalQuery[T]): T = ???
  // How do we wrap the result?
  def parseBest[T](text: String, queries: TemporalQuery[T]*): TemporalAccessor = ???
  // How do we wrap the result?
  def parseUnresolved(text: CharSequence, parsePosition: ParsePosition): TemporalAccessor = ???
  def toFormat(): Format = ???
  def toFormat[T](parseQuery: TemporalQuery[T]): Format = ???
  def withChronology(chrono: Chronology): DateTimeFormatter = f.withChronology(chrono.asInstanceOf[IsoChronology])
  def withResolverFields(resolverFields: java.util.Set[TemporalField]): DateTimeFormatter = ???
  def withResolverFields(resolverFields: TemporalField*): DateTimeFormatter = ???
  def withResolverStyle(resolverStyle: ResolverStyle): DateTimeFormatter = ???
  def withZone(zone: ZoneId): DateTimeFormatter = ???

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
