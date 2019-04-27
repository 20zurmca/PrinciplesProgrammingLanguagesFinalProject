package PatternMatching
import scala.util.Random

/**
  * This File shows the various ways to pattern match in scala
  * pattern matching is like switch statements in Java
  * pattern matching is eager-->first case wins
  */
object PatternMatching1 extends App {

  //a simple match
  val bools = List(true, false)

  for(bool <- bools){
    bool match {
      case true => println("head")
      case false => println("tails")
      case _ => println("something other than head or tails (yikes!)")
    }
  }
}

/**
  * PatternMatching 2 exhibits matching with variables
  */
object PatternMatching2 extends App{
  val randomInt = new Random().nextInt(10)

  randomInt match{
    case 7 => println("lucky seven!")
    case otherNumber => println("boo, got boring" + otherNumber)
  }
}

/**
  * PatternMatching 3 exhibits matching on type
  */
object PatternMatching3 extends App{
  val sundries: List[Any] = List(23, "Hello", 8.5, 'q')
  for(sundry<-sundries){
    sundry match{
      case i: Int => println("got an Integer: " + i)
      case s: String => println("got a String: " + s)
      case f: Double => println("got a Double: " + f)
      case other => println("got something else: " + other) }
    }
  }

/**
  * PatternMatching 4 exhibits matching on Sequences
  */
object PatternMatching4 extends App{
  val willWork = List(1, 3, 23, 90)
  val willNotWork = List(4, 18, 52)
  val empty = List()
  for(l <- List(willWork, willNotWork, empty)){
    l match{
      case List(_, 3, _, _) => println("Four elements, with the 2nd being 3")
      case List(_*) => println("Any other list with 0 or more elements")
    }
  }
}

/**
  * ProcessList exhibits using case statements to process a list
  */
object ProcessList extends App{
  val willWork = List(1, 3, 23, 90)
  val willNotWork = List(4, 18, 52)
  val empty = List()

  def processList(l:List[Any]): Unit =
    l match{
      case head :: tail =>
        print("%s ".format(head))
        processList(tail)
      case Nil => println("Empty list")
    }

  for (l <- List(willWork, willNotWork, empty)){
    print("List: ")
    processList(l)
  }
}

/**
  * TupleMatch exhibits matching on Tuples and using Guards for extra logic
  */
object TupleMatch extends App {
  val tupA = ("Good", "Morning!", "Class")
  val tupB = ("Guten", "Tag!")

  for (tup <- List(tupA, tupB)) {
    tup match {
      case (thingOne, thingTwo, thingThree) if thingOne == "Good" =>
        println("A three-tuple starting with 'Good'. ")
      case (thingOne, thingTwo) => println("This has two things: " + thingOne + " and "
        + thingTwo)
    }
  }
}

object ClassMatch extends App{

}