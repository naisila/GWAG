/**
 * __Non-GUI Square class
 * @author __Franc Gripshi___
 * @version __28/04/2017__
 */
public class Square
{
  //properties
  private boolean occupied;
  private int xLocation, yLocation;
  //private Question question;
  
  //constructor
  public Square(int x, int y)
  {
    xLocation = x;
    yLocation = y;
    occupied = false;
  }
  
  //methods
  public void setOccupied( boolean occupy)
  {
    occupied = occupy;
  }
  
  public boolean isOccupied()
  {
    return occupied;
  }
  
//  public Question getPopUpQuestion(int questionTypeIndex)
//  {
//  }
  
  public int getX()
  {
    return xLocation;
  }
  
  public int getY()
  {
    return yLocation;
  }
}