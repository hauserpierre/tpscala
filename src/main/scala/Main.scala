import scala.Console
import scala.io.Source
import java.util.Date

object Main {
  def main(args: Array[String]) : Unit = {
    Console.print("wesh weeeeeesh")
    val file = new Fichier
    for (line <- Source.fromFile("fichierTest.txt").getLines){
      var stuff:Array[java.lang.String] = line.split(" ").map(_.trim)
      var con:Connexion = new Connexion
      val date:Long = (stuff(0).toLong)*1000
      con.time = new Date(date)
      con.host1 = stuff(1)
      con.host2 = stuff(2)
      println(con.time)
      file.list+=con
    }

  }
}
