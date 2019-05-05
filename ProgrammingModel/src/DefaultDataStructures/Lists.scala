package DefaultDataStructures

/**
  * Demonstrates functionality of immutable lists
  */
object Lists extends App {
  //Arrays are mutable, lists are immutable and are implemented like a linked list

  val myList: List[Int] = List(1, 2, 5, 8, 9, 6, 4)
  val names: List[String] = List("Max", "Tom", "Jon")

  //indexing
  println("myList at index 1: " + myList(1)) //prints "myList at index1: 2"
  //Error: myList(0) = 8; lists are immutable

  //printing out lists
  println("Printing myList : " + myList)
  println("Printing names : " + names)

  //cons
  println("Appending 0 to myList: " + 0 :: myList) ///adds 0 to the front on the list. myList not changed in memory
  println("Printing myList again: " + myList) //notice a copy of the list was made in the prior call!

  //Nil is the empty list
  println("Printing empty list with Nil: " + Nil) //prints List()
  println("constructing a list in method call: " + (1 :: 5 :: 9 :: Nil)) //constructing List(1, 5, 9) here
  println("constructing a list in method call: " + (Nil :+ 1 :+ 5 :+ 9)) //another way to construct List(1, 5, 9)

  //head and tail
  println("Printing head of myList: " + myList.head) //head is the first element in the list, prints 1
  println("Printing tail of myList: " + names.tail) //tail is a list of everything but the first element
                                                    //prints List(Tom, Jon)

  //boolean checks
  println("Printing names.isEmpty: " + names.isEmpty) //false

  //reversing
  println("Printing myList.reverse: " + myList.reverse) //prints List(4, 6, 9, 8, 5, 2, 1)

  //filling with defaults
  println("Using List.fill: " + List.fill(5)(2)); //prints List(2, 2, 2, 2, 2)

  //sum a list using the _ wildcard
  var sum : Int = 0
  myList.foreach(sum += _ )
  println("sum is: " + sum) //sum is: 35

}
