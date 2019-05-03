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

  var loc = 50
  val width_card = 130

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
  this.add(button_split)

  //split game area from button area
  var area_split = new JPanel(null)
  area_split.setBounds(0, 322, 1115, 5)
  area_split.setBackground(Color.BLACK)
  area_split.setEnabled(true)
  area_split.setVisible(true)
  this.add(area_split)

  //display dealer text
  var dealer_text = new JLabel("Dealer")
  dealer_text.setBounds(30, -10, 200, 100)
  dealer_text.setFont(new Font("Segoe UI Black", 0, 40))
  dealer_text.setForeground((Color.WHITE))
  dealer_text.setEnabled(true)
  dealer_text.setVisible(true)
  this.add(dealer_text)

  //display player text
  var player_text = new JLabel("Player")
  player_text.setBounds(30, 317, 200, 100)
  player_text.setFont(new Font("Segoe UI Black", 0, 40))
  player_text.setForeground((Color.WHITE))
  player_text.setEnabled(true)
  player_text.setVisible(true)
  this.add(player_text)

  //display dealer score
  var dealer_score = new JLabel("Dealer Wins: 0")
  dealer_score.setBounds(1125, -15, 200, 100)
  dealer_score.setFont(new Font("Segoe UI Black", 0, 20))
  dealer_score.setForeground((Color.WHITE))
  dealer_score.setEnabled(true)
  dealer_score.setVisible(true)
  this.add(dealer_score)

  //display player score
  var player_score = new JLabel("Player Wins: 0")
  player_score.setBounds(1125, 30, 200, 100)
  player_score.setFont(new Font("Segoe UI Black", 0, 20))
  player_score.setForeground((Color.WHITE))
  player_score.setEnabled(true)
  player_score.setVisible(true)
  this.add(player_score)

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
  this.add(deal_button)

  deal_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      hit_button.setVisible(true)
      stand_button.setVisible(true)
      split_button.setVisible(true)
      deal_button.setVisible(false)
      new_game.start_deal()
      println("Deal button")
      new_game.player.print_hand()
    }
  })

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
  this.add(hit_button)

  hit_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      println("Hit button")
      //System.exit(0)
    }
  })

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
  this.add(stand_button)

  stand_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      println("Stand button")
    }
  })

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
  this.add(split_button)

  split_button.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      println("Split button")
    }
  })

  this.add(get_new_card(loc, 432))

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
  //adding panel to JFrame and seting of window position and close operation
  this.add(contentPane)
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  this.setLocationRelativeTo(null)
  this.pack()
  this.setVisible(true)

  def get_new_card(start_loc: Int, height_spot: Int): JLabel = {
    var card_image = new ImageIcon("./Cards/red_back.png")
    var raw_image = card_image.getImage() //scale image
    var final_card_image = raw_image.getScaledInstance(103, 157, java.awt.Image.SCALE_SMOOTH) //overwrite un scaled image
    card_image = new ImageIcon(final_card_image) //create as  JLabel
    var card_label = new JLabel(card_image)
    card_label.setBounds(start_loc, height_spot, 103, 157)
    loc+=width_card //increment location of next card
    card_label.setVisible(true)
    return card_label
  }

}