// ThisBuild / name := "chess"
ThisBuild / organization := "htwg.se.chess"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "3.2.1"

lazy val BoardComponent =
  (project in file("BoardComponent"))
    // (project in file("src/test/scala/htwg/se/chess/model/Boarddddddddddd"))
    .settings(
      libraryDependencies += "com.google.inject" % "guice" % "5.1.0"
      // other settings
    )

lazy val FileIOComponent =
  // (project in file("src/test/scala/htwg/se/chess/model/FileIOComponent"))
  (project in file("FileIOComponent"))
    .dependsOn(BoardComponent)
    .settings(
      libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0"
      // other settings
    )

lazy val root = (project in file("."))
  .aggregate(BoardComponent, FileIOComponent)
  .dependsOn(BoardComponent, FileIOComponent)
  .settings(
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.15",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test",
    libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
    libraryDependencies += "net.codingwell" %% "scala-guice" % "5.1.1",
    libraryDependencies += "com.typesafe.play" %% "play-test" % "2.9.0-M3" % Test
  )

// name := "chess"
// version := "0.1"
// organization := "htwg.se.chess"
// scalaVersion := "3.2.1"

// libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.15"
// libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
// libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
// libraryDependencies += "com.google.inject" % "guice" % "5.1.0"
// libraryDependencies += "net.codingwell" %% "scala-guice" % "5.1.1"
// libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0"
// libraryDependencies += "com.typesafe.play" %% "play-test" % "2.9.0-M3" % Test

coverageExcludedPackages := "htwg\\.se\\.chess\\.aview\\.gui;.*FileIOComponent.*;.*Chess"
