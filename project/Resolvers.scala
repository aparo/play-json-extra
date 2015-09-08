import sbt._
import Keys._

object Resolvers {
  lazy val repositories = Seq(
    // Sonatype repo
    Resolver.sonatypeRepo("snapshots"),
    //    "staging"       at "http://oss.sonatype.org/content/repositories/staging",
    Resolver.sonatypeRepo("releases"),
    "Typesafe ivy-snapshots" at "http://repo.typesafe.com/typesafe/ivy-snapshots/",
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
  )
}