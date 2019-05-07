package Blackjack.src

//ace is rank 1, anything rank 10 or over just counts for 10

/*
This class is responsible for simulating the cards in the game and carries
information about their suit and value.
Parameters:
  -suit : var String. The cards suit
  -rank : var, Int. The cards rank
Return Type:
	Card
 */
class Card (var suit: String, var rank: Int){
  /*
  Returns the suit and rank of the card as a tuple.
  Parameters: N/A
  Return Type:
  Tuple (String, Int)
 */
  def value(): (String, Int) = {
    (suit, rank)
  }


  /*
  Converts the cards suit and rank to a printable name and then returns it (Club 11 -> [Club Jack])
  Parameters: N/A
  Return Type:
	  String
   */
  def to_string(): (String) = {
    var name = ""

    if (rank == 1) {
      name = "Ace"
    } else if (rank == 11) {
      name = "Jack"
    } else if (rank == 12) {
      name = "Queen"
    } else if (rank == 13) {
      name = "King"
    }

    if (name == "") {
      "[" + suit + " " + rank + "]"
    } else {
      "[" + suit + " " + name + "]"
    }

  }
}
