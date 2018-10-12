/**
 * __Non-GUI Game class
 * @author __Franc Gripshi, Ana Peçini, Naisila Puka___
 * @version __01/05/2017__
 */
public class Game
{
  //properties
  private GameBoard board;
  private Die die;
  private Player[] players;
  private int turn;
  private int round;
  private int checkRound;
  
  //constructor
  public Game(Player player1, Player player2)
  {
    players = new Player[2];
    players[0] = player1;
    players[1] = player2;
    board = new GameBoard();
    die = new Die();
    turn = 0;
    round = 0;
    checkRound = 0;
  }
  
  //methods
  public int turnOf()
  {
    return turn;
  }
  public Player getTurnOf()
  {
    return players[turn];
  }
  public int getRound()
  {
    return round;
  }
  
  public void changeTurn()
  {
    if (this.turn == 0)
    {
      this.turn = 1;
    }
    else 
    {
      this.turn = 0;
    }
    if(checkRound == 0)
      checkRound++;
    else
    {
      checkRound = 0;
      round++;
    }
  }
  
  public void next(int i)
  {
    //this.players[this.turnOf()].makeMove(die.rollDie());
    this.players[this.turnOf()].makeMove(i);
    //board.setThisOccupied(players[turnOf()].getPawnSquareNumber(), true);
    //board.getOccupied().getPopUpQuestion(int questionTypeIndex)
    //players[turnOf()].makeMove(board.getOccupied().question.getMovesNumber());
    //board.getOccupied().setOccupied(false);
    //changeTurn();
  }
  
  public boolean isGameOver()
  {
    for(int g = 0; g < 2; g++)
    {
      if(players[g].getPawnSquareNumber() == GameBoard.NO_OF_SQUARES - 1)
        return true;
    }
    return false;
  }
  
  
  public Player getPlayer(int index)
  {
    if (index == 1 || index == 0)
      return this.players[index];
    else 
      return null;
  }
  
  public String getWinnerMessage()
  {
    String str = "";
    if (isGameOver())
    {
      if(players[0].getPawnSquareNumber() > players[1].getPawnSquareNumber())
        str = "Winner is : " + players[0].toString();
      else
        str = "Winner is : " + players[1].toString();
    }
    else 
    {
      str = "Game is not over yet";
    }
    return str;
  }
  
  public Player getWinner()
  {
    if(players[0].getPawnSquareNumber() > players[1].getPawnSquareNumber())
      return players[0];
    else
      return players[1];
  }
}