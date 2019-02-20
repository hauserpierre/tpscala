import scala.io.Source
import java.util.Date

object Main {
  def main(args: Array[String]) : Unit = {
    val file = new Fichier
    for (line <- Source.fromFile("fichierTest.txt").getLines){
      var stuff:Array[java.lang.String] = line.split(" ").map(_.trim)
      var con:Connexion = new Connexion
      val date:Long = (stuff(0).toLong)*1000
      con.time = new Date(date)
      con.host1 = stuff(1)
      con.host2 = stuff(2)
      file.list+=con
    }
    //Afficher les connexions dans l'heure
    var dateBefore = new Date(System.currentTimeMillis() - (1000*60*60))
    var thisHour = file.list.filter(Connexion => Connexion.time.getTime > dateBefore.getTime)
    println("Connexion dans l'heure")
    for(test <- thisHour) println(test.time, test.host1, test.host2)

    //Afficher le serveur ayant le plus de connexions


    //Afficher la connexion la plus récente
    var mostRecentCo:Connexion = new Connexion
    for(test <- file.list){
      if(test.time.getTime > mostRecentCo.time.getTime) mostRecentCo = test
    }
    println("Connexion la plus récente")
    println(mostRecentCo.time, mostRecentCo.host1, mostRecentCo.host2)
  }
}
