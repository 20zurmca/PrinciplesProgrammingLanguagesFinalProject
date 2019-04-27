package Blackjack.src

class Deck (var num_decks: Int){
  //build the deck array
  var deck_index = 0
  var deck =  new Array[Card](52*num_decks)
  for(i <- 0 until num_decks){
    for (j <- 0 until 4){
      for (k <- 0 until 13){
        var suit = ""
        if( j == 0 ){ suit = "Spade"}
        else if( j == 1){ suit = "Heart"}
        else if( j == 2){ suit = "Club"}
        else if( j == 3){ suit = "Diamond"}
        deck((i*52)+(j*13)+k) = new Card(suit, (k+1))
      }
    }
  }


  def draw_card(): Card ={
    if(deck_index >= deck.size){
      //ran out of deck to use, shuffle the deck and reset the deck index
      shuffle_deck()
      deck_index = 0
    }
    val temp = deck(deck_index)
    deck_index = deck_index + 1
    println("Drawn card: " + temp.to_string())
    return temp
  }

  def shuffle_deck(): Unit ={
    deck = util.Random.shuffle(deck.toSeq).toArray
  }

  def print_deck(): Unit ={
    for(i <- 0 until deck.size){
      println(deck(i).to_string())
    }
  }
}
