import java.awt.*;
import javax.swing.JFrame;
import java.io.*;
public class GameFrame extends JFrame
{
  public GameFrame()
  {
  setBounds(100, 100, 1000, 600);
  try
  {
    add(new MainPanel(new Player(new Pawn(Color.red), "Redi"), new Player(new Pawn(Color.red), "Naisila")));
  }
  catch(IOException e){}
    setVisible(true);
    setResizable(false);
    pack();}
}