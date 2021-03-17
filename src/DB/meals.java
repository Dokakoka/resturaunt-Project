package DB;

import DB.DB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class meals {
        private String username;
        private String pass;
        private int number;
        private float price;
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    
    public void addMeals(String meal_title, String descreption, double number, String meal_type) {
            try {
            DB d = new DB();
            con = d.connect();
            String query = "INSERT INTO meals (meal_title, descreption, price, meal_type) values(?, ?, ?, ?)";
                         
            pst = con.prepareStatement(query);
            pst.setString(1, meal_title);
            pst.setString(2, descreption);
            pst.setDouble(3, number);
            pst.setString(4, meal_type);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Inserted sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }   
        
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Insertion is failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        
        public void deleteMeals(String value) {
            int opt = JOptionPane.showConfirmDialog(null, "Are You sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt == 0) {

        try {
            DB d = new DB();
            con = d.connect();
            
            String query = "DELETE FROM meals WHERE id=" + value;
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deleted sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        }
        
        public void updateMeals(String meal_title, String descreption, double number, String value) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE meals SET meal_title = ?, descreption = ?, price = ? where id=" + value;
            
            pst = con.prepareStatement(query);
            pst.setString(1, meal_title);
            pst.setString(2, descreption);
            pst.setDouble(3, number);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Updated sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public float getMoney(int id) {
            try {
            
            DB d = new DB();
            con = d.connect();
            
            String query = "SELECT money FROM customers where id=" + id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()) {
                float money = rs.getFloat("money");
                return money;
            }
            
        }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        return 0;
        
        }
        
        public int checkPrice(float money, float price, String value) {
            try {
            
            DB d = new DB();
            con = d.connect();
            String query = "SELECT price FROM meals where id=" + value;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()) {
                
                if(money >= price ) {
                    JOptionPane.showMessageDialog(null,"You have money", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    return 1;
                } else {
                    JOptionPane.showMessageDialog(null,"You don't have enough money", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            }
        }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        return 0;
        }
        public void addOrders(String meal_title, float meal_price, int customer_id, String descreption, float total_bill, int order_id, String customer_type) {
    try {
            
            DB d = new DB();
            con = d.connect();
            String query = "INSERT INTO orders (meal_title, meal_price, customer_id, descreption, total_bill, order_id, customer_type) Values(?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, meal_title);
            pst.setFloat(2, meal_price);
            pst.setInt(3, customer_id);
            pst.setString(4, descreption);
            pst.setFloat(5, total_bill);
            pst.setInt(6, order_id);
            pst.setString(7, customer_type);
            pst.executeUpdate();
}
    catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
}
        
        public void deleteOrders(String value) {
    int opt = JOptionPane.showConfirmDialog(null, "Are You sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt == 0) {

        try {
            DB d = new DB();
            con = d.connect();
            
            String query = "DELETE FROM orders WHERE id=" + value;
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deleted sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
}
        public void setEmployeeID(int id, String value) {

        try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE orders set employee_id = ? WHERE id=" + value;
            pst = con.prepareStatement(query);
            
            pst.setInt(1, id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Updated sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }

        public void checkout(int id, float price) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE customers SET money -= ? where id=" + id;
            
            pst = con.prepareStatement(query);
            pst.setFloat(1, price);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"You successefully purchase the order", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public int changeOrderID(int id) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE orders SET order_id += 1 where customer_id=" + id;
            
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            int order_id = rs.getInt("order_id");
            return order_id;
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            return 0;
        }
        
        public void increaseOrders(int id) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE customers SET number_of_orders += 1 where id=" + id;
            
            pst = con.prepareStatement(query);
            pst.executeUpdate();
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        public int selectOrderID() {
            try {
            DB d = new DB();
            con = d.connect();
            int order_id = 0;
                String query = "Select MAX(order_id) as max_id from orders";
            
            pst = con.prepareStatement(query);
            pst.executeQuery();
            if(rs.next()){
            order_id = rs.getInt("max_id");
            }
            return ++order_id;
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            return 0;
        }
        
        /*public void increaseOrders(int id) {
            try {
            DB d = new DB();
            con = d.connect();
            
            String query = "UPDATE orders SET order_id += 1 where customer_id=" + id;
            
            pst = con.prepareStatement(query);
            pst.executeUpdate();
        
         }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }*/
        
        public void addOffer(String meal_title, String descreption, float price) {
            try {
                DB d = new DB();
                con = d.connect();
                
                String query = "insert into meals (meal_title, descreption, price, meal_type) VALUES(?, ?, ?, 'offer')";

                pst = con.prepareStatement(query);
                pst.setString(1, meal_title);
                pst.setString(2, descreption);
                pst.setFloat(3, price);

                pst.executeUpdate();
            
    }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
           }
        }
        
        public void updateOffer(float price) {
            try {
                
                DB d = new DB();
                con = d.connect();
                
                String query = "update meals set price -= ? where meal_type = 'offer'";
                pst = con.prepareStatement(query);
                
                pst.setFloat(1, price);

                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Updated sucessefully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            
    }
         catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
           }
        }
        }