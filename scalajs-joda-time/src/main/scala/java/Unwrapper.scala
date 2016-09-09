package java

import scala.language.implicitConversions

trait Unwrapper {
  implicit def unwrapF[T <: AnyRef](wrapper: Wraps[T]): T = wrapper.f
}
