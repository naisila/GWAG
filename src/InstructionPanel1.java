/**
 * __First panel of the instructions
 * @author __Functionality: Naisila, GUI: Franc___
 * @version __12/05/2017__
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class InstructionPanel1 extends JPanel {
  
  private JLabel back;
  private JLabel label_1;
  /**
   * Create the panel.
   */
  public InstructionPanel1() {
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    
    JTextPane textPane = new JTextPane();
    textPane.setText("-   The game board has numbered squares, and each square in which the player arrives after " + 
                     "he/she rolls the dice displays a question\r\n\r\n\r\n-  The turn of one player ends when he " +
                     "answers the question and moves according to the answer he gave. ");
    textPane.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
    textPane.setBackground(new Color(255, 250, 205));
    textPane.setBounds(131, 349, 455, 311);
    textPane.setEditable(false);
    add(textPane);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("src/GWAGimages/instructions.png"));
    label.setBounds(121, 182, 714, 156);
    add(label);
    
    label_1 = new JLabel("");
    label_1.setIcon(new ImageIcon("src/GWAGimages/next.png"));
    label_1.setBounds(712, 679, 165, 66);
    add(label_1);
    
    
    JLabel label_3 = new JLabel("");
    label_3.setIcon(new ImageIcon("src/GWAGimages/instr_border.png"));
    label_3.setBounds(28, 91, 925, 740);
    add(label_3);
    back = new JLabel("");
    back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
    back.setBounds(94, 671, 165, 66);
    add(back);
    
    JLabel pergamen = new JLabel("");
    pergamen.setIcon(new ImageIcon("src/GWAGimages/pergamen.png"));
    pergamen.setBounds(600, 350, 400, 220);
    add(pergamen);
  }
  public void setMLBack(MouseAdapter madpt)
  {
    back.addMouseListener(madpt);
  }
  public void setMLNext(MouseAdapter madpt)
  {
    label_1.addMouseListener(madpt);
  }
}