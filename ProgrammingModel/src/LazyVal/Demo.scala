package LazyVal

/**
  * Demonstrates the use of lazy val in scala
  * Lazy evaluation is an evaluation of an expression that is delayed until needed
  * Haskell also has Lazy evaluation
  * Strict evaluation is the default in scala
  */
object Demo extends App {

  class strict {
    val e: Int = {
      println("strict")
      9
    }
  }

  class LazyEval {
    lazy val l: Int = {
      println("lazy")
      9
    }
  }

  val x = new strict //only strict is printed
  val y = new LazyEval

  println(x.e)
  println(y.l)
}

/**
  * Demo 2 is another demonstration for lazy eval
  */
object Demo2 extends App{
  def method1(n: Int): Unit ={
    println("Method 1")
    println(n)
  }

  def method2(n: => Int): Unit ={ //this method is a call by name parameter method
    println("method 2")
    println(n) //until n is accessed for the first time, n is not evaluated
  }

  val add = (a: Int, b: Int) => {
    println("Add")
    a + b
  }

  method1(add(5, 6)) //prints Add Method 1 11
  method2(add(5, 6)) //prints method 2 Add 11
}
