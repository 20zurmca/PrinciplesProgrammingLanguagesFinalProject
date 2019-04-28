package Blackjack.src

trait User {
  val default_bet = 1
  val user_hand = new Hand(default_bet)
  var active_turn = false

  def stand(): Unit

  def hit(): Unit

  def print_hand(): Unit

  def start_turn(): Unit = {
    active_turn = true
    //get the player bet
  }

  def end_turn(): Unit = {
    active_turn = false
  }

}
