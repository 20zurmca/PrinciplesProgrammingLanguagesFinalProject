import Blackjack.src.Deck

object Bye extends App {
  //deck demo
  val deck1 = new Deck(1)
  deck1.print_deck()
  println(deck1.draw_card().to_string())
  deck1.shuffle_deck()
  deck1.print_deck()
}
