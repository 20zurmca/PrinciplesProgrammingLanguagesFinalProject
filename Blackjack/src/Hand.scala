package Blackjack.src

import scala.collection.mutable.ArrayBuffer

class Hand {
  val hand: ArrayBuffer[Card] = ArrayBuffer.empty[Card]

  def add_card(card: Card): Unit ={
    hand += card
  }

  def remove_card(index: Int): Unit = {
    hand.remove(index)
  }

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
}
