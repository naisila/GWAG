/**
 * __Login Panel of the Game
 * @author __Functionality(with online connection): Naisila, GUI: Franc___
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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginPanel extends JPanel {
  Connection conn = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  ResultSet rs2 = null;
  
  private JTextField txtEnterUsername;
  private JPasswordField txtPassword;
  private JButton signInButton;
  private int ageOfUser = 0;
  private JLabel back;
  
  /**
   * Create the panel.
   */
  public LoginPanel() {
    setFont(new Font("Tahoma", Font.PLAIN, 11));
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    JLabel guessWhatImage = new JLabel("");
    guessWhatImage.setIcon(new ImageIcon("src/GWAGimages/title.png"));
    guessWhatImage.setBounds(183, 120, 612, 166);
    add(guessWhatImage);
    
    JLabel lblUsername = new JLabel("Username\r\n");
    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
    lblUsername.setBounds(169, 377, 239, 53);
    add(lblUsername);
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblPassword.setBounds(169, 455, 239, 53);
    add(lblPassword);
    
    txtEnterUsername = new JTextField();
    txtEnterUsername.setText("username");
    txtEnterUsername.setBounds(441, 389, 188, 36);
    add(txtEnterUsername);
    txtEnterUsername.setColumns(10);
    
    txtPassword = new JPasswordField();
    txtPassword.setText("password\r\n");
    txtPassword.setColumns(10);
    txtPassword.setBounds(440, 467, 188, 36);
    add(txtPassword);
    
    signInButton = new JButton("Sign in");
    signInButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    signInButton.setBounds(324, 600, 316, 53);
    add(signInButton);
    
    back = new JLabel("");
    back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
    back.setBounds(60, 800, 165, 66);
    add(back);
    conn = jConnectivity.ConnecrDb();
  }
  
  
  public void addAct(ActionListener aL)
  {
    signInButton.addActionListener(aL);
  }
  public PreparedStatement getpst()
  {
    return pst;
  }
  public JTextField gettxtEnterUsername()
  {
    return txtEnterUsername;
  }
  public JPasswordField gettxtPassword()
  {
    return txtPassword;
  }
  public Connection getconn()
  {
    return conn;
  }
  public void setpst(PreparedStatement pstt)
  {
    pst = pstt;
  }
  public void setrs(ResultSet rss)
  {
    rs = rss;
  }
  public void setrs2(ResultSet rss)
  {
    rs2 = rss;
  }
  public ResultSet getrs()
  {
    return rs;
  }
  public ResultSet getrs2()
  {
    return rs2;
  }
  public void setAgeOfUser(int ag)
  {
    ageOfUser = ag;
  }
  public int getAgeOfUser()
  {
    return ageOfUser;
  }
  public void setMLBack(MouseAdapter madpt)
  {
    back.addMouseListener(madpt);
  }
}//end of LoginPanel class
