package IntroducingScala

/**
  * CarefulWithTypeInference demonstrates some of the pitfalls with type inference
  * Return types need to be specified in the following errors
  * Uncomment code to see the errors
  */
/*
object CarefulWithTypeInference {

  def joiner(strings: List[String], separator: String): String =
    strings.mkString(separator)

  def joiner(strings: List[String]) = joiner(strings, " ") //warning


  def makeList(strings: String*)= { //need type because of different returns values
    if (strings.length == 0)
      List(0) //this is of type List[Int]
    else
      strings.toList //this is List[String] thus return type should be List[Any]
  }

  def factorial(i: Int) = {
    def fact(i: Int, accumulator: Int) = { //return type needed for recursive method
      if (i <= 1)
        accumulator
      else
        fact(i-1, i*accumulator)
    }
    fact(i, 1)
  }

}
*/

