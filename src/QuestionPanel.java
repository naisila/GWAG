import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Label;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
public class QuestionPanel extends JFrame {

 private JPanel contentPane;
private int timee = 20;
private Timer timer;
 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     QuestionPanel frame = new QuestionPanel();
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
 public QuestionPanel() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 801, 447);
  contentPane = new JPanel();
  contentPane.setBackground(new Color(255, 250, 205));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JSeparator separator = new JSeparator();
  separator.setBounds(38, 81, 668, 2);
  contentPane.add(separator);
  

  JSeparator separator_2 = new JSeparator();
  separator_2.setBounds(38, 326, 668, 2);
  contentPane.add(separator_2);
  
  JButton btnNewButton = new JButton("15\r\n");
  btnNewButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    
   }
  });
  btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
  btnNewButton.setBounds(38, 268, 144, 53);
  contentPane.add(btnNewButton);
  
  JButton button = new JButton("20");
  button.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  button.setFont(new Font("Tahoma", Font.PLAIN, 15));
  button.setBounds(211, 268, 144, 53);
  contentPane.add(button);
  
  JButton button_1 = new JButton("27");
  button_1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
  button_1.setBounds(391, 268, 144, 53);
  contentPane.add(button_1);
  
  JButton button_2 = new JButton("17");
  button_2.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
  button_2.setBounds(562, 268, 144, 53);
  contentPane.add(button_2);
  
  JButton btnSubmit = new JButton("Submit");
  btnSubmit.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
  btnSubmit.setBounds(484, 339, 106, 38);
  contentPane.add(btnSubmit);
  
  JButton btnGiveUp = new JButton("Give up");
  btnGiveUp.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  btnGiveUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
  btnGiveUp.setBounds(600, 339, 106, 38);
  contentPane.add(btnGiveUp);
  
  JLabel lblNewLabel_1 = new JLabel("New label");
  lblNewLabel_1.setIcon(new ImageIcon("src/GWAGimages/minion.png"));
  lblNewLabel_1.setBounds(10, 11, 106, 72);
  contentPane.add(lblNewLabel_1);
  
  JLabel lblNewLabel_2 = new JLabel("2");
  lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
  lblNewLabel_2.setBounds(126, 20, 89, 44);
  contentPane.add(lblNewLabel_2);
  JLabel time = new JLabel("Time left: 20 sec");
  time.setForeground(Color.red);
  time.setFont(new Font("Tahoma", Font.PLAIN, 28));
  time.setBounds(470, 0, 800, 130);
  contentPane.add(time);
  JTextArea txtrCalciumOxideIs = new JTextArea();
  txtrCalciumOxideIs.setBackground(new Color(255, 250, 205));
  txtrCalciumOxideIs.setFont(new Font("Tahoma", Font.PLAIN, 17));
  txtrCalciumOxideIs.setText("Calcium oxide is used to make cement and steel.\r\nThe chemical " + 
                               "formula for calcium oxide is CaO.\r\n\r\nComplete the statement.\r\nCalcium " +
                             "oxide is _______________.\u00A0");
  txtrCalciumOxideIs.setBounds(38, 111, 683, 130);
  contentPane.add(txtrCalciumOxideIs);
  
   timer = new Timer(1000, new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
      timee = timee - 1;
      
      time.setText("Time left: " + timee + " sec");
      if(timee == 0)
        timer.stop();
    }
  });
  timer.start();
 }
}