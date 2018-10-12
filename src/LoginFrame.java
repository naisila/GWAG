import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginFrame extends JFrame {
 Connection conn = null;
 PreparedStatement pst = null;
 ResultSet rs = null;

 private JPanel contentPane;
 private JTextField txtEnterUsername;
 private JPasswordField txtPassword;
 private JButton signInButton;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     LoginFrame frame = new LoginFrame();
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
 public LoginFrame() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 1000, 800);
  contentPane = new JPanel();
  contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
  contentPane.setBackground(new Color(255, 250, 205));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JLabel guessWhatImage = new JLabel("");
  guessWhatImage.setIcon(new ImageIcon("src/GWAGimages/title.png"));
  guessWhatImage.setBounds(183, 54, 612, 166);
  contentPane.add(guessWhatImage);
  
  JLabel lblUsername = new JLabel("Username\r\n");
  lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
  lblUsername.setBounds(169, 277, 239, 53);
  contentPane.add(lblUsername);
  
  JLabel lblPassword = new JLabel("Password");
  lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
  lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lblPassword.setBounds(169, 355, 239, 53);
  contentPane.add(lblPassword);
  
  txtEnterUsername = new JTextField();
  txtEnterUsername.setText("username");
  txtEnterUsername.setBounds(441, 289, 188, 36);
  contentPane.add(txtEnterUsername);
  txtEnterUsername.setColumns(10);
  
  txtPassword = new JPasswordField();
  txtPassword.setText("password\r\n");
  txtPassword.setColumns(10);
  txtPassword.setBounds(440, 367, 188, 36);
  contentPane.add(txtPassword);
  
  JLabel doNotHaveAccount = new JLabel("Don\u2019t have an account?");
  doNotHaveAccount.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
   }
  });
  doNotHaveAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
  doNotHaveAccount.setHorizontalAlignment(SwingConstants.CENTER);
  doNotHaveAccount.setHorizontalTextPosition(SwingConstants.CENTER);
  doNotHaveAccount.setBounds(402, 451, 138, 16);
  contentPane.add(doNotHaveAccount);
  
  signInButton = new JButton("Sign in");
  signInButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     String sql = "select * from Users.UserAccount where username = ? and password = ?"; 
    try{
     pst = conn.prepareStatement(sql);
     pst.setString(1, txtEnterUsername.getText() );
     pst.setString(2, txtPassword.getText() );
     rs = pst.executeQuery();
     if( rs.next()){
      System.out.println("Successful");
     }
     else
     {
      System.out.println("Username and Password does not match");
     } 
    }catch( Exception ee){
     JOptionPane.showMessageDialog(null, e);
   }
   }
  });
  signInButton.setFont(new Font("Tahoma", Font.BOLD, 15));
  signInButton.setBounds(324, 528, 316, 53);
  contentPane.add(signInButton);
  conn = jConnectivity.ConnecrDb();
 }
}