package FunctionalProgramming

/**
  * Demo shows different concepts of functional programming we learned
  */
object Demo extends App {

  //higher order functions

  def math(x: Double, y:Double, z:Double, f: (Double, Double) => Double): Double = f(f(x,  y), z) //combiner function

  val result = math(50, 20, 30, (x, y) => x+ y )
  val result2 = math(50, 20, 10, _+_) //takes the first two parameters to throw into f

  println(result) //100
  println(result2)//80
  println(math(50, 20, 30, (x, y) => x min y)) //20

  def sum2: (Int, Int) => Int = (x:Int, y:Int) => x+y //returning a lambda

  println(sum2(10, 11)) //21


  //partially applied functions:

  val sum = (a: Int, b: Int, c: Int) => a + b + c //sum is a fully applied function
  println(sum(10, 20, 30)) //60


  //partially applied is when you use a default value or a wildcard in your function call

  val f = sum(10, 20, _ : Int) //this function expects you to give the third argument and will use the first two

  val z = sum (10, _: Int, _: Int)
  println(f(30)) //60
  println(z(100, 200)) //310

  //closures in scala

  //A closure is a function which uses one or more variables declared outside the function

  var number = 10
  val add = (x : Int) => x + number //number is a free variable that is not bound to the function

  println(add(20)) //30

  number = 100

  println(add(20)) //number is updated. The closure can also update the variable's value

  //Impure closure is when the closure variable is of var type
  //Pure closure is when the closure variables is of val type
}
