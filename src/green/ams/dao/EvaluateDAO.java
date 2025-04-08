/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.models.Evaluate;
import green.ams.models.Feedback;
import green.ams.services.dbhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adham
 */
public class EvaluateDAO {

    private dbhelper db;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public EvaluateDAO() {
        this.db = new dbhelper();
        try {
            this.conn = db.getConnection();
            if (conn == null) {
                System.out.println("Error: Database connection is null.");
            }
        } catch (Exception e) {
            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }

    public boolean addEvaluate(Evaluate evaluate) {
        System.out.println(evaluate.getId());
        System.out.println(evaluate.getFeedback_id());
        System.out.println(evaluate.getUser_id());
        System.out.println(evaluate.getRate());
    return false;        
    }

    public boolean addFeedback(Feedback feedback) {
        if (feedback == null) {
            System.out.println("Error: Feedback object is null.");
            return false;
        }
        
        boolean success = false;
        String sql = "INSERT INTO feedback (FullName, EmailAddress, PhoneNumber, Message, CreatedDate) VALUES (?, ?, ?, ?, ?)";
        
        try {
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, feedback.getFull_name());
            pst.setString(2, feedback.getEmail_address());
            pst.setString(3, feedback.getPhone_number());
            pst.setString(4, feedback.getMessage());
            pst.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Feedback inserted successfully!");
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        } finally {
            closeResources(pst, null, null);
        }
        
        return success;
    }
    

        private void closeResources(PreparedStatement prepStmt, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepStmt != null) {
                prepStmt.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }

    public boolean addEvaluate(Feedback feedback) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
