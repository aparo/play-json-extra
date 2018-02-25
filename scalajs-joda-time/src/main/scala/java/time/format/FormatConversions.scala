package java.time.format

import com.zoepepper.facades.jsjoda.format.{DateTimeFormatter => DateTimeFormatterF}
import com.zoepepper.facades.jsjoda.format.{DecimalStyle => DecimalStyleF}
import com.zoepepper.facades.jsjoda.format.{ResolverStyle => ResolverStyleF}

import scala.language.implicitConversions

trait FormatConversions {
  implicit def f2DateTimeFormatter(f: DateTimeFormatterF): DateTimeFormatter = new DateTimeFormatter(f)
  implicit def f2DecimalStyle(f: DecimalStyleF): DecimalStyle = new DecimalStyle(f)
  implicit def f2ResolverStyle(f: ResolverStyleF): ResolverStyle = new ResolverStyle(f)
}
