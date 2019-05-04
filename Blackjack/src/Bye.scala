package Blackjack.src

object Bye extends App {
  //deck demo
  val deck1 = new Deck(2)
  deck1.print_deck()
  println()
  println(deck1.draw_card().to_string())
  println()
  deck1.shuffle_deck()
  deck1.print_deck()

  println("\n ***PLAYER AND DEALER DEMO***\n")

  //Player and dealer demo
  val player1 = new Player(deck1)
  player1.hit()
  player1.print_hand()

  val dealer = new Dealer(deck1)
  dealer.hit()
  dealer.print_hand()*/

//}
