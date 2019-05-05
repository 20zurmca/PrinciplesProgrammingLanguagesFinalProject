package IntroducingScala

/**
  * Demonstrates the usage of parameterized types (generics)
  */
abstract class BulkReader {
  type In //type will be defined in child classes
  val source: In
  def read: String
}

class StringBulkReader(val source: String) extends BulkReader{
  type In = String
  def read : String = source
}

//could have used generics this way as well
abstract class Reader[In]{
  val source: In
  def read: String
}

class StringReader(val source: String) extends Reader[String]{
  def read: String = source
}