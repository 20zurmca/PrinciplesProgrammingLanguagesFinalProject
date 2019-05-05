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

    println("a + b = " + (a + b) ) //30
    println("a - b = " + (a - b) ) //-10
    println("a * b = " + (a * b) ) //200
    println("b / a = " + (b / a) ) //2
    println("b % a = " + (b % a) ) //0
    println("c % a = " + (c % a) ) //5

    //everything is an object
    println("a.+(b) = " + a.+(b)) //30
    println("a.-(b) = " + a.-(b)) //-10
    println("a.*(b) = " + a.*(b)) //200
    println("b./(a) = " + b./(a)) //2
    println("b.%(a) = " + b.%(a)) //0
    println("c.%(a) = " + c.% (a)) //5
  }

}
