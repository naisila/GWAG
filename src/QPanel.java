/**
 * __The panel for Multiple choice questions.
 * @author __Naisila Puka___
 * @version __12/05/2017__
 */
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;
import java.io.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
public class QPanel extends JPanel
{
  private JButton btnSubmit;
  private JButton btnGiveUp;
  private Question q;
  private JButton btnNewButton;
  private JButton button;
  private JButton button_1;
  private JButton button_2;
  private JLabel lblNewLabel_1;
  private JLabel lblNewLabel_2;
  private JTextArea txtrCalciumOxideIs;
  private int a,b,c,d;
  private BufferedImage sel;
  private int timee = 25;
  private Timer timer;
  public QPanel(Question qe, int pts)
  {
    a = 0;
    b =0;
    c=0;
    d=0;
    String imgg;
    if(pts == 2)
      imgg = "minion";
    else
      imgg = "police";
    try {
      sel = ImageIO.read(new File("src/GWAGimages/puzzleBorder.gif"));
    } catch(IOException e) {
      e.printStackTrace();
    }
    
    q = qe;
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(38, 81, 668, 2);
    add(separator);
    
    
    JSeparator separator_2 = new JSeparator();
    separator_2.setBounds(38, 331, 668, 2);
    add(separator_2);
    
    btnSubmit = new JButton("Submit");
    btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
    btnSubmit.setBounds(484, 339, 106, 38);
    btnSubmit.setEnabled(false);
    add(btnSubmit);
    
    btnNewButton = new JButton();
    btnNewButton.setText(q.getQuestionOptions().get(0));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if(q.getCorrectOptionIndex() == 0)
          q.setPoints(pts);
        else
          q.setPoints(pts - 2);
        a =  31;
        b = 262;
        c = 161;
        d = 64;
        repaint();
        btnSubmit.setEnabled(true);
      }
    });
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
    btnNewButton.setBounds(38, 268, 144, 53);
    add(btnNewButton);
    
    button = new JButton();
    button.setText(q.getQuestionOptions().get(1));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(q.getCorrectOptionIndex() == 1)
          q.setPoints(pts);
        else
          q.setPoints(pts - 2);
        a =  204;
        b = 262;
        c = 161;
        d = 64;
        repaint();
        btnSubmit.setEnabled(true);
      }
    });
    button.setFont(new Font("Tahoma", Font.PLAIN, 15));
    button.setBounds(211, 268, 144, 53);
    add(button);
    
    button_1 = new JButton();
    button_1.setText(q.getQuestionOptions().get(2));
    button_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(q.getCorrectOptionIndex() == 2)
          q.setPoints(pts);
        else
          q.setPoints(pts - 2);
        a =  384;
        b = 262;
        c = 161;
        d = 64;
        repaint();
        btnSubmit.setEnabled(true);
      }
    });
    button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    button_1.setBounds(391, 268, 144, 53);
    add(button_1);
    
    button_2 = new JButton();
    button_2.setText(q.getQuestionOptions().get(3));
    button_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(q.getCorrectOptionIndex() == 3)
          q.setPoints(pts);
        else
          q.setPoints(pts - 2);
        a =  555;
        b = 262;
        c = 161;
        d = 64;
        repaint();
        btnSubmit.setEnabled(true);
      }
    });
    button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    button_2.setBounds(562, 268, 144, 53);
    add(button_2);
    
    
    
    btnGiveUp = new JButton("Give up");
//      btnGiveUp.addMouseListener(new MouseAdapter() {
//   public void MousePressed(MouseEvent e) {
//     q.setPoints(pts - 2);
//   }
//  });
    btnGiveUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
    btnGiveUp.setBounds(600, 339, 106, 38);
    add(btnGiveUp);
    
    lblNewLabel_1 = new JLabel("New label");
    lblNewLabel_1.setIcon(new ImageIcon("src/GWAGimages/" + imgg + ".png"));
    lblNewLabel_1.setBounds(10, 11, 106, 72);
    add(lblNewLabel_1);
    
    lblNewLabel_2 = new JLabel("2");
    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
    lblNewLabel_2.setBounds(126, 20, 89, 44);
    add(lblNewLabel_2);
    
    txtrCalciumOxideIs = new JTextArea();
    txtrCalciumOxideIs.setBackground(new Color(255, 250, 205));
    txtrCalciumOxideIs.setFont(new Font("Tahoma", Font.PLAIN, 17));
    
    txtrCalciumOxideIs.setLineWrap(true);
    txtrCalciumOxideIs.setWrapStyleWord(true);
    txtrCalciumOxideIs.setText(q.getQuestion());
    txtrCalciumOxideIs.setBounds(38, 111, 683, 130);
    txtrCalciumOxideIs.setEditable(false);
    add(txtrCalciumOxideIs);
    
    JLabel time = new JLabel("Time left: 25 sec");
    time.setForeground(Color.red);
    time.setFont(new Font("Tahoma", Font.PLAIN, 28));
    time.setBounds(470, 0, 800, 130);
    add(time);
    
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
  public void adAct(ActionListener al, ActionListener alb)
  {
    btnSubmit.addActionListener(al);
    btnGiveUp.addActionListener(alb);
  }
  
  public Question getQ()
  {
    return q;
  }
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(sel, a, b, c, d, this);
  }
  
}