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

import javax.swing.border.Border
import javax.swing._
import javax.swing.JButton



object Blackjack {
  def main(args: Array[String]): Unit = {
    System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel")
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      override def run(): Unit = {
        new GUI

      }
    })
  }
}

class GUI() //Constructor
  extends JFrame {

  var new_game = new Game(1)

  var p_loc = 50
  var d_loc = 50
  var split_loc1 = 50
  var split_loc2 = 50
  val width_card = 130
  val split_width = 85
  var possible_split1: JLabel = null
  var possible_split2: JLabel = null

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

  //display dealer text
  var dealer_text = new JLabel("Dealer")
  dealer_text.setBounds(30, -10, 200, 100)
  dealer_text.setFont(new Font("Segoe UI Black", 0, 40))
  dealer_text.setForeground((Color.WHITE))
  dealer_text.setEnabled(true)
  dealer_text.setVisible(true)

  //display player text
  var player_text = new JLabel("Player")
  player_text.setBounds(30, 317, 200, 100)
  player_text.setFont(new Font("Segoe UI Black", 0, 40))
  player_text.setForeground((Color.WHITE))
  player_text.setEnabled(true)
  player_text.setVisible(true)

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

  //this.add(get_new_card(loc, 432))

  /*
  //Create a Card Image
  var card_image = new ImageIcon("./Cards/red_back.png")
  var raw_image = card_image.getImage() //scale image
  var final_card_image = raw_image.getScaledInstance(103, 157, java.awt.Image.SCALE_SMOOTH) //overwrite un scaled image
  card_image = new ImageIcon(final_card_image) //create as  JLabel
  var card_label = new JLabel(card_image)
  card_label.setBounds(50, 105, 103, 157)
  card_label.setVisible(true)
  this.add(card_label)

  /* Following 3 display testing of cards */

  var card_image1 = new ImageIcon("./Cards/3C.png")
  var raw_image1 = card_image1.getImage() //scale image
  var final_card_image1 = raw_image1.getScaledInstance(103, 157, java.awt.Image.SCALE_SMOOTH) //overwrite un scaled image
  card_image1 = new ImageIcon(final_card_image1) //create as  JLabel
  var card_label1 = new JLabel(card_image1)
  card_label1.setBounds(50, 432, 103, 157)
  card_label1.setVisible(true)
  this.add(card_label1)

  var card_image2 = new ImageIcon("./Cards/6D.png")
  var raw_image2 = card_image2.getImage() //scale image
  var final_card_image2 = raw_image2.getScaledInstance(103, 157, java.awt.Image.SCALE_SMOOTH) //overwrite un scaled image
  card_image2 = new ImageIcon(final_card_image2) //create as  JLabel
  var card_label2 = new JLabel(card_image2)
  card_label2.setBounds(183, 105, 103, 157)
  card_label2.setVisible(true)
  this.add(card_label2)

  var card_image3 = new ImageIcon("./Cards/AS.png")
  var raw_image3 = card_image3.getImage() //scale image
  var final_card_image3 = raw_image3.getScaledInstance(103, 157, java.awt.Image.SCALE_SMOOTH) //overwrite un scaled image
  card_image3 = new ImageIcon(final_card_image3) //create as  JLabel
  var card_label3 = new JLabel(card_image3)
  card_label3.setBounds(183, 432, 103, 157)
  card_label3.setVisible(true)
  this.add(card_label3)

  /* End of Extra Card tests */
  */

  deal_button.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
      hit_button.setVisible(true)
      stand_button.setVisible(true)
      split_button.setVisible(true)
      deal_button.setVisible(false)
      new_game.start_deal() //deal out game

      var dealer_size = new_game.dealer.hand_size()
      var d_second = new_game.dealer.get_card(dealer_size-1)

      var player_size = new_game.player.hand_size()
      var p_first = new_game.player.get_card(player_size-2)
      var p_second = new_game.player.get_card(player_size-1)

      //add in dealer cards

      contentPane.add(get_new_card(d_loc, 105, null, false))
      d_loc+=width_card //increment location of next card

      contentPane.add(get_new_card(d_loc, 105, d_second, true))
      d_loc+=width_card //increment location of next card

      //add in player cards

      possible_split1 = get_new_card(p_loc, 432, p_first, true)
      contentPane.add(possible_split1)
      p_loc+=width_card //increment location of next card

      possible_split2 = get_new_card(p_loc, 432, p_second, true) //assign to split for card removal later
      contentPane.add(possible_split2)
      p_loc+=width_card //increment location of next card

      GUI.this.repaint()

      println("Deal button")
      new_game.player.print_hand()
      new_game.dealer.print_hand()
    }
  })

  hit_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      var player_size = new_game.player.hand_size()

      if (player_size < 6) {
        new_game.player_hit()

        var p_card = new_game.player.get_card(player_size)

        contentPane.add(get_new_card(p_loc, 432, p_card, true))
        p_loc += width_card //increment location of next card

        GUI.this.repaint()
      }

      println("Hit button")
      new_game.player.print_hand()
    }
  })

  stand_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
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

      contentPane.add(get_new_card_split(split_loc1, 432, p_first))
      split_loc1+=split_width //increment location of next card

      contentPane.add(get_new_card_split(split_loc2, 537, p_second))
      split_loc2+=split_width //increment location of next card

      split_button.setVisible(false)

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

        contentPane.add(get_new_card_split(split_loc1, 432, p_card))
        split_loc1 += split_width //increment location of next card

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

        contentPane.add(get_new_card_split(split_loc2, 537, p_card))
        split_loc2 += split_width //increment location of next card

        GUI.this.repaint()
      }

      println("Hit Lower button")
      new_game.player.print_hand()
      new_game.player.print_split_hand()
    }
  })

  stand_top_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      println("Stand Upper button")
    }
  })

  stand_lower_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      println("Stand Lower button")
    }
  })

  //add in everything to canvas
  contentPane.add(button_split)
  contentPane.add(area_split)
  contentPane.add(dealer_text)
  contentPane.add(player_text)
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

}