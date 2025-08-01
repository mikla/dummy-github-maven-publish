ThisBuild / organization := "io.github.mikla"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "rstring",
    description := "A simple Scala 3 library for generating random strings",
    
    // Publishing settings for GitHub Packages
    publishMavenStyle := true,
    publishTo := Some("GitHub Packages" at "https://maven.pkg.github.com/mikla/rstring"),
    credentials += Credentials(
      "GitHub Package Registry",
      "maven.pkg.github.com",
      "mikla",
      sys.env.getOrElse("GITHUB_TOKEN", "")
    ),
    
    // Library dependencies
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.17" % Test
    ),
    
    // Compiler options
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-unchecked",
      "-Xfatal-warnings"
    ),
    
    // Test options
    Test / parallelExecution := false
  ) 