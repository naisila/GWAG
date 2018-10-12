/**
 * __Guess What And Go Client class.
 * @author __Ana___
 * @version __12/05/2017__
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;
import java.io.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuessWhatAndGOClient 
{
  private JFrame frame = new JFrame("Guess What and GO");
  
  private JLabel messageLabel = new JLabel("");
  
//  private ImageIcon icon;
//  private ImageIcon opponentIcon;
  private JPanel gamePanel; 
  
  public static final int NAME_FONT = 15;
  
  
  private GameBoardOnline     board;
  private DiePanel            theDie;
  private BufferedImage       boardImage;
  private ImageIcon           pawn1;
  private ImageIcon           pawn2;
  private JLabel              pl1, pl2;
  private JPanel              playersPanel;
  private ArrayList<Question> questions;
  private Player              first, second;
  private Timer               timerForPawnMove, pop, pop1;
  private Timer               timerForQuestionDelay, itsup;
  private char                posOrNeg;
  private int                 ptsPosOrNeg;
  private Question            randomQuestion;
  private QPanelOnline        popup;  
  private QPanelPicOnline     popup1;  
  private ActionListener      submit, giveUp;
  private int                 playerNumber;
  private ImageLabel          pawn1Label;
  private ImageLabel          pawn2Label;
  private ImagePanel          boardPanel;
  private JFrame      dialog;
  private boolean             type;
  
  private SquareOnline currentSquare1;
  private SquareOnline currentSquare2;
  private int currentSquareIndex1;
  private int currentSquareIndex2;
  
  private static int PORT = 8902;
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private int move;
  
  /**
   * Runs the client as an application.
   */
  public static void main(String[] args) throws Exception 
  {
    
    while (true)
    {
      String serverAddress = (args.length == 0) ? "localhost" : args[1];
      GuessWhatAndGOClient client = new GuessWhatAndGOClient(serverAddress);
      client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      client.frame.setSize(1015, 930);
      client.frame.setVisible(true);
      client.frame.setResizable(false);
      client.play();
      if (!client.wantsToPlayAgain()) 
      {
        break;
      }
    }
  }//end of main method
  
  public GuessWhatAndGOClient(String serverAddress) throws Exception {
    
    // Setup networking
    socket = new Socket(serverAddress, PORT);
    in = new BufferedReader(new InputStreamReader(
                                                  socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);
    messageLabel.setBackground(Color.lightGray);
    frame.setLayout(new FlowLayout());
    theDie = new DiePanel();
    frame.add(theDie);
    frame.add(messageLabel);
    messageLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
    board = new GameBoardOnline();
    currentSquareIndex1 = 0;
    currentSquareIndex2 = 0;
    
//    theDie.getDieButton().setEnabled(false);
    try {
      boardImage = ImageIO.read(getClass().getResourceAsStream("GWAGimages/galaxy.jpg"));
    } catch(IOException e) {
      e.printStackTrace();
    }
    
    boardPanel = new ImagePanel(boardImage);
    boardPanel.setLayout(null);
    frame.add(boardPanel);
    addBellsnWhistles();
  }
  
  class ImagePanel extends JPanel {
    private Image image;
    public ImagePanel(Image image) {
      setPreferredSize(new Dimension(1000, 800));
      this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(image, 0, 0, 1000, 800, this);
    }
  }
  
  class ImageLabel extends JLabel 
  {
    public ImageLabel(String img)
    {
      this(new ImageIcon(img));
    }
    
    public ImageLabel(ImageIcon icon)
    {
      setIcon(icon);
      // setMargin(new Insets(0,0,0,0));
      setIconTextGap(0);
      // setBorderPainted(false);
      setBorder(null);
      setText(null);
      setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
    }
  }
  
  
  
  public void addBellsnWhistles()
  {
    theDie.getDieButton().addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent event) {
//        theDie.getDieButton().setEnabled(false);
        if (theDie.getTimer() != null)
        {
          return;
        }
        theDie.setTimer(new Timer(100, new ActionListener() {
          int picChange = 1;
          public void actionPerformed(ActionEvent e){
            theDie.setDie(( int )( Math.random() *  6) + 1);
            theDie.repaint();
            picChange++;
            
            if (picChange == 10) 
            {
              theDie.getTimer().stop();
              theDie.setTimer(null);
              theDie.repaint();
              
              move = theDie.getDie();
              
              displayPopUpQuestion();
             
            }//end of if statement
          }//end of action performed in the Die
        }));//end of theDie.setTimer
        theDie.getTimer().start();
        
      }//end of action performed in the roll button 
    });//end of actionListener
  }
  
  public void play() throws Exception 
  {
    String response;
    try {
      
      response = in.readLine();
      if (response.startsWith("WELCOME")) {
        
        playerNumber = Integer.parseInt(response.substring(8,9));
        if ( playerNumber == 0)
        {
          try {
            pawn1 = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("GWAGimages/blue_pawn.png")));
            pawn1Label =new ImageLabel(pawn1);
          } catch(IOException e) {
            e.printStackTrace();
            
          }
          try {
            pawn2 = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("GWAGimages/green_pawn.png")));
            pawn2Label =new ImageLabel(pawn2);
          } catch(IOException e) {
            e.printStackTrace();
          }
          
        }
        else 
        {
          try {
            pawn1 = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("GWAGimages/green_pawn.png")));
            pawn1Label =new ImageLabel(pawn1);
//            pawn1Label.setLocation(39, 107);
//            boardPanel.add(pawn1Label);
          } catch(IOException e) {
            e.printStackTrace();
          }
          try {
            pawn2 = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("GWAGimages/blue_pawn.png")));
            pawn2Label =new ImageLabel(pawn2);
//            pawn2Label.setLocation(55, 107);
//            boardPanel.add(pawn2Label);
          } catch(IOException e) {
            e.printStackTrace();
          }
          theDie.getDieButton().setEnabled(false);
        }
        pawn1Label.setLocation(32, 10);
        boardPanel.add(pawn1Label);
        pawn2Label.setLocation(65, 10);
        boardPanel.add(pawn2Label);
        frame.setTitle("Guess What and GO - Player " + playerNumber);
      }
      while (true) {
        response = in.readLine();
        if (response.startsWith("VALID_MOVE")) {
          messageLabel.setText("Move completed, please wait");
          theDie.getDieButton().setEnabled(false);
          int m = Integer.parseInt(response.substring(11,12));
          
          pop = new Timer(300, new ActionListener() {
            int mprim = 0;
            public void actionPerformed(ActionEvent e)
            {
              mprim++;
              if(mprim <= m)
                pawn1Label.setLocation(65 + board.getSquare(currentSquareIndex1 + mprim).getX(), 
                                       10 + board.getSquare(currentSquareIndex1 + mprim).getY());
              else
               {
                pop.stop();
                currentSquareIndex1 += m;
          currentSquare1 = board.getSquare(currentSquareIndex1);
          pawn1Label.setLocation(65 + currentSquare1.getX(), 10 + currentSquare1.getY());
              }
            }//end of action performed in the Die
          });
          pop.start();
        } 
        else if (response.startsWith("OPPONENT_MOVED")) {
          messageLabel.setText("Opponent moved, your turn");
          theDie.getDieButton().setEnabled(true);
          int m2 = Integer.parseInt(response.substring(15,16));
          
          pop1 = new Timer(300, new ActionListener() {
            int mprim2 = 0;
            public void actionPerformed(ActionEvent e)
            {
              mprim2++;
              if(mprim2 <= m2)
                pawn2Label.setLocation(32 + board.getSquare(currentSquareIndex2 + mprim2).getX(), 
                                       10 + board.getSquare(currentSquareIndex2 + mprim2).getY());
              else
              {
                pop1.stop();
                currentSquareIndex2 += m2;
          currentSquare2 = board.getSquare(currentSquareIndex2);
          pawn2Label.setLocation(32 + currentSquare2.getX(), 10 + currentSquare2.getY());
              }
            }//end of action performed in the Die
          });
          pop1.start();
//          frame.repaint();
        } 
        else if (response.startsWith("VICTORY")) {
          messageLabel.setText("You win");
          break;
        } 
        else if (response.startsWith("DEFEAT")) {
          messageLabel.setText("You lose");
          break;
        } 
        else if (response.startsWith("MESSAGE")) {
          messageLabel.setText(response.substring(8));
        }
      }
      out.println("QUIT");
    }
    finally {
      socket.close();
    }
  }
  
  
  private boolean wantsToPlayAgain()
  {
    int response = JOptionPane.showConfirmDialog(frame,
                                                 "Want to play again?",
                                                 "Guess What and Go",
                                                 JOptionPane.YES_NO_OPTION);
    frame.dispose();
    return response == JOptionPane.YES_OPTION;
  }//end of wantsToPlayAgain method
  
  private boolean getOneQuestion() throws IOException, FileNotFoundException 
  {
    //int q = 49;
    
    int q = (int) (Math.random() * 51) + 1;
    String s = "QuestionsOnline.txt";
    if(q >= 37)
    {
      randomQuestion = new PictureCompletionQuestion();
      randomQuestion.getQuestion(s, q);
      return true;
    }
    else
    {
      randomQuestion = new Question();
      randomQuestion.getQuestion(s, q);
      return false;
    }
  }
  
  
  private void displayPopUpQuestion() 
  {
    //final JFrame thisFrame = GuessWhatAndGOClient.this.frame;

      posOrNeg = '+';
      ptsPosOrNeg = 2;

//    
    dialog = new JFrame("Question! " + posOrNeg);//(" + posOrNeg + ")");
    
//    dialog.addInternalFrameListener(new InternalFrameAdapter() {
//      @Override
//      public void internalFrameClosed(InternalFrameEvent arg0) {
//        thisFrame.requestFocusInWindow();
//      }
//    });
//    
    try
    {
      type = getOneQuestion();
      randomQuestion.setPoints(ptsPosOrNeg - 2);
    }
    catch(IOException er){}
    if(type == false)
      popup = new QPanelOnline(randomQuestion, ptsPosOrNeg);
    else 
      popup1 = new QPanelPicOnline((PictureCompletionQuestion)randomQuestion, ptsPosOrNeg);
    submit = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        itsup.stop();
        dialog.dispose();
        move = move + randomQuestion.getPoints();
        out.println("MOVE " + move);
      }
    };
    
    giveUp = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        itsup.stop();
       randomQuestion.setPoints(0);
       dialog.dispose();
       
       out.println("MOVE " + move);
      }
    };
    if(type == false)
    {
      popup.adAct(submit, giveUp);
      popup.setBounds(0,0,750,600);
    }
    else 
    {
      popup1.adAct(submit, giveUp);
      popup1.setBounds(0,0,750,600);
    }
    dialog.setResizable(false);
    dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    dialog.setSize(750, 600);
    //dialog.setLayout(null);
    if(type == false)
      dialog.setContentPane(popup);
    else 
      dialog.setContentPane(popup1);
    //dialog.setContentPane(popup);
    
    dialog.setVisible(true);
    itsup = new Timer(20000, new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
        out.println("MOVE " + move);
      }
    });
    itsup.setRepeats(false);
    itsup.start();
    itsup.setCoalesce(true);
    //GuessWhatAndGOClient.this.frame.add(dialog);
  }
  
}