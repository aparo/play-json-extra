package com.zoepepper.facades.jsjoda.format

import com.zoepepper.facades.jsjoda.{Period, ZoneId}
import com.zoepepper.facades.jsjoda.chrono.IsoChronology
import com.zoepepper.facades.jsjoda.temporal.{TemporalAccessor, TemporalField, TemporalQuery}

import scalajs.js
import scalajs.js.annotation.JSName

@js.native
@JSName("JSJoda.DateTimeFormatter")
object DateTimeFormatter extends js.Object {
  def parsedExcessDays(): TemporalQuery[Period] = js.native
  def parsedLeapSecond(): TemporalQuery[Boolean] = js.native
  def ofPattern(pattern: String): DateTimeFormatter = js.native

  val ISO_LOCAL_DATE: DateTimeFormatter = js.native
  val ISO_LOCAL_TIME: DateTimeFormatter = js.native
  val ISO_LOCAL_DATE_TIME: DateTimeFormatter = js.native
  val ISO_INSTANT: DateTimeFormatter = js.native
  val ISO_OFFSET_DATE_TIME: DateTimeFormatter = js.native
  val ISO_ZONED_DATE_TIME: DateTimeFormatter = js.native
  val PARSED_EXCESS_DAYS: DateTimeFormatter = js.native
  val PARSED_LEAP_SECOND: DateTimeFormatter = js.native
}

@js.native
class DateTimeFormatter protected[jsjoda]() extends js.Object {
  def decimalStyle(): DecimalStyle = js.native
  def chronology(): IsoChronology = js.native
  def withChronology(chrono: IsoChronology): DateTimeFormatter = js.native
  def format(temporal: TemporalAccessor): String = js.native
  def parse(text: String): TemporalAccessor = js.native
  def parse[T](text: String, query: TemporalQuery[T]): T = js.native
  def parseUnresolved(text: String, position: ParsePosition): TemporalAccessor = js.native
  val resolverFields: js.Array[TemporalField] = js.native
  val resolverStyle: ResolverStyle = js.native
  val zone: ZoneId = js.native
}
