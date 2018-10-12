/**
 * __GUI class for the Die Panel. It shows a die which is rolled when the Roll button is pressed.
 * @author __GUI and Functionality : Naisila___
 * @version __30/04/2017__
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiePanel extends JPanel 
{
  //properties
  private int die = 5;
  private JButton rollButton;
  private Timer timer;   
  
  //constructor
  public DiePanel() 
  {
    setLayout(new BorderLayout(2,2));
    setBackground(new Color(255, 250, 205));
    setBorder(BorderFactory.createLineBorder(new Color(255, 250, 205), 2));
    
    JPanel dicePanel = new JPanel() {
      public void paintComponent(Graphics g) { 
        super.paintComponent(g);  
        drawDie(g, die, 10, 10); // draw the dice.
      }
    };
    
    dicePanel.setPreferredSize( new Dimension(50,50) );
    dicePanel.setBackground( new Color(255, 250, 205) );  
    add(dicePanel, BorderLayout.CENTER);
    
    rollButton = new JButton("Roll");
    add(rollButton, BorderLayout.SOUTH);
    
  } // end constructor
  
  //methods
  public void drawDie(Graphics g, int faceValue, int x, int y) 
  {
    g.setColor(Color.red);
    g.fillRect(x, y, 35, 35);
    g.drawRect(x, y, 34, 34);
    
    g.setColor(Color.white);
    if (faceValue > 1)  // upper left dot
      g.fillOval(x + 3, y + 3, 9, 9);
    if (faceValue > 3)  // upper right dot
      g.fillOval(x + 23, y + 3, 9, 9);
    if (faceValue == 6) // middle left dot
      g.fillOval(x + 3, y + 13, 9, 9);
    if (faceValue % 2 == 1) // middle dot (for odd-numbered val's)
      g.fillOval(x + 13, y + 13, 9, 9);
    if (faceValue == 6) // middle right dot
      g.fillOval(x + 23, y + 13, 9, 9);
    if (faceValue > 3)  // bottom left dot
      g.fillOval(x + 3, y + 23, 9, 9);
    if (faceValue > 1)  // bottom right dot
      g.fillOval(x + 23, y + 23, 9, 9);
  }
  
  public JButton getDieButton()
  {
    return rollButton;
  }
  
  public void setDie(int h)
  {
    die = h;
  }
  
  public void setTimer(Timer t)
  {
    timer = t;
  }
  public int getDie()
  {
    return die;
  }
  
  public Timer getTimer()
  {
    return timer;
  }
  
} // end class DiePanel