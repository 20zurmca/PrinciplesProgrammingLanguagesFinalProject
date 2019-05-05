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

  /* Output
  true class java.lang.Boolean
  false class java.lang.Boolean
  2 class java.lang.Integer
  a class java.lang.Character
  23 class java.lang.Long
  23.23 class java.lang.Double
  Hello class java.lang.String
  () class scala.runtime.BoxedUnit
   */

}
