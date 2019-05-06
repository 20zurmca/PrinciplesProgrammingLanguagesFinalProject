package Blackjack.src

import javax.swing.UIManager.LookAndFeelInfo
import java.awt._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent
import java.awt.event.MouseWheelListener
import java.io.File

import javax.sound.sampled.{AudioSystem, Clip}
import javax.swing.border.Border
import javax.swing._
import javax.swing.JButton

import scala.collection.mutable.ArrayBuffer



object Blackjack {
  def main(args: Array[String]): Unit = {
    System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel")
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new GUI
        try
        {
          val clip = AudioSystem.getClip();
          clip.open(AudioSystem.getAudioInputStream(new File("../Blackjack/music/Memoir_of_Summer.wav")))
          clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch {
          case e => println(e)
        }
      }
    })
  }
}

class GUI() //Constructor
  extends JFrame {

  var new_game = new Game(1)
  var all_cards: ArrayBuffer[JLabel] = ArrayBuffer.empty[JLabel]
  var player_wins = 0
  var dealer_wins = 0
  val width_card = 130
  val split_width = 85

  var p_loc = 50
  var d_loc = 50
  var split_loc1 = 50
  var split_loc2 = 50
  var possible_split1: JLabel = null
  var possible_split2: JLabel = null
  var blank_dealer_card: JLabel = null
  var first_dealer_card: JLabel = null
  var top_stand = false
  var bottom_stand = false
  var split_bust = false

  this.setTitle("Blackjack")
  this.setSize(763, 435)
  //pane with null layout
  val contentPane = new JPanel(null)
  contentPane.setPreferredSize(new Dimension(1300, 650))
  contentPane.setBackground(new Color(0, 100, 0))
  contentPane.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK))

  //split game area from button area
  var button_split = new JPanel(null)
  button_split.setBounds(1115, 0, 5, 650)
  button_split.setBackground(Color.BLACK)
  button_split.setEnabled(true)
  button_split.setVisible(true)

  //split game area from button area
  var area_split = new JPanel(null)
  area_split.setBounds(0, 322, 1115, 5)
  area_split.setBackground(Color.BLACK)
  area_split.setEnabled(true)
  area_split.setVisible(true)

  //display dealer blackjack text
  var dealer_blackjack_text = new JLabel("Blackjack!")
  dealer_blackjack_text.setBounds(400, -20, 800, 400)
  dealer_blackjack_text.setFont(new Font("Segoe UI Black", 0, 120))
  dealer_blackjack_text.setForeground((Color.RED))
  dealer_blackjack_text.setEnabled(true)
  dealer_blackjack_text.setVisible(false)

  //display dealer blackjack text
  var player_blackjack_text = new JLabel("Blackjack!")
  player_blackjack_text.setBounds(400, 300, 800, 400)
  player_blackjack_text.setFont(new Font("Segoe UI Black", 0, 120))
  player_blackjack_text.setForeground((Color.RED))
  player_blackjack_text.setEnabled(true)
  player_blackjack_text.setVisible(false)

  //display dealer text
  var dealer_text = new JLabel("Dealer")
  dealer_text.setBounds(30, -10, 200, 100)
  dealer_text.setFont(new Font("Segoe UI Black", 0, 40))
  dealer_text.setForeground((Color.WHITE))
  dealer_text.setEnabled(true)
  dealer_text.setVisible(true)

  //display dealer winner text
  var dealerw_text = new JLabel("Winner!")
  dealerw_text.setBounds(250, -10, 200, 100)
  dealerw_text.setFont(new Font("Segoe UI Black", 0, 40))
  dealerw_text.setForeground((Color.GREEN))
  dealerw_text.setEnabled(true)
  dealerw_text.setVisible(false)

  //display dealer counter
  var dealer_counter = new JLabel("Hand Total: ")
  dealer_counter.setBounds(500, -10, 300, 100)
  dealer_counter.setFont(new Font("Segoe UI Black", 0, 30))
  dealer_counter.setForeground((Color.WHITE))
  dealer_counter.setEnabled(true)
  dealer_counter.setVisible(false)

  //display tie/draw text
  var draw_text = new JLabel("Draw!")
  draw_text.setBounds(250, -10, 200, 100)
  draw_text.setFont(new Font("Segoe UI Black", 0, 40))
  draw_text.setForeground((Color.GREEN))
  draw_text.setEnabled(true)
  draw_text.setVisible(false)

  //display player text
  var player_text = new JLabel("Player")
  player_text.setBounds(30, 317, 200, 100)
  player_text.setFont(new Font("Segoe UI Black", 0, 40))
  player_text.setForeground((Color.WHITE))
  player_text.setEnabled(true)
  player_text.setVisible(true)

  //display player winner text
  var playerw_text = new JLabel("Winner!")
  playerw_text.setBounds(250, 317, 200, 100)
  playerw_text.setFont(new Font("Segoe UI Black", 0, 40))
  playerw_text.setForeground((Color.GREEN))
  playerw_text.setEnabled(true)
  playerw_text.setVisible(false)

  //display player 1 counter
  var player_counter = new JLabel("Hand Total: 0")
  player_counter.setBounds(500, 317, 300, 100)
  player_counter.setFont(new Font("Segoe UI Black", 0, 30))
  player_counter.setForeground((Color.WHITE))
  player_counter.setEnabled(true)
  player_counter.setVisible(false)

  //display player 1 counter
  var player1_counter = new JLabel("Lower Hand Total: ")
  player1_counter.setBounds(800, 317, 300, 100)
  player1_counter.setFont(new Font("Segoe UI Black", 0, 28))
  player1_counter.setForeground((Color.WHITE))
  player1_counter.setEnabled(true)
  player1_counter.setVisible(false)

  //display dealer score
  var dealer_score = new JLabel("Dealer Wins: 0")
  dealer_score.setBounds(1125, -15, 200, 100)
  dealer_score.setFont(new Font("Segoe UI Black", 0, 20))
  dealer_score.setForeground((Color.WHITE))
  dealer_score.setEnabled(true)
  dealer_score.setVisible(true)

  //display player score
  var player_score = new JLabel("Player Wins: 0")
  player_score.setBounds(1125, 30, 200, 100)
  player_score.setFont(new Font("Segoe UI Black", 0, 20))
  player_score.setForeground((Color.WHITE))
  player_score.setEnabled(true)
  player_score.setVisible(true)

  //add in Deal button
  var deal_button = new JButton
  deal_button.setBounds(1160, 530, 100, 100)
  deal_button.setBackground(new Color(0, 152, 240))
  deal_button.setOpaque(true)
  deal_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  deal_button.setForeground(new Color(255, 255, 255))
  deal_button.setEnabled(true)
  deal_button.setFont(new Font("Segoe UI Black", 0, 28))
  deal_button.setText("Deal")
  deal_button.setVisible(true)
  deal_button.setEnabled(true)

  //add in hit button
  var hit_button = new JButton
  hit_button.setBounds(1160, 530, 100, 100)
  hit_button.setBackground(new Color(0, 152, 240))
  hit_button.setOpaque(true)
  hit_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  hit_button.setForeground(new Color(255, 255, 255))
  hit_button.setEnabled(true)
  hit_button.setFont(new Font("Segoe UI Black", 0, 28))
  hit_button.setText("Hit")
  hit_button.setVisible(false)
  hit_button.setEnabled(true)

  //add in stand button
  var stand_button = new JButton
  stand_button.setBounds(1160, 400, 100, 100)
  stand_button.setBackground(new Color(0, 152, 240))
  stand_button.setOpaque(true)
  stand_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  stand_button.setForeground(new Color(255, 255, 255))
  stand_button.setEnabled(true)
  stand_button.setFont(new Font("Segoe UI Black", 0, 28))
  stand_button.setText("Stand")
  stand_button.setVisible(false)
  stand_button.setEnabled(true)

  //add in split button
  var split_button = new JButton
  split_button.setBounds(1160, 270, 100, 100)
  split_button.setBackground(new Color(0, 152, 240))
  split_button.setOpaque(true)
  split_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  split_button.setForeground(new Color(255, 255, 255))
  split_button.setEnabled(true)
  split_button.setFont(new Font("Segoe UI Black", 0, 28))
  split_button.setText("Split")
  split_button.setVisible(false)
  split_button.setEnabled(true)

  //add in hit top button
  var hittop_button = new JButton
  hittop_button.setBounds(1160, 530, 100, 100)
  hittop_button.setBackground(new Color(0, 152, 240))
  hittop_button.setOpaque(true)
  hittop_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  hittop_button.setForeground(new Color(255, 255, 255))
  hittop_button.setEnabled(true)
  hittop_button.setFont(new Font("Segoe UI Black", 0, 18))
  hittop_button.setText("Hit Upper")
  hittop_button.setVisible(false)
  hittop_button.setEnabled(true)

  //add in hit lower button
  var hitlower_button = new JButton
  hitlower_button.setBounds(1160, 400, 100, 100)
  hitlower_button.setBackground(new Color(0, 152, 240))
  hitlower_button.setOpaque(true)
  hitlower_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  hitlower_button.setForeground(new Color(255, 255, 255))
  hitlower_button.setEnabled(true)
  hitlower_button.setFont(new Font("Segoe UI Black", 0, 18))
  hitlower_button.setText("Hit Lower")
  hitlower_button.setVisible(false)
  hitlower_button.setEnabled(true)

  //add in stand upper button
  var stand_top_button = new JButton
  stand_top_button.setBounds(1160, 270, 100, 100)
  stand_top_button.setBackground(new Color(0, 152, 240))
  stand_top_button.setOpaque(true)
  stand_top_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  stand_top_button.setForeground(new Color(255, 255, 255))
  stand_top_button.setEnabled(true)
  stand_top_button.setFont(new Font("Segoe UI Black", 0, 14))
  stand_top_button.setText("Stand Upper")
  stand_top_button.setVisible(false)
  stand_top_button.setEnabled(true)

  //add in stand lower button
  var stand_lower_button = new JButton
  stand_lower_button.setBounds(1160, 140, 100, 100)
  stand_lower_button.setBackground(new Color(0, 152, 240))
  stand_lower_button.setOpaque(true)
  stand_lower_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  stand_lower_button.setForeground(new Color(255, 255, 255))
  stand_lower_button.setEnabled(true)
  stand_lower_button.setFont(new Font("Segoe UI Black", 0, 14))
  stand_lower_button.setText("Stand Lower")
  stand_lower_button.setVisible(false)
  stand_lower_button.setEnabled(true)

  //add in new game button
  var new_game_button = new JButton
  new_game_button.setBounds(1160, 530, 100, 100)
  new_game_button.setBackground(new Color(0, 152, 240))
  new_game_button.setOpaque(true)
  new_game_button.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE))
  new_game_button.setForeground(new Color(255, 255, 255))
  new_game_button.setEnabled(true)
  new_game_button.setFont(new Font("Segoe UI Black", 0, 16))
  new_game_button.setText("New Game")
  new_game_button.setVisible(false)
  new_game_button.setEnabled(true)

  deal_button.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
      hit_button.setVisible(true)
      stand_button.setVisible(true)
      deal_button.setVisible(false)
      player_counter.setVisible(true)

      //deal sound effects
      try
      {
        val clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File("../Blackjack/music/shuffle.wav")))
        clip.start()
      } catch {
        case e:Exception => println(e)
      }

      new_game.start_deal() //deal out game

      var dealer_size = new_game.dealer.hand_size()
      var d_first = new_game.dealer.get_card(dealer_size-2)
      var d_second = new_game.dealer.get_card(dealer_size-1)

      var player_size = new_game.player.hand_size()
      var p_first = new_game.player.get_card(player_size-2)
      var p_second = new_game.player.get_card(player_size-1)

      //add in dealer cards

      //blank card
      blank_dealer_card = get_new_card(d_loc, 105, null, false)
      contentPane.add(blank_dealer_card)
      d_loc+=width_card //increment location of next card

      first_dealer_card = get_new_card(50, 105, d_first, true)
      contentPane.add(first_dealer_card)
      first_dealer_card.setVisible(false)

      var temp_3 = get_new_card(d_loc, 105, d_second, true)
      contentPane.add(temp_3)
      d_loc+=width_card //increment location of next card

      //add in player cards

      possible_split1 = get_new_card(p_loc, 432, p_first, true)
      contentPane.add(possible_split1)
      p_loc+=width_card //increment location of next card

      possible_split2 = get_new_card(p_loc, 432, p_second, true) //assign to split for card removal later
      contentPane.add(possible_split2)
      p_loc+=width_card //increment location of next card

      //add all cards to array
      all_cards+=blank_dealer_card
      all_cards+=first_dealer_card
      all_cards+=temp_3
      all_cards+=possible_split1
      all_cards+=possible_split2

      if(new_game.player.can_split()) {
        split_button.setVisible(true)
      }

      update_counters()

      //if there is a draw
      if (new_game.initial_draw()) {
        dealer_blackjack_text.setVisible(true)
        player_blackjack_text.setVisible(true)
        end_game(false, false, true)
        return
      }

      if (new_game.player_blackjack()) {
        player_blackjack_text.setVisible(true)
        end_game(true, false, false)
        return
      }

      if (new_game.dealer_blackjack()) {
        dealer_blackjack_text.setVisible(true)
        end_game(false, true, false)
        return
      }

      GUI.this.repaint()

      println("Deal button")
      new_game.player.print_hand()
      new_game.dealer.print_hand()
    }
  })

  hit_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      split_button.setVisible(false)

      var player_size = new_game.player.hand_size()

      if (player_size < 6) {
        new_game.player_hit()

        var p_card = new_game.player.get_card(player_size)

        var temp_1 = get_new_card(p_loc, 432, p_card, true)
        contentPane.add(temp_1)
        p_loc += width_card //increment location of next card

        all_cards+=temp_1

        update_counters()

        if (new_game.player_bust()) {
          end_game(false, true, false)
          return
        }

        if (new_game.player_blackjack()) {
          end_game(true, false, false)
          return
        }

        GUI.this.repaint()
      }

      println("Hit button")
      new_game.player.print_hand()
    }
  })

  stand_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      hit_button.setVisible(false)
      split_button.setVisible(false)
      stand_button.setVisible(false)

      dealer_turn()

      GUI.this.repaint()

      println("Stand button")
    }
  })

  split_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      hit_button.setVisible(false)
      hittop_button.setVisible(true)
      hitlower_button.setVisible(true)
      stand_button.setVisible(false)
      stand_top_button.setVisible(true)
      stand_lower_button.setVisible(true)

      possible_split1.setVisible(false)
      possible_split2.setVisible(false)

      new_game.player_split()

      var player_size = new_game.player.hand_size()
      var split_size = new_game.player.split_hand_size()
      var p_first = new_game.player.get_card(player_size-1)
      var p_second = new_game.player.get_split_card(split_size-1)

      var temp_1 = get_new_card_split(split_loc1, 432, p_first)
      contentPane.add(temp_1)
      split_loc1+=split_width //increment location of next card

      var temp_2 = get_new_card_split(split_loc2, 537, p_second)
      contentPane.add(temp_2)
      split_loc2+=split_width //increment location of next card

      split_button.setVisible(false)

      all_cards+=temp_1
      all_cards+=temp_2

      update_counters()

      GUI.this.repaint()
      //possible_split.setVisible(false)
      println("Split button")
      new_game.player.print_hand()
      new_game.player.print_split_hand()
    }
  })

  hittop_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      var player_size = new_game.player.hand_size()

      if (player_size < 6) {
        new_game.player_hit()

        var p_card = new_game.player.get_card(player_size)

        var temp_1 = get_new_card_split(split_loc1, 432, p_card)
        contentPane.add(temp_1)
        split_loc1 += split_width //increment location of next card

        all_cards+=temp_1

        update_counters()

        if (new_game.player_bust()) {
          if (split_bust) {
            end_game(false, true, false)
            return
          } else {
            hittop_button.setVisible(false)
            stand_top_button.setVisible(false)
            split_bust = true
            top_stand = true
          }
        }

        if (new_game.player_blackjack()) {
          end_game(true, false, false)
          return
        }

        GUI.this.repaint()
      }

      println("Hit Upper button")
      new_game.player.print_hand()
      new_game.player.print_split_hand()
    }
  })

  hitlower_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      var player_split_size = new_game.player.split_hand_size()

      if (player_split_size < 6) {
        new_game.player_hit_split()

        var p_card = new_game.player.get_split_card(player_split_size)

        var temp_1 = get_new_card_split(split_loc2, 537, p_card)
        contentPane.add(temp_1)
        split_loc2 += split_width //increment location of next card

        all_cards+=temp_1

        update_counters()

        if (new_game.player_split_bust()) {
          if (split_bust) {
            end_game(false, true, false)
            return
          } else {
            hitlower_button.setVisible(false)
            stand_lower_button.setVisible(false)
            split_bust = true
            bottom_stand = true
          }
        }

        if (new_game.player_blackjack()) {
          end_game(true, false, false)
          return
        }

        GUI.this.repaint()
      }

      println("Hit Lower button")
      new_game.player.print_hand()
      new_game.player.print_split_hand()
    }
  })

  stand_top_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      hittop_button.setVisible(false)
      stand_top_button.setVisible(false)
      top_stand = true
      split_bust = true

      if (bottom_stand) {
        dealer_turn()
      }

      GUI.this.repaint()
      println("Stand Upper button")
    }
  })

  stand_lower_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      hitlower_button.setVisible(false)
      stand_lower_button.setVisible(false)
      bottom_stand = true
      split_bust = true

      if (top_stand) {
        dealer_turn()
      }

      GUI.this.repaint()
      println("Stand Lower button")
    }
  })

  new_game_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      remove_cards()
      new_game.new_game()

      p_loc = 50
      d_loc = 50
      split_loc1 = 50
      split_loc2 = 50
      possible_split1 = null
      possible_split2 = null
      blank_dealer_card = null
      first_dealer_card = null
      top_stand = false
      bottom_stand = false
      split_bust = false
      new_game.dealer_result = false
      new_game.player_result = false
      new_game.tie_result = false

      split_button.setVisible(false)
      dealer_blackjack_text.setVisible(false)
      player_blackjack_text.setVisible(false)
      dealerw_text.setVisible(false)
      dealer_counter.setVisible(false)
      draw_text.setVisible(false)
      playerw_text.setVisible(false)
      player_counter.setBounds(500, 317, 300, 100)
      player_counter.setFont(new Font("Segoe UI Black", 0, 30))
      player_counter.setText("Hand Total: 0")
      player1_counter.setVisible(false)
      new_game_button.setVisible(false)
      deal_button.setVisible(true)

      println("New game button")
    }
  })

  //add in everything to canvas
  contentPane.add(button_split)
  contentPane.add(area_split)
  contentPane.add(dealer_blackjack_text)
  contentPane.add(player_blackjack_text)
  contentPane.add(dealer_text)
  contentPane.add(dealerw_text)
  contentPane.add(dealer_counter)
  contentPane.add(draw_text)
  contentPane.add(player_text)
  contentPane.add(playerw_text)
  contentPane.add(player_counter)
  contentPane.add(player1_counter)
  contentPane.add(dealer_score)
  contentPane.add(player_score)
  contentPane.add(deal_button)
  contentPane.add(hit_button)
  contentPane.add(stand_button)
  contentPane.add(split_button)
  contentPane.add(hittop_button)
  contentPane.add(hitlower_button)
  contentPane.add(stand_top_button)
  contentPane.add(stand_lower_button)
  contentPane.add(new_game_button)

  this.add(contentPane)
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  this.setLocationRelativeTo(null)
  this.pack()
  this.setVisible(true)

  def get_new_card(start_loc: Int, height_spot: Int, card: Card, flipped: Boolean): JLabel = {
    var file_path = "./Cards/"
    if (flipped) {
      var suit = card.suit
      var rank = card.rank
      var temp_suit = ""
      var temp_rank = ""

      if (suit == "Spade") temp_suit = "S"
      else if (suit == "Heart") temp_suit = "H"
      else if (suit == "Club") temp_suit = "C"
      else if (suit == "Diamond") temp_suit = "D"

      if (rank == 1) temp_rank = "A"
      else if (rank == 2) temp_rank = "2"
      else if (rank == 3) temp_rank = "3"
      else if (rank == 4) temp_rank = "4"
      else if (rank == 5) temp_rank = "5"
      else if (rank == 6) temp_rank = "6"
      else if (rank == 7) temp_rank = "7"
      else if (rank == 8) temp_rank = "8"
      else if (rank == 9) temp_rank = "9"
      else if (rank == 10) temp_rank = "10"
      else if (rank == 11) temp_rank = "J"
      else if (rank == 12) temp_rank = "Q"
      else if (rank == 13) temp_rank = "K"

      file_path = file_path + temp_rank + temp_suit + ".png"
    } else {
      file_path = file_path + "red_back.png"
    }

    var card_image = new ImageIcon(file_path)

    var raw_image = card_image.getImage() //scale image
    var final_card_image = raw_image.getScaledInstance(103, 157, java.awt.Image.SCALE_SMOOTH) //overwrite un scaled image
    card_image = new ImageIcon(final_card_image) //create as  JLabel
    var card_label = new JLabel(card_image)
    card_label.setBounds(start_loc, height_spot, 103, 157)
    card_label.setVisible(true)
    return card_label
  }

  def get_new_card_split(start_loc: Int, height_spot: Int, card: Card): JLabel = {
    var file_path = "./Cards/"
    var suit = card.suit
    var rank = card.rank
    var temp_suit = ""
    var temp_rank = ""

    if (suit == "Spade") temp_suit = "S"
    else if (suit == "Heart") temp_suit = "H"
    else if (suit == "Club") temp_suit = "C"
    else if (suit == "Diamond") temp_suit = "D"

    if (rank == 1) temp_rank = "A"
    else if (rank == 2) temp_rank = "2"
    else if (rank == 3) temp_rank = "3"
    else if (rank == 4) temp_rank = "4"
    else if (rank == 5) temp_rank = "5"
    else if (rank == 6) temp_rank = "6"
    else if (rank == 7) temp_rank = "7"
    else if (rank == 8) temp_rank = "8"
    else if (rank == 9) temp_rank = "9"
    else if (rank == 10) temp_rank = "10"
    else if (rank == 11) temp_rank = "J"
    else if (rank == 12) temp_rank = "Q"
    else if (rank == 13) temp_rank = "K"

    file_path = file_path + temp_rank + temp_suit + ".png"

    var card_image = new ImageIcon(file_path)

    var raw_image = card_image.getImage() //scale image
    var final_card_image = raw_image.getScaledInstance(55, 85, java.awt.Image.SCALE_SMOOTH) //overwrite un scaled image
    card_image = new ImageIcon(final_card_image) //create as  JLabel
    var card_label = new JLabel(card_image)
    card_label.setBounds(start_loc, height_spot, 55, 85)
    card_label.setVisible(true)
    return card_label
  }

  def remove_cards(): Unit = {
    for (i <- 0 until all_cards.size) {
      contentPane.remove(all_cards(i))
    }

    all_cards.clear()
    this.repaint()
  }

  def dealer_turn(): Unit = {
    while (new_game.dealer.hand_value() < 17 && new_game.dealer.hand_size() <= 6) {
      new_game.dealer_hit()

      var d_card = new_game.dealer.get_card(new_game.dealer.hand_size()-1)

      var temp_1 = get_new_card(d_loc, 105, d_card, true)
      contentPane.add(temp_1)
      d_loc += width_card //increment location of next card

      all_cards+=temp_1

      if (new_game.dealer_bust()) {
        end_game(true, false, false)
        return
      }

      if (new_game.dealer_blackjack()) {
        end_game(false, true, false)
        return
      }

      GUI.this.repaint()
      //right here cameron

    }
    determine_winner()
  }

  def end_game(player: Boolean, dealer: Boolean, tie: Boolean): Unit = {
    hit_button.setVisible(false)
    stand_button.setVisible(false)
    split_button.setVisible(false)
    hittop_button.setVisible(false)
    hitlower_button.setVisible(false)
    stand_top_button.setVisible(false)
    stand_lower_button.setVisible(false)
    new_game_button.setVisible(true)
    blank_dealer_card.setVisible(false)
    first_dealer_card.setVisible(true)
    dealer_counter.setText("Hand Total: " + new_game.dealer.hand_value())
    dealer_counter.setVisible(true)

    if (player) {
      playerw_text.setVisible(true)
      player_wins+=1
      player_score.setText("Player Wins: " + player_wins)
    } else if (dealer) {
      dealerw_text.setVisible(true)
      dealer_wins+=1
      dealer_score.setText("Dealer Wins: " + dealer_wins)
    } else if (tie) {
      draw_text.setVisible(true)
    }

    this.repaint()
  }

  def determine_winner(): Unit = {
    new_game.determine_winner()
    end_game(new_game.player_result, new_game.dealer_result, new_game.tie_result)
  }

  def update_counters(): Unit = {

    if (new_game.player.is_split) {
      player_counter.setBounds(450, 317, 300, 100)
      player_counter.setFont(new Font("Segoe UI Black", 0, 28))
      player1_counter.setVisible(true)
      player_counter.setText("Upper Hand Total: " + new_game.player.hand_value())
      player1_counter.setText("Lower Hand Total: " + new_game.player.split_hand_value())
    } else {
      player_counter.setText("Hand Total: " + new_game.player.hand_value())
    }
  }

}