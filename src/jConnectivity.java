/**
 * __Class for creating connectivity to online MYSQL database
 * @author __Naisila Puka and Mustafa Bayraktar___
 * @version2.0 __27/03/2018__
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class jConnectivity {
  
  static Connection conn = null;
  static final String USER = "root" ;
  static final String PASS = "perstack1";
  
  public static Connection ConnecrDb(){
    try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://107.191.36.226:3306/Users", USER, PASS);
      System.out.println("Connected");
      return conn;
    }catch( SQLException se ){
      se.printStackTrace();
    }catch(Exception e){
      JOptionPane.showMessageDialog(null,e);
      return null;
    }
    return conn;
  }
}
