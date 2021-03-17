/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.*;
import javax.swing.JOptionPane;

public class DB {
    public static Connection connect() throws ClassNotFoundException, SQLException{
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=resturant;user=sa;password=12345";
                con = DriverManager.getConnection(connectionUrl);
                return con;
    }
}

