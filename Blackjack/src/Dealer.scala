package Blackjack.src

class Dealer (var deck: Deck) extends User {

  override def hit(): Unit = {
    user_hand.add_card(deck.draw_card())
  }

  override def stand(): Unit = {
    //Literally do nothing
  }

  override def print_hand(): Unit = {
    print("Dealer Hand: ")
    for (i <- 0 until user_hand.hand.size) {
      print(user_hand.hand(i).to_string() + " ")
    }
    println()
  }
}