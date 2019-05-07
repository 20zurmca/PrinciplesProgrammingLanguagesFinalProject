package Blackjack.src

/*
Handles all game related operations. Stores the deck for each game, the player, the dealer, turn information, and scoring information as well as the following methods.
Parameters:
	-num_deck: Int the number of decks to use in the game
Return Type:
	Game returns itself as an object
 */
class Game (var num_deck: Int) {
  var game_deck = new Deck(num_deck)
  game_deck.shuffle_deck()
  var player = new Player(game_deck)
  var dealer = new Dealer(game_deck)
  var player_result = false
  var dealer_result = false
  var tie_result = false

  /*
  new_game() method
Creates new player and dealer objects and provides them with a deck to use.
Parameters: N/A
Return Type: Unit
   */
  def new_game(): Unit = {
    player = new Player(game_deck)
    dealer = new Dealer(game_deck)
  }

  /*
  start_deal() method
Deals the player and the dealer their initial two cards.
Parameters: N/A
Return Type: Unit
   */
  def start_deal(): Unit = {
    player.hit()
    player.hit()
    dealer.hit()
    dealer.hit()
  }

  /*
  player_hit() method
Hits the player’s main hand once
Parameters: N/A
Return Type: Unit
   */
  def player_hit(): Unit = {
    player.hit()
  }

  /*
  player_hit_split() method
Hits the player’s split hand once
Parameters: N/A
Return Type: Unit
   */
  def player_hit_split(): Unit = {
    player.hit_split()
  }

  /*
  player_stand() method
Stands the player’s hand
Parameters: N/A
Return Type: Unit
   */
  def player_stand(): Unit = {
    player.stand()

  }

  /*
  player_split() method
Splits the player’s hand
Parameters: N/A
Return Type: Unit
   */
  def player_split(): Unit = {
    player.split()
  }

  /*
  get_player_hand() method
Gets the players main hand
Parameters: N/A
Return Type:
	-Hand the players main hand
   */
  def get_player_hand(): Hand = {
    return player.user_hand
  }

  /*
  get_player_split_hand() method
Gets the players split hand
Parameters: N/A
Return Type:
	-Hand the players split hand
   */
  def get_player_split_hand(): Hand = {
    return player.split_hand
  }

  /*
  get_dealer_hand() method
Gets the dealer’s hand
Parameters: N/A
Return Type:
	-Hand the players main hand
   */
  def get_dealer_hand(): Hand = {
    return dealer.user_hand
  }

  /*
  dealer_hit() method
Hits the dealer’s hand
Parameters: N/A
Return Type: Unit
   */
  def dealer_hit(): Unit = {
    dealer.hit()
  }

  /*
  dealer_stand() method
Stands the dealer’s hand
Parameters: N/A
Return Type: Unit
   */
  def dealer_stand(): Unit = {
    dealer.stand()
  }

  /*
  initial_draw() method
Checks for blackjacks in the initial hands of the dealer and player
Parameters: N/A
Return Type:
	-Boolean, true if player and  dealer have blackjack, false otherwise.
   */
  def initial_draw(): Boolean = {
    if (player.hand_value() == 21 && dealer.hand_value() == 21) {
      return true
    }
    return false
  }

  /*
  player_bust() method
Checks if the player has busted, returns true if they have, false otherwise
Parameters: N/A
Return Type:
	-Boolean
   */
  def player_bust(): Boolean = {
    if (player.hand_value() > 21) {
      return true
    }

    return false
  }

  /*
  player_split_bust() method
Checks if the player has busted on their split hand, returns true if they have, false otherwise
Parameters: N/A
Return Type:
	-Boolean
   */
  def player_split_bust(): Boolean = {
    if (player.is_split) {
      if (player.split_hand_value() > 21) {
        return true
      }
      return false
    }
    return false
  }

  /*
  player_blackjack() method
Checks if the player has a blackjack in either their split or main hand. Returns true if they do and false otherwise.
Parameters: N/A
Return Type:
	Boolean
   */
  def player_blackjack(): Boolean = {
    if (player.hand_value() == 21) {
      return true
    } else if (player.is_split) {
      if (player.split_hand_value() == 21) {
        return true
      }
    }
    return false
  }

  /*
  dealer_bust() method
Checks if the dealer has bust or not, returns true if they have and false otherwise.
Parameters: N/A
Return Type: Boolean
   */
  def dealer_bust(): Boolean = {
    if (dealer.hand_value() > 21) {
      return true
    } else {
      return false
    }
  }

  /*
  dealer_blackjack() method
Checks if the dealer has a blackjack or not. returns true if they have and false if they dont.
Parameters: N/A
Return Type: Boolean
   */
  def dealer_blackjack(): Boolean = {
    if (dealer.hand_value() == 21) {
      return true
    } else {
      return false
    }
  }

  /*
  determine_winner() method
Determines if the player or dealer has won.
Parameters: N/A
Return Type: Unit
   */
  def determine_winner(): Unit = {
    var player_hand_1 = player.hand_value()
    var player_hand_2 = player.split_hand_value()
    var dealer_hand = dealer.hand_value()
    var optimal_player = 0

    if (player_hand_1 > 21) player_hand_1 = 0
    if (player_hand_2 > 21) player_hand_2 = 0
    if (dealer_hand > 21) dealer_hand = 0

    if (player.is_split) {
      if (player_hand_1 > player_hand_2) {
        optimal_player = player_hand_1
      } else if (player_hand_2 > player_hand_1) {
        optimal_player = player_hand_2
      } else {
        optimal_player = player_hand_1
      }
    } else {
      optimal_player = player_hand_1
    }

    if (optimal_player > dealer_hand) {
      player_result = true
    } else if (dealer_hand > optimal_player) {
      dealer_result = true
    } else if (dealer_hand == optimal_player) {
      tie_result = true
    }

  }

}

