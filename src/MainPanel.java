/**
 * __A panel currently not in use. It was useful in the beginning to play two players in the same frame.
 * @author __Naisila Puka___
 * @version __30/04/2017__
 */
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;
import java.io.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
public class MainPanel extends JPanel
{
  //constants
  public static final int NAME_FONT = 15;
  
  //properties
  private String firstgame = "0";
  private String secondgame = "0";
  private String thirdgame = "0";
  private Connection conn = null;
  private PreparedStatement pst = null;
  private ResultSet rs = null;
  private Game                gameWithoutGui;
  private GameBoard           boardWithoutGui;
  private DiePanel            theDie;
  private BufferedImage       boardImage, pawn1, pawn2;
  private JLabel              pl1, pl2;
  private JPanel              playersPanel;
  private ArrayList<Question> questions;
  private Player              first, second;
  private Timer               timerForPawnMove;
  private Timer               timerForQuestionDelay;
  private char                posOrNeg;
  private int                 ptsPosOrNeg;
  private Question            randomQuestion;
  private QPanel              popup;  
  private QPanelPic           popup1;  
  private boolean             type = false;
  private ActionListener      submit, giveUp;
  private ArrayList<Integer>  used;
  private JLabel             back;
  
  //constructor
  public MainPanel(Player p1, Player p2) throws IOException
  {
    setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    //setPreferredSize(new Dimension(1000, 900));
    setBackground(new Color(255, 250, 205));
    
    first = p1;
    second = p2;
    initComponents();
    addBellsnWhistles();
    
  }
  
  //methods
  public void initComponents()
  {
    gameWithoutGui = new Game(first, second);
    boardWithoutGui = new GameBoard();
    theDie = new DiePanel();
    
    back = new JLabel("");
    back.setIcon(new ImageIcon("src/GWAGimages/back.png"));
    JLabel tt = new JLabel("");
    tt.setIcon(new ImageIcon("src/GWAGimages/smalltitle.png"));
    add(back);
    add(theDie);
    
    try {
      boardImage = ImageIO.read(new File("src/GWAGimages/sea.jpg"));
    } catch(IOException e) {
      e.printStackTrace();
    }
    try {
      pawn1 = ImageIO.read(new File("src/GWAGimages/blue_pawn.png"));
    } catch(IOException e) {
      e.printStackTrace();
    }
    try {
      pawn2 = ImageIO.read(new File("src/GWAGimages/green_pawn.png"));
    } catch(IOException e) {
      e.printStackTrace();
    }
    
    pl1 = new JLabel(first.toString());
    pl2 = new JLabel(second.toString());
    pl1.setFont(new Font("Arial", Font.BOLD, NAME_FONT));
    pl2.setFont(new Font("Arial", Font.BOLD, NAME_FONT));
    pl1.setOpaque(true);
    pl1.setBackground(Color.CYAN);
    pl2.setOpaque(true);
    pl2.setBackground(Color.LIGHT_GRAY);
    
    JLabel picLabel1 = new JLabel(new ImageIcon(pawn1));
    JLabel picLabel2 = new JLabel(new ImageIcon(pawn2));
    playersPanel = new JPanel();
    playersPanel.add(picLabel1);
    playersPanel.add(pl1);
    playersPanel.add(picLabel2);
    playersPanel.add(pl2);
    add(playersPanel);
    add(tt);
    //theDie.setLocation(800, 600);
  }//end of initComponents
  
