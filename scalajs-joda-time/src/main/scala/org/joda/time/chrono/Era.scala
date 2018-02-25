package org.joda.time.chrono

import org.joda.Wrapper
import java.time.format.TextStyle
import org.joda.time.temporal.{TemporalAccessor, TemporalAdjuster}
import java.util.Locale

trait Era extends TemporalAccessor with TemporalAdjuster {self: Wrapper =>
  protected[time] val eraF = self.f.asInstanceOf[AnyRef]

  def getDisplayName(style: TextStyle, locale: Locale): String = ???
}
