package java.time.temporal

import java.Wrapper
import java.time.format.ResolverStyle
import java.util.Locale

import com.zoepepper.facades.jsjoda.temporal.{ChronoField => ChronoFieldF}
import com.zoepepper.facades.jsjoda.temporal.{ChronoUnit => ChronoUnitF}

trait TemporalField { self: Wrapper =>
  protected[time] val temporalFieldF = self.f.asInstanceOf[ChronoFieldF]

  def range(): ValueRange = temporalFieldF.range
  def rangeRefinedBy(temporal: TemporalAccessor): ValueRange = temporalFieldF.rangeRefinedBy(temporal)
  def getFrom(temporal: TemporalAccessor): Long = temporalFieldF.getFrom(temporal).toLong
  def isSupportedBy(temporal: TemporalAccessor): Boolean = ???
  def isDateBased(): Boolean = temporalFieldF.isDateBased
  def getRangeUnit(): TemporalUnit = temporalFieldF.rangeUnit.asInstanceOf[ChronoUnitF]
  def getBaseUnit(): TemporalUnit = temporalFieldF.baseUnit.asInstanceOf[ChronoUnitF]
  def isTimeBased(): Boolean = temporalFieldF.isTimeBased
  def adjustInto[R <: Temporal](temporal: R, newValue: Long): R = ???
  def getDisplayName(locale: Locale): String = ???
  def resolve(fieldValues: java.util.Map[TemporalField, Long], partialTemporal: TemporalAccessor,
              resolverStyle: ResolverStyle): TemporalAccessor = ???

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
