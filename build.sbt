ThisBuild / scalaVersion        := "3.2.2"
ThisBuild / organization        := "com.vzxplnhqr"
ThisBuild / homepage            := Some(url("https://github.com/VzxPLnHqr/sats-effect"))
ThisBuild / licenses            += License.Apache2
ThisBuild / developers          := List(tlGitHubDev("VzxPLnHqr", "VzxPLnHqr"))

ThisBuild / version             := "0.0.1"

Global / onChangedBuildSource := ReloadOnSourceChanges

val CatsVersion = "2.9.0"
val CatsEffectVersion = "3.5.0-RC3"
val Fs2Version = "3.7.0-RC2"
val ScoinVersion = "0.7.0-SNAPSHOT"

lazy val core = crossProject(JVMPlatform /*, JSPlatform, NativePlatform*/)
  .in(file("."))
  .settings(
    name := "sats-effect",
    description := "purely functional bitcoin library",
    libraryDependencies ++= Seq(
      "com.fiatjaf" %%% "scoin" % ScoinVersion,
      "org.typelevel" %%% "cats-core" % CatsVersion,
      "org.typelevel" %%% "cats-effect" % CatsEffectVersion,
      "co.fs2" %%% "fs2-core" % Fs2Version,
      "com.lihaoyi" %%% "utest" % "0.8.0" % Test,
      "org.typelevel" %%% "cats-effect-testing-utest" % "1.5.0" % Test
    ),
    testFrameworks += new TestFramework("utest.runner.Framework")
  )
  .jvmSettings(
    crossScalaVersions := List("3.2.2"),
  )
  /*.jsConfigure { _.enablePlugins(NpmDependenciesPlugin) }
  .jsSettings(
    scalaVersion := "3.2.2",
    libraryDependencies ++= Seq(

    ),
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    scalaJSUseMainModuleInitializer := true

  )
  .nativeSettings(
    scalaVersion := "3.2.2",
    nativeConfig ~= { _.withEmbedResources(true) }
  )*/