/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.test;

import green.ams.services.dbhelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adham
 */
public class UserTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        dbhelper db = new dbhelper();

        String id = "";

        Statement st = null;
        ResultSet rs = null;

        try {

            st = db.getConnection().createStatement();

            rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {

                id = rs.getString("Email");

                System.out.println(id);
            }

        } catch (SQLException e) {
            System.out.println("Error in SQL query" + e.getMessage());
        }

    }

}
