package Traits

/**
  * Demo demonstrates trait functionality
  * You can inherit multiple traits in Scala
  * Traits are like java interfaces
  */
object Demo extends App{

  trait Shape{ //at least one method needs to be abstract in a trait
    def color: String
  }

  abstract class Polygon {
    def area: Double
  }

  class Rectangle(var width: Double, var height: Double) extends Polygon with Shape{
    override def area: Double = width * height
    override def color: String = "Blue" //override is optional with trait inheritance

    def information: String = "Area: " + area + " Color: " + color
  }

  val r = new Rectangle(5, 5)
  println(r.information)

}
