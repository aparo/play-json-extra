package java.time.chrono

import java.Wraps

object IsoEra {
  def of(isoEra: Int): IsoEra = ???
  def valueOf(name: String): IsoEra = ???
  def values(): Array[IsoEra] = ???

  val BCE: IsoEra = ???
  val CE: IsoEra = ???
}

class IsoEra protected[time](f: AnyRef) extends Wraps(f) with Comparable[IsoEra] with Era {
  def getValue(): Int = ???
  def compareTo(otherDuration: IsoEra): Int = ???
}
