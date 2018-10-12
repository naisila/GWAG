import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChooseBgPanel extends JPanel {
  
  
  
  /**
   * Create the panel.
   */
  public ChooseBgPanel() {
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    JLabel seaImage = new JLabel("New label");
    seaImage.setIcon(new ImageIcon("src/GWAGimages/sea1.png"));
    seaImage.setBounds(71, 78, 313, 250);
    add(seaImage);
    
    JLabel desertImage = new JLabel("");
    desertImage.setIcon(new ImageIcon("src/GWAGimages/desert1.png"));
    desertImage.setBounds(461, 78, 313, 250);
    add(desertImage);
    
    JLabel forestImage = new JLabel("New label");
    forestImage.setIcon(new ImageIcon("src/GWAGimages/forest1.png"));
    forestImage.setBounds(71, 433, 313, 250);
    add(forestImage);
    
    JLabel galaxyImage = new JLabel("");
    galaxyImage.setIcon(new ImageIcon("src/GWAGimages/space1.png"));
    galaxyImage.setBounds(461, 433, 313, 250);
    add(galaxyImage);
    
    JRadioButton seaButton = new JRadioButton("Sea");
    seaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    seaButton.setBackground(new Color(255, 250, 205));
    seaButton.setBounds(114, 359, 224, 30);
    add(seaButton);
    
    JRadioButton desertButton = new JRadioButton("Desert");
    desertButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    desertButton.setBackground(new Color(255, 250, 205));
    desertButton.setBounds(509, 359, 224, 30);
    add(desertButton);
    
    JRadioButton forestButton = new JRadioButton("Forest");
    forestButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    forestButton.setBackground(new Color(255, 250, 205));
    forestButton.setBounds(114, 708, 224, 30);
    add(forestButton);
    
    JRadioButton galaxyButton = new JRadioButton("Galaxy");
    galaxyButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    galaxyButton.setBackground(new Color(255, 250, 205));
    galaxyButton.setBounds(509, 708, 224, 30);
    add(galaxyButton);
    
    JTextPane choseBackground = new JTextPane();
    choseBackground.setBackground(new Color(255, 250, 205));
    choseBackground.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
    choseBackground.setText("Choose your favorite background  :");
    choseBackground.setBounds(71, 22, 526, 45);
    choseBackground.setEditable(false);
    add(choseBackground);
    
    JLabel nextImage = new JLabel("");
    nextImage.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
      }
    });
    nextImage.setHorizontalAlignment(SwingConstants.LEFT);
    nextImage.setIcon(new ImageIcon("src/GWAGimages/nextchoosebg.png"));
    nextImage.setBounds(804, 692, 170, 59);
    add(nextImage);
  }
}