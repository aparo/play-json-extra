
import scala.scalajs.js
import js.annotation._

package web {

package moment {

import scala.scalajs.js.Date

@js.native
trait MomentInput extends js.Object {
  var years: Double = js.native
  var y: Double = js.native
  var months: Double = js.native
  var M: Double = js.native
  var weeks: Double = js.native
  var w: Double = js.native
  var days: Double = js.native
  var d: Double = js.native
  var hours: Double = js.native
  var h: Double = js.native
  var minutes: Double = js.native
  var m: Double = js.native
  var seconds: Double = js.native
  var s: Double = js.native
  var milliseconds: Double = js.native
  var ms: Double = js.native
}

@js.native
trait Duration extends js.Object {
  def humanize(withSuffix: Boolean = ???): String = js.native
  def as(units: String): Double = js.native
  def milliseconds(): Double = js.native
  def asMilliseconds(): Double = js.native
  def seconds(): Double = js.native
  def asSeconds(): Double = js.native
  def minutes(): Double = js.native
  def asMinutes(): Double = js.native
  def hours(): Double = js.native
  def asHours(): Double = js.native
  def days(): Double = js.native
  def asDays(): Double = js.native
  def months(): Double = js.native
  def asMonths(): Double = js.native
  def years(): Double = js.native
  def asYears(): Double = js.native
  def add(n: Double, p: String): Duration = js.native
  def add(n: Double): Duration = js.native
  def add(d: Duration): Duration = js.native
  def subtract(n: Double, p: String): Duration = js.native
  def subtract(n: Double): Duration = js.native
  def subtract(d: Duration): Duration = js.native
  def toISOString(): String = js.native
}

@js.native
trait Moment extends js.Object {
  def format(format: String): String = js.native
  def format(): String = js.native
  def fromNow(withoutSuffix: Boolean = ???): String = js.native
  def startOf(unitOfTime: String): Moment = js.native
  def endOf(unitOfTime: String): Moment = js.native
  def add(unitOfTime: String, amount: Double): Moment = js.native
  def add(amount: Double, unitOfTime: String): Moment = js.native
  def add(objectLiteral: MomentInput): Moment = js.native
  def add(duration: Duration): Moment = js.native
  def subtract(unitOfTime: String, amount: Double): Moment = js.native
  def subtract(amount: Double, unitOfTime: String): Moment = js.native
  def subtract(objectLiteral: MomentInput): Moment = js.native
  def subtract(duration: Duration): Moment = js.native
  def calendar(): String = js.native
  def calendar(start: Moment): String = js.native
  //  def clone(): Moment = js.native
  //  def valueOf(): Double = js.native
  def local(): Moment = js.native
  def utc(): Moment = js.native
  def isValid(): Boolean = js.native
  def year(y: Double): Moment = js.native
  def year(): Double = js.native
  def quarter(): Double = js.native
  def quarter(q: Double): Moment = js.native
  def month(M: Double): Moment = js.native
  def month(): Double = js.native
  def day(d: Double): Moment = js.native
  def day(): Double = js.native
  def date(d: Double): Moment = js.native
  def date(): Double = js.native
  def hour(h: Double): Moment = js.native
  def hour(): Double = js.native
  def hours(h: Double): Moment = js.native
  def hours(): Double = js.native
  def minute(m: Double): Moment = js.native
  def minute(): Double = js.native
  def minutes(m: Double): Moment = js.native
  def minutes(): Double = js.native
  def second(s: Double): Moment = js.native
  def second(): Double = js.native
  def seconds(s: Double): Moment = js.native
  def seconds(): Double = js.native
  def millisecond(ms: Double): Moment = js.native
  def millisecond(): Double = js.native
  def milliseconds(ms: Double): Moment = js.native
  def milliseconds(): Double = js.native
  def weekday(): Double = js.native
  def weekday(d: Double): Moment = js.native
  def isoWeekday(): Double = js.native
  def isoWeekday(d: Double): Moment = js.native
  def weekYear(): Double = js.native
  def weekYear(d: Double): Moment = js.native
  def isoWeekYear(): Double = js.native
  def isoWeekYear(d: Double): Moment = js.native
  def week(): Double = js.native
  def week(d: Double): Moment = js.native
  def weeks(): Double = js.native
  def weeks(d: Double): Moment = js.native
  def isoWeek(): Double = js.native
  def isoWeek(d: Double): Moment = js.native
  def isoWeeks(): Double = js.native
  def isoWeeks(d: Double): Moment = js.native
  def weeksInYear(): Double = js.native
  def isoWeeksInYear(): Double = js.native
  def dayOfYear(): Double = js.native
  def dayOfYear(d: Double): Moment = js.native
  def from(f: Moment): String = js.native
  def from(f: Moment, suffix: Boolean): String = js.native
  def from(d: Date): String = js.native
  def from(s: String): String = js.native
  def from(date: js.Array[Double]): String = js.native
  def diff(b: Moment): Double = js.native
  def diff(b: Moment, unitOfTime: String): Double = js.native
  def diff(b: Moment, unitOfTime: String, round: Boolean): Double = js.native
  def toArray(): js.Array[Double] = js.native
  def toDate(): Date = js.native
  def toISOString(): String = js.native
  def toJSON(): String = js.native
  def unix(): Double = js.native
  def isLeapYear(): Boolean = js.native
  def zone(): Double = js.native
  def zone(b: Double): Moment = js.native
  def daysInMonth(): Double = js.native
  def isDST(): Boolean = js.native
  def isBefore(): Boolean = js.native
  def isBefore(b: Moment): Boolean = js.native
  def isBefore(b: Moment, granularity: String): Boolean = js.native
  def isAfter(): Boolean = js.native
  def isAfter(b: Moment): Boolean = js.native
  def isAfter(b: Moment, granularity: String): Boolean = js.native
  def isSame(b: Moment): Boolean = js.native
  def isSame(b: Moment, granularity: String): Boolean = js.native
  def lang(language: String): Moment = js.native
  def lang(reset: Boolean): Moment = js.native
  def lang(): MomentLanguage = js.native
  def locale(language: String): Moment = js.native
  def locale(reset: Boolean): Moment = js.native
  def locale(): String = js.native
  def localeData(language: String): Moment = js.native
  def localeData(reset: Boolean): Moment = js.native
  def localeData(): MomentLanguage = js.native
  def max(date: Date): Moment = js.native
  def max(date: String, format: String): Moment = js.native
  def max(clone: Moment): Moment = js.native
  def min(date: Date): Moment = js.native
  def min(date: String, format: String): Moment = js.native
  def min(clone: Moment): Moment = js.native
  def get(unit: String): Double = js.native
  def set(unit: String, value: Double): Moment = js.native

  //timezone support
  def tz(timezone: String): Moment = js.native

}

@js.native
trait MomentCalendar extends js.Object {
  var lastDay: js.Any = js.native
  var sameDay: js.Any = js.native
  var nextDay: js.Any = js.native
  var lastWeek: js.Any = js.native
  var nextWeek: js.Any = js.native
  var sameElse: js.Any = js.native
}

@js.native
trait MomentLanguage extends js.Object {
  var months: js.Any = js.native
  var monthsShort: js.Any = js.native
  var weekdays: js.Any = js.native
  var weekdaysShort: js.Any = js.native
  var weekdaysMin: js.Any = js.native
  var longDateFormat: MomentLongDateFormat = js.native
  var relativeTime: MomentRelativeTime = js.native
  var meridiem: js.Function3[Double, Double, Boolean, String] = js.native
  var calendar: MomentCalendar = js.native
  var ordinal: js.Function1[Double, String] = js.native
}

@js.native
trait MomentLongDateFormat extends js.Object {
  var L: String = js.native
  var LL: String = js.native
  var LLL: String = js.native
  var LLLL: String = js.native
  var LT: String = js.native
  var l: String = js.native
  var ll: String = js.native
  var lll: String = js.native
  var llll: String = js.native
  var lt: String = js.native
}

@js.native
trait MomentRelativeTime extends js.Object {
  var future: js.Any = js.native
  var past: js.Any = js.native
  var s: js.Any = js.native
  var m: js.Any = js.native
  var mm: js.Any = js.native
  var h: js.Any = js.native
  var hh: js.Any = js.native
  var d: js.Any = js.native
  var dd: js.Any = js.native
  var M: js.Any = js.native
  var MM: js.Any = js.native
  var y: js.Any = js.native
  var yy: js.Any = js.native
}

@js.native
trait MomentStatic extends js.Object {
  var version: String = js.native
  def apply(): Moment = js.native
  def apply(date: Double): Moment = js.native
  //  def apply(date: String, format: String = ???, strict: Boolean = ???): Moment = js.native
  def apply(date: String, format: String = null, language: String = "en", strict: Boolean = false): Moment = js.native
  //  def apply(date: String, formats: js.Array[String], strict: Boolean = ???): Moment = js.native
  //  def apply(date: String, formats: js.Array[String], language: String = ???, strict: Boolean = ???): Moment = js.native
  //  def apply(date: String, specialFormat: js.Function0[Unit], strict: Boolean = ???): Moment = js.native
  //  def apply(date: String, specialFormat: js.Function0[Unit], language: String = ???, strict: Boolean = ???): Moment = js.native
  //  def apply(date: String, formatsIncludingSpecial: js.Array[js.Any], strict: Boolean = ???): Moment = js.native
  //  def apply(date: String, formatsIncludingSpecial: js.Array[js.Any], language: String = ???, strict: Boolean = ???): Moment = js.native
  def utc(): Moment = js.native
  def utc(date: Double): Moment = js.native
  //  def utc(date: String, format: String = ???, strict: Boolean = ???): Moment = js.native
  def utc(date: String, format: String = ???, language: String = ???, strict: Boolean = ???): Moment = js.native
  //  def utc(date: String, formats: js.Array[String], strict: Boolean = ???): Moment = js.native
  //  def utc(date: String, formats: js.Array[String], language: String = ???, strict: Boolean = ???): Moment = js.native
  def unix(timestamp: Double): Moment = js.native
  def invalid(parsingFlags: Object = ???): Moment = js.native
  def isMoment(): Boolean = js.native
  def isMoment(m: js.Any): Boolean = js.native
  def isDuration(): Boolean = js.native
  def isDuration(d: js.Any): Boolean = js.native
  //  def lang(language: String = ???): String = js.native
  def lang(language: String = ???, definition: MomentLanguage = ???): String = js.native
  //  def locale(language: String = ???): String = js.native
  def locale(language: String = ???, definition: MomentLanguage = ???): String = js.native
  def localeData(language: String = ???): MomentLanguage = js.native
  var longDateFormat: js.Any = js.native
  var relativeTime: js.Any = js.native
  var meridiem: js.Function3[Double, Double, Boolean, String] = js.native
  var calendar: js.Any = js.native
  var ordinal: js.Function1[Double, String] = js.native
  def duration(milliseconds: Number): Duration = js.native
  def duration(num: Number, unitOfTime: String): Duration = js.native
  def duration(input: MomentInput): Duration = js.native
  def duration(`object`: js.Any): Duration = js.native
  def duration(): Duration = js.native
  def parseZone(date: String): Moment = js.native
  def months(): js.Array[String] = js.native
  def months(index: Double): String = js.native
  def months(format: String): js.Array[String] = js.native
  def months(format: String, index: Double): String = js.native
  def monthsShort(): js.Array[String] = js.native
  def monthsShort(index: Double): String = js.native
  def monthsShort(format: String): js.Array[String] = js.native
  def monthsShort(format: String, index: Double): String = js.native
  def weekdays(): js.Array[String] = js.native
  def weekdays(index: Double): String = js.native
  def weekdays(format: String): js.Array[String] = js.native
  def weekdays(format: String, index: Double): String = js.native
  def weekdaysShort(): js.Array[String] = js.native
  def weekdaysShort(index: Double): String = js.native
  def weekdaysShort(format: String): js.Array[String] = js.native
  def weekdaysShort(format: String, index: Double): String = js.native
  def weekdaysMin(): js.Array[String] = js.native
  def weekdaysMin(index: Double): String = js.native
  def weekdaysMin(format: String): js.Array[String] = js.native
  def weekdaysMin(format: String, index: Double): String = js.native
  def min(moments: js.Array[Moment]): Moment = js.native
  def max(moments: js.Array[Moment]): Moment = js.native
  def normalizeUnits(unit: String): String = js.native
  def relativeTimeThreshold(threshold: String, limit: Double): Unit = js.native
  def ISO_8601(): Unit = js.native

  //timezone support
  var tz: MomentTimezone = js.native
}

}

}

package object moment extends js.GlobalScope {
  var moment: web.moment.MomentStatic = js.native
}
