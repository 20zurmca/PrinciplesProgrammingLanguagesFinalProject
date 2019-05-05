package ExceptionHandling
import java.util.Calendar

/**
  * This object demonstrates basic exception handling
  */
object Demo extends App {
  val before = null
  val now = Calendar.getInstance()

  try{
    now.compareTo(before)
  } catch {
    case e: NullPointerException => println("One was null!"); System.exit(-1)
    case unknown: Throwable => println("Unknown exception " + unknown); System.exit(-1)
  }finally {
    println("It all worked out.")
    System.exit(0)
  }
}
