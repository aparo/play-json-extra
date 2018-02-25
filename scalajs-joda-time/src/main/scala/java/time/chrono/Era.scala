package java.time.chrono

import java.Wrapper
import java.time.format.TextStyle
import java.time.temporal.{TemporalAccessor, TemporalAdjuster}
import java.util.Locale

trait Era extends TemporalAccessor with TemporalAdjuster {self: Wrapper =>
  protected[time] val eraF = self.f.asInstanceOf[AnyRef]

  def getDisplayName(style: TextStyle, locale: Locale): String = ???
}
