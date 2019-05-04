package Blackjack.src

trait User {
  val default_bet = 1
  val user_hand = new Hand(default_bet)
  var active_turn = false

  def stand(): Unit

  def hit(): Unit

  def print_hand(): Unit

  def get_card(num: Int): Card = {
    return user_hand.hand(num)
  }

  def hand_size(): Int = {
    return user_hand.hand.size
  }

  def start_turn(): Unit = {
    active_turn = true
    //get the player bet
  }

  def end_turn(): Unit = {
    active_turn = false
  }

}
