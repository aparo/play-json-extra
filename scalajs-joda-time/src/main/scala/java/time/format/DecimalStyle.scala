package java.time.format

import java.Wraps
import java.util.Locale

import com.zoepepper.facades.jsjoda.format.{DecimalStyle => DecimalStyleF}

object DecimalStyle {
  def getAvailableLocales(): java.util.Set[Locale] = ???
  def of(locale: Locale): DecimalStyle = ???
  def ofDefaultLocale(): DecimalStyle = ???

  val STANDARD: DecimalStyle = DecimalStyleF.STANDARD
}

class DecimalStyle protected[time](f: DecimalStyleF) extends Wraps(f) {
  def getDecimalSeparator(): Char = f.decimalSeparator
  def getNegativeSign(): Char = f.negativeSign
  def getPositiveSign(): Char = f.positiveSign
  def getZeroDigit(): Char = f.zeroDigit
  def withDecimalSeparator(decimalSeparator: Char): DecimalStyle = f.withDecimalSeparator(decimalSeparator)
  def withNegativeSign(negativeSign: Char): DecimalStyle = f.withNegativeSign(negativeSign)
  def withPositiveSign(positiveSign: Char): DecimalStyle = f.withPositiveSign(positiveSign)
  def withZeroDigit(zeroDigit: Char): DecimalStyle = f.withZeroDigit(zeroDigit)

  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
