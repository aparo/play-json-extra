/* Copyright 2009-2015 - Paro Alberto Maria Angelo  All Rights Reserved. */

import sbt._
import sbt.Keys._
import org.scalajs.sbtplugin._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Versions {

  lazy val app = "2.5.6"

  //scalajs
  lazy val upickle = "0.4.2"
  lazy val boopickle = "1.2.4"
  lazy val log4js = "1.4.10"
  lazy val uTest = "0.3.1"

  lazy val scala = "2.11.8"

  lazy val scalaTest = "3.0.0"

  lazy val play = _root_.play.core.PlayVersion.current
  lazy val specs2 = "3.8.4"

}


object Library {

lazy val scalaJavaLocales = Def.setting("com.github.cquiroz" %%% "scala-java-locales" % "0.3.0+29")
lazy val jsjoda = Def.setting("com.zoepepper" %%% "scalajs-jsjoda" % "1.0.4")
lazy val jsjodaJavaTime = Def.setting("com.zoepepper" %%% "scalajs-jsjoda-as-java-time" % "1.0.4")


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
