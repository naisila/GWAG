/**
 * __Third(last) panel of the instructions
 * @author __Functionality: Naisila, GUI: Franc___
 * @version __12/05/2017__
 */
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

public class InstructionPanel3 extends JPanel {
  private JLabel back;
  /**
   * Create the panel.
   */
  public InstructionPanel3() {
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    JTextPane txtpnEachOf = new JTextPane();
    txtpnEachOf.setText("- Each of the players will start the game with a <+> question, then <->, then <+> and so " + 
                        "on.\r\n- This will be maintained by displaying <+> question in odd turns and <-> in even " + 
                        "ones.\r\n\r\n\r\n- The winner is the one who reaches the final square first.");
    txtpnEachOf.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
    txtpnEachOf.setBackground(new Color(255, 250, 205));
    txtpnEachOf.setBounds(131, 349, 455, 311);
    txtpnEachOf.setEditable(false);
    add(txtpnEachOf);
    
    JLabel gameInstruction = new JLabel("");
    gameInstruction.setIcon(new ImageIcon("src/GWAGimages/instructions.png"));
    gameInstruction.setBounds(121, 182, 714, 156);
    add(gameInstruction);
    
    back = new JLabel("");
    back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
    back.setBounds(94, 671, 165, 66);
    add(back);
    
    JLabel korniza = new JLabel("");
    korniza.setIcon(new ImageIcon("src/GWAGimages/instr_border.png"));
    korniza.setBounds(28, 91, 925, 740);
    add(korniza);
    
    JLabel pergamen = new JLabel("");
    pergamen.setIcon(new ImageIcon("src/GWAGimages/pergamen.png"));
    pergamen.setBounds(600, 350, 400, 220);
    add(pergamen);
  }
  public void setMLBack(MouseAdapter madpt)
  {
    back.addMouseListener(madpt);
  }
}