package java.time.format

import java.Wraps

import com.zoepepper.facades.jsjoda.format.{ResolverStyle => ResolverStyleF}

object ResolverStyle {
  val STRICT: ResolverStyle = ResolverStyleF.STRICT
  val SMART: ResolverStyle = ResolverStyleF.SMART
  val LENIENT: ResolverStyle = ResolverStyleF.LENIENT
}

class ResolverStyle protected[time](f: ResolverStyleF) extends Wraps(f) {
  override def toString(): String = f.toString()
  override def hashCode(): Int = f.hashCode()
  override def equals(obj: Any): Boolean = f.equals(obj)
}
