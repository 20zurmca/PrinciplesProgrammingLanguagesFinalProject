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
        //using a guard in next case here
      case (thingOne:String, thingTwo, thingThree) => if("Good" == thingOne)
        println("A three-tuple starting with 'Good'. ")
      case (thingOne, thingTwo) => println("This has two things: " + thingOne + " and "
        + thingTwo)
    }
  }
}

/**
  * ClassMatch exhibits deep matching, examining the contents of objects in a pattern match
  */
object ClassMatch extends App{
  //making a case class
  case class Person(name: String, age: Int)

  val alice = Person("Alice", 25)
  val bob =  Person("Bob", 32)
  val charlie = Person("Charlie", 32)

  for(person <- List(alice, bob, charlie)){
    person match{
      case Person("Alice", 25) => println("Hi, Alice!")
      case Person("Bob", 32) => println("Hi, Bob!")
      case Person(name, age) =>
        println("Who are you, " + age + " year-old person named " + name + "?")
    }
  }
}

/**
  * ClassMatchNested exhibits Binding Nested Variables in Case Clauses
  * Sometimes you want to bind a variable to an object enclosed in a match
  */
object ClassMatchNested extends App{
  class Role
  case object Manager extends Role
  case object Developer extends Role

  case class Person(name: String, age: Int, role: Role)

  val alice = Person("Alice", 25, Developer)
  val bob = Person("Bob", 32, Manager)
  val charlie = Person("Charlie", 32, Developer)

  for(item <- Map(1 -> alice, 2 -> bob, 3 -> charlie)){
    item match{
      case (id, p @ Person(_, _, Manager)) => println("%s is overpaid.\n".format(p))
      case (id, p @ Person(_, _, _)) => println("%s is underpaid.\n".format(p))
    }
  }

  //alternative matching on the role
  for(item <- Map(1 -> alice, 2 -> bob, 3 -> charlie)){
    item match{
      case (id, p:Person) => p.role match{
        case Manager => println("%s is overpaid.\n".format(p))
        case _ => println("%s is underpaid.\n".format(p))
    }
  }
 }
}

/**
  * REMatch exhibits regular expression pattern matching
  */
object REMatch extends App{
  val BookExtractorRE =  """Book: title=([^,]+),\s+authors=(.+)""".r
  val MagazineExtractorRE = """Magazine: title=([^,]+),\s+issue=(.+)""".r

  """
    Notice that each of our regexes defines two capture groups, connoted by parentheses.
    Each group captures the value of a single field in the record, such as a book’s title or
    author. Regexes in Scala translate those capture groups to extractors. Every match sets
    a field to the captured result; every miss is set to null.
    Notice that each of our regexes defines two capture groups, connoted by parentheses.
    Each group captures the value of a single field in the record, such as a book’s title or
    author. Regexes in Scala translate those capture groups to extractors. Every match sets
    a field to the captured result; every miss is set to null.
  """

  val catalog = List(
    "Book: title=Programming Scala, authors=Dean Wampler, Alex Payne",
    "Magazine: title=The New Yorker, issue=January 2009",
    "Book: title=War and Peace, authors=Leo Tolstoy",
    "Magazine: title=The Atlantic, issue=February 2009",
    "BadData: text=Who put this here??"
  )

  for (item <- catalog){
    item match{
      case BookExtractorRE(title, authors) =>
        println("Book \"" + title + "\", written by " + authors)
      case MagazineExtractorRE(title, issue) =>
        println("Magazine \"" + title + "\", issue " + issue)
      case entry => println("Unrecognized entry: " + entry)
    }
  }
}