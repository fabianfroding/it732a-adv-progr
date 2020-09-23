ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "se.his"

lazy val hello = (project in file("."))
  .settings(
    name := "linalg",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
  )
