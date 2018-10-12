/**
 * __Panel which welcomes each user.
 * @author __Franc Gripshi___
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
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomePanel extends JPanel {
  private JLabel continueImage;
  private JTextPane txtpnYourAccountWas;
  
  /**
   * Create the panel.
   */
  public WelcomePanel() {
    setForeground(new Color(0, 0, 51));
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    JLabel welcomeImageLabel = new JLabel("");
    welcomeImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    welcomeImageLabel.setIcon(new ImageIcon("src/GWAGimages/welcome.png"));
    welcomeImageLabel.setBounds(118, 63, 742, 208);
    add(welcomeImageLabel);
    
    txtpnYourAccountWas = new JTextPane();
    txtpnYourAccountWas.setBackground(new Color(255, 250, 205));
    txtpnYourAccountWas.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
    txtpnYourAccountWas.setText("Your account was successfully created.\r\nYou are in [ Age ] Group Level.\r\nPress Continue to proceed.");
    txtpnYourAccountWas.setBounds(132, 330, 478, 208);
    txtpnYourAccountWas.setEditable(false);
    add(txtpnYourAccountWas);
    
    JLabel pawnImageLabel = new JLabel("");
    pawnImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    pawnImageLabel.setIcon(new ImageIcon("src/GWAGimages/smiley.png"));
    pawnImageLabel.setBounds(544, 292, 346, 325);
    add(pawnImageLabel);
    
    continueImage = new JLabel("");
//  continueImage.addMouseListener(new MouseAdapter() {
//   @Override
//   public void mousePressed(MouseEvent arg0) {
//   }
//  });
    continueImage.setIcon(new ImageIcon("src/GWAGimages/continue.png"));
    continueImage.setBounds(687, 659, 264, 72);
    add(continueImage);
  }
  
  public void addMouse(MouseAdapter mL)
  {
    continueImage.addMouseListener(mL);
  }
  
  public void setAgeText(String ageText)
  {
    txtpnYourAccountWas.setText("Your account was successfully created.\r\nYou are in age " + ageText +
                                " Group Level.\r\nPress Continue to proceed.");
  }
}