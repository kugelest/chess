name := "chess"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.7"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"

libraryDependencies += "com.google.inject" % "guice" % "5.0.1"
libraryDependencies += "net.codingwell" %% "scala-guice" % "5.0.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.0"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.2"

coverageExcludedPackages := "htwg\\.se\\.chess\\.aview\\.gui;.*FileIOComponent.*;.*Chess"