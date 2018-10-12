/**
 * __SignUp Panel of the Game
 * @author __Naisila Puka___
 * @version __12/05/2017__
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpPanel extends JPanel {
  
  private JPanel contentPane;
  private JTextField txtName;
  private JTextField txtSurname;
  private JTextField txtAge;
  private JTextField textField_3;
  private JPasswordField passwordField;
  private JPasswordField passwordField_1;
  private JButton btnCreateAnAccount;
  private JLabel back;
  
  Connection conn = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  
  /**
   * Create the panel.
   */
  public SignUpPanel() {
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("src/GWAGimages/title.png"));
    label.setBounds(159, 66, 647, 146);
    add(label);
    
    JLabel lblName = new JLabel("Name");
    lblName.setHorizontalAlignment(SwingConstants.LEFT);
    lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblName.setBounds(243, 234, 142, 53);
    add(lblName);
    
    JLabel lblAge = new JLabel("Age\r\n");
    lblAge.setHorizontalAlignment(SwingConstants.LEFT);
    lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblAge.setBounds(243, 292, 160, 53);
    add(lblAge);
    
    JLabel label_4 = new JLabel("Username\r\n");
    label_4.setHorizontalAlignment(SwingConstants.LEFT);
    label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
    label_4.setBounds(243, 356, 181, 53);
    add(label_4);
    
    JLabel lblPassword = new JLabel("Password\r\n");
    lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblPassword.setBounds(243, 420, 181, 53);
    add(lblPassword);
    
    JLabel lblConfirmPassword = new JLabel("Confirm password");
    lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
    lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblConfirmPassword.setBounds(243, 486, 196, 53);
    add(lblConfirmPassword);
    
    txtName = new JTextField();
    txtName.setText("");
    txtName.setColumns(10);
    txtName.setBounds(482, 245, 188, 36);
    add(txtName);
    
    txtAge = new JTextField();
    txtAge.setText("");
    txtAge.setColumns(10);
    txtAge.setBounds(482, 303, 188, 36);
    add(txtAge);
    
    textField_3 = new JTextField();
    textField_3.setText("");
    textField_3.setColumns(10);
    textField_3.setBounds(482, 367, 188, 36);
    add(textField_3);
    
    passwordField = new JPasswordField();
    passwordField.setText("");
    passwordField.setColumns(10);
    passwordField.setBounds(482, 431, 188, 36);
    add(passwordField);
    
    passwordField_1 = new JPasswordField();
    passwordField_1.setText("");
    passwordField_1.setColumns(10);
    passwordField_1.setBounds(482, 497, 188, 36);
    add(passwordField_1);
    
    btnCreateAnAccount = new JButton("Create an account");
    
    btnCreateAnAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnCreateAnAccount.setBounds(303, 561, 316, 53);
    add(btnCreateAnAccount);
    
    JLabel label_5 = new JLabel("");
    label_5.setHorizontalAlignment(SwingConstants.LEFT);
    label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
    label_5.setBounds(243, 356, 181, 53);
    add(label_5);
    
    back = new JLabel("");
    back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
    back.setBounds(94, 671, 165, 66);
    add(back);
    conn = jConnectivity.ConnecrDb();
    
    
  }
  public void addAct(ActionListener aL)
  {
    btnCreateAnAccount.addActionListener(aL);
  }
  public PreparedStatement getpst()
  {
    return pst;
  }
  public JTextField gettxtName()
  {
    return txtName;
  }
  public JTextField gettxtAge()
  {
    return txtAge;
  }
  public JTextField gettextField_3()
  {
    return textField_3;
  }
  public JPasswordField getpasswordField()
  {
    return passwordField;
  }
  public JPasswordField getpasswordField_1()
  {
    return passwordField_1;
  }
  public Connection getconn()
  {
    return conn;
  }
  public void setpst(PreparedStatement pstt)
  {
    pst = pstt;
  }
  public void setMLBack(MouseAdapter madpt)
  {
    back.addMouseListener(madpt);
  }
  
}//end of sign in class


