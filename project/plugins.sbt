// Comment to get more information during initialization
logLevel := Level.Warn

addSbtPlugin("com.typesafe.play"  % "sbt-plugin"            % "2.5.6")
addSbtPlugin("org.scala-js"       % "sbt-scalajs"           % "0.6.12")
addSbtPlugin("com.typesafe.sbt"   % "sbt-scalariform"       % "1.3.0")
addSbtPlugin("org.scalastyle"     % "scalastyle-sbt-plugin" % "0.7.0")
// https://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt"   % "sbt-updates"           % "0.1.10")
addSbtPlugin("com.scalapenos"     % "sbt-prompt"            % "0.2.1")
