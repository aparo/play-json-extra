package java.time.chrono

import com.zoepepper.facades.jsjoda.chrono.{ChronoLocalDate => ChronoLocalDateF}
import com.zoepepper.facades.jsjoda.chrono.{ChronoZonedDateTime => ChronoZonedDateTimeF}
import com.zoepepper.facades.jsjoda.chrono.{IsoChronology => IsoChronologyF}

import scala.language.implicitConversions

trait ChronoConversions {
  implicit def f2isoChronology(f: IsoChronologyF): IsoChronology = new IsoChronology(f)

  implicit def chronoLocalDate2f(cld: ChronoLocalDate): ChronoLocalDateF = cld.chronoLocalDateF
  
  implicit def chronoZonedDateTime2f(czdt: ChronoZonedDateTime[_]): ChronoZonedDateTimeF[_] = czdt.chronoZonedDateTimeF
}
