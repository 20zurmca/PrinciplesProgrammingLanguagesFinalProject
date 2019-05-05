package ControlStructures

/**
  * ifStatement demonstrates the basic if statement
  */
object ifStatement extends App {
  val foo = false

  if (foo) println(5) else println(9) //prints 9

  if (foo){
    println(5)
  } else
      println(9) //prints 0

  //if in println
  println(if(!foo) "a" else "b") //prints a

  //in arithmetic
  val num = 7 * 2 + (if(foo) 2 else 7)
  println("num is: " + num) //prints "num is: 21"

  //as a method body

  def abs(x: Int) = if (x >= 0) x else -x

  println("abs of -5 is " + abs(-5)) //prints "abs of -5 is 5"
}

/**
  * Demonstrates a While Loop
  */
object WhileLoop extends App{
  var times = 2
  while(times > 0)
    {
      println(times)
      times -= 1
    }
  //prints 2 1
}

/**
  * Demonstrates for loops
  */
object ForLoop extends App{
  println("For loop 0 to 5: ")
  for (i <- 0 to 5) print(i + " ") //prints 0 to 5, inclusive
  println()

  println("For loop 0 until 5: ")
  for (i <- 0 until 5) print(i + " ") //prints 0 to 5, not including 5
  println()

  println("For loop 0 to 10 by 2: ")
  for (i <- 0 to 10 by 2) print(i + " ") //0 to 10 by 2
  println()

  println("For loop with multiple counters: ")
  for (i <- 1 to 2; j <- 1 to 2) printf("i = %d, j = %d\n", i, j) //behaves same was as if they were nested

  /* output:
  i = 1, j = 1
  i = 1, j = 2
  i = 2, j = 1
  i = 2, j = 2
  */
  println()

  println("For loops with guards: ")
  for{
    i <- 1 to 10
    if i > 5
    if i % 2 == 0
  } print(i + " ") //prints 6 8 10
  println()

  println("For loops with yield statement: ")
  val a = Array("apple", "banana", "orange") //Array(apple, banana, orange)
  val newArray = for (e <- a) yield e.toUpperCase // Array(APPLE, BANANA, ORANGE)

  //a yield statement is used in For Comprehensions. newArray is now iterable
  for (s <- newArray) println(s) //prints APPLE BANANA ORANGE on separate lines
}

/**
  * Demonstrates do while loops
  */
object DoWhile extends App{
  val stop = 10
  var start = 0

  do{
    println(start)
    start += 1
  } while(start <= stop) //prints 0 to 10 on separate lines
}


