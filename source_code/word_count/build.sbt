name := "word_count"

version := "0.1"

scalaVersion := "2.11.8"

description := "project by 'Saurabh Verma' on github/saurabh17jan"

/**
 *
 * Add following to use scopt, for better parsing of CLI args
 *
 */
libraryDependencies += "com.github.scopt" %% "scopt" % "3.5.0"

/**
 * use these spark libraries and ensure proper version is mentioned.
 * use 'provided' option in production
 */
/*
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.1" % "provided"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.1" % "provided"
libraryDependencies += "org.apache.spark" % "spark-hive_2.11" % "2.0.1" % "provided"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
*/

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.1"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.1"
libraryDependencies += "org.apache.spark" % "spark-hive_2.11" % "2.0.1"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
