name := "arkon-scalatraining"

version := "0.1"

scalaVersion := "2.13.3"

Compile / mainClass := Some("graphql.app.Main")


libraryDependencies ++= Seq(
  "org.tpolecat"             %% "doobie-core" % "1.0.0-RC2",
  "org.tpolecat"             %% "doobie-hikari" % "1.0.0-RC2",
  "org.tpolecat"             %% "doobie-postgres" % "1.0.0-RC2",

  "org.sangria-graphql" %% "sangria-ast"           % "3.0.0",
  "org.sangria-graphql" %% "sangria-parser"        % "3.0.0",
  "org.sangria-graphql" %% "sangria-core"          % "3.0.0",
  "org.sangria-graphql" %% "sangria-derivation"    % "3.0.0",
  "org.sangria-graphql" %% "sangria-circe"         % "1.3.2",

  "org.typelevel" %% "cats-effect" % "3.3.5",

  "org.tpolecat" %% "doobie-core" % "1.0.0-RC2",
  "org.tpolecat" %% "doobie-hikari" % "1.0.0-RC2",
  "org.tpolecat" %% "doobie-postgres" % "1.0.0-RC2",

  "org.postgresql" % "postgresql" % "42.3.1",

  "com.github.pureconfig" %% "pureconfig" % "0.17.4",

  "io.circe" %% "circe-generic" % "0.14.1",
  "io.circe" %% "circe-parser"  % "0.14.1",

  "org.http4s" %% "http4s-ember-server" % "0.23.11",
  "org.http4s" %% "http4s-circe" % "0.23.11",
  "org.http4s" %% "http4s-dsl" % "0.23.11",

  "ch.qos.logback" % "logback-classic" % "1.2.11",

  "org.scalatest" %% "scalatest"    % "3.2.9" % "test"
)
