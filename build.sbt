organization := "so.dun"
name := "java-utils"
version := "0.0.1"

scalaVersion := "2.12.5"
javacOptions in Compile ++= Seq("-encoding", "UTF-8", "-source", "1.8")
javacOptions in(Compile, compile) ++= Seq("-target", "1.8")

lazy val root = (project in file("."))
