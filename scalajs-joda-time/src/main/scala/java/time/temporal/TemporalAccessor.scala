package java.time.temporal

import java.Wrapper

import com.zoepepper.facades.jsjoda.temporal.{TemporalAccessor => TemporalAccessorF}

trait TemporalAccessor {self: Wrapper =>
  protected[time] val temporalAccessorF = self.f.asInstanceOf[TemporalAccessorF]

  def get(field: TemporalField): Int = temporalAccessorF.get(field)
  def getLong(field: TemporalField): Long = temporalAccessorF.get(field).toLong
  def isSupported(field: TemporalField): Boolean = temporalAccessorF.isSupported(field)
  def query[T](query: TemporalQuery[T]): T = ??? // How can we wrap result?
  def range(field: TemporalField): ValueRange = temporalAccessorF.range(field)
}