package org.joda

abstract class Wraps[T <: AnyRef] protected[joda](protected[joda] val f: T) extends Wrapper