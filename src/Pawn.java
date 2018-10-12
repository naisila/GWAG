/**
 * __Non-GUI Pawn class
 * @author __Ana Pecini___
 * @version __28/04/2017__
 */
import java.awt.Color;
public class Pawn
{
  //properties
  private int squareNumber;
  private Color color;
  
  //constructor  
  public Pawn(Color pawnColor)
  {
    this.color = pawnColor;
    this.squareNumber = 0;
  }
  
  //methods
  public int getSquareNumber()
  {
    return this.squareNumber;
  }
  
  public void updateSquareNumber(int faceValue)
  {
    int a = squareNumber + faceValue;
    if(a > GameBoard.NO_OF_SQUARES - 1)
      squareNumber = GameBoard.NO_OF_SQUARES - 1;
    else if(a <= 0)
      squareNumber = 0;
    else
      squareNumber = a;
  }
}