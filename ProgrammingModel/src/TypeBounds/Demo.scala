package TypeBounds

/**
  * Defines upper and lower type bounds
  */
object Demo {

  /**
  S <: T means that S is a subtype of T. This is also called an upper type bound.
  Similarly, S >: T means that S is a supertype of T, a lower type bound.
  S <% T is a view bound, and expresses that S must come equipped with a view that maps its values into values of type T.
*/

  //We can enforce the comparability of a type by demanding that the type is a subtype
  //of Ordered. This is done by giving an upper bound to the type parameter of Set:

  trait Set[A <: Ordered[A]] {
    def incl(x: A): Set[A]
    def contains(x: A): Boolean
  }
}
