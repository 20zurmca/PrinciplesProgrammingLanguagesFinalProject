package Blackjack.src

class Player (var deck: Deck) extends User {
  val split_hand = new Hand(default_bet)
  var is_split = false

  override def hit(): Unit = {
    user_hand.add_card(deck.draw_card())
  }

  def hit_split(): Unit = {
    split_hand.add_card(deck.draw_card())
  }

  def split(): Unit = {
    val size = user_hand.hand.size

    //get first 2 cards
    val temp_card = user_hand.hand(0)
    val temp_card2 = user_hand.hand(1)

    split_hand.add_card(temp_card2) //add second card to split deck
    user_hand.remove_card(1) //remove second card
    is_split = true

  }

  override def stand(): Unit = {
    //Literally do nothing
  }

  def get_split_card(num: Int): Card = {
    return split_hand.hand(num)
  }

  def split_hand_size(): Int = {
    return split_hand.hand.size
  }

  def split_hand_value(): Int = {
    return split_hand.value()
  }

  override def print_hand(): Unit = {
    print("Player Hand: ")
    for (i <- 0 until user_hand.hand.size) {
      print(user_hand.hand(i).to_string() + " ")
    }
    println()
  }

  def print_split_hand(): Unit = {
    print("Player Split Hand: ")
    for (i <- 0 until split_hand.hand.size) {
      print(split_hand.hand(i).to_string() + " ")
    }
    println()
  }
}