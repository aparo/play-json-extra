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
        "com.lihaoyi" %%% "utest" % "0.3.1" % "test"),
    jsDependencies += (ProvidedJS / "moment-with-locales.min.js") % Test,
    jsDependencies += RuntimeDOM % Test,
    requiresDOM := true
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
        "me.chrons" %%% "boopickle" % Versions.boopickle,
        "org.scalatest" %%% "scalatest" % Versions.scalaTestJS % "test",
        "com.lihaoyi" %%% "utest" % "0.3.1" % "test") ++
      DependencyHelpers.provided(Library.scalaReflect)
  )
  .jsSettings(
    jsDependencies += (ProvidedJS / "moment-with-locales.min.js") % Test,
    jsDependencies += RuntimeDOM % Test,
    requiresDOM := true
  )
  .jvmSettings(
    libraryDependencies ++= DependencyHelpers.compile(
      Library.jawnParser,
      Library.playJson
    ) ++ DependencyHelpers.test(
      Library.scalatest,
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

