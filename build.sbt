//publishTo := sonatypePublishTo.value

Common.settings


val playJsonExtra = crossProject.in(file("play-json-extra"))
  .settings(Common.settings: _*)
  .settings(
    name := s"play-json-extra",
    scalacOptions += "-language:reflectiveCalls",
    scalaVersion := Versions.scala,
    version := Versions.app,
    libraryDependencies ++= DependencyHelpers.compile(Library.scalastm, Library.scalaCompiler) ++
      Seq(
        "com.typesafe.play" %%% "play-json" % Versions.playJson,
        "org.scalatest" %%% "scalatest" % Versions.scalaTestJS % Test,
          "org.specs2" %%% "specs2-core" % Versions.specs2 % Test,
        "com.lihaoyi" %%% "utest" % "0.6.3" % "test") ++
      DependencyHelpers.provided(Library.scalaReflect)
  )

lazy val playJsonExtraJS = playJsonExtra.js

lazy val playJsonExtraJVM = playJsonExtra.jvm

lazy val root =
  project.in(file(".")).settings(
      publishArtifact := false,
      packagedArtifacts := Map.empty) // doesn't work - https://github.com/sbt/sbt-pgp/issues/42
    .aggregate(playJsonExtraJS, playJsonExtraJVM)

