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
  this.setTitle("Blackjack")
  this.setSize(763, 435)
  //pane with null layout
  val contentPane = new JPanel(null)
  contentPane.setPreferredSize(new Dimension(763, 435))
  contentPane.setBackground(new Color(22, 181, 75))

  var button1 = new JButton
  button1.setBounds(389, 290, 90, 35)
  button1.setBackground(new Color(214, 217, 223))
  button1.setForeground(new Color(0, 0, 0))
  button1.setEnabled(true)
  button1.setFont(new Font("sansserif", 0, 12))
  button1.setText("Button1")
  button1.setVisible(true)

  button1.addMouseListener(new MouseAdapter() {
    override def mouseClicked(evt: MouseEvent): Unit = {
      println("Button is clicking")
      //System.exit(0)
    }
  })

  //adding components to contentPane panel
  contentPane.add(button1)

  //adding panel to JFrame and seting of window position and close operation
  this.add(contentPane)
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  this.setLocationRelativeTo(null)
  this.pack()
  this.setVisible(true)

}