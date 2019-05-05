package Currying

/**
  * Demonstrates currying
  * Currying is the technique of transforming a function
  * that takes multiple args into a function
  * that takes a single arg
  */
object Demo extends App {

  def add(x: Int): Int => Int = {
    (y: Int) => (x + y)
  }

  def add2 (x :Int)(y:Int) : Int = x+ y

  val add40 : Int => Int = add(40)

  println(add(4)(5)) //9
  println(add40(100)) // 140

  val sum50 = add2(50)_ //_ needed to provide y a argument

  println(sum50(40)) //90

}
