/* Copyright 2009-2015 - Paro Alberto Maria Angelo  All Rights Reserved. */

import sbt._
import sbt.Keys._
import org.scalajs.sbtplugin._

object Versions {

  lazy val app = "2.5.0-SNAPSHOT"

  //scalajs
  lazy val upickle = "0.3.9"
  lazy val boopickle = "1.1.3"
  lazy val log4js = "1.4.10"
  lazy val uTest = "0.3.1"

  lazy val scala = "2.11.8"

  lazy val scalaTest = "2.2.5"
  lazy val scalaTestJS = "3.0.0-M7"

  lazy val play = _root_.play.core.PlayVersion.current
  lazy val specs2 = "3.6.4"

}


object Library {

  lazy val scalaCompiler = "org.scala-lang" % "scala-compiler" % Versions.scala

  lazy val scalaReflect = "org.scala-lang" % "scala-reflect" % Versions.scala

  lazy val jodaTime = "joda-time" % "joda-time" % "2.9.3"
  lazy val jodaConvert = "org.joda" % "joda-convert" % "1.8.1"

  lazy val scalastm = "org.scala-stm" %% "scala-stm" % "0.7"

  lazy val jawnParser = "org.spire-math" %% "jawn-parser" % "0.7.0"

  lazy val specs2 = "org.specs2" %% "specs2-core" % Versions.specs2
  // "test"
  lazy val specs2Junit = "org.specs2" %% "specs2-junit" % Versions.specs2
  // "test"
  lazy val specs2ScalaCheck = "org.specs2" %% "specs2-scalacheck" % Versions.specs2 // "test"

  lazy val playJson = "com.typesafe.play" %% "play-json" % Versions.play

  lazy val scalatest = "org.scalatest" %% "scalatest" % Versions.scalaTest

}


object DependencyHelpers {
  def compile(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")

  def provided(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")

  def test(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  def runtime(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")

  def container(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")
}
