/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author veysels
 */
@ManagedBean
@RequestScoped
public class DBconnection {

    /**
     * Creates a new instance of DBconnection
     */
      public Connection GetConnection() throws SQLException{
       Connection con;
       con=null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           String database="jdbc:mysql://localhost:3306/itfaiye";
           con = (Connection) DriverManager.getConnection(database,"root","veya2709");
        
       }catch(ClassNotFoundException | SQLException e)
       {
           JOptionPane.showMessageDialog(null, e.toString(), " ", JOptionPane.INFORMATION_MESSAGE);
       }
      return con;
        
    }

    public DBconnection() {
    }
    
    
    
}
