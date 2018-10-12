/**
 * __The panel which shows the progress of the player in the last 5 games.
 * @author __Naisila Puka___
 * @version __12/05/2017__
 */
import java.util.*;
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
public class ProgressPanel extends JPanel {
  
  private JPanel contentPane;
  private JTextField txtName;
  private JTextField txtSurname;
  private JTextField txtAge;
  private JTextField textField_3;
  private JPasswordField passwordField;
  private JPasswordField passwordField_1;
  private double[] values;
  private String[] names;
  private JLabel back;
  private JTextPane gamesWon;
  
  /**
   * Create the panel.
   */
  public ProgressPanel() {
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    //setBounds(100, 100, 900, 800);
    setLayout(new FlowLayout(FlowLayout.LEFT));
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("src/GWAGimages/progress.png"));
    //label.setBounds(50, 50, 860, 200);
    add(label);
    values = new double[5];
    names = new String[5];
    values[0] = 0;
    names[0] = "Last 5th Game";
    
    values[1] = 0;
    names[1] = "Last 4th Game";
    
    values[2] = 0;
    names[2] = "Last 3rd Game";
    
    values[3] = 0;
    names[3] = "Last 2nd Game";
    
    values[4] = 0;
    names[4] = "Last Game";
    
    back = new JLabel("");
    back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
    back.setBounds(94, 591, 165, 66);
    
    gamesWon = new JTextPane();
    gamesWon.setText("Games won: ");
    gamesWon.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
    gamesWon.setBackground(new Color(255, 250, 205));
    //txtpnEachOf.setBounds(131, 269, 455, 311);
    gamesWon.setEditable(false);
    //gamesWon = new JLabel("Games won: ");
    add(gamesWon);
    add(new ChartPanel(values, names, "Correct Answers' Percentage in Last 5 Games"));
    add(back);
  }
  public void setValues(ArrayList<String> valuess)
  {
    try{
      double first = Double.parseDouble(valuess.get(0).substring(0, valuess.get(0).indexOf('%')));
      values[4] = first ;
      names[4] = valuess.get(0);
    }
    catch(Exception e){
      values[4] = 0;
      names[4] = "Last Game";
    }
    try{
      double second = Double.parseDouble(valuess.get(1).substring(0, valuess.get(1).indexOf('%')));
      values[3] = second ;
      names[3] = valuess.get(1);
    }
    catch(Exception ee){
      values[3] = 0;
      names[3] = "Last 2nd Game";}
    try{
      double third = Double.parseDouble(valuess.get(2).substring(0, valuess.get(2).indexOf('%')));
      values[2] = third ;
      names[2] = valuess.get(2);
    }
    catch(Exception eee){
      values[2] = 0;
      names[2] = "Last 3rd Game";}
    try{
      double fourth = Double.parseDouble(valuess.get(3).substring(0, valuess.get(3).indexOf('%')));
      values[1] = fourth ;
      names[1] = valuess.get(3);
    }
    catch(Exception eeee){
      values[1] = 0;
      names[1] = "Last 4th Game";}
    try{
      double fifth = Double.parseDouble(valuess.get(4).substring(0, valuess.get(4).indexOf('%')));
      values[0] = fifth ;
      names[0] = valuess.get(4);
    }
    catch(Exception eeeee){
      values[0] = 0;
      names[0] = "Last 5th Game";}
  }
  public void addMSL(MouseAdapter msa)
  {
    back.addMouseListener(msa);
  }
  
  public void setWin(int winn)
  {
    gamesWon.setText("Games won: " + winn);
  }
}//end of sign in class