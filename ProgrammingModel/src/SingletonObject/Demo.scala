package SingletonObject

/**
  * An Object is a class that has exactly one instance.
  * It is created lazily when it is reference, like lazy val
  * As a top-level value, an object is a singleton
  * As a member of an enclosing class or as a local value, it behaves exactly like a lazy val
  */
object Logger {
  def info(message: String): Unit = println(s"INFO: $message") //another way to format
}

class Project(name: String, daysToComplete: Int)

/**
  * Test demonstrates importing a method from a singleton
  */
class Test{
  import SingletonObject.Logger.info //importing the info method from singleton object

  val project1 = new Project("TPS Reports", 1)
  val project2 = new Project("Website redesign", 5)
  info("created projects") //prints info statement
}

import scala.math._

/**
  * A singleton circle object
  */
object Circle{
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

/**
  * Circle case class has the same name as Circle singleton
  * That means that the case class and the object are companions
  * A companion class or object can access private members of its companion
  * companion classes must be defined in the same file
  * @param radius the radius of the circle
  */
case class Circle(radius: Double){
  import Circle._ //importing companion object
  def area: Double = calculateArea(radius) //can use the private method
}

object Launch extends App{
  val circle1 = new Circle(5.0)
  println("%.2f".format(circle1.area)) // 78.54
}
