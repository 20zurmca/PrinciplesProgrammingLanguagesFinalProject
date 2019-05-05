package Blackjack.src

class Game (var num_deck: Int) {
  var game_deck = new Deck(num_deck)
  game_deck.shuffle_deck()
  var player = new Player(game_deck)
  var dealer = new Dealer(game_deck)
  var player_result = false
  var dealer_result = false
  var tie_result = false

  def new_game(): Unit = {
    player = new Player(game_deck)
    dealer = new Dealer(game_deck)
  }

  def start_deal(): Unit = {
    player.hit()
    player.hit()
    dealer.hit()
    dealer.hit()
  }

  def player_hit(): Unit = {
    player.hit()
  }

  def player_hit_split(): Unit = {
    player.hit_split()
  }

  def player_stand(): Unit = {
    player.stand()
  }

  def player_split(): Unit = {
    player.split()
  }

  def get_player_hand(): Hand = {
    return player.user_hand
  }

  def get_player_split_hand(): Hand = {
    return player.split_hand
  }

  def get_dealer_hand(): Hand = {
    return dealer.user_hand
  }

  def dealer_hit(): Unit = {
    dealer.hit()
  }

  def dealer_stand(): Unit = {
    dealer.stand()
  }

  def initial_draw(): Boolean = {
    if (player.hand_value() == 21 && dealer.hand_value() == 21) {
      return true
    }
    return false
  }

  def player_bust(): Boolean = {
    if (player.hand_value() > 21) {
      return true
    }

    return false
  }

  def player_split_bust(): Boolean = {
    if (player.is_split) {
      if (player.split_hand_value() > 21) {
        return true
      }
      return false
    }
    return false
  }

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

  def dealer_bust(): Boolean = {
    if (dealer.hand_value() > 21) {
      return true
    } else {
      return false
    }
  }

  def dealer_blackjack(): Boolean = {
    if (dealer.hand_value() == 21) {
      return true
    } else {
      return false
    }
  }

  def determine_winner(): Unit = {
    var player_hand_1 = player.hand_value()
    var player_hand_2 = 0
    var dealer_hand = dealer.hand_value()
    var optimal_player = 0

    if (player.is_split) {
      player_hand_2 = player.split_hand_value()
      if (player_hand_1 < 22 && player_hand_1 > player_hand_2) {
        optimal_player = player_hand_1
      } else if (player_hand_2 < 22 && player_hand_2 > player_hand_1) {
        println("test test")
        optimal_player = player_hand_2
      } else {
        optimal_player = player_hand_1
      }
    } else {
      optimal_player = player_hand_1
    }

    if (optimal_player < 22 && optimal_player > dealer_hand) {
      player_result = true
    } else if (dealer_hand < 22 && dealer_hand > optimal_player) {
      dealer_result = true
    } else if (dealer_hand == optimal_player) {
      tie_result = true
    }

  }

}

