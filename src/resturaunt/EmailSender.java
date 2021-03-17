package resturaunt;

import DB.DB;
import GUI.*;
import GUI3.CustomerLoyality;
import com.email.durgesh.Email;
import java.sql.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class EmailSender {
    private String email1;
    private String pass;
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement pst = null;
    
public void offer(String email1, String pass) {    
try  {
    Email email = new Email (email1, pass);
    email.setFrom(email1, "Resturaunt");
    email.setSubject("Offer added");
    
    email.setContent("<h1>There is a new offer added check the market if you are a loyality customer</h1>", "text/html");
    email.addRecipient(email1);
    email.send();
}
    catch (Exception e) {
    e.printStackTrace();
}
}

public void report(String email1, String pass, String text) {    
try  {
    Email email = new Email (email1, pass);
    email.setFrom(email1, "Resturaunt");
    email.setSubject("Report Update");
    
    email.setContent("<h1>" + text + "</h1>", "text/html");
    email.addRecipient(email1);
    email.send();
}
    catch (Exception e) {
    e.printStackTrace();
}
}

public static boolean validEmail(String emai1) {    

    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailPat.matcher(emai1);
    if(matcher.find()){
        JOptionPane.showMessageDialog(null,"Your email is valid", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    else{
            JOptionPane.showMessageDialog(null,"please enter a valid email", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    return false;
}

public void loyality(String email1, String pass) {    
try  {
    Email email = new Email (email1, pass);
    email.setFrom(email1, "Resturaunt");
    email.setSubject("Loyality customer confirmation");
    
    email.setContent("<h1>You are a loyality customer you will get a special offers on your orders</h1>", "text/html");
    email.addRecipient(email1);
    email.send();
}
    catch (Exception e) {
    e.printStackTrace();
}
}

public void reward(String email1, String pass, double text) {    
try  {
    Email email = new Email (email1, pass);
    email.setFrom(email1, "Resturaunt");
    email.setSubject("Reward added");
    
    email.setContent("<h1>A reward has been sent to your account check it out you have get</h1>" + "<h1>" + text + "</h1>" + "<h1>EGP</h1>", "text/html");
    email.addRecipient(email1);
    email.send();
}
    catch (Exception e) {
    e.printStackTrace();
}
}

public void confirm(String email1, String pass) {    
try  {
    Email email = new Email (email1, pass);
    email.setFrom(email1, "Resturaunt");
    email.setSubject("Email is confirmed");
    
    email.setContent("<h1>Thank you for registering in notification center you will recieve email with all the market updates</h1>", "text/html");
    email.addRecipient(email1);
    email.send();
}
    catch (Exception e) {
    e.printStackTrace();
}
}

public void registConfirm(String email1, String pass) {    
try  {
    Email email = new Email (email1, pass);
    email.setFrom(email1, "Resturaunt");
    email.setSubject("Email is confirmed");
    
    email.setContent("<h1>Your registeration is delivered the admin will check it</h1>", "text/html");
    email.addRecipient(email1);
    email.send();
}
    catch (Exception e) {
    e.printStackTrace();
}
}

public String getEmail() throws SQLException
    {   
        try {
                DB d = new DB();
                con = d.connect();
                String query = "Select email, email_password from customers where email != '' and email_password != ''" ;

                pst = con.prepareStatement(query);
                
                rs = pst.executeQuery();
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        while(rs.next()) {
            String email = rs.getString("email");
            String password = rs.getString("email_password");
            return password;
        }
        return null;
}

public String getEmailByID(String id) throws SQLException
    {   
        try {
                DB d = new DB();
                con = d.connect();    
                String query = "Select email, email_password from customers where email != '' and email_password != '' and id=" + id ;

                pst = con.prepareStatement(query);
                
                rs = pst.executeQuery();
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        while(rs.next()) {
            String email = rs.getString("email");
            String password = rs.getString("email_password");
            rewardProgramms.E_mail = email;
            return password;
        }
        return null;
}

public String getEmailByIntID(int id) throws SQLException {   
        
        try {
                DB d = new DB();
                con = d.connect();
                String query = "Select email, email_password from customers where email != '' and email_password != '' and id=" + id ;

                pst = con.prepareStatement(query);
                
                rs = pst.executeQuery();
               
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        while(rs.next()) {
            String email = rs.getString("email");
            String password = rs.getString("email_password");
            rewardProgramms.E_mail = email;
            CustomerLoyality.getEmail = email;
            return password;
        }
        return null;
}


}
