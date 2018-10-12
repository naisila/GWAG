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

public class SignUpFrame extends JFrame {
  
  private JPanel contentPane;
  private JTextField txtName;
  private JTextField txtSurname;
  private JTextField txtAge;
  private JTextField textField_3;
  private JPasswordField passwordField;
  private JPasswordField passwordField_1;
  
  
  Connection conn = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SignUpFrame frame = new SignUpFrame();
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
  public SignUpFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1015, 930);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 250, 205));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("src/GWAGimages/title.png"));
    label.setBounds(159, 66, 647, 146);
    contentPane.add(label);
    
    JLabel lblName = new JLabel("Name");
    lblName.setHorizontalAlignment(SwingConstants.LEFT);
    lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblName.setBounds(243, 234, 142, 53);
    contentPane.add(lblName);
    
//  JLabel lblSurname = new JLabel("Surname");
//  lblSurname.setHorizontalAlignment(SwingConstants.LEFT);
//  lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 18));
//  lblSurname.setBounds(243, 298, 154, 53);
//  contentPane.add(lblSurname);
    
    JLabel lblAge = new JLabel("Age\r\n");
    lblAge.setHorizontalAlignment(SwingConstants.LEFT);
    lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblAge.setBounds(243, 292, 160, 53);
    contentPane.add(lblAge);
    
    JLabel label_4 = new JLabel("Username\r\n");
    label_4.setHorizontalAlignment(SwingConstants.LEFT);
    label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
    label_4.setBounds(243, 356, 181, 53);
    contentPane.add(label_4);
    
    JLabel lblPassword = new JLabel("Password\r\n");
    lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblPassword.setBounds(243, 420, 181, 53);
    contentPane.add(lblPassword);
    
    JLabel lblConfirmPassword = new JLabel("Confirm password");
    lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
    lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblConfirmPassword.setBounds(243, 486, 196, 53);
    contentPane.add(lblConfirmPassword);
    
    txtName = new JTextField();
    txtName.setText("");
    txtName.setColumns(10);
    txtName.setBounds(482, 245, 188, 36);
    contentPane.add(txtName);
    
    txtAge = new JTextField();
    txtAge.setText("");
    txtAge.setColumns(10);
    txtAge.setBounds(482, 303, 188, 36);
    contentPane.add(txtAge);
    
    textField_3 = new JTextField();
    textField_3.setText("");
    textField_3.setColumns(10);
    textField_3.setBounds(482, 367, 188, 36);
    contentPane.add(textField_3);
    
    passwordField = new JPasswordField();
    passwordField.setText("");
    passwordField.setColumns(10);
    passwordField.setBounds(482, 431, 188, 36);
    contentPane.add(passwordField);
    
    passwordField_1 = new JPasswordField();
    passwordField_1.setText("");
    passwordField_1.setColumns(10);
    passwordField_1.setBounds(482, 497, 188, 36);
    contentPane.add(passwordField_1);
    
    JButton btnCreateAnAccount = new JButton("Create an account");
    btnCreateAnAccount.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String a = passwordField.getText();
        if(a.equals(passwordField_1.getText()) && !(textField_3.getText().equals("")) &&
           !(a.equals("")) && !(txtAge.getText().equals("")) && !(txtAge.getText().equals("")) )
        {
          try 
          {
            int val = Integer.parseInt(txtAge.getText());
            
            String sql = "INSERT INTO Users.UserAccount(id,username, password, age, mail,firstgame,secondgame,thirdgame) values(?,?,?,?,?,?,?,?,?,?,?)";
            try{
              pst = conn.prepareStatement(sql);
              pst.setString(1,"0");
              pst.setString(2, textField_3.getText() );
              pst.setString(3, passwordField.getText() );
              pst.setString(4, txtAge.getText() );
              pst.setString(5, txtAge.getText() );
              pst.setString(6, "0");
              pst.setString(7, "0");
              pst.setString(8, "0");
              pst.setString(9, "0");
              pst.setString(10,"0");
              pst.setString(11,"0");
              pst.execute();
              System.out.println("Registered");
            }catch( Exception eee){
              JOptionPane.showMessageDialog(null, e);
            }
          }
          catch(NumberFormatException noFormatException) {
            System.out.println("Invalid");
          }
        }
      }
    });
    btnCreateAnAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnCreateAnAccount.setBounds(303, 561, 316, 53);
    contentPane.add(btnCreateAnAccount);
    
    JLabel label_5 = new JLabel("");
    label_5.setHorizontalAlignment(SwingConstants.LEFT);
    label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
    label_5.setBounds(243, 356, 181, 53);
    contentPane.add(label_5);
    
    conn = jConnectivity.ConnecrDb();
  }
}//end of sign in class



