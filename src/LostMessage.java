/**
 * __JDialog which contains the loser messsage 
 * @author __Franc___
 * @version __12/05/2017__
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class LostMessage extends JDialog {
  
  private final JPanel contentPanel = new JPanel();
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      LostMessage dialog = new LostMessage();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Create the dialog.
   */
  public LostMessage() {
    setBounds(100, 100, 702, 447);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBackground(new Color(255, 250, 205));
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    {
      JLabel label = new JLabel("");
      label.setIcon(new ImageIcon("src/GWAGimages/ulost.png"));
      label.setBounds(26, 34, 339, 103);
      contentPanel.add(label);
    }
    {
      JLabel label = new JLabel("");
      label.setIcon(new ImageIcon("src/GWAGimages/tryagain.png"));
      label.setBounds(55, 148, 220, 76);
      contentPanel.add(label);
    }
    {
      JLabel label = new JLabel("");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setIcon(new ImageIcon("src/GWAGimages/littlecry.png"));
      label.setBounds(263, 123, 212, 286);
      contentPanel.add(label);
    }
    {
      JLabel label = new JLabel("");
      label.setIcon(new ImageIcon("src/GWAGimages/loserpawn.png"));
      label.setBounds(314, 93, 333, 274);
      contentPanel.add(label);
    }
    {
      JLabel label = new JLabel("");
      label.setIcon(new ImageIcon("src/GWAGimages/cryingcloud.png"));
      label.setBounds(285, 0, 335, 188);
      contentPanel.add(label);
    }
  }
  
}