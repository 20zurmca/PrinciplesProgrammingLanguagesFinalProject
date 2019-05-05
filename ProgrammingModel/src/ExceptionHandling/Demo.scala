package ExceptionHandling

/**
  * This object demonstrates basic exception handling
  */
object Demo extends App {

  try{
    val a = 5/0
  } catch {
    case e: NullPointerException => println("One was null!"); System.exit(-1)
    case unknown: Throwable => println("Unknown exception " + unknown); System.exit(-1)
  }finally {
    println("It all worked out.")
    System.exit(0)
  }
}
