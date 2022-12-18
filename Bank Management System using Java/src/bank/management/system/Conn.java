/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.sql.*;

public class Conn {
    
     //globally created
        Connection conn;
        Statement stmt;
    public Conn()
    {
        //try catch for avoiding error
        try
        {
//           1. Register JDBC Driver − This step causes the JVM to load the desired 
//            driver implementation into memory so it can fulfill your JDBC requests.
            Class.forName("com.mysql.cj.jdbc.Driver");
            
//          2. Create connecteion connection = drivermanager.getConnection(url, username, pswd);
            conn = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "30140603");
            stmt = conn.createStatement();
        }

        catch(Exception e)
        {
            System.out.print(e);
        }
    }
}
