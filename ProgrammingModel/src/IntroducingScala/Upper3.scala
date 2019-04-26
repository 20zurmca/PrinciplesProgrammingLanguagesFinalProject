package IntroducingScala

/**
  * Upper 3 exhibits method chaining like java streams, as well as using CLI args
  */
object Upper3 {
  def main(args: Array[String]): Unit = {
    args.map(_.toUpperCase()).foreach(printf("%s ", _)) //%s matches the string
    println("")
  }
}
