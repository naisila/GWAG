/**
 * __Non-GUI GameBoard class
 * @author __Franc Gripshi, Ana Peçini___
 * @version __01/05/2017__
 */
public class GameBoardOnline
{
  //constants
  public static final int NO_OF_SQUARES = 48;
  public static final int NO_OF_ROWS = 6;
  public static final int NO_OF_COLUMNS = 8;
  
  //properties
  SquareOnline[] squares = new SquareOnline[NO_OF_SQUARES];
  
  //constructor by Franc
  public GameBoardOnline()
  {
    int i = 0;
    int j = 0;
    boolean right = true;
    
    for(int row = 0; row < NO_OF_ROWS; row++)
    {
      if ( right )
      {
        for(int col = 0; col < NO_OF_COLUMNS; col++)
        {
          squares[row * NO_OF_COLUMNS + col] = new SquareOnline(i, j);
          i = i + 125;
        }
        right = false;
      }
      else
      {
        i = 875;
        for(int col = 0; col < NO_OF_COLUMNS; col++)
        {
          squares[row * NO_OF_COLUMNS + col] = new SquareOnline(i, j);
          i = i - 125;
        }
        right = true;
      }
      i = 0;
      j = j + 133;
    }
  }
  
  
  
  //methods
  
  public SquareOnline[] getSquares()
  {
    return squares;
  }
  
  public SquareOnline getSquare(int i)
  {
    if (i >= 0 && i < 48) 
      return squares[i];
    else  if ( i >= 48)
      return squares[47];
    return squares[0];
  }
  
  //currently not in use
//  public boolean setThisOccupied(int squareNumber, boolean occupyThis)
//  {
//    if(squareNumber > -1 && squareNumber < NO_OF_SQUARES)
//    {
//      squares[squareNumber].setOccupied(occupyThis);
//      return true;
//    }
//    return false;
//  }
  
  //currently not in use
  public SquareOnline getOccupied(int playerNumber)
  {
    for(int i = 0; i < NO_OF_SQUARES; i++)
    {
      if(squares[i].isOccupied(playerNumber) == true)
        return squares[i];
    }
    return null;
  }
  
//  public int getOccupiedIndex(int playerNumber)
//  {
//    for(int i = 0; i < NO_OF_SQUARES; i++)
//    {
//      if(squares[i].isOccupied(playerNumber) == true)
//        return i;
//    }
//    return -1;
//  }
//  
    
  //another way to write the code for the constructor by Ana
  //  public GameBoard()
//  {
//    squares = new Square[NO_OF_SQUARES];
//    int x = 0;
//    int y = 0;
//    int row = 1;
//    for (int j = 0 ; j <= NO_OF_SQUARES - 1; j = j + 8)
//    {
//      for (int i = j; i < row * NO_OF_COLUMNS; i++)
//      {
//        squares[i] = new Square(x,y);
//        if ( i != row * NO_OF_COLUMNS - 1)
//        {
//          if (row % 2 == 1)
//          {
//            x = x + 100;
//          }
//          else 
//          {
//            x = x - 100;
//          }
//        }
//      }
//      y = y + 100; 
//      row ++;
//    }
//  }
  
  
  //  //for test purpose
//  public static void main(String[] args)
//  {
//     GameBoard board = new GameBoard();
//     Square[] sq = (board.getSquares()).clone();
//     
//     for ( int i = 0; i < sq.length; i++)
//     {
//       System.out.println( i + " coordinate of X :  " + sq[i].getX() + " coordinate of Y :  " + sq[i].getY());
//     }
//     
//  }
//  
}