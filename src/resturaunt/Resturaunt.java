package resturaunt;

import DB.DB;
import GUI.login;
import java.lang.*;
import java.sql.*;

public class Resturaunt {

    public static void main(String[] args) throws ClassNotFoundException {
        
        login log = new login();
        log.setLocation(500, 250);
        log.setSize(600, 400);
         log.setVisible(true);
         
    }
    
}
