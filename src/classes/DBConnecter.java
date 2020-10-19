/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmoud
 */
public class DBConnecter {
    
    public static Connection connectionDB () throws ClassNotFoundException, InstantiationException, IllegalAccessException {
          Connection conn=null;
        try {
            
           // DBConnecter.connServer();
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
          // String user="jasser",password="jasser",url="jdbc:derby:managedata;create=true;user=jasser;password=jasser",url2="jdbc:derby:newdbtest; create=true";
             
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/supervisordb","jasser","jasser");
         
            System.out.println("conn  mcheeeeeet :ppppppp");
            System.out.println(conn);
             return conn;
        }catch (SQLException ex) {
            Logger.getLogger(DBConnecter.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("conn  work not");
             return conn;
        }
    
     
}


public static void connServer() {
    String cmd="connect 'jdbc:derby://localhost:1527/supervisor';";
        try {
            // Run "netsh" Windows command
            Process process = Runtime.getRuntime().exec(cmd);

            // Get input streams
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Read command standard output
            String s;
            System.out.println("Standard output: ");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read command errors
            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}