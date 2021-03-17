package DB;

import DB.DB;
import DB.employee;
import GUI.*;
import GUI2.*;
import GUI3.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login {
    private String name;
    private String pass;
    private int Roll_id;
    
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement pst = null;
    
    public void sigin (String name, String pass, int Roll_id) throws SQLException
    {   
        try {
                DB d = new DB();
                con = d.connect();
                String query = "Select * from users where username = ? and pass = ? and Roll_id = ?" ;

                pst = con.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, pass);
                pst.setInt(3, Roll_id);
                rs = pst.executeQuery();
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(rs.next()) { 
                    
                    if( name.equals(rs.getString("username")) && pass.equals(rs.getString("pass")) && rs.getInt("Roll_id") == 1 ) {

                        JOptionPane.showMessageDialog(null,"Username and password is correct", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        new admin().setVisible(true);
                    }

                    else if( name.equals(rs.getString("username")) && pass.equals(rs.getString("pass")) && rs.getInt("Roll_id") == 2 ) {

                        JOptionPane.showMessageDialog(null,"Username and password is correct", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        new employee().setVisible(true);
                        orders.getEmployeeID = rs.getInt("id");
                        updateEmployee.getID = rs.getInt("id");
                        emailUpdate.getID = rs.getInt("id");
                        
                    }
                  
                }
        else {
                        JOptionPane.showMessageDialog(null,"Username and password is uncorrect", "Error", JOptionPane.ERROR_MESSAGE);
                        new login().setVisible(true);
        }                
        }
    
    public void customerLogin(String name, String pass) {
        try {
                DB d = new DB();
                con = d.connect();
                String query = "Select * from customers where customer_name = ? and customer_password = ?" ;

                pst = con.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, pass);
                
                rs = pst.executeQuery();
               
               if(rs.next()) { 
                if( name.equals(rs.getString("customer_name")) && pass.equals(rs.getString("customer_password"))) {

                        JOptionPane.showMessageDialog(null,"Username and password is correct", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        new customer().setVisible(true);
                        
                        CustomerLoyality.getID = rs.getInt("id");
                        market.getID = rs.getInt("id");
                        loyalityMarket.getID = rs.getInt("id");
                        notificationCenter.getID = rs.getInt("id");
                        rewardProfile.getID = rs.getInt("id");
                        mealsProfile.getID = rs.getInt("id");
                        customer.getCustomerType = rs.getString("customer_type");
                        loyalityMarket.customer_type = rs.getString("customer_type");
                        market.customer_type = rs.getString("customer_type");
                        offerProfile.getID = rs.getInt("id");
                    }
                    
               }
               else {
                        JOptionPane.showMessageDialog(null,"Username and password is uncorrect", "Error", JOptionPane.ERROR_MESSAGE);
                        new login().setVisible(true);
                }
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void customerLoyalityLogin(String name, String pass){
        try {
                DB d = new DB();
                con = d.connect();
                String query = "Select * from customers where customer_name = ? and customer_password = ?" ;

                pst = con.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, pass);
                
                rs = pst.executeQuery();
               
               if(rs.next()) { 
                if( name.equals(rs.getString("customer_name")) && pass.equals(rs.getString("customer_password"))) {

                        JOptionPane.showMessageDialog(null,"Username and password is correct", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    
               }
               else {
                        JOptionPane.showMessageDialog(null,"Username and password is uncorrect", "Error", JOptionPane.ERROR_MESSAGE);
                }
               
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
    public int Roll (String name) {
        if(name.equals("Admin")){
            return 1;
        }
        else if(name.equals("Employee")){
            return 2;
        }
        else if(name.equals("Customer")){
            return 3;
        }
        
        return 0;
    }         
    }