package IntroducingScala

/**
  * Method Chaining demonstrates different ways to chain methods in Scala
  */
object MethodChaining extends App {

  def isEven(n:Int) =
     (n % 2) == 0
}

/**
  * Demonstrates various ways of accomplishing list filter with method chaining
  */
object Launcher{
  def main(args: Array[String]): Unit = {
    val m = MethodChaining
    val lst = List(1, 2, 3, 4)

    lst filter m.isEven foreach println

    lst.filter(m.isEven).foreach(println)

    lst.filter((x:Int) => x%2==0) foreach println //uses lambda

  }
}
