package java

abstract class Wraps[T <: AnyRef] protected[java](protected[java] val f: T) extends Wrapper