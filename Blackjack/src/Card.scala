package Blackjack.src

//ace is rank 1, anything rank 10 or over just counts for 10

class Card (var suit: String, var rank: Int){
  def value(): (String, Int) = {
    (suit, rank)
  }

  def to_string(): (String) = {
    "[" + suit + " " + rank + "]"
  }
}
