package IntroducingScala

/**
  * Filtering demonstrates various ways to filter lists
  */
object Filtering {
  def main(args: Array[String]): Unit = {
    val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund", "Scottish Terrier")
    for(breed <- dogBreeds)
        println(breed) //prints the dogBreed lists

    for(breed <- dogBreeds
        if breed.contains("Terrier")
        if !breed.startsWith("Yorkshire")
    ) println(breed) //prints Scottish Terrier
  }
}
