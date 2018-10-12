/**
 * __Non-GUI Player class
 * @author __Franc Gripshi___
 * @version __28/04/2017__
 */
public class Player
{
  //properties
  private Pawn pawn;
  private String username;
  private double qAsked;
  private double qAnswered;
  
  //constructor
  public Player(Pawn pawn, String username)
  {
    this.pawn = pawn;
    this.username = username;
    qAsked = 0;
    qAnswered = 0;
  }
  
  //methods
  public void addQ()
  {
    qAsked = qAsked + 1;
  }
  
  public void addCorrect()
  {
    qAnswered = qAnswered + 1;
  }
  
  public String getGameInfo()
  {
    double info = qAnswered / qAsked;
    int it = (int)(info * 100);
    info = ((double)(it)) / 100;
    return it + "%, " + (int)(qAnswered) + "/" + (int)(qAsked);
  }
  
  public Pawn getPawn()
  {
    return this.pawn;
  }
  
  public void makeMove(int faceValue)
  {
    this.pawn.updateSquareNumber(faceValue);
  }
  
  public int getPawnSquareNumber()
  {
    return this.pawn.getSquareNumber();
  }
  
  public String toString()
  {
    return username;
  }
  
  
}