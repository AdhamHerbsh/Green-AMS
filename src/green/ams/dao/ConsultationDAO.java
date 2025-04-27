/*
 * ConsultationDAO.java
 */
package green.ams.dao;

import green.ams.models.Consultation;
import green.ams.services.dbhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Consultation operations.
 */
public class ConsultationDAO extends DAO {

    private dbhelper db;
    private Connection conn;

    public ConsultationDAO() {
        this.db = new dbhelper();
        try {
            this.conn = db.getConnection();
            if (conn == null) {
                throw new SQLException("Database connection is null.");
            }
        } catch (SQLException e) {
            System.err.println("Error initializing database connection: " + e.getMessage());
            throw new RuntimeException("Failed to initialize ConsultationDAO", e);
        }
    }

    public boolean addConsultation(Consultation consultation) {
        if (consultation == null || consultation.getMessage() == null || consultation.getUser_id() < 0) {
            System.err.println("Invalid consultation data");
            return false;
        }

        String sql = "INSERT INTO consultations (UserID, ReceivedID, Topic, Message, SenderRole, Status, SendedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, consultation.getUser_id());
            pst.setInt(2, consultation.getReceived_id());
            pst.setString(3, consultation.getTopic() != null ? consultation.getTopic() : "General");
            pst.setString(4, consultation.getMessage());
            pst.setString(5, consultation.getSender_role() != null ? consultation.getSender_role() : "user");
            pst.setString(6, consultation.getStatus() != null ? consultation.getStatus() : "sent");
            pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    if (rs.next()) {
                        consultation.setId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error inserting consultation: " + e.getMessage());
        }
        return false;
    }

    public List<Consultation> getChatHistory(int userId) {
        List<Consultation> messages = new ArrayList<>();
        String sql = "SELECT c.ID, c.UserID, c.ReceivedID, c.Topic, c.Message, c.SenderRole, c.Status, c.SendedDate " +
                     "FROM consultations c " +
                     "WHERE c.UserID = ? OR c.ReceivedID = ? " +
                     "ORDER BY c.SendedDate ASC";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    messages.add(mapConsultation(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving chat history: " + e.getMessage());
        }
        return messages;
    }

    public List<Consultation> getNewMessages(int userId, int lastMessageId) {
        List<Consultation> newMessages = new ArrayList<>();
        String sql = "SELECT c.ID, c.UserID, c.ReceivedID, c.Topic, c.Message, c.SenderRole, c.Status, c.SendedDate " +
                     "FROM consultations c " +
                     "WHERE (c.UserID = ? OR c.ReceivedID = ?) AND c.ID > ? " +
                     "ORDER BY c.SendedDate ASC";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, userId);
            stmt.setInt(3, lastMessageId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    newMessages.add(mapConsultation(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving new messages: " + e.getMessage());
        }
        return newMessages;
    }

    public String getLastMessagePreview(int userId) {
        String sql = "SELECT Message FROM consultations " +
                     "WHERE UserID = ? OR ReceivedID = ? " +
                     "ORDER BY SendedDate DESC LIMIT 1";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String message = rs.getString("Message");
                    return message != null && message.length() > 30 ? message.substring(0, 27) + "..." : message;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving last message preview: " + e.getMessage());
        }
        return "No messages yet";
    }

    public String getMessagesCount(int userid) {
         String sql = "SELECT COUNT(Message) FROM consultations " +
                     "WHERE UserID = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String message_count = "" + rs.getInt(1);
                    return message_count != null && message_count.length() > 3 ? message_count.substring(0, 2) + "..." : message_count;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving last message preview: " + e.getMessage());
        }
        return "0";
    }

    private Consultation mapConsultation(ResultSet rs) throws SQLException {
        Consultation consultation = new Consultation();
        consultation.setId(rs.getInt("ID"));
        consultation.setUser_id(rs.getInt("UserID"));
        consultation.setReceived_id(rs.getInt("ReceivedID"));
        consultation.setTopic(rs.getString("Topic"));
        consultation.setMessage(rs.getString("Message"));
        consultation.setSender_role(rs.getString("SenderRole"));
        consultation.setStatus(rs.getString("Status"));
        consultation.setSended_date(rs.getTimestamp("SendedDate"));
        return consultation;
    }

}