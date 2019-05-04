package Yielding

/**
  * Demonstrates the yield keyword
  * Though there’s a yield in other languages such as Python and Ruby
  * Scala’s yield does something very different from them. In Scala, yield is part of for comprehensions – a generalization of Ruby and Python’s list-comprehensions.
  * Scala’s “for comprehensions” are equivalent to Haskell’s “do” notation, and it is nothing more than a syntactic sugar for composition of multiple monadic operations.
  * So, for loops can act as expressions
  */
object Demo extends App {

  for(i <- 1 to 10) println(i) //this does something

  val b = for(i <-1 to 10) yield i //this returns a Vector

  println(b)

}
