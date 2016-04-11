// Comment to get more information during initialization
logLevel := Level.Warn

//logLevel := Level.Debug

// Resolvers
resolvers += "sonatype-releases"   at "http://oss.sonatype.org/content/repositories/releases"
resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
resolvers += Resolver.sonatypeRepo("public")

addSbtPlugin("com.typesafe.play"  % "sbt-plugin"            % "2.5.1")
addSbtPlugin("com.eed3si9n"       % "sbt-unidoc"            % "0.3.2")
addSbtPlugin("com.github.gseitz"  % "sbt-release"           % "0.8.5")
addSbtPlugin("org.scala-js"       % "sbt-scalajs"           % "0.6.8")
addSbtPlugin("org.scoverage"      % "sbt-scoverage"         % "1.0.4")
addSbtPlugin("com.codacy"         % "sbt-codacy-coverage"   % "1.0.3")
addSbtPlugin("org.scoverage"      % "sbt-coveralls"         % "1.0.0")
addSbtPlugin("com.typesafe.sbt"   % "sbt-scalariform"       % "1.3.0")
addSbtPlugin("org.scalastyle"     % "scalastyle-sbt-plugin" % "0.7.0")
// https://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt"   % "sbt-updates"           % "0.1.10")
addSbtPlugin("com.scalapenos"     % "sbt-prompt"            % "0.2.1")

addSbtPlugin("com.jsuereth"       % "sbt-pgp"               % "1.0.0")
addSbtPlugin("org.xerial.sbt"     % "sbt-sonatype"          % "0.2.2")




