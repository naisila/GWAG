import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BgPanel extends JPanel {
  
  private JLabel seaImage;
  private JLabel desertImage;
  private JLabel galaxyImage;
  private JLabel forestImage;
  private JRadioButton seaButton;
  private JRadioButton desertButton;
  private JRadioButton galaxyButton;
  private JRadioButton forestButton;
  private  ButtonGroup group;
 
  /**
   * Create the frame.
   */
  public BgPanel() {
    setBackground(new Color(255, 250, 205));
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);
    
    seaImage = new JLabel("New label");
    seaImage.setIcon(new ImageIcon("src/GWAGimages/sea1.jpg"));
    seaImage.setBounds(71, 88, 313, 250);
    add(seaImage);
    
    desertImage = new JLabel("");
    desertImage.setIcon(new ImageIcon("src/GWAGimages/desert1.jpg"));
    desertImage.setBounds(461, 88, 313, 250);
    add(desertImage);
    
    forestImage = new JLabel("New label");
    forestImage.setIcon(new ImageIcon("src/GWAGimages/forest1.jpg"));
    forestImage.setBounds(71, 443, 313, 250);
    add(forestImage);
    
    galaxyImage = new JLabel("");
    galaxyImage.setIcon(new ImageIcon("src/GWAGimages/space1.jpg"));
    galaxyImage.setBounds(461, 443, 313, 250);
    add(galaxyImage);
    
    seaButton = new JRadioButton("Sea");
    seaButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    seaButton.setBackground(new Color(255, 250, 205));
    seaButton.setBounds(114, 369, 224, 30);
    add(seaButton);
    
    desertButton = new JRadioButton("Desert");
    desertButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    desertButton.setBackground(new Color(255, 250, 205));
    desertButton.setBounds(509, 369, 224, 30);
    add(desertButton);
    
    forestButton = new JRadioButton("Forest");
    forestButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    forestButton.setBackground(new Color(255, 250, 205));
    forestButton.setBounds(114, 718, 224, 30);
    add(forestButton);
    
    galaxyButton = new JRadioButton("Galaxy");
    galaxyButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    galaxyButton.setBackground(new Color(255, 250, 205));
    galaxyButton.setBounds(509, 718, 224, 30);
    add(galaxyButton);
    
    JTextPane choseBackground = new JTextPane();
    choseBackground.setBackground(new Color(255, 250, 205));
    choseBackground.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
    choseBackground.setText("Choose your favorite background  :");
    choseBackground.setBounds(71, 28, 526, 45);
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
    nextImage.setBounds(804, 800, 170, 59);
    add(nextImage);
    
    group = new ButtonGroup();
    group.add(desertButton);
    group.add(forestButton);
    group.add(galaxyButton);
    group.add(seaButton);
  }
  public String getBG()
  {
    if(galaxyButton.isSelected())
      return "src/GWAGimages/space1.jpg";
    else if(forestButton.isSelected())
      return "src/GWAGimages/forest1.jpg";
    else if(desertButton.isSelected())
      return "src/GWAGimages/desert1.jpg";
    else if(seaButton.isSelected())
      return "src/GWAGimages/sea1.jpg";
    else
      return null;
  }
  
}