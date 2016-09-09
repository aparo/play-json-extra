package java.time

import scala.reflect.ClassTag
import scalajs.js
import scala.collection.mutable

import scala.language.implicitConversions

trait TraversableConversions {
  implicit def jsArrayF2scalaArray[A, B : ClassTag](a: js.Array[A])(implicit ev: A => B): Array[B] =
    (a : mutable.Seq[A]).map(ev).toArray[B]

  implicit def jsArrayF2javaList[A, B: ClassTag](a: js.Array[A])
                                                (implicit ev: js.Array[A] => Array[B]): java.util.List[B] =
    java.util.Arrays.asList(ev(a):_*)

  implicit def jsArrayF2javaSet[A, B: ClassTag](a: js.Array[A])
                                                (implicit ev: js.Array[A] => java.util.List[B]): java.util.Set[B] =
    new java.util.HashSet[B](ev(a))
}
