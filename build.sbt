name := """hello-scala"""

version := "1.0"

scalaVersion := "2.11.7"


val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % Test

)

libraryDependencies ++= testDependencies

fork in run := true