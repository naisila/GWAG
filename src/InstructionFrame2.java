
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

public class InstructionFrame2 extends JFrame {

 private JPanel contentPane;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     InstructionFrame2 frame = new InstructionFrame2();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the frame.
  */
 public InstructionFrame2() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 1000, 800);
  contentPane = new JPanel();
  contentPane.setBackground(new Color(255, 250, 205));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JTextPane txtpnThePlayer = new JTextPane();
  txtpnThePlayer.setText("- The player will get either a <+> or <-> question in the square in which he arrives " + 
                         "after rolling the dice.\r\n  - In the <+> question, the game awards you by moving several " + 
                         "steps ahead in the board if you answer correctly; otherwise you stay steady until next " + 
                         "turn.\r\n  - In the <-> question, you stay steady until next turn if you answer correctly " + 
                         "or the game punishes you by regressing several squares back if you answer incorrectly.");
  txtpnThePlayer.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
  txtpnThePlayer.setBackground(new Color(255, 250, 205));
  txtpnThePlayer.setBounds(131, 255, 455, 342);
  txtpnThePlayer.setEditable(false);
  contentPane.add(txtpnThePlayer);
  
  JLabel label = new JLabel("");
  label.setIcon(new ImageIcon("src/GWAGimages/instructions.png"));
  label.setBounds(121, 102, 714, 156);
  contentPane.add(label);
  
  JLabel label_1 = new JLabel("");
  label_1.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
   }
  });
  label_1.setIcon(new ImageIcon("src/GWAGimages/next.png"));
  label_1.setBounds(712, 599, 165, 66);
  contentPane.add(label_1);
  
  JLabel back = new JLabel("");
  back.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
   }
  });
  back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
  back.setBounds(94, 591, 165, 66);
  contentPane.add(back);
  
  JLabel label_3 = new JLabel("");
  label_3.setIcon(new ImageIcon("src/GWAGimages/instr_border.png"));
  label_3.setBounds(28, 11, 925, 740);
  contentPane.add(label_3);
 }

}