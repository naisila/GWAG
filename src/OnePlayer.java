/**
 * __The panel of the game against the computer. It is one of the most crucial parts of the code.
 * @author __Functionality of class: Naisila, Question methods: Ana, Connectivity: Naisila and Mustafa, GUI: Franc___
 * @version __12/05/2017__
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
public class OnePlayer extends JPanel
{
  //constants
  public static final int NAME_FONT = 15;
  
  //properties
  private String firstgame = "0";
  private String secondgame = "0";
  private String thirdgame = "0";
  private String forthgame = "0";
  private String fifthgame= "0";
  private int win;
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
  private Timer               timerForQuestionDelay, itsup;
  private char                posOrNeg;
  private int                 ptsPosOrNeg;
  private Question            randomQuestion;
  private QPanel              popup;  
  private QPanelPic           popup1;  
  private boolean             type = false;
  private ActionListener      submit, giveUp;
  private ArrayList<Integer>  used;
  private JLabel              back;
  private JInternalFrame      dialog;
  private WinnerMessage       winMsg;
  private boolean             toSetStats = true;
  private String              bg;
  private String              txt;
  //constructor
  public OnePlayer(Player p1, String bG, String txt) throws IOException
  {
    this.bg = bG;
    setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    //setPreferredSize(new Dimension(1000, 900));
    setBackground(new Color(255, 250, 205));
    first = p1;
    second = new Player(new Pawn(Color.red), "computer");
    initComponents();
    addBellsnWhistles();
    this.txt = txt;
  }
  
  //methods
  public void initComponents()
  {
    toSetStats = true;
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
      boardImage = ImageIO.read(new File(bg));
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
    playersPanel.setBackground(new Color(255, 250, 205));
    add(playersPanel);
    add(tt);
    //theDie.setLocation(800, 600);
  }//end of initComponents
  public void stopDie()
  {
    theDie.getTimer().stop();
  }
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
                  OnePlayer.this.repaint();
                  move++;
                  if(move == theDie.getDie())
                    //if(move == 15)
                    timerForPawnMove.stop();
                }
              });
              
              timerForPawnMove.start();
              OnePlayer.this.repaint();
              //  if(!gameWithoutGui.isGameOver())
              
              if(gameWithoutGui.turnOf() == 0)
              {
                EventQueue.invokeLater(new Runnable() {
                  public void run() {
                    timerForQuestionDelay = new Timer(1400, new ActionListener() {
                      
                      @Override
                      public void actionPerformed(ActionEvent e) {
                        if(!gameWithoutGui.isGameOver())
                        {
                          displayPopUpQuestion();
                          gameWithoutGui.getTurnOf().addQ();
                        }
                        else
                        {
                          theDie.getDieButton().setEnabled(false);
                          if(gameWithoutGui.getWinner() == first)
                          {
                            setWin(first.toString(), true);
                            winMsg = new WinnerMessage();
                            winMsg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                            winMsg.setVisible(true);
                          }
                          else
                          {
                            JOptionPane.showMessageDialog(OnePlayer.this, gameWithoutGui.getWinnerMessage(), null, 
                                                          JOptionPane.PLAIN_MESSAGE, new ImageIcon("title1.png"));
                          }
                          setStats();
                          toSetStats = false;
                        }
                      }
                    });
                    timerForQuestionDelay.setRepeats(false);
                    timerForQuestionDelay.start();
                    timerForQuestionDelay.setCoalesce(true);
                  }//end of run
                });//end of invokeLater
              }//end of if statemtn if it is the player's turn
              else
              { 
                EventQueue.invokeLater(new Runnable() {
                  public void run() {
                    timerForQuestionDelay = new Timer(1400, new ActionListener() {
                      
                      @Override
                      public void actionPerformed(ActionEvent e) {
                        if(!gameWithoutGui.isGameOver())
                        {
                          changeTheTurn();
                          theDie.getDieButton().setEnabled(true);
                        }
                        else
                        {
                          theDie.getDieButton().setEnabled(false);
                          if(gameWithoutGui.getWinner() == first)
                          {
                            setWin(first.toString(), true);
                            winMsg = new WinnerMessage();
                            winMsg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                            winMsg.setVisible(true);
                          }
                          else
                          {
                            JOptionPane.showMessageDialog(OnePlayer.this, gameWithoutGui.getWinnerMessage(), null, 
                                                          JOptionPane.PLAIN_MESSAGE, new ImageIcon("title1.png"));
                          }
                          
                          setStats();
                          toSetStats = false;
                        }
                        //theDie.getDieButton().doClick();
                      }
                    });
                    timerForQuestionDelay.setRepeats(false);
                    timerForQuestionDelay.start();
                    timerForQuestionDelay.setCoalesce(true);
                  }//end of run
                });
                
              }//end of else
//                JOptionPane.showMessageDialog(OnePlayer.this, gameWithoutGui.getWinnerMessage(), null, 
//                                        JOptionPane.PLAIN_MESSAGE, new ImageIcon("title1.png"));
              
            }//end of if pic change is 10
          }//end of action performed in the Die
        }));//end of theDie.setTimer
        theDie.getTimer().start();
      }//end of action performed in the roll button 
    });//end of actionListener
  }//end of addBellsnWhistles
  
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
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
    final OnePlayer thisPanel = this;
    
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
    
    dialog = new JInternalFrame("Question! (" + posOrNeg + ")");
    
    dialog.addInternalFrameListener(new InternalFrameAdapter() {
      @Override
      public void internalFrameClosed(InternalFrameEvent arg0) {
        thisPanel.requestFocusInWindow();
      }
    });
    
    try
    {
      type = getOneQuestion();
      randomQuestion.setPoints(ptsPosOrNeg - 2);
    }
    catch(IOException er){}
    if(type == false)
      popup = new QPanel(randomQuestion, ptsPosOrNeg);
    else 
      popup1 = new QPanelPic((PictureCompletionQuestion)randomQuestion, ptsPosOrNeg);
    
    submit = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        itsup.stop();
        submitOrItsUp();
      }
    };
    
    giveUp = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        itsup.stop();
        dialog.setVisible(false);
        dialog.dispose();
        timerForQuestionDelay = new Timer(200, new ActionListener() {
          int movee = ptsPosOrNeg - 2;
          int m = 0;
          public void actionPerformed(ActionEvent evt) {
            if(movee == 0)
            {
              timerForQuestionDelay.stop();
              timerForQuestionDelay = new Timer(500, new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                  changeTheTurn();
                  theDie.getDieButton().setEnabled(true);
                  theDie.getDieButton().doClick();
                  //theDie.getDieButton().doClick();
                }
              });
              timerForQuestionDelay.setRepeats(false);
              timerForQuestionDelay.start();
              timerForQuestionDelay.setCoalesce(true);
            }
            else
            {
              gameWithoutGui.next(movee / 2);
              OnePlayer.this.repaint();
              m = m + (movee / 2) ;
              if(m == movee)
              {
                timerForQuestionDelay.stop();
                timerForQuestionDelay = new Timer(500, new ActionListener() {
                  
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    changeTheTurn();
                    theDie.getDieButton().setEnabled(true);
                    theDie.getDieButton().doClick();
                    //theDie.getDieButton().doClick();
                  }
                });
                timerForQuestionDelay.setRepeats(false);
                timerForQuestionDelay.start();
                timerForQuestionDelay.setCoalesce(true);
              }
            }
          }
        });
        
        timerForQuestionDelay.start();
        OnePlayer.this.repaint();
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
    itsup = new Timer(26000, new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        submitOrItsUp();
      }
    });
    itsup.setRepeats(false);
    itsup.start();
    itsup.setCoalesce(true);
    OnePlayer.this.add(dialog);
  }
  
  private boolean getOneQuestion() throws IOException, FileNotFoundException 
  {
    //int q = 49;
    
    int q = (int) (Math.random() * 84) + 1;
    while(checkUsed(q))
      q = (int) (Math.random() * 84) + 1;
    String s = txt;
    //String s = "src/Questions2.txt";
    used.add(q);
    if(q >= 60)
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
  
  public void setStats()  
  {
    if(toSetStats)
    {
      String newStat = first.getGameInfo();
      String userr = first.toString();
      conn = jConnectivity.ConnecrDb();
      String query = "select firstgame, secondgame, thirdgame, forthgame from Users.UserAccount where username = ?";
      try {
        pst = conn.prepareStatement(query);
        pst.setString(1, userr);
        rs = pst.executeQuery();
        if (rs.next()) {
          firstgame = rs.getString("firstgame");
          secondgame = rs.getString("secondgame");
          thirdgame = rs.getString("thirdgame");
          forthgame = rs.getString("forthgame");
        }
        fifthgame = forthgame;
        forthgame = thirdgame;
        thirdgame = secondgame;
        secondgame = firstgame;
        firstgame = newStat;
      }catch( Exception e){
        JOptionPane.showMessageDialog(null, e);
      } 
      query = "UPDATE Users.UserAccount SET firstgame = ?, secondgame = ?, thirdgame = ?, forthgame = ?, fifthgame = ? WHERE username = ? ";
      try {
        pst = conn.prepareStatement(query);
        pst.setString(1, firstgame);
        pst.setString(2, secondgame);
        pst.setString(3, thirdgame);
        pst.setString(4, forthgame);
        pst.setString(5, fifthgame);
        pst.setString(6, userr);
        pst.execute();
      } catch( Exception e){
        JOptionPane.showMessageDialog(null, e);
      }
    }
  }//end of setStats
  public ArrayList<String> getStats(String userr)
  {
    conn = jConnectivity.ConnecrDb();
    ArrayList<String> stats = new ArrayList <>();
    Statement stmt = null;
    String query = "select firstgame, secondgame, thirdgame, forthgame, fifthgame from Users.UserAccount where username = ?";
    
    try {
      pst = conn.prepareStatement(query);
      pst.setString(1, userr);
      rs = pst.executeQuery();
      while (rs.next()) {           
        stats.add( rs.getString("firstgame") );
        stats.add( rs.getString("secondgame") );
        stats.add( rs.getString("thirdgame") );
        stats.add( rs.getString("forthgame") );
        stats.add( rs.getString("fifthgame") );
      }
    }catch( Exception e){
      JOptionPane.showMessageDialog(null, e);
    }
    
    return stats;
  }
  
  public void setWin(String name, boolean winner)
  {
    if( winner )
    {
      
      conn = jConnectivity.ConnecrDb();
      String query = "select win from Users.UserAccount where username = ?";
      try {
        pst = conn.prepareStatement(query);
        pst.setString(1, name);
        rs = pst.executeQuery();
        if (rs.next()) {
          win = rs.getInt("win");
        }} catch( Exception e){
          JOptionPane.showMessageDialog(null, e);
        }
        win++;
        query = "UPDATE Users.UserAccount SET win = ? WHERE username = ? ";
        try {
          pst = conn.prepareStatement(query);
          pst.setInt(1, win);
          pst.setString(2, name);
          pst.execute();
        } catch( Exception ee){
          JOptionPane.showMessageDialog(null, ee);
        }
    }
  }
  
  public int getWin(String name)
  {
    String query = "select win from Users.UserAccount where username = ?";
    try {
      pst = conn.prepareStatement(query);
      pst.setString(1, name);
      rs = pst.executeQuery();
      if (rs.next()) {
        win = rs.getInt("win");
      }}catch( Exception e){
        JOptionPane.showMessageDialog(null, e);
      }
      return win;
  }
  
//  public void setPlayer(Player r)
//  {
//    first = r;
//  }
  public void addML(MouseAdapter mL)
  {
    back.addMouseListener(mL);
  }
  
  public Player getHuman()
  {
    return first;
  }
  public void submitOrItsUp()
  {
    dialog.setVisible(false);
    dialog.dispose();
    int movee;
    if(type == false)
      movee = popup.getQ().getPoints();
    else 
      movee = popup1.getQ().getPoints();
    if(movee == ptsPosOrNeg)
      OnePlayer.this.getHuman().addCorrect();
    timerForPawnMove = new Timer(200, new ActionListener() {
      //int movee = popup.getQ().getPoints();
      int m = 0;
      public void actionPerformed(ActionEvent evt) {
        if(movee == 0)
        {
          timerForPawnMove.stop();
          
          timerForQuestionDelay = new Timer(500, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
              changeTheTurn();
              theDie.getDieButton().setEnabled(true);
              theDie.getDieButton().doClick();
              //theDie.getDieButton().doClick();
            }
          });
          timerForQuestionDelay.setRepeats(false);
          timerForQuestionDelay.start();
          timerForQuestionDelay.setCoalesce(true);
        }
        else
        {
          gameWithoutGui.next(movee / 2);
          OnePlayer.this.repaint();
          m = m + (movee / 2) ;
          if(m == movee)
          {
            timerForPawnMove.stop();
            if(!gameWithoutGui.isGameOver())
            {
              
              timerForQuestionDelay = new Timer(500, new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                  changeTheTurn();
                  theDie.getDieButton().setEnabled(true);
                  theDie.getDieButton().doClick();
                }
              });
              timerForQuestionDelay.setRepeats(false);
              timerForQuestionDelay.start();
              timerForQuestionDelay.setCoalesce(true);
            }
            else
            {
              theDie.getDieButton().setEnabled(false);
              if(gameWithoutGui.getWinner() == first)
              {
                setWin(first.toString(), true);
                winMsg = new WinnerMessage();
                winMsg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                winMsg.setVisible(true);
              }
              else
              {
                JOptionPane.showMessageDialog(OnePlayer.this, gameWithoutGui.getWinnerMessage(), null, 
                                              JOptionPane.PLAIN_MESSAGE, new ImageIcon("title1.png"));
              }
              setStats();
              toSetStats = false;
            }
          }
        }
      }
    });
    
    timerForPawnMove.start();
    OnePlayer.this.repaint();
  }
  
  public Game getGame()
  {
    return gameWithoutGui;
  }
} //end of MainPanel class