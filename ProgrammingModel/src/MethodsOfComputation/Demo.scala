package MethodsOfComputation

/**
  * This demo shows the different methods of computation there are in Scala
  * Operations include + - * / %
  */
object Demo {
  def main(args: Array[String]) {
    var a = 10
    var b = 20
    var c = 25
    var d = 25

    println("a + b = " + (a + b) )
    println("a - b = " + (a - b) )
    println("a * b = " + (a * b) )
    println("b / a = " + (b / a) )
    println("b % a = " + (b % a) )
    println("c % a = " + (c % a) )

    //everything is an object
    println("a.+(b) = " + a.+(b))
    println("a.-(b) = " + a.-(b))
    println("a.*(b) = " + a.*(b))
    println("b./(a) = " + b./(a))
    println("b.%(a) = " + b.%(a))
    println("c.%(a) = " + c.% (a))
  }

}
