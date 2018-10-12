/**
 * __A class currently not in use for the game board
 * @author __Naisila Puka___
 * @version __30/04/2017__
 */
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;

public class BoardPanel extends JPanel
{
  //properties
  private BufferedImage img;
  private BufferedImage pawn1;
  private BufferedImage pawn2;
  
  //constructor
  public BoardPanel()
  {
    setPreferredSize(new Dimension(1000, 800));
    
    try 
    {
      img = ImageIO.read(new File("src/GWAGimages/background.jpg"));
    } catch(IOException e) 
    {
      e.printStackTrace();
    }
  }
  
  //methods
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 0, 0, 1000, 800, this);
//    g.drawImage(pawn1, 50, 0, 30, 70, this);
//    g.drawImage(pawn2, 80, 0, 30, 70, this);
  }
}