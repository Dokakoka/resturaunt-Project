package DB;

import DB.DB;
import java.sql.*;
import javax.swing.JOptionPane;

public class manageEmployee {
        private String username;
        private String pass;
        private int number;    
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    public void addEmployee (String username, String pass) {
        
        try {
            DB d = new DB();
            con = d.connect();
            String query = "INSERT INTO users (username, pass, roll_id) values(?, ?, 2)";
                         
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Inserted sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }   
        
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Insertion is failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        public void updateEmployee (String username, String pass, String value) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE users SET username = ?, pass = ? where id=" + value;
            
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);
          
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Updated sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public void deleteEmployee(String value) {
            int opt = JOptionPane.showConfirmDialog(null, "Are You sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt == 0) {

        try {
            DB d = new DB();
            con = d.connect();
            String query = "DELETE FROM USERS WHERE id=" + value;
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deleted sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        }
}