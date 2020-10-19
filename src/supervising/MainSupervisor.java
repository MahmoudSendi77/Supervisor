/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supervising;

import classes.DBConnecter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmoud
 */
public class MainSupervisor {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Connection conn=DBConnecter.connectionDB();
        
      jloggin j= new jloggin();
      j.setVisible(true);
    
    }
   
}
