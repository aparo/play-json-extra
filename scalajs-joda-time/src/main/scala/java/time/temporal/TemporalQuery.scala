package java.time.temporal

import java.Wrapper

import com.zoepepper.facades.jsjoda.temporal.{TemporalQuery => TemporalQueryF}

trait TemporalQuery[R] { self: Wrapper =>
  protected[time] val temporalQueryF = self.f.asInstanceOf[TemporalQueryF[_]]

  def queryFrom(temporal: TemporalAccessor): R

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}