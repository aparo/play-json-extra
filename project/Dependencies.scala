/* Copyright 2009-2017 - Paro Alberto Maria Angelo  All Rights Reserved. */

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.libraryDependencies
import sbt._

object Versions {

  lazy val app = "2.6.8"

  //scalajs
  lazy val upickle = "0.5.1"
  lazy val boopickle = "1.2.5"
  lazy val log4js = "1.4.10"
  lazy val uTest = "0.3.1"

  lazy val scala = "2.12.4"

  lazy val scalaTest = "3.0.5"
  lazy val scalaTestJS = "3.0.5"

  lazy val playJson = "2.7.0-SNAPSHOT"
  lazy val specs2 = "4.0.2"

}


object Library {

  lazy val scalaCompiler = "org.scala-lang" % "scala-compiler" % Versions.scala

  lazy val scalaReflect = "org.scala-lang" % "scala-reflect" % Versions.scala

  lazy val scalastm = "org.scala-stm" %% "scala-stm" % "0.8"

  lazy val specs2 = "org.specs2" %% "specs2-core" % Versions.specs2
  // "test"
  lazy val specs2Junit = "org.specs2" %% "specs2-junit" % Versions.specs2
  // "test"
  lazy val specs2ScalaCheck = "org.specs2" %% "specs2-scalacheck" % Versions.specs2 // "test"

  lazy val scalatest = "org.scalatest" %% "scalatest" % Versions.scalaTest

}


object DependencyHelpers {
  def compile(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")

  def provided(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")

  def test(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  def runtime(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")

  def container(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")
}
