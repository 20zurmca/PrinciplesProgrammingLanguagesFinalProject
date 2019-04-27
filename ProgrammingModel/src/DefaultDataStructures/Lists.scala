package DefaultDataStructures

/**
  * Demonstrates functionality of immutable lists
  */
object Lists extends App {
  //Arrays are mutable, lists are immutable and are implemented like a linked list
  //Any

  val myList: List[Int] = List(1, 2, 5, 8, 9, 6, 4)
  val names: List[String] = List("Max", "Tom", "Jon")

  //indexing
  println("myList at index 1: " + myList(1))
  //Error: myList(0) = 8; lists are immutable

  //printing out lists
  println("Printing myList : " + myList)
  println("Printing names : " + names)

  //cons
  println("Appending 0 to myList: " + 0 :: myList)
  println("Printing myList again: " + myList) //notice a copy of the list was made in the prior call!

  //Nil is the empty list
  println("Printing empty list with Nil: " + Nil)
  println("constructing a list in method call: " + 1 :: 5 :: 9 :: Nil) //constructing a list

  //head and tail
  println("Printing head of myList: " + myList.head) //head is the first element in the list
  println("Printing tail of myList: " + names.tail) //tail is a list of everything but the first element

  //boolean checks
  println("Printing names.isEmpty: " + names.isEmpty)

  //reversing
  println("Printing myList.reverse: " + myList.reverse)

  //filling with defaults
  println("Using List.fill: " + List.fill(5)(2)); //filling list with 5 elements of #2

  //sum a list using the _ wildcard
  var sum : Int = 0
  myList.foreach(sum += _ )
  println("sum is: " + sum)

}
