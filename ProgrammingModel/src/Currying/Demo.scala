package Currying

/**
  * Demonstrates currying
  * Currying is the technique of transforming a function
  * that takes multiple args into a function
  * that takes a single arg
  */
object Demo extends App {

  def add(x: Int): Int => Int = { //add is a function that returns a function
    y: Int => x + y
  }

  def add2 (x :Int)(y:Int) : Int = x+ y //add2 takes curried parameters

  val add40 : Int => Int = add(40) //add40 now has x as 40

  println(add(4)(5)) //9
  println(add40(100)) // 140

  val sum50 = add2(50)_ //_ is used to provide y a argument in add2, unlike add40

  println(sum50(40)) //90

}
