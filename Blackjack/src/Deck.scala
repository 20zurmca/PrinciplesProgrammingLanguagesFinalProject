package Blackjack.src

class Deck (val num_decks: Int) {
  //build the deck array
  private[this] var deck_index = 0
  private deck = new Array[Card](52 * num_decks)

  def init_deck(): Unit = {
    for (i <- 0 until num_decks) {
      for (j <- 0 until 4) {
        for (k <- 0 until 13) {
          var suit = ""
          j match{
            case 0 => suit = "Spade"
            case 1 => suit = "Heart"
            case 2 => suit = "Club"
            case 3 => suit = "Diamond"
          }
          deck((i * 52) + (j * 13) + k) = new Card(suit, (k + 1))
        }
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
