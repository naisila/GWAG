/**
 * __Non-GUI Square class
 * @author __Franc Gripshi___
 * @version __28/04/2017__
 */
public class SquareOnline
{
  //properties
  private boolean occupied1;
  private boolean occupied2;
  private int xLocation, yLocation;
  //private Question question;
  
  //constructor
  public SquareOnline(int x, int y)
  {
    xLocation = x;
    yLocation = y;
    occupied1 = false;
    occupied2 = false;
  }
  
  //methods
  public void setOccupied( int playerNumber, boolean occupy)
  {
    if (playerNumber == 0)
      occupied1 = occupy;
    else 
      occupied2 = occupy;
  }
  
  public boolean isOccupied(int playerNumber)
  {
    if (playerNumber == 0)
      return occupied1;
    else
      return occupied2;
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