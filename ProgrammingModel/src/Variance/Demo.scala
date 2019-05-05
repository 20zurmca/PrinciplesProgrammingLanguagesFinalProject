package Variance

/**
  * Defines the different types of variances in scala
  * Variance is the correlation of subtyping relationships of complex types and the subtyping relationships of their component types.
  * Scala supports variance annotations of type parameters of generic classes, to allow them to be covariant, contravariant, or invariant if no annotations are used.
  * The use of variance in the type system allows us to make intuitive connections between complex types, whereas the lack of variance can restrict the reuse of a class abstraction.
  *  In Java, however, variance annotations are given by clients when a class abstraction is used (use-site variance)
  */
object Demo {

  class Foo[+A] // A covariant class. (loose) Java equivalent is ? extends T
  class Bar[-A] // A contravariant class. (loose) Java equivalent is ? super T
  class Baz[A]  // An invariant class. Java equivalent is T

  /**
  function traits are covariant in the return type parameter R and contravariant
    in the argument parameters
    */

}
