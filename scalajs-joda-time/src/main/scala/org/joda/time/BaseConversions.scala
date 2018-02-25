package org.joda.time

import com.zoepepper.facades.jsjoda.{Clock => ClockF, DayOfWeek => DayOfWeekF, Duration => DurationF, Instant => InstantF, LocalDate => LocalDateF, LocalDateTime => LocalDateTimeF, LocalTime => LocalTimeF, Month => MonthF, MonthDay => MonthDayF, Period => PeriodF, Year => YearF, YearMonth => YearMonthF, ZoneId => ZoneIdF, ZoneOffset => ZoneOffsetF, ZonedDateTime => ZonedDateTimeF}

import scala.language.implicitConversions

trait BaseConversions {
  implicit def f2Clock(f: ClockF): Clock = new Clock(f)
  implicit def f2DayOfWeek(f: DayOfWeekF): DayOfWeek = new DayOfWeek(f)
  implicit def f2Duration(f: DurationF): Duration = new Duration(f)
  implicit def f2Instant(f: InstantF): Instant = new Instant(f)
  implicit def f2LocalDate(f: LocalDateF): LocalDate = new LocalDate(f)
  implicit def f2LocalDateTime(f: LocalDateTimeF): DateTime = new DateTime(f)
  implicit def f2LocalTime(f: LocalTimeF): LocalTime = new LocalTime(f)
  implicit def f2Month(f: MonthF): Month = new Month(f)
  implicit def f2MonthDay(f: MonthDayF): MonthDay = new MonthDay(f)
  implicit def f2Period(f: PeriodF): Period = new Period(f)
  implicit def f2Year(f: YearF): Year = new Year(f)
  implicit def f2YearMonth(f: YearMonthF): YearMonth = new YearMonth(f)
  implicit def zoneId2F(zoneId: ZoneId): ZoneIdF = zoneId.zoneIdF
  implicit def f2ZoneOffset(f: ZoneOffsetF): ZoneOffset = new ZoneOffset(f)
  implicit def f2ZonedDateTime(f: ZonedDateTimeF): ZonedDateTime = new ZonedDateTime(f)
}
