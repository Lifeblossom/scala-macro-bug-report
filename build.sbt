ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "macro-testing-scala213",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test",
    libraryDependencies +=  "org.scala-lang" % "scala-reflect" % "2.13.10"
  )
  .settings(
    scalacOptions += "-Vprint:_"
  )