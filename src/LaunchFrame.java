/**
 * __Main Frame of the game. From here you can navigate anywhere in our game.
 * @author __GUI: Franc, Database Connection: Naisila and Mustafa, 
 * Functionality and navigation through game: Naisila, CMD call for 2 players and Server Client classes: Ana___
 * @version __12/05/2017__
 */
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.Point;
public class LaunchFrame extends JFrame {
  
  private JPanel contentPane;
  private SignUpPanel su;
  private WelcomePanel wp;
  private LoginPanel li;
  private MenuPanel mp;
  private OnePlayer op;
  private ProgressPanel pp;
  private InstructionPanel1 ip1;
  private InstructionPanel2 ip2;
  private InstructionPanel3 ip3;
  private BgPanel bg;
  private String txtFile;
  
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          LaunchFrame frame = new LaunchFrame();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
  /**
   * Create the frame.
   */
  public LaunchFrame() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage("src/GWAGimages/cursor.png");
    Cursor c = toolkit.createCustomCursor(image , new Point(LaunchFrame.this.getX(), 
                                                            LaunchFrame.this.getY()), "img");
    setCursor(c);
    setTitle("<Guess What And Go> by FAMNAY");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 50, 1015, 930);
    su = new SignUpPanel();
    wp = new WelcomePanel();
    li = new LoginPanel();
    mp = new MenuPanel();
    pp = new ProgressPanel();
    ip1 = new InstructionPanel1();
    ip2 = new InstructionPanel2();
    ip3 = new InstructionPanel3();
    bg = new BgPanel();
    try{
      op = new OnePlayer(new Player(new Pawn(Color.red), ""), "src/GWAGimages/sea1.jpg", "src/Questions.txt");
    }
    catch(IOException qqq){}
    contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 250, 205));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon("src/GWAGimages/title.png"));
    label.setBounds(180, 46, 863, 168);
    contentPane.add(label);
    
    JLabel slogan = new JLabel("");
    slogan.setIcon(new ImageIcon("src/GWAGimages/slogan.png"));
    slogan.setBounds(148, 213, 732, 168);
    contentPane.add(slogan);
    
    JButton logIn = new JButton("Log in");
    logIn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        LaunchFrame.this.setContentPane(li);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    logIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
    logIn.setBounds(148, 733, 254, 64);
    contentPane.add(logIn);
    
    JButton signUp = new JButton("Sign Up");
    signUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
        LaunchFrame.this.setContentPane(su);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    signUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
    signUp.setBounds(527, 733, 254, 64);
    contentPane.add(signUp);
    
    JLabel gameTimeImage = new JLabel("");
    gameTimeImage.setIcon(new ImageIcon("src/GWAGimages/gametime1.png"));
    gameTimeImage.setBounds(256, 415, 474, 272);
    contentPane.add(gameTimeImage);
    
    JLabel gameInfo = new JLabel("GAME INFO");
    gameInfo.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent arg0) {
        ip1.setMLBack(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            LaunchFrame.this.setContentPane(contentPane);
            LaunchFrame.this.invalidate();
            LaunchFrame.this.validate();
          }
        });
        LaunchFrame.this.setContentPane(ip1);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    gameInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
    gameInfo.setBounds(426, 841, 88, 21);
    contentPane.add(gameInfo);
    
    su.addAct(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String a = su.getpasswordField().getText();
        if(a.equals(su.getpasswordField_1().getText()) && !(su.gettextField_3().getText().equals("")) &&
           !(a.equals("")) && !(su.gettxtName().getText().equals("")) && !(su.gettxtAge().getText().equals("")) )
        {
          try 
          {
            int val = Integer.parseInt(su.gettxtAge().getText());
            
            String sql = "INSERT INTO Users.UserAccount(id,username, password, age, mail," + 
              "firstgame,secondgame,thirdgame,forthgame,fifthgame,win) values(?,?,?,?,?,?,?,?,?,?,?)";
            try{
              su.setpst(su.getconn().prepareStatement(sql));
              su.getpst().setString(1,"0");
              su.getpst().setString(2, su.gettextField_3().getText() );
              su.getpst().setString(3, su.getpasswordField().getText() );
              su.getpst().setString(4, su.gettxtAge().getText() );
              su.getpst().setString(5, su.gettxtName().getText() );
              su.getpst().setString(6, "0");
              su.getpst().setString(7, "0");
              su.getpst().setString(8, "0");
              su.getpst().setString(9, "0");
              su.getpst().setString(10, "0");
              su.getpst().setInt(11, 0);
              su.getpst().execute();
              System.out.println("Registered");
              wp.setAgeText(su.gettxtAge().getText());
              LaunchFrame.this.setContentPane(wp);
              LaunchFrame.this.invalidate();
              LaunchFrame.this.validate();
            }catch( Exception eee){
              JOptionPane.showMessageDialog(LaunchFrame.this, "Enter correct age, fill everything and check \n" + 
                                            "password and confirm password fields. ", "Hey GWAGER", 
                                            JOptionPane.PLAIN_MESSAGE);
            }
          }
          catch(NumberFormatException noFormatException) {
            JOptionPane.showMessageDialog(LaunchFrame.this, "Enter correct age. ", "Hey GWAGER", 
                                          JOptionPane.PLAIN_MESSAGE);
            System.out.println("Invalid");
          }
        }
        else
        {
          JOptionPane.showMessageDialog(LaunchFrame.this, "Fill everything and check password and confirm\n" + 
                                        " password fields. They have to match. ", "Hey GWAGER", 
                                        JOptionPane.PLAIN_MESSAGE);
        }
      }
    });
    li.addAct(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String sql = "select * from Users.UserAccount where username = ? and password = ?"; 
        try{
          li.setpst(li.getconn().prepareStatement(sql));
          li.getpst().setString(1, li.gettxtEnterUsername().getText() );
          li.getpst().setString(2, li.gettxtPassword().getText() );
          li.setrs(li.getpst().executeQuery());
          if( li.getrs().next()){
            li.setpst(li.getconn().prepareStatement("SELECT age FROM Users.UserAccount WHERE username = ?"));
            li.getpst().setString(1, li.gettxtEnterUsername().getText() );
            li.setrs2(li.getpst().executeQuery());
            if( li.getrs2().next()){
              li.setAgeOfUser(li.getrs2().getInt("age"));
            }
            mp.setName(li.gettxtEnterUsername().getText());
            mp.setAge(li.getAgeOfUser() + "");
            pp.setValues(mp.getStats());
            pp.setWin(mp.getWin(mp.getName()));
            LaunchFrame.this.setContentPane(mp);
            LaunchFrame.this.invalidate();
            LaunchFrame.this.validate();
            System.out.println("Successful");
          }
          else
          {
            JOptionPane.showMessageDialog(LaunchFrame.this, "Username and Password do not match.", "Hey GWAGER", 
                                          JOptionPane.PLAIN_MESSAGE);
            System.out.println("Username and Password does not match");
          } 
        }catch( Exception ee){
          JOptionPane.showMessageDialog(null, e);
        }
      }
    });
    
    li.setMLBack(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        LaunchFrame.this.setContentPane(LaunchFrame.this.contentPane);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    su.setMLBack(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        LaunchFrame.this.setContentPane(LaunchFrame.this.contentPane);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    mp.addActOnePlayer(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        LaunchFrame.this.setContentPane(bg);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    mp.addActTwoPlayer(new ActionListener() {
      public void actionPerformed(ActionEvent e) 
      {
        /////////////////////////// 
        try
        {
          Runtime.getRuntime().exec("cmd.exe /c start"); 
          Runtime.getRuntime().exec("cmd.exe /c start"); 
//         Runtime.getRuntime().exec("cmd.exe /c start"); 
          //set path=%path%;C:\Program Files\Java\jdk1.8.0_101\bin
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
        
        
        ////////////////////////// 
      }
    });
    
    bg.addMA(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if(bg.getBG() != null)
        {
          if(mp.getAge() < 11)
            txtFile = "src/Questions.txt";
          else if(mp.getAge() > 16)
            txtFile = "src/Questions3.txt";
          else
            txtFile = "src/Questions2.txt";
          
          try{
            op = new OnePlayer(new Player(new Pawn(Color.red), mp.getName()), bg.getBG(), txtFile);
            op.addML(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                if(!op.getGame().isGameOver())
                {
                  int reply = JOptionPane.showConfirmDialog(LaunchFrame.this, "Are you sure you want to quit the game?", 
                                                            "Hey GWAGER", JOptionPane.YES_NO_OPTION);
                  //restart if the user presses Yes option
                  if (reply == JOptionPane.YES_OPTION) 
                  {
                    op.setStats();
                    pp.setValues(op.getStats(mp.getName()));
                    pp.setWin(op.getWin(mp.getName()));
                    try{
                      op.stopDie();
                    }
                    catch(Exception tt){}
                    op.initComponents();
                    LaunchFrame.this.setContentPane(mp);
                    LaunchFrame.this.invalidate();
                    LaunchFrame.this.validate();
                  }
                }
                else
                {
                  op.setStats();
                  pp.setValues(op.getStats(mp.getName()));
                  pp.setWin(op.getWin(mp.getName()));
                  try{
                    op.stopDie();
                  }
                  catch(Exception tt){}
                  op.initComponents();
                  LaunchFrame.this.setContentPane(mp);
                  LaunchFrame.this.invalidate();
                  LaunchFrame.this.validate();
                }
              }
            });
          }
          catch(IOException qqq){}
          
          LaunchFrame.this.setContentPane(op);
          LaunchFrame.this.invalidate();
          LaunchFrame.this.validate();
        }
      }
    });
    
    //////////////////////////
    
    /////////////////////////////////////
    
    mp.addActProgress(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        LaunchFrame.this.setContentPane(pp);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    pp.addMSL(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        LaunchFrame.this.setContentPane(mp);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    
    
    ip1.setMLNext(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        LaunchFrame.this.setContentPane(ip2);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    ip2.setMLBack(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        LaunchFrame.this.setContentPane(ip1);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    ip2.setMLNext(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        LaunchFrame.this.setContentPane(ip3);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    ip3.setMLBack(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        LaunchFrame.this.setContentPane(ip2);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    wp.addMouse(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        mp.setName(su.gettextField_3().getText());
        mp.setAge(su.gettxtAge().getText());
        pp.setValues(mp.getStats());
        LaunchFrame.this.setContentPane(mp);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    ////////////////////
    mp.addActInstr(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        ip1.setMLBack(new MouseAdapter() {
          @Override
          public void mousePressed(MouseEvent e) {
            LaunchFrame.this.setContentPane(mp);
            LaunchFrame.this.invalidate();
            LaunchFrame.this.validate();
          }
        });
        LaunchFrame.this.setContentPane(ip1);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
    
    ////////////////////
    
    mp.addActLogOut(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        LaunchFrame.this.setContentPane(contentPane);
        LaunchFrame.this.invalidate();
        LaunchFrame.this.validate();
      }
    });
  }
}