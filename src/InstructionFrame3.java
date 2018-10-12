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

public class InstructionFrame3 extends JFrame {

 private JPanel contentPane;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     InstructionFrame3 frame = new InstructionFrame3();
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
 public InstructionFrame3() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 1000, 800);
  contentPane = new JPanel();
  contentPane.setBackground(new Color(255, 250, 205));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JTextPane txtpnEachOf = new JTextPane();
  txtpnEachOf.setText("- Each of the players will start the game with a <+> question, then <->, then <+> and so " + 
                      "on.\r\n- This will be maintained by displaying <+> question in odd turns and <-> in even " + 
                      "ones.\r\n\r\n\r\n- The winner is the one who reaches the final square first.");
  txtpnEachOf.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
  txtpnEachOf.setBackground(new Color(255, 250, 205));
  txtpnEachOf.setBounds(131, 269, 455, 311);
  txtpnEachOf.setEditable(false);
  contentPane.add(txtpnEachOf);
  
  JLabel gameInstruction = new JLabel("");
  gameInstruction.setIcon(new ImageIcon("src/GWAGimages/instructions.png"));
  gameInstruction.setBounds(121, 102, 714, 156);
  contentPane.add(gameInstruction);
  
  JLabel next = new JLabel("");
  next.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent arg0) {
   }
  });
  next.setIcon(new ImageIcon("src/GWAGimages/next.png"));
  next.setBounds(712, 599, 165, 66);
  contentPane.add(next);
  
  JLabel back = new JLabel("");
  back.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
   }
  });
  back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
  back.setBounds(94, 591, 165, 66);
  contentPane.add(back);
  
  JLabel korniza = new JLabel("");
  korniza.setIcon(new ImageIcon("src/GWAGimages/instr_border.png"));
  korniza.setBounds(28, 11, 925, 740);
  contentPane.add(korniza);
 }

}