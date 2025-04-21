/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.models.Consultation;
import green.ams.services.dbhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adham
 */
public class ConsultationDAO extends DAO {

    private dbhelper db;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public ConsultationDAO() {
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

    public boolean addConsultation(Consultation consultation) {

        String sql = "INSERT INTO consultations (UserID, Topic, Message, Reply, Status, SendedDate) VALUES (?, ?, ?, ?, ?, ?)";

        boolean success = false;

        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, consultation.getUser_id());
            pst.setString(2, consultation.getTopic());
            pst.setString(3, consultation.getMessage());
            pst.setString(4, consultation.getReply());
            pst.setString(5, consultation.getStatus());
            pst.setDate(6, new java.sql.Date(new java.util.Date().getTime()));

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Message inserted successfully!");
                success = true;
            } else {
                System.out.println("Faild");
            }

        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        } finally {
            closeResources(pst, null, null);
        }

        return success;
    }


    public String getReply(int user_id, String text) {
        String reply = "";
        String sql = "SELECT Reply FROM consultations WHERE UserID = ? AND Message = ? ORDER BY SendedDate DESC LIMIT 1";

        try {

            pst = conn.prepareStatement(sql);

            pst.setInt(1, user_id);
            pst.setString(2, text);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                reply = rs.getString("Reply");
                if (reply == null) {
                    reply = ""; // Convert NULL replies to empty string
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving reply: " + e.getMessage());
        }

        return reply;
    }
}
