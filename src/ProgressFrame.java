import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.*;
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
import javax.swing.JTextPane;
public class ProgressFrame extends JFrame {
  
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
          ProgressFrame frame = new ProgressFrame();
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
  public ProgressFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1015, 930);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 250, 205));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setBounds(100, 100, 900, 800);
    setContentPane(contentPane);
    contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("src/GWAGimages/progress.png"));
    label.setBounds(50, 50, 860, 200);
    contentPane.add(label);
    double[] values = new double[3];
    String[] names = new String[3];
    values[0] = 70;
    names[0] = "Last 3rd Game";

    values[1] = 100;
    names[1] = "Last 2nd Game";

    values[2] = 1;
    names[2] = "Last Game";

    
    JLabel back = new JLabel("");
    back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
    back.setBounds(94, 591, 165, 66);
    
   JTextPane gamesWon = new JTextPane();
    gamesWon.setText("Games won: ");
    gamesWon.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
    gamesWon.setBackground(new Color(255, 250, 205));
    //txtpnEachOf.setBounds(131, 269, 455, 311);
    gamesWon.setEditable(false);
    //gamesWon = new JLabel("Games won: ");
    contentPane.add(gamesWon);
    contentPane.add(new ChartPanel(values, names, "Correct Answers' Percentage"));
    contentPane.add(back);
  }
}//end of sign in class