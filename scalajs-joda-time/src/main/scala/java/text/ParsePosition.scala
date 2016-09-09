package java.text

import java.Wraps

import com.zoepepper.facades.jsjoda.format.{ParsePosition => ParsePositionF}

class ParsePosition protected[java](f: ParsePositionF) extends Wraps(f) {
  def getErrorIndex(): Int = f.getErrorIndex()
  def getIndex(): Int = f.getIndex()
  def setErrorIndex(ei: Int) = f.setErrorIndex(ei)
  def setIndex(index: Int) = f.setIndex(index)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
