package Blackjack.src

import scala.collection.mutable.ArrayBuffer

/*
Data class responsible for keeping track of the cards in a hand. It also
has the basic framework for betting information but that is currently not being used.
Parameters:
  -bet : var, Int the bet placed on the hand
Return Type:
	Hand
 */
class Hand(var bet: Int) {
  val hand: ArrayBuffer[Card] = ArrayBuffer.empty[Card]
  var player_bet = bet

  /*
  Adds a given card to the hand
  Parameters:
    -card : Card The card to add to the hand.
  Return Type: Unit
   */
  def add_card(card: Card): Unit ={
    hand += card
  }

  /*
  remove_card() method
  removes a given card from the hand
  Parameters:
    -index : Int The index of the card to remove from the hand.
  Return Type: Unit
   */
  def remove_card(index: Int): Unit = {
    hand.remove(index)
  }

  /*
  value() method
  Calculates the value of the hand (sum of card values)
  Parameters: N/A
  Return Type:
	  Int, the total of the card values
   */
  def value(): Int = {
    var aces_count = 0
    var total = 0
    for(i <- 0 until hand.size){
      if (hand(i).value()._2 == 1){
        aces_count += 1
      }else if (hand(i).value()._2 >= 10){
        total += 10
      }else{
        total += hand(i).value()._2
      }
    }

    for( i <- 0 until aces_count){
      if((total + 11) > 21){
        total += 1
      }else{
        total += 11
      }
    }
    total
  }

  /*
  get_bet() method
  Gets the bet value for the hand (not used)
  Parameters: N/A
  Return Type: Int
   */
  def get_bet(): Int ={
    bet
  }

  /*
  set_bet() method
  Sets the bet value for the hand (not used)
  Parameters:
    -temp_bet : Int The value of the bet to assign to the hand.
  Return Type: Unit
   */
  def set_bet(temp_bet: Int){
    player_bet = temp_bet
  }
}
