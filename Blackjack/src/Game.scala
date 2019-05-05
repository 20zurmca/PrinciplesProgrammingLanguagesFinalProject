package Blackjack.src

class Game (var num_deck: Int) {
  var game_deck = new Deck(num_deck)
  game_deck.shuffle_deck()
  var player = new Player(game_deck)
  var dealer = new Dealer(game_deck)

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

  def dealer_turn(): Unit = {
    while(dealer.hand_value() < 17){
      dealer.hit()
    }
  }

  def score_game(): Unit = {
    var dealer_wins = false
    if(player.hand_value() > 21){
      dealer_wins = true
    }else if (player.hand_value() > dealer.hand_value()){
      dealer_wins = true
    }
  }

}

//need method in here to check if player can hit again or if dealer can hit again. be sure to include split case in player