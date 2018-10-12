/**
 * __Non-GUI Die class of the game
 * @author __Ana Pecini___
 * @version __30/04/2017__
 */
public class Die
{
  //method
  public int rollDie()
  {
    int facevalue = (int)(6 * Math.random()) + 1;
    System.out.println("Face value of die : " + facevalue);
    return facevalue;
  }
}