/**
 * __Non-GUI Square class
 * @author __Franc Gripshi, Ana Peçini___
 * @version __28/04/2017__
 */
import java.awt.*;

public class Test
{
  public static void main(String[] args)
  {
    GameBoard board = new GameBoard();
    Die die = new Die();
    
    Color red = new Color( 255 , 0 , 0);
    Color blue = new Color( 0 , 85 , 255);
   
    Pawn pawn1 = new Pawn( red );
    Pawn pawn2 = new Pawn( blue );
    
    Player pl1 = new Player( pawn1, "Franc");
    Player pl2 = new Player( pawn2, "Ana");
    
    Game game = new Game( pl1, pl2);
//    
//    System.out.println( game.turnOf());
//    System.out.println( pl1.getPawn().getSquareNumber() );
//    game.next();
//    System.out.println( pl1.getPawn().getSquareNumber() );
//    
//    System.out.println("Turn " + game.turnOf());
//    System.out.println( pl2.getPawn().getSquareNumber() );
//    game.next();
//    System.out.println( pl2.getPawn().getSquareNumber() );
//    System.out.println( "Turn " + game.turnOf());
//    
//    System.out.println( "Pl1 : " + pl1.getPawn().getSquareNumber() );
//    game.next();
//    System.out.println( "Pl1 : " +  pl1.getPawn().getSquareNumber() );
//    
//    System.out.println("Turn " + game.turnOf());
//    System.out.println( "Pl2 : " + pl2.getPawn().getSquareNumber() );
//    game.next();
//    System.out.println( "Pl2 : " + pl2.getPawn().getSquareNumber() );
//    System.out.println( "Turn " + game.turnOf());
//    
    
    while ( !game.isGameOver() )
    {
//      System.out.println(game.getWinner());
      int tempTurn = game.turnOf() ; 
      System.out.println("Turn of " + tempTurn);
      System.out.println("Loc of player " + game.getPlayer(tempTurn).toString() + "   was :" + game.getPlayer(tempTurn).getPawnSquareNumber() );
      game.next(die.rollDie());
      System.out.println("Loc of player " + game.getPlayer(tempTurn).toString() + "  now is :" + game.getPlayer(tempTurn).getPawnSquareNumber() );
      System.out.println();
    }
    System.out.println( game.isGameOver() );
    System.out.println(game.getWinnerMessage());
  }
}