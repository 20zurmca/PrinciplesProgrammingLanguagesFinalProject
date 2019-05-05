package DefaultDataStructures

/**
  * Demonstrates how Arrays are mutable sequences
  */
object Arrays extends App {
  val a: Array[Int] = Array(1, 2, 3, 4)

  //changing a(0)
  a(0) = 5
  println(a(0)) //returns 5, a(0) is changed in memory
  println(" ")

  println("Storing an array of different types")
  val b: Array[Any] = Array("joe", 5, 23.32, false)
  b foreach println //iterating and printing the array

  //cannot extend the array's length like a list
  println(" ")
  val copy = a :+ 3 //can make copies with appending an element. There are several other copy methods
  copy foreach println //prints 5 2 3 4 3
  println(" ")
  a foreach println //prints 5 2 3 4
}
