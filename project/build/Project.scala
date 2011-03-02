import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info)
{
    val scalaToolsSnapshots = "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"



    val scalazCore = "org.scalaz" %% "scalaz-core" % "6.0-SNAPSHOT" withSources
    //val scalazHttp = "org.scalaz" %% "scalaz-http" % "6.0-SNAPSHOT"

    val specs = "org.scala-tools.testing" %% "specs" % "1.6.7" % "test->default"
    val scalacheck = "org.scala-tools.testing" %% "scalacheck" % "1.8" % "test->default"
}
