package java.time.temporal

import com.zoepepper.facades.jsjoda.temporal.{ValueRange => ValueRangeF}

class ValueRange protected[time](protected[time] val f: ValueRangeF) {
  def isFixed(): Boolean = f.isFixed
  def getMinimum(): Long = f.minimum.toLong
  def getLargestMinimum(): Long = f.largestMinimum.toLong
  def getMaximum(): Long = f.maximum.toLong
  def getSmallestMaximum(): Long = f.smallestMaximum.toLong
  def isValidValue(value: Long): Boolean = f.isValidValue(value)
  def isValidIntValue(value: Long): Boolean = f.isValidIntValue(value)
  def checkValidValue(value: Long, field: TemporalField): Long = f.checkValidValue(value, field).toLong
  def checkValidIntValue(value: Long, field: TemporalField): Int = f.checkValidIntValue(value, field)
  def isIntValue(): Boolean = f.isIntValue

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
