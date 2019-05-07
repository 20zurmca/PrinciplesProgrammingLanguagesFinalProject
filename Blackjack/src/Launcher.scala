package Blackjack.src

/*
Launcher Object
This creates an instance of the Blackjack object and runs it. The point of this was to
have a launcher that simply runs an object without doing anything else to launch the game.
 */
object Launcher {
  def main(args: Array[String]): Unit = {
    Blackjack.main(Array())
  }

}