//  
//  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  setBounds(100, 100, 900, 643);
//  contentPane = new JPanel();
//  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//  setContentPane(contentPane);
//  contentPane.setLayout(null);
//  JPanel panel = new JPanel();
//  panel.setBackground(new Color(128, 0, 128));
//  panel.setForeground(new Color(128, 0, 128));
//  panel.setBounds(0, 0, 450, 596);
//  contentPane.add(panel);
//  panel.setLayout(null);
//  
//  JPanel panel_1 = new JPanel();
//  panel_1.setBackground(new Color(105, 105, 105));
//  panel_1.setBounds(447, 0, 435, 596);
//  contentPane.add(panel_1);
//  panel_1.setLayout(null);
//  
//  JLabel inLabel = new JLabel("Sign up");
//  inLabel.setFont(new Font("Century Gothic", Font.PLAIN, 23));
//  inLabel.setBounds(175, 157, 83, 34);
//  inLabel.setForeground(new Color(240, 248, 255));
//  panel_1.add(inLabel);
//  
//  JLabel lblUsername = new JLabel("Username:");
//  lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 18));
//  lblUsername.setForeground(new Color(240, 255, 255));
//  lblUsername.setBounds(71, 232, 101, 34);
//  panel_1.add(lblUsername);
//  
//  JLabel lblPassword = new JLabel("Password:");
//  lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 18));
//  lblPassword.setForeground(new Color(240, 255, 255));
//  lblPassword.setBounds(71, 299, 111, 41);
//  panel_1.add(lblPassword);
//  
//  JLabel lblAge = new JLabel("Age:");
//  lblAge.setFont(new Font("Century Gothic", Font.PLAIN, 18));
//  lblAge.setForeground(new Color(240, 255, 255));
//  lblAge.setBounds(71, 366, 101, 34);
//  panel_1.add(lblAge);
//  
//  JLabel lblMail = new JLabel("E-mail:");
//  lblMail.setFont(new Font("Century Gothic", Font.PLAIN, 18));
//  lblMail.setForeground(new Color(240, 255, 255));
//  lblMail.setBounds(71, 422, 111, 41);
//  panel_1.add(lblMail);
//  
//  JSeparator separator = new JSeparator();
//  separator.setBounds(71, 294, 315, 2);
//  panel_1.add(separator);
//  
//  JSeparator separator_1 = new JSeparator();
//  separator_1.setBounds(71, 363, 315, 2);
//  panel_1.add(separator_1);
//  
//  JSeparator separator_2 = new JSeparator();
//  separator_2.setBounds(71, 422, 315, 2);
//  panel_1.add(separator_2);
//  
//  JSeparator separator_3 = new JSeparator();
//  separator_3.setBounds(71, 476, 315, 2);
//  panel_1.add(separator_3);
//  
//  unameField = new JTextField();
//  unameField.setBackground(new Color(105, 105, 105));
//  unameField.setForeground(new Color(255, 255, 255));
//  unameField.setBounds(71, 268, 298, 22);
//  panel_1.add(unameField);
//  unameField.setColumns(10);
//  unameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//  
//  passField = new JPasswordField();
//  passField.setBackground(new Color(105, 105, 105));
//  passField.setForeground(new Color(255, 255, 255));
//  passField.setBounds(71, 338, 298, 22);
//  panel_1.add(passField);
//  passField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//  
//  ageField = new JTextField();
//  ageField.setBackground(new Color(105, 105, 105));
//  ageField.setForeground(new Color(255, 255, 255));
//  ageField.setBounds(71, 396, 298, 22);
//  panel_1.add(ageField);
//  ageField.setColumns(10);
//  ageField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//  
//  mailField = new JTextField();
//  mailField.setForeground(new Color(255, 255, 255));
//  mailField.setBackground(new Color(105, 105, 105));
//  mailField.setBounds(71, 452, 298, 22);
//  panel_1.add(mailField);
//  mailField.setColumns(10);
//  mailField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//  
//  JButton btnSignup = new JButton("Signup");
//  btnSignup.addActionListener(new ActionListener() {
//   public void actionPerformed(ActionEvent arg0) {
//    String sql = "INSERT INTO Users.UserAccount(id,username, password, age, mail) values(?,?,?,?,?)"; 
//    try{
//     pst = conn.prepareStatement(sql);
//     pst.setString(1,"0");
//     pst.setString(2, unameField.getText() );
//     pst.setString(3, passField.getText() );
//     pst.setString(4, ageField.getText() );
//     pst.setString(5, mailField.getText() );
//     pst.execute();
//      System.out.println("Registered"); 
//    }catch( Exception e){
//     JOptionPane.showMessageDialog(null, e);
//    }
//   }
//  });
//  btnSignup.setBounds(175, 502, 97, 25);
//  panel_1.add(btnSignup);
//  
//  JLabel lblNewLabel = new JLabel("Already have an account?");
//  lblNewLabel.addMouseListener(new MouseAdapter() {
//   @Override
//   public void mousePressed(MouseEvent arg0) {
//    
//   }
//  });
//  lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
//  lblNewLabel.setForeground(new Color(255, 255, 255));
//  lblNewLabel.setBounds(140, 540, 209, 22);
//  panel_1.add(lblNewLabel);
    
//  txtSurname = new JTextField();
//  txtSurname.setText("surname");
//  txtSurname.setColumns(10);
//  txtSurname.setBounds(482, 309, 188, 36);
//  contentPane.add(txtSurname);
