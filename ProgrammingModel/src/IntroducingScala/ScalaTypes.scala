package IntroducingScala

/**
  * A program that illustrates the various types in scala
  * Note that if a method has no arguments, () are optional
  * Same types as java.lang
  * need to specify byte, short, long, float
  * String class resides in the package java.lang
  * Extends App
  */
object ScalaTypes extends App {

  //() is unit

  val container : List[Any] = List(true, false, 2, 'a', 23L, 23.23, "Hello", ())

  for(v <- container){
    println(v + " " + v.getClass)
  }

}
