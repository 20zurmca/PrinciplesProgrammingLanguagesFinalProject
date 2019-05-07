package Blackjack.src

/*
A collection of basic methods and variables that will be used by both
the player and the dealer. (default_bet, user_hand, and active_turn,
which are the default bet for a users hand, the basic hand for that
user, and whether or not it is that user’s turn respectively).
 */
trait User {
  val default_bet = 1
  val user_hand = new Hand(default_bet)
  var active_turn = false

  def stand(): Unit

  def hit(): Unit

  def print_hand(): Unit

  /*
  get_card() method
  Gets a specified card from the user’s hand
  Parameters:
    - num : Int  the index of the card to get
  Return Type:
	  Card the card associated with the given index
   */
  def get_card(num: Int): Card = {
    return user_hand.hand(num)
  }

  /*
  hand_side() method
  Returns the size of the user’s primary hand
    Parameters: N/A
  Return Type:
	  Int size of the hand
   */
  def hand_size(): Int = {
    return user_hand.hand.size
  }

  /*
  start_turn() method
  Start that user’s active turn
  Parameters: N/A
  Return Type: Unit
   */
  def start_turn(): Unit = {
    active_turn = true
    //get the player bet
  }

  /*
  end_turn() method
  End that user’s active turn
  Parameters: N/A
  Return Type: Unit
   */
  def end_turn(): Unit = {
    active_turn = false
  }

  /*
  hand_value() method
  Returns the value of the user’s primary hand
  Parameters: N/A
  Return Type:
	  Int value of hand
   */
  def hand_value(): Int = {
    return user_hand.value()
  }

}
