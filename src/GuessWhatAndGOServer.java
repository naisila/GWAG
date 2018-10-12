/**
 * __Guess What And Go Client class.
 * @author __Ana___
 * @version __12/05/2017__
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.Color;

public class GuessWhatAndGOServer
{
  
  /**
   * Runs the application. Pairs up clients that connect.
   */
  public static void main(String[] args) throws Exception {
    ServerSocket listener = new ServerSocket(8902);
    System.out.println("Guess What and Go Server is Running");
    
    try {
      while (true) {
        
        GameOnline game = new GameOnline();
        
        GameOnline.PlayerOnline player1 = game.new PlayerOnline(listener.accept(), 0);
        
        GameOnline.PlayerOnline player2 = game.new PlayerOnline(listener.accept(), 1);
        
        player1.setOpponent(player2);
        player2.setOpponent(player1);
        game.currentPlayer = player1;
        player1.start();
        player2.start();
        
      }
    } finally {
      listener.close();
    }
  }
}

class GameOnline
{
  public static final int NO_OF_SQUARES = 48;
  public static final int NO_OF_ROWS = 6;
  public static final int NO_OF_COLUMNS = 8;
  private GameBoardOnline board;
  PlayerOnline currentPlayer;
//  private PlayerOnline[] board = new PlayerOnline[NO_OF_SQUARES];
  public GameOnline()
  {
    board = new GameBoardOnline();
    board.getSquare(0).setOccupied(0,true);
    board.getSquare(0).setOccupied(1,true);
  }
   
  public boolean hasWinner()
  {
    return ( board.getSquare(NO_OF_SQUARES - 1).isOccupied(0) || board.getSquare(NO_OF_SQUARES - 1).isOccupied(1));
  }
  
  public synchronized boolean legalMove(int location, PlayerOnline player) {
    if (player == currentPlayer ) //&& board[location] == null) 
    {
//      board[location] = currentPlayer;
      player.currentIndex += location;
      board.getOccupied(player.playerNumber).setOccupied( player.playerNumber, false);
      board.getSquare(player.currentIndex).setOccupied(player.playerNumber, true);
      currentPlayer = currentPlayer.opponent;
      currentPlayer.otherPlayerMoved(location);
      return true;
    }
    return false;
  }
  
  class PlayerOnline extends Thread {
    int playerNumber;
//    String username;
    PlayerOnline opponent;
    Socket socket;
    BufferedReader input;
    PrintWriter output;
    private int currentIndex;
    
    public PlayerOnline(Socket socket, int playerNumber) {
      this.socket = socket;
      this.playerNumber = playerNumber;
      currentIndex = 0;
//      this.username = username;
      try {
        input = new BufferedReader(
                                   new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
        output.println("WELCOME " + playerNumber);
        output.println("MESSAGE Waiting for opponent to connect");
      } catch (IOException e) {
        System.out.println("Player disconnected: " + e);
      }
    
    } 
    
    /**
     * Handles the otherPlayerMoved message.
     */
    public void otherPlayerMoved(int location) {
      output.println("OPPONENT_MOVED " + location);
      if (hasWinner())
        output.println("DEFEAT");
    }
    
    public void setOpponent(PlayerOnline opponent)
    {
      this.opponent = opponent;
    }
    
      public void run() 
      {
        try 
        {
          // The thread is only started after everyone connects.
          output.println("MESSAGE All players connected");
          
          // Tell the first player that it is her turn.
          if (playerNumber == 0) {
            output.println("MESSAGE Your move");
          }
          
          // Repeatedly get commands from the client and process them.
          while (true) 
          {
            String command = input.readLine();
            if (command.startsWith("MOVE")) 
            {
              int location = Integer.parseInt(command.substring(5));
              if (legalMove(location, this))
              {
                output.println("VALID_MOVE " + location);
                if (hasWinner())
                  output.println("VICTORY");
                                 
              } 
              else
              {
                output.println("MESSAGE Not your turn");
              }
            }
            else if (command.startsWith("QUIT"))
            {
              return;
            }
          }
        } 
        catch (IOException e)
        {
          System.out.println("Player disconnected: " + e);
        } 
        finally 
        {
          try {socket.close();} catch (IOException e) {}
        }
      }
      
      
  }
}