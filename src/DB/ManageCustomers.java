package DB;

import DB.DB;
import GUI3.customer;
import GUI3.loyalityMarket;
import GUI3.market;
import java.sql.*;
import javax.swing.JOptionPane;

public class ManageCustomers {
        private String username;
        private String pass;
        private int number;
        private int money;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;    

    public void addCustomer (String username, String password) {
            try {
                DB d = new DB();
                con = d.connect();
                String query = "INSERT INTO customers (customer_name, customer_password) values(?, ?)";
                pst = con.prepareStatement(query);
                pst.setString(1, username);
                
                pst.setString(2, password);
                JOptionPane.showMessageDialog(null,"Registered sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                pst.executeUpdate();
        }   
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}

        
        public void deleteCustomer(String value) {
            int opt = JOptionPane.showConfirmDialog(null, "Are You sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt == 0) {

        try {
            DB d = new DB();
            con = d.connect();
            
            String query = "DELETE FROM customers WHERE id=" + value;
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deleted sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        }
        
        public void updateCustomer(String username, String pass, String value) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE customers SET customer_name = ?, customer_password = ? where id=" + value;
            
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
        
        public void selectCustomerType(String customer_type) {
            
            if(customer_type.equals("loyality")){
                new loyalityMarket().setVisible(true);
            }
        
        else{
            new market().setVisible(true);
        }
        }
        
        public void addMoney(Double money, int value) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE customers SET money += ? where id=" + value;
            
            pst = con.prepareStatement(query);
            pst.setDouble(1, money);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Updated sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public boolean checkOrders(String value, double money, double total_money, double moneyNumber) {
            
            try {
                if(total_money > money) {
                    DB d = new DB();
                    con = d.connect();

                    String query = "Update customers set money += ? where id=" + value;

                    pst = con.prepareStatement(query);
                    pst.setDouble(1, moneyNumber);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Updated sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                else {
                    JOptionPane.showMessageDialog(null,"This customer doesn't get the specific range of payments " + money, "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            return false;
        }
        
        public void updateLoyality(String value, int number_of_orders, int number) {
            
            try{
                if(number_of_orders > number) {
                    DB d = new DB();
                    con = d.connect();

                    String query = "Update customers set customer_type = 'loyality' where id=" + value;

                    pst = con.prepareStatement(query);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"This will be a loyality customer", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"This customer doesn't get the specific number of orders: " + number, "Sucess", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public void updateEmail(String email, String password, int id) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE customers SET email = ?, email_password = ? where id=" + id;
            
            pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"You will recieve an email", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public void updateEmployeeEmail(String email, String password, int id) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE users SET email = ?, email_password = ? where id=" + id;
            
            pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"You will recieve an email", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public void registeration(int id) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE customers SET register = 'true' where id=" + id;
            
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"You will recieve an email soon", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public void addReward (String customer_id, double reward_price) {
            try {
                DB d = new DB();
                con = d.connect();
                String query = "INSERT INTO rewards (customer_id, reward_price) values(?, ?)";
                pst = con.prepareStatement(query);
                
                pst.setString(1, customer_id);
                pst.setDouble(2, reward_price);
                
                JOptionPane.showMessageDialog(null,"Registered sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                pst.executeUpdate();
        }   
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
        
}