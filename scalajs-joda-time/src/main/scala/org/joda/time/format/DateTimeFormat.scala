package org.joda.time.format

import org.joda.Wraps
import java.text.Format
import java.time.format.FormatStyle

import org.joda.time.chrono.Chronology
import org.joda.time.temporal.{TemporalAccessor, TemporalField, TemporalQuery}
import org.joda.time.{Period, ZoneId}
import java.util.Locale

import com.zoepepper.facades.jsjoda.format.{ParsePosition, DateTimeFormatter => DateTimeFormatterF}
import com.zoepepper.facades.jsjoda.{ZoneOffset => ZoneOffsetF}
import org.joda.time.temporal

object DateTimeFormat {
  def ofLocalizedDate(dateStyle: FormatStyle): DateTimeFormat = ???
  def ofLocalizedDateTime(dateTimeStyle: FormatStyle): DateTimeFormat = ???
  def ofLocalizedDateTime(dateStyle: FormatStyle, timeStyle: FormatStyle): DateTimeFormat = ???
  def ofLocalizedTime(timeStyle: FormatStyle): DateTimeFormat = ???
  def ofPattern(pattern: String): DateTimeFormat = new DateTimeFormat(DateTimeFormatterF.ofPattern(pattern))
  def ofPattern(pattern: String, locale: Locale): DateTimeFormat = ???
  def parsedExcessDays(): TemporalQuery[Period] = ???
  def parsedLeapSecond(): TemporalQuery[Boolean] = ???


  val ISO_LOCAL_DATE: DateTimeFormat = new DateTimeFormat(DateTimeFormatterF.ISO_LOCAL_DATE)
  val ISO_LOCAL_TIME: DateTimeFormat = new DateTimeFormat(DateTimeFormatterF.ISO_LOCAL_TIME)
  val ISO_LOCAL_DATE_TIME: DateTimeFormat = new DateTimeFormat(DateTimeFormatterF.ISO_LOCAL_DATE_TIME)
  val ISO_INSTANT: DateTimeFormat = new DateTimeFormat(DateTimeFormatterF.ISO_INSTANT)
  val ISO_OFFSET_DATE_TIME: DateTimeFormat = new DateTimeFormat(DateTimeFormatterF.ISO_OFFSET_DATE_TIME)
  val ISO_ZONED_DATE_TIME: DateTimeFormat = new DateTimeFormat(DateTimeFormatterF.ISO_ZONED_DATE_TIME)

  // If we declare these as unimplemented we have trouble. For example, if we call ISO_LOCAL_DATE then
  // BASIC_ISO_DATE gets called and an exception is thrown.
  //  val BASIC_ISO_DATE: DateTimeFormat = ???
  //  val ISO_DATE: DateTimeFormat = ???
  //  val ISO_DATE_TIME: DateTimeFormat = ???
  //  val ISO_OFFSET_DATE: DateTimeFormat = ???
  //  val ISO_OFFSET_TIME: DateTimeFormat = ???
  //  val ISO_ORDINAL_DATE: DateTimeFormat = ???
  //  val ISO_TIME: DateTimeFormat = ???
  //  val RFC_1123_DATE_TIME: DateTimeFormat = ???
}

class DateTimeFormat protected[time](f: DateTimeFormatterF) extends Wraps(f) {
  def format(temporal: TemporalAccessor): String = f.format(temporal)
  def formatTo(temporal: TemporalAccessor, appendable: Appendable): Unit = ???
  def getChronology(): Chronology = f.chronology
  def getDecimalStyle(): DecimalStyle = f.decimalStyle
  def getLocale(): Locale = ???
  def getResolverFields(): java.util.Set[TemporalField] = f.resolverFields.asInstanceOf[scalajs.js.Array[temporal.ChronoField]]
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
  def withChronology(chrono: Chronology): DateTimeFormat = new DateTimeFormat(f.withChronology(chrono.asInstanceOf[com.zoepepper.facades.jsjoda.chrono.IsoChronology]))
  def withResolverFields(resolverFields: java.util.Set[TemporalField]): DateTimeFormat = ???
  def withResolverFields(resolverFields: TemporalField*): DateTimeFormat = ???
  def withResolverStyle(resolverStyle: ResolverStyle): DateTimeFormat = ???
  def withZone(zone: ZoneId): DateTimeFormat = ???

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
