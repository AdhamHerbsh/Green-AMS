/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.components.ChatCard;
import green.ams.models.Attachements;
import green.ams.models.Request;
import green.ams.services.dbhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adham
 */
public class AdminDAO extends DAO {

    private List<ChatCard> chat_card_list;
    
    public AdminDAO() {
        this.setDb(new dbhelper());
        try {
            this.setConn(this.getDb().getConnection());
            if (this.getConn() == null) {
                System.out.println("Error: Database connection is null.");
            }
        } catch (Exception e) {
            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }

    public Map<Integer, Integer> getUserConsultationWaitCounts() {
        String sql = "SELECT UserID, COUNT(*) as WaitCount FROM consultations WHERE Status = 'wait' GROUP BY UserID";
        Map<Integer, Integer> userWaitCounts = new HashMap<>();

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = getConn().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("UserID");
                int count = rs.getInt("WaitCount");
                
                
                userWaitCounts.put(userId, count);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching wait counts: " + e.getMessage());
        } finally {
            closeResources(pst, null, rs);
        }

        return userWaitCounts;
    }
    
    
    public List<ChatCard> getConsultationMessage(){
        
        chat_card_list = new ArrayList<>();
        
        String sql = "SELECT UserID, Topic, Message, Reply, Status, SendedDate FROM consultations";
        
        try (PreparedStatement pst = getConn().prepareStatement(sql)) {
            
            setRs(pst.executeQuery());
            
        } catch (Exception e) {
        }
        
        
        return chat_card_list;
        
    }
    
}
