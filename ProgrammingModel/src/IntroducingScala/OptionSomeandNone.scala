package IntroducingScala

/**
  * Introduces types Option, Some, and None
  */
object OptionSomeandNone extends App{
  /*
    Scala wants users to avoid using null whenever possible.
    Philosophy: no need to return a keyword when a value is expected

    Null is a trait
    null is an instance of Null-similar to java null
    Nil represents an empty List of anything of zero length. No content list
    Nothing is a trait, a subtype of everything. Not a superclass of anything.
      No instances of Nothing
    None-Used to represent a sensible return value. Subclass of Option.
    Unit-void return value
   */

  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")


  println("show(capitals.get( \"Japan\")) : " + capitals.get( "Japan")) //returns Option[String]
  println("show(capitals.get( \"India\")) : " + capitals.get( "India")) //returns Option[String]

}
