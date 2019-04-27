package Blackjack.src

import scala.collection.mutable.ArrayBuffer

class Hand {
  val hand: ArrayBuffer[Card] = ArrayBuffer.empty[Card]

  def add_card(card: Card): Unit ={
    hand += card
  }

  def value(): Int = {
    val aces: ArrayBuffer[Card] = ArrayBuffer.empty[Card]
    var total = 0
    for(i <- 0 until hand.size){
      if (hand(i).value()(1) == 1){
        
      }
    }
    total
  }
}
