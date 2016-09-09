package java.time

import com.zoepepper.facades.jsjoda.{Clock => ClockF}
import com.zoepepper.facades.jsjoda.{DayOfWeek => DayOfWeekF}
import com.zoepepper.facades.jsjoda.{Duration => DurationF}
import com.zoepepper.facades.jsjoda.{Instant => InstantF}
import com.zoepepper.facades.jsjoda.{LocalDate => LocalDateF}
import com.zoepepper.facades.jsjoda.{LocalDateTime => LocalDateTimeF}
import com.zoepepper.facades.jsjoda.{LocalTime => LocalTimeF}
import com.zoepepper.facades.jsjoda.{Month => MonthF}
import com.zoepepper.facades.jsjoda.{MonthDay => MonthDayF}
import com.zoepepper.facades.jsjoda.{Period => PeriodF}
import com.zoepepper.facades.jsjoda.{Year => YearF}
import com.zoepepper.facades.jsjoda.{YearMonth => YearMonthF}
import com.zoepepper.facades.jsjoda.{ZoneId => ZoneIdF}
import com.zoepepper.facades.jsjoda.{ZoneOffset => ZoneOffsetF}
import com.zoepepper.facades.jsjoda.{ZonedDateTime => ZonedDateTimeF}

import scala.language.implicitConversions

trait BaseConversions {
  implicit def f2Clock(f: ClockF): Clock = new Clock(f)
  implicit def f2DayOfWeek(f: DayOfWeekF): DayOfWeek = new DayOfWeek(f)
  implicit def f2Duration(f: DurationF): Duration = new Duration(f)
  implicit def f2Instant(f: InstantF): Instant = new Instant(f)
  implicit def f2LocalDate(f: LocalDateF): LocalDate = new LocalDate(f)
  implicit def f2LocalDateTime(f: LocalDateTimeF): LocalDateTime = new LocalDateTime(f)
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
