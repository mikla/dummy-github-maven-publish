ThisBuild / organization := "io.github.mikla"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "3.3.1"
ThisBuild / versionScheme := Some("early-semver")

lazy val root = (project in file("."))
  .settings(
    name := "rstring",
    description := "A simple Scala 3 library for generating random strings",
    
    // Publishing settings for GitHub Packages
    publishMavenStyle := true,
    publishTo := Some("GitHub Packages" at "https://maven.pkg.github.com/mikla/dummy-github-maven-publish"),
    credentials += Credentials(
      "GitHub Package Registry",
      "maven.pkg.github.com",
      "mikla",
      sys.env.getOrElse("GITHUB_TOKEN", "")
    ),
    
    // Additional publishing settings
    pomIncludeRepository := { _ => false },
    Test / publishArtifact := false,
    
    // POM information
    pomExtra := (
      <url>https://github.com/mikla/dummy-github-maven-publish</url>
      <licenses>
        <license>
          <name>MIT</name>
          <url>https://opensource.org/licenses/MIT</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:git://github.com/mikla/dummy-github-maven-publish.git</connection>
        <developerConnection>scm:git:ssh://github.com:mikla/dummy-github-maven-publish.git</developerConnection>
        <url>https://github.com/mikla/dummy-github-maven-publish</url>
      </scm>
      <developers>
        <developer>
          <id>mikla</id>
          <name>Mikla</name>
        </developer>
      </developers>
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