  public void addBellsnWhistles()
  {
    used = new ArrayList<Integer>();
    theDie.getDieButton().addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        theDie.getDieButton().setEnabled(false);
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
              timerForPawnMove = new Timer(200, new ActionListener() {
                int move = 0;
                public void actionPerformed(ActionEvent evt) {
                  gameWithoutGui.next(1);
                  MainPanel.this.repaint();
                  move++;
                  if(move == theDie.getDie())
                    timerForPawnMove.stop();
                }
              });
              
              timerForPawnMove.start();
              MainPanel.this.repaint();
              
              EventQueue.invokeLater(new Runnable() {
                public void run() {
                  timerForQuestionDelay = new Timer(1400, new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      displayPopUpQuestion();
                      gameWithoutGui.getTurnOf().addQ();
                    }
                  });
                  timerForQuestionDelay.setRepeats(false);
                  timerForQuestionDelay.start();
                  timerForQuestionDelay.setCoalesce(true);
                }//end of run
              });//end of invokeLater
            }//end of if statement
          }//end of action performed in the Die
        }));//end of theDie.setTimer
        theDie.getTimer().start();
      }//end of action performed in the roll button 
    });//end of actionListener
  }//end of addBellsnWhistles
  
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
    setBackground(new Color(255, 250, 205));
    g.drawImage(boardImage, 0, 100, 1000, 800, this);
    g.drawImage(pawn1, boardWithoutGui.getSquare(gameWithoutGui.getPlayer(0).getPawnSquareNumber()).getX() + 39, 
                boardWithoutGui.getSquare(gameWithoutGui.getPlayer(0).getPawnSquareNumber()).getY() + 110, 30, 
                70, this);
    g.drawImage(pawn2, boardWithoutGui.getSquare(gameWithoutGui.getPlayer(1).getPawnSquareNumber()).getX() + 72, 
                boardWithoutGui.getSquare(gameWithoutGui.getPlayer(1).getPawnSquareNumber()).getY() + 110, 30, 
                70, this);
  }
  
  private void displayPopUpQuestion() 
  {
    final MainPanel thisPanel = this;
    
    if(gameWithoutGui.getRound() % 2 == 0)
    {
      posOrNeg = '+';
      ptsPosOrNeg = 2;
    }
    else
    {
      posOrNeg = '-';
      ptsPosOrNeg = 0;
    }
    
    JInternalFrame dialog = new JInternalFrame("Question! (" + posOrNeg + ")");
    
    dialog.addInternalFrameListener(new InternalFrameAdapter() {
      @Override
      public void internalFrameClosed(InternalFrameEvent arg0) {
        thisPanel.requestFocusInWindow();
      }
    });
    
    try
    {
      type = getOneQuestion();
    }
    catch(IOException er){}
    if(type == false)
      popup = new QPanel(randomQuestion, ptsPosOrNeg);
    else 
      popup1 = new QPanelPic((PictureCompletionQuestion)randomQuestion, ptsPosOrNeg);
    
    submit = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
        dialog.dispose();
        timerForPawnMove = new Timer(200, new ActionListener() {
          //int movee = popup.getQ().getPoints();
          int m = 0;
          public void actionPerformed(ActionEvent evt) {
            
            int movee;
            if(type == false)
              movee = popup.getQ().getPoints();
            else 
              movee = popup1.getQ().getPoints();
            if(movee == ptsPosOrNeg)
              gameWithoutGui.getTurnOf().addCorrect();
            if(movee == 0)
            {
              timerForPawnMove.stop();
              changeTheTurn();
            }
            else
            {
              gameWithoutGui.next(movee / 2);
              MainPanel.this.repaint();
              m = m + (movee / 2) ;
              if(m == movee)
              {
                timerForPawnMove.stop();
                changeTheTurn();
              }
            }
          }
        });
        
        timerForPawnMove.start();
        MainPanel.this.repaint();
        theDie.getDieButton().setEnabled(true);
        //questions.clear();
      }
    };
    
    giveUp = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
        dialog.dispose();
        timerForQuestionDelay = new Timer(200, new ActionListener() {
          int movee = ptsPosOrNeg - 2;
          int m = 0;
          public void actionPerformed(ActionEvent evt) {
            if(movee == 0)
            {
              timerForQuestionDelay.stop();
              changeTheTurn();
            }
            else
            {
              gameWithoutGui.next(movee / 2);
              MainPanel.this.repaint();
              m = m + (movee / 2) ;
              if(m == movee)
              {
                timerForQuestionDelay.stop();
                changeTheTurn();
              }
            }
          }
        });
        
        timerForQuestionDelay.start();
        MainPanel.this.repaint();
        theDie.getDieButton().setEnabled(true);
        //questions.clear();
      }
    };
    
    if(type == false)
      popup.adAct(submit, giveUp);
    else 
      popup1.adAct(submit, giveUp);
    
    dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    dialog.setPreferredSize(new Dimension(750, 600));
    if(type == false)
      dialog.setContentPane(popup);
    else 
      dialog.setContentPane(popup1);
    //dialog.setContentPane(popup);
    
    dialog.setVisible(true);
    MainPanel.this.add(dialog);
  }
  
  private boolean getOneQuestion() throws IOException, FileNotFoundException 
  {
    //int q = 49;
    
    int q = (int) (Math.random() * 51) + 1;
    while(checkUsed(q))
      q = (int) (Math.random() * 51) + 1;
    String s = "src/Questions.txt";
    used.add(q);
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
  
  public void changeTheTurn()
  {
    gameWithoutGui.changeTurn();
    if ( gameWithoutGui.turnOf() == 0 )
    {
      pl1.setBackground(Color.CYAN);
      pl2.setBackground(Color.LIGHT_GRAY);
    }
    else
    {
      pl1.setBackground(Color.LIGHT_GRAY);
      pl2.setBackground(Color.CYAN);
    }
  }
  
  public boolean checkUsed(int qq)
  {
    for(int i = 0; i < used.size(); i++)
    {
      if(used.get(i) == qq)
        return true;
    }
    return false;
  }
  
  public void setStats( String newStat, String userr )  
  {
    conn = jConnectivity.ConnecrDb();
    String query = "select firstgame, secondgame from Users.UserAccount where username = ?";
    try {
      pst = conn.prepareStatement(query);
      pst.setString(1, userr);
      rs = pst.executeQuery();
      if (rs.next()) {
        firstgame = rs.getString("firstgame");
        secondgame = rs.getString("secondgame");
        
      }
      thirdgame = secondgame;
      secondgame = firstgame;
      firstgame = newStat;
    }catch( Exception e){
      JOptionPane.showMessageDialog(null, e);
    } 
    query = "UPDATE Users.UserAccount SET firstgame = ?, secondgame = ?, thirdgame = ? WHERE username = ? ";
    try {
      pst = conn.prepareStatement(query);
      pst.setString(1, firstgame);
      pst.setString(2, secondgame);
      pst.setString(3, thirdgame);
      pst.setString(4, userr);
      pst.execute();
    } catch( Exception e){
      JOptionPane.showMessageDialog(null, e);
    }
  }//end of setStats
} //end of MainPanel class 