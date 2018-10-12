/**
 * __JDialog which contains the winner messsage 
 * @author __Franc Gripshi___
 * @version __12/05/2017__
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
public class WinnerMessage extends JDialog {
  
  private final JPanel contentPanel = new JPanel();
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      WinnerMessage dialog = new WinnerMessage();
      //dialog.setBounds(200,200, 702, 447);
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Create the dialog.
   */
  public WinnerMessage() {
    setBounds(300, 200, 702, 447);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBackground(new Color(255, 250, 205));
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    
    JLabel congratulations = new JLabel("");
    congratulations.setIcon(new ImageIcon("src/GWAGimages/congrats.png"));
    congratulations.setBounds(10, 32, 325, 133);
    contentPanel.add(congratulations);
    
    JLabel youWon = new JLabel("");
    youWon.setIcon(new ImageIcon("src/GWAGimages/uwon.png"));
    youWon.setBounds(61, 170, 180, 84);
    contentPanel.add(youWon);
    
    JLabel sadPawn = new JLabel("");
    sadPawn.setIcon(new ImageIcon("src/GWAGimages/winnerpawn.png"));
    sadPawn.setBounds(227, 106, 318, 292);
    contentPanel.add(sadPawn);
    
    JLabel fireWork = new JLabel("");
    fireWork.setIcon(new ImageIcon("src/GWAGimages/firework.png"));
    fireWork.setBounds(0, 0, 676, 409);
    contentPanel.add(fireWork);
    Timer itsup = new Timer(7000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        WinnerMessage.this.dispose();
      }
    });
    itsup.setRepeats(false);
    itsup.start();
    itsup.setCoalesce(true);
  }
}