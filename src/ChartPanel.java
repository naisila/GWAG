/**
 * __Panel for creating a chart. It also has a main method to try it out with any values :)
 * @author __GUI and Functionality: Naisila___
 * @version __12/05/2017__
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartPanel extends JPanel {
  private double[] values;
  
  private String[] names;
  
  private String title;
  
  public ChartPanel(double[] v, String[] n, String t) {
    setBackground(new Color(255, 250, 205));
    setPreferredSize(new Dimension(830, 540));
    names = n;
    values = v;
    title = t;
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    if (values == null || values.length == 0)
      return;
    double minValue = 0;
    double maxValue = 100;
//    for (int i = 0; i < values.length; i++) {
//      if (minValue > values[i])
//        minValue = values[i];
//      if (maxValue < values[i])
//        maxValue = values[i];
//    }
    
    Dimension d = getSize();
    int clientWidth = 830;
    int clientHeight = 500;
    int barWidth = clientWidth / values.length;
    
    Font titleFont = new Font("Comic Sans MS", Font.BOLD, 20);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
    Font labelFont = new Font("Comic Sans MS", Font.PLAIN, 10);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
    
    int titleWidth = titleFontMetrics.stringWidth(title);
    int y = titleFontMetrics.getAscent();
    int x = (clientWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, x, y);
    g.drawLine(0, 28 , 830, 28);
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue)
      return;
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    y = clientHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    
    for (int i = 0; i < values.length; i++) {
      int valueX = i * barWidth + 1;
      int valueY = top;
      int height = (int) (values[i] * scale);
      if (values[i] >= 0)
        valueY += (int) ((maxValue - values[i]) * scale);
      else {
        valueY += (int) (maxValue * scale);
        height = -height;
      }
      
      if(i == 0)
        g.setColor(Color.magenta);
      else if(i == 1)
        g.setColor(Color.red);
      else if(i==2)
        g.setColor(Color.yellow);
      else if(i==3)
        g.setColor(Color.green);
      else if(i==4)
        g.setColor(Color.blue);
      g.fillRect(valueX, valueY, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueX, valueY, barWidth - 2, height);
      int labelWidth = labelFontMetrics.stringWidth(names[i]);
      x = i * barWidth + (barWidth - labelWidth) / 2;
      g.setFont(new Font("TimesRoman", Font.PLAIN, 14)); 
      g.drawString(names[i], x , y + 3);
      if(i == 0)
        g.drawString("Last 5th Game", x-17 , y + 20);
      else if(i == 1)
        g.drawString("Last 4th Game", x-17 , y + 20);
      else if(i == 2)
        g.drawString("Last 3rd Game", x-17 , y + 20);
      else if(i == 3)
        g.drawString("Last 2nd Game", x-17 , y + 20);
      else
        g.drawString("Last Game", x-17 , y + 20);
      
    }
  }
  
  public static void main(String[] argv) {
    JFrame f = new JFrame();
    f.setSize(400, 300);
    double[] values = new double[3];
    String[] names = new String[3];
    values[0] = 70;
    names[0] = "Item 1";
    
    values[1] = 85;
    names[1] = "Item 2";
    
    values[2] = 65;
    names[2] = "Item 3";
    
    f.add(new ChartPanel(values, names, "Correct Answers' Percentage"));
    
    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    f.addWindowListener(wndCloser);
    f.setVisible(true);
  }
}
