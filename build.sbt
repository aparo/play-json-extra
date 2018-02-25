//publishTo := sonatypePublishTo.value

Common.settings

val scalaJSJodaTime = project.in(file("scalajs-joda-time"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Common.settings: _*)
  .settings(
    name := s"scalajs-joda-time",
    scalacOptions += "-language:reflectiveCalls",
    scalaVersion := Versions.scala,
    version := Versions.app,
    libraryDependencies ++=
      Seq(
        "org.scalatest" %%% "scalatest" % Versions.scalaTestJS % "test",
        "com.lihaoyi" %%% "utest" % "0.6.3" % "test"),
    jsDependencies += (ProvidedJS / "moment-with-locales.min.js") % Test,
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv
  )

val playJsonExtra = crossProject.in(file("play-json-extra"))
  .settings(Common.settings: _*)
  .settings(
    name := s"play-json-extra",
    scalacOptions += "-language:reflectiveCalls",
    scalaVersion := Versions.scala,
    version := Versions.app,
    libraryDependencies ++= DependencyHelpers.compile(Library.scalastm, Library.scalaCompiler) ++
      Seq(
        "com.lihaoyi" %%% "upickle" % Versions.upickle,
        "io.suzaku" %%% "boopickle" % Versions.boopickle,
        "com.typesafe.play" %%% "play-functional" % _root_.play.core.PlayVersion.current,
        "com.typesafe.play" %%% "play-json" % _root_.play.core.PlayVersion.current,
        "org.scalatest" %%% "scalatest" % Versions.scalaTestJS % "test",
        "com.lihaoyi" %%% "utest" % "0.6.3" % "test") ++
      DependencyHelpers.provided(Library.scalaReflect)
  )
  .jsSettings(
    jsDependencies += (ProvidedJS / "moment-with-locales.min.js") % Test,
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv
  )
  .jvmSettings(
    libraryDependencies ++= DependencyHelpers.compile(
      Library.jawnParser
    ) ++ DependencyHelpers.test(
      Library.specs2
    )
  )

lazy val playJsonExtraJS = playJsonExtra.js.dependsOn(scalaJSJodaTime)

lazy val playJsonExtraJVM = playJsonExtra.jvm

lazy val root =
  project.in(file(".")).settings(
      publishArtifact := false,
      packagedArtifacts := Map.empty) // doesn't work - https://github.com/sbt/sbt-pgp/issues/42
    .aggregate(scalaJSJodaTime, playJsonExtraJS, playJsonExtraJVM)

