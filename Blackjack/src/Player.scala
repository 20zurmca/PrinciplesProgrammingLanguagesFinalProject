package Blackjack.src

class Player (var deck: Deck) extends User {
  val split_hand = new Hand
  var is_split = false

  override def hit(): Unit = {

    if (is_split) {
      split_hand.add_card(deck.draw_card())
    }

    user_hand.add_card(deck.draw_card())
  }

  def split(): Unit = {
    val size = user_hand.hand.size

    if (size == 2) {
      //get first 2 cards
      val temp_card = user_hand.hand(0)
      val temp_card2 = user_hand.hand(1)

      //check if they have the same number
      if (temp_card.value()._2 == temp_card2.value()._2) {
        split_hand.add_card(temp_card2) //add second card to split deck
        user_hand.remove_card(1) //remove second card
        is_split = true
      }
    }
  }

  override def stand(): Unit = {
    //Literally do nothing
  }

  override def print_hand(): Unit = {
    print("Player Hand: ")
    for (i <- 0 until user_hand.hand.size) {
      print(user_hand.hand(i).to_string() + " ")
    }
    println()
  }
}