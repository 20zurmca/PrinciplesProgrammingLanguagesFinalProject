package Blackjack.src

/*
Handles all of the player’s actions and player specific data
(the main player specific data is the split hand possibility).
This class also extends the User trait and inherits all of its
data and methods.
 */
class Player (var deck: Deck) extends User {
  val split_hand = new Hand(default_bet)
  var is_split = false

  /*
  hit() method
  Overrides its inherited method, draws a card from its deck and adds it to the user’s active hand.
  Parameters: N/A
  Return Type: Unit
   */
  override def hit(): Unit = {
    user_hand.add_card(deck.draw_card())
  }

  /*
  hit_split() method
  draws a card from its deck and adds it to the user’s active split hand.
  Parameters: N/A
  Return Type: Unit
   */
  def hit_split(): Unit = {
    split_hand.add_card(deck.draw_card())
  }

  /*
  split() method
  Splits the user’s current hand into two hands, can only be done if the user
  has exactly 2 cards and both cards match in rank.
  Parameters: N/A
  Return Type: Unit
   */
  def split(): Unit = {
    val size = user_hand.hand.size

    //get first 2 cards
    val temp_card = user_hand.hand(0)
    val temp_card2 = user_hand.hand(1)

    split_hand.add_card(temp_card2) //add second card to split deck
    user_hand.remove_card(1) //remove second card
    is_split = true

  }

  /*
  can_split() method
  Checks if the user’s hand can be split or not, returns true when the user’s
  hand has exactly 2 cards and both cards match in rank.
  Parameters: N/A
  Return Type:
	  Boolean, true if split eligible, false if not.
   */
  def can_split(): Boolean = {
    //get first 2 cards
    val temp_card = user_hand.hand(0)
    val temp_card2 = user_hand.hand(1)

    if (temp_card.rank == temp_card2.rank) {
      return true
    }
    return false
  }

  /*
  stand() method
  Overrides the inherited method. Ends the users current turn
  Parameters: N/A
  Return Type: Unit
   */
  override def stand(): Unit = {
    //Literally do nothing
  }

  /*
  get_split_card() method
  Gets the card from the user’s main hand in the case of a split
  Parameters:
 	  -num: Int, index of the card
  Return Type:
	  Card the card for the split hand
   */
  def get_split_card(num: Int): Card = {
    return split_hand.hand(num)
  }

  /*
  split_hand_size() method
  Gets the size of the player’s split hand (how many cards are in it)
  Parameters: N/A
  Return Type:
	  Int how many cards are in the split hand
   */
  def split_hand_size(): Int = {
    return split_hand.hand.size
  }

  /*
  split_hand_value() method
  Gets the value of the player’s split hand
  Parameters: N/A
  Return Type:
	  Int value of the cards in the split hand
   */
  def split_hand_value(): Int = {
    return split_hand.value()
  }

  /*
  print_hand() method
  Overrides the inherited method, prints all of the cards in the player’s main hand.
  Parameters: N/A
  Return Type: Unit
   */
  override def print_hand(): Unit = {
    print("Player Hand: ")
    for (i <- 0 until user_hand.hand.size) {
      print(user_hand.hand(i).to_string() + " ")
    }
    println()
  }

  /*
  print_split_hand() method
  Prints all of the cards in the player’s split hand.
  Parameters: N/A
  Return Type: Unit
   */
  def print_split_hand(): Unit = {
    print("Player Split Hand: ")
    for (i <- 0 until split_hand.hand.size) {
      print(split_hand.hand(i).to_string() + " ")
    }
    println()
  }
}