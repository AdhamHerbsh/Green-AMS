/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.test;

import green.ams.services.dbhelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adham
 */
public class UserTable {

    /**
     * @param args the command line arguments
     */
    
    public static void f(){
        
        dbhelper db = new dbhelper();
        int rowsInserted = 0;
        String id = "";

        PreparedStatement pst = null;
        Statement st = null;
        ResultSet rs = null;

//        String sql = "INSERT INTO users (FullName, Email, Address, PhoneNumber, Role, Password, CreatedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//            pst = db.getConnection().prepareStatement(sql);
//            pst.setString(1, "mewa");
//            pst.setString(2, "mewa@mewa.com");
//            pst.setString(3, "Office");
//            pst.setString(4, "----------------");
//            pst.setString(5, "Mewa");
//            pst.setString(6, "mewa");
//            pst.setDate(7, new java.sql.Date(new java.util.Date().getTime()));
//
//            rowsInserted = pst.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (rowsInserted > 0) {
//            System.out.println("User inserted successfully!");
//        }

        try {

            st = db.getConnection().createStatement();

            rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {

                id = rs.getString(3);

                System.out.println(id);
            }

        } catch (SQLException e) {
            System.out.println("Error in SQL query" + e.getMessage());
        }

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
