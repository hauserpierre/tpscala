import java.util.Calendar

class Connexion {
  var time:java.util.Date = Calendar.getInstance().getTime
  var host1:String = ""
  var host2:String = ""

  def toListOfString(): List[String] ={
    return List(host1, host2)
  }
}
