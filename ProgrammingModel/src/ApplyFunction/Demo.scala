package ApplyFunction

/**
  * Demonstrates use of the apply method is Scala
  */
object Demo extends App{
  val a = Array(1, 2, 3)

  println(a(0)) //apply method is called here

  println(a.apply(0))

  //you can therefore override this special method in custom data structures
  //to get similar behavior for indexing

}
