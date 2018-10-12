import java.awt.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuFrame extends JFrame {

 private JPanel contentPane;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     MenuFrame frame = new MenuFrame();
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
 public MenuFrame()
 {
  setForeground(new Color(255, 255, 255));
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(200,100, 1015, 930);
  contentPane = new JPanel();
  contentPane.setBackground(new Color(255, 250, 205));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JButton btnNewButton = new JButton("One Player");
  btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
  btnNewButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
   }
  });
  btnNewButton.setBounds(80, 180, 312, 68);
  contentPane.add(btnNewButton);
  
  JLabel label = new JLabel("");
  label.setIcon(new ImageIcon("src/GWAGimages/MENU.png"));
  
  label.setBounds(74, 11, 346, 165);
  contentPane.add(label);
  
  JButton btnTwoPlayer = new JButton("Two Players");
  btnTwoPlayer.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     
    // MenuFrame.this.getContentPane().remove(contentPane);
      //MenuFrame.this.remove(contentPane);
     try
     {
       MenuFrame.this.setContentPane(new MainPanel(new Player(new Pawn(Color.red), "naisila"), new Player(new Pawn(Color.red), "redi")));
       MenuFrame.this.invalidate();
       MenuFrame.this.validate();
     }
     catch(IOException ent){}
//    //setVisible(true);
//    setResizable(false);
    //pack();
//      MenuFrame.this.dispose();
//    GameFrame eng = new GameFrame();
//    eng.setVisible(true);
   }
  });
  btnTwoPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
  btnTwoPlayer.setBounds(80, 272, 312, 68);
  contentPane.add(btnTwoPlayer);
  
  JButton btnMyProgress = new JButton("My Progress");
  btnMyProgress.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  btnMyProgress.setFont(new Font("Tahoma", Font.PLAIN, 20));
  btnMyProgress.setBounds(80, 365, 312, 68);
  contentPane.add(btnMyProgress);
  
  JButton btnInstructions = new JButton("Instructions");
  btnInstructions.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  btnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
  btnInstructions.setBounds(80, 455, 312, 68);
  contentPane.add(btnInstructions);
  
  JLabel label_1 = new JLabel("");
  label_1.setIcon(new ImageIcon("src/GWAGimages/dice-575658_960_720.png"));
  label_1.setBounds(484, 162, 412, 361);
  contentPane.add(label_1);
  
  JPanel panel_1 = new JPanel();
  panel_1.setBorder(null);
  panel_1.setBackground(new Color(255, 250, 205));
  panel_1.setBounds(650, 33, 273, 135);
  contentPane.add(panel_1);
  panel_1.setLayout(null);
  JLabel lblNewLabel = new JLabel("");
  lblNewLabel.setBounds(0, 0, 122, 135);
  panel_1.add(lblNewLabel);
  lblNewLabel.setIcon(new ImageIcon("src/GWAGimages/user.png"));
  //lblNewLabel.setIcon( new ImageIcon(Menu.class.getResource("src/GWAGimages/dice-575658_960_720.png")));
  
  JLabel lblNewLabel_2 = new JLabel("USERNAME");
  lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
  lblNewLabel_2.setBounds(115, 74, 146, 28);
  panel_1.add(lblNewLabel_2);
  
  JLabel lblNewLabel_3 = new JLabel("AGE:");
  lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
  lblNewLabel_3.setBounds(115, 31, 56, 16);
  panel_1.add(lblNewLabel_3);
  
  JLabel lblNewLabel_4 = new JLabel("20");
  lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
  lblNewLabel_4.setBounds(153, 31, 56, 16);
  panel_1.add(lblNewLabel_4);
  
 }
}