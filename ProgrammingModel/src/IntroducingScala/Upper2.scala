package IntroducingScala

/**
  * Upper2 is like Upper1, but uses the _ wildcard matcher to process strings
  * Notice I use just object Upper2, which is the singleton version of class
  */
object Upper2 extends App {
  def upper(strings: String*) = strings.map(_.toUpperCase())
  println(this.upper("A", "First", "Scala", "Program")) //this refers to the object

}
