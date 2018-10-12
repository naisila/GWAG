/**
 * __The menu panel of the game.
 * @author __Functionality: Naisila, GUI: Franc___
 * @version __12/05/2017__
 */
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class MenuPanel extends JPanel {
  private JLabel lblNewLabel_2;
  private JLabel lblNewLabel_4;
  private JButton btnNewButton;
  private JButton btnTwoPlayer;
  private JButton btnMyProgress;
  private String firstgame = "0";
  private String secondgame = "0";
  private String thirdgame = "0";
  private Connection conn = null;
  private PreparedStatement pst = null;
  private ResultSet rs = null;
  private JButton btnInstructions;
  private JButton btnLogOut;
  /**
   * Create the panel.
   */
  public MenuPanel()
  {
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    btnNewButton = new JButton("One Player");
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
    
    btnNewButton.setBounds(80, 300, 312, 68);
    add(btnNewButton);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("src/GWAGimages/MENU.png"));
    
    label.setBounds(80, 10, 420, 250);
    add(label);
    
    btnTwoPlayer = new JButton("Two Players");
    btnTwoPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnTwoPlayer.setBounds(80, 405, 312, 68);
    add(btnTwoPlayer);
    
    btnMyProgress = new JButton("My Progress");
    btnMyProgress.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnMyProgress.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnMyProgress.setBounds(80, 508, 312, 68);
    add(btnMyProgress);
    
    btnInstructions = new JButton("Instructions");
    
    btnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnInstructions.setBounds(80, 612, 312, 68);
    add(btnInstructions);
    
    btnLogOut = new JButton("Log Out");
    btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnLogOut.setBounds(80, 719, 312, 68);
    add(btnLogOut);
    
    JLabel label_1 = new JLabel("");
    label_1.setIcon(new ImageIcon("src/GWAGimages/dice-575658_960_720.png"));
    label_1.setBounds(540, 350, 412, 361);
    add(label_1);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBorder(null);
    panel_1.setBackground(new Color(255, 250, 205));
    panel_1.setBounds(650, 33, 273, 135);
    add(panel_1);
    panel_1.setLayout(null);
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setBounds(21, 0, 122, 135);
    panel_1.add(lblNewLabel);
    lblNewLabel.setIcon(new ImageIcon("src/GWAGimages/user.png"));
    //lblNewLabel.setIcon( new ImageIcon(Menu.class.getResource("src/GWAGimages/dice-575658_960_720.png")));
    
    lblNewLabel_2 = new JLabel("USERNAME");
    lblNewLabel_2.setForeground(Color.red);
    lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
    lblNewLabel_2.setBounds(165, 74, 166, 28);
    panel_1.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("AGE:");
    lblNewLabel_3.setForeground(Color.blue);
    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel_3.setBounds(165, 31, 76, 16);
    panel_1.add(lblNewLabel_3);
    
    lblNewLabel_4 = new JLabel("20");
    lblNewLabel_4.setForeground(Color.red);
    lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNewLabel_4.setBounds(213, 31, 76, 16);
    panel_1.add(lblNewLabel_4);
  }
  public void setName(String name)
  {
    lblNewLabel_2.setText(name);
  }
  public void setAge(String age)
  {
    lblNewLabel_4.setText(age);
  }
  public int getAge()
  {
    return Integer.parseInt(lblNewLabel_4.getText());
  }
  public void addActOnePlayer(ActionListener aL)
  {
    btnNewButton.addActionListener(aL);
  }
  public void addActTwoPlayer(ActionListener aL)
  {
    btnTwoPlayer.addActionListener(aL);
  }
  public void addActProgress(ActionListener aL)
  {
    btnMyProgress.addActionListener(aL);
  }
  public void addActLogOut(ActionListener aL)
  {
    btnLogOut.addActionListener(aL);
  }
  public void addActInstr(ActionListener aL)
  {
    btnInstructions.addActionListener(aL);
  }
  public String getName()
  {
    return lblNewLabel_2.getText();
  }
  
  public ArrayList<String> getStats()
  {
    conn = jConnectivity.ConnecrDb();
    ArrayList<String> stats = new ArrayList <>();
    Statement stmt = null;
    String query = "select firstgame, secondgame, thirdgame, forthgame, fifthgame from Users.UserAccount where username = ?";
    
    try {
      pst = conn.prepareStatement(query);
      pst.setString(1, lblNewLabel_2.getText());
      rs = pst.executeQuery();
      while (rs.next()) {           
        stats.add( rs.getString("firstgame") );
        stats.add( rs.getString("secondgame") );
        stats.add( rs.getString("thirdgame") );
        stats.add( rs.getString("forthgame") );
        stats.add( rs.getString("fifthgame") );
      }
    }catch( Exception e){
      JOptionPane.showMessageDialog(null, e);
    }
    
    return stats;
  }
  public int getWin(String name)
  {
    int win = 0;
    String query = "select win from Users.UserAccount where username = ?";
    try {
      pst = conn.prepareStatement(query);
      pst.setString(1, name);
      rs = pst.executeQuery();
      if (rs.next()) {
        win = rs.getInt("win");
      }}catch( Exception e){
        JOptionPane.showMessageDialog(null, e);
      }
      return win;
  }
}