name := "AlarmFromTweet"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.twitter4j".%("twitter4j-core") % "4.0.4",
  "org.twitter4j".%("twitter4j-async") % "4.0.4",
  "org.twitter4j".%("twitter4j-stream") % "4.0.4"
)
    