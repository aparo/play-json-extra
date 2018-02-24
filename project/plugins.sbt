// Comment to get more information during initialization
logLevel := Level.Warn

//logLevel := Level.Debug

// Resolvers
resolvers += "sonatype-releases"   at "http://oss.sonatype.org/content/repositories/releases"
resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
resolvers += Resolver.sonatypeRepo("public")

addSbtPlugin("com.typesafe.play"  % "sbt-plugin"            % "2.6.8")
addSbtPlugin("com.eed3si9n"       % "sbt-unidoc"            % "0.4.1")
addSbtPlugin("com.github.gseitz"  % "sbt-release"           % "1.0.6")
addSbtPlugin("org.scala-js"       % "sbt-scalajs"           % "0.6.22")
addSbtPlugin("org.scoverage"      % "sbt-scoverage"         % "1.5.1")
//addSbtPlugin("com.codacy"         % "sbt-codacy-coverage"   % "1.0.3")
//addSbtPlugin("org.scoverage"      % "sbt-coveralls"         % "1.0.0")
//https://scalacenter.github.io/scalafix/
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.5.7")
addSbtPlugin("org.scalastyle"     % "scalastyle-sbt-plugin" % "1.0.0")
// https://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt"   % "sbt-updates"           % "0.3.1")
addSbtPlugin("com.scalapenos"     % "sbt-prompt"            % "1.0.2")

addSbtPlugin("com.jsuereth"       % "sbt-pgp"               % "1.1.0")
addSbtPlugin("org.xerial.sbt"     % "sbt-sonatype"          % "2.0")




