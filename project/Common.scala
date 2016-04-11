import sbt._
import Keys._
import com.scalapenos.sbt.prompt._
import SbtPrompt.autoImport._

object Common {

  val settings: Seq[Setting[_]] = Seq(
    organizationName := "Paro Alberto Maria Angelo",
    organization := "io.megl",
    version := Versions.app,
    scalaVersion := Versions.scala,
    autoScalaLibrary := false,
    ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) },
    parallelExecution := false,
    scalacOptions ++= Seq(
      "-encoding", "UTF-8", "-target:jvm-1.8", 
      "-unchecked", // Enable additional warnings where generated code depends on assumptions.
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      //"-Xfatal-warnings", // Fail the compilation if there are any warnings.
      //"-Xlint", // Enable recommended additional warnings.
      //"-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
      //"-Ywarn-dead-code", // Warn when dead code is identified.
      //"-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
      //"-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
      //"-Ywarn-numeric-widen", // Warn when numerics are widened.
      "-language:postfixOps", 
      "-language:implicitConversions",
      "-language:higherKinds", 
      "-language:existentials", 
      "-language:reflectiveCalls"
      /*, "-Ylog-classpath"*/),
    scalacOptions in Test ++= Seq("-Yrangepos"),
    javacOptions ++= Seq("-encoding", "UTF-8", "-source", "1.8", "-target", "1.8"),
    //updateOptions := updateOptions.value.withCachedResolution(true),
    //shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " },
    promptTheme := ScalapenosTheme,
    //    additionalLibs in Dist := file("sigar").listFiles.filter(f => !f.isDirectory),
    logBuffered := false,
    historyPath <<= baseDirectory({
      t => //println(t);
        val historyDir = new File(System.getProperty("user.home")) / ".sbt_history"
        if (!historyDir.exists())
          historyDir.mkdir()
        Some(historyDir / t.getAbsolutePath.replace("/", "-").substring(1))
    }),
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := {
      _ => false
    },
    makePomConfiguration ~= {
      _.copy(configurations = Some(Seq(Compile, Runtime)))
    },
    homepage := Some(url("http://www.megl.io")),
    startYear := Some(2015),
    licenses +=("Apache License 2.0", url("http://www.apache.org/licenses/")),
    resolvers ++= Resolvers.repositories,
    pomExtra :=
      <developers>
        <developer>
          <id>aparo</id>
          <name>Alberto Paro</name>
          <timezone>+1</timezone>
          <url>http://www.megl.io</url>
        </developer>
      </developers>
        <scm>
          <url>https://github.com/aparo/play-json-extra</url>
          <connection>scm:git:https://github.com/aparo/play-json-extra.git</connection>
        </scm>,
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)//,
    //sources in doc in Compile := List() //disable doc generation
  )

}