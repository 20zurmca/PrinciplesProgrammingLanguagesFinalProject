package Blackjack.src

/*
Handles the dealer’s options, extends the user trait and inherits all of its methods and data.
Parameters:
	-deck: Deck the deck for the user to pull cards from
Return Type:
  Dealer returns a dealer object
 */
class Dealer (var deck: Deck) extends User {

  /*
  hit() method
  Overrides the inherited method, draws a card from its deck and adds it to its hand.
  Parameters: N/A
  Return Type: Unit
   */
  override def hit(): Unit = {
    user_hand.add_card(deck.draw_card())
  }

  /*
  stand() method
  Stands the dealers hand
  Parameters: N/A
  Return Type: Unit
   */
  override def stand(): Unit = {
    //Literally do nothing
  }

  /*
  print_hand() method
  Overrides the inherited method, prints the cards in the dealer’s hand.
  Parameters: N/A
  Return Type: Unit
 */
  override def print_hand(): Unit = {
    print("Dealer Hand: ")
    for (i <- 0 until user_hand.hand.size) {
      print(user_hand.hand(i).to_string() + " ")
    }
    println()
  }
}