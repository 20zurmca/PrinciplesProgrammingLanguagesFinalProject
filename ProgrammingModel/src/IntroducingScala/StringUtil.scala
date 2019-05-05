package IntroducingScala

/**
  * StringUtil demonstrates default parameter values
  */
object StringUtil extends App {
  /**
    * joiner joints strings with a default separator
    */

  def joiner(strings: List[String], separator: String = " "): String =
    strings.mkString(separator)

  println(this.joiner(List("Programming", "Scala")))
  println(this.joiner(List("Programming", "Scala"), separator = "-"))

  /* Output
  Programming Scala
  Programming-Scala
   */
}
