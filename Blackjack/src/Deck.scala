package Blackjack.src

/*
This class is responsible for simulating the deck required for the game. It can simulate 1
or any number of decks combined into one for the game as most blackjack games use
anywhere from six to eight decks. Cards are stored in an array.
Parameters:
-num_decks : var, int
	The number of decks to simulate at once.
Return Type:
	The main method of the Deck class returns a new deck object.
 */
class Deck (var num_decks: Int){
  //build the deck array
  var deck_index = 0
  var deck =  new Array[Card](52*num_decks)
  //loop through all the cards
  for(i <- 0 until num_decks){
    for (j <- 0 until 4){
      for (k <- 0 until 13){
        var suit = ""
        if( j == 0 ){ suit = "Spade"}
        else if( j == 1){ suit = "Heart"}
        else if( j == 2){ suit = "Club"}
        else if( j == 3){ suit = "Diamond"}
        //add cards to the deck array
        deck((i*52)+(j*13)+k) = new Card(suit, (k+1))
      }
    }
  }


  /*
  Returns the first card off the deck and moves a pointer one step further into the deck.
  If the pointer runs out of deck, the deck is shuffled and the pointer reset.
  Parameters: N/A
  Return Type:
	  Returns Card

   */
  def draw_card(): Card ={
    if(deck_index >= deck.size){
      //ran out of deck to use, shuffle the deck and reset the deck index
      shuffle_deck()
      deck_index = 0
    }
    val temp = deck(deck_index)
    deck_index = deck_index + 1
    return temp
  }

  /*
  Shuffles the deck to a new order using a built in Scala method.
  Parameters: N/A
  Return Type: Unit
   */
  def shuffle_deck(): Unit ={
    deck = util.Random.shuffle(deck.toSeq).toArray
  }

  /*
  Prints all of the cards in the deck in their current order.
  Parameters: N/A
  Return Type: Unit
   */
  def print_deck(): Unit ={
    for(i <- 0 until deck.size){
      println(deck(i).to_string())
    }
  }
}
