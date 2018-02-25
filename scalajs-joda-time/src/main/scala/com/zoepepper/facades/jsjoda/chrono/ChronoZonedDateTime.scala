package com.zoepepper.facades.jsjoda.chrono

import com.zoepepper.facades.jsjoda.Instant
import com.zoepepper.facades.jsjoda.format.DateTimeFormatter
import com.zoepepper.facades.jsjoda.temporal.Temporal

import scalajs.js

@js.native
trait ChronoZonedDateTime[D <: ChronoLocalDate] extends Temporal {
  def format(formatter: DateTimeFormatter): String = js.native
  def toInstant(): Instant = js.native
  def toEpochSecond(): Double = js.native
  def compareTo(other: ChronoZonedDateTime[_]): Int = js.native
  def isAfter(other: ChronoZonedDateTime[_]): Boolean = js.native
  def isBefore(other: ChronoZonedDateTime[_]): Boolean = js.native
  def isEqual(other: ChronoZonedDateTime[_]): Boolean = js.native
}
