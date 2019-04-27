package Blackjack.src

trait User {
  val user_hand = new Hand
  var active_turn = false

  def stand(): Unit

  def hit(): Unit

  def print_hand(): Unit

  def start_turn(): Unit = {
    active_turn = true
  }

  def end_turn(): Unit = {
    active_turn = false
  }

}
