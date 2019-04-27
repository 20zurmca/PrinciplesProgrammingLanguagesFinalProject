package Blackjack.src

class Card (var suit: String, var rank: Int){
  def value(): (String, Int) = {
    (suit, rank)
  }

  def to_string(): (String) = {
    suit + " " + rank
  }
}
