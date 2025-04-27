/*
 * AdminDAO.java
 */
package green.ams.dao;

import green.ams.models.AreaWithRequest;
import green.ams.models.Consultation;
import green.ams.models.FeedbackEvaluationDTO;
import green.ams.models.Order;
import green.ams.models.User;
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
 * Data Access Object for Admin-specific operations.
 */
public class AdminDAO extends DAO {

    private dbhelper db;
    private Connection conn;

    public AdminDAO() {
        this.db = new dbhelper();
        try {
            this.conn = db.getConnection();
            if (conn == null) {
                throw new SQLException("Database connection is null.");
            }
        } catch (SQLException e) {
            System.err.println("Error initializing database connection: " + e.getMessage());
            throw new RuntimeException("Failed to initialize AdminDAO", e);
        }
    }

    public Map<Integer, Integer> getUserConsultationWaitCounts() {
        String sql = "SELECT UserID, COUNT(*) as WaitCount FROM consultations WHERE Status = 'wait' GROUP BY UserID";
        Map<Integer, Integer> userWaitCounts = new HashMap<>();

        try (PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                userWaitCounts.put(rs.getInt("UserID"), rs.getInt("WaitCount"));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching wait counts: " + e.getMessage());
        }
        return userWaitCounts;
    }

    public List<User> getUsersWithConsultations() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT DISTINCT u.ID, u.FullName, u.Email "
                + "FROM users u "
                + "INNER JOIN consultations c ON (u.ID = c.UserID OR u.ID = c.ReceivedID) "
                + "WHERE u.Role = 'User Public' ";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setFull_name(rs.getString("FullName"));
                user.setEmail(rs.getString("Email"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving users with consultations: " + e.getMessage());
        }
        return users;
    }

    public List<Order> getOrdersWithUserDetails() {
        List<Order> orders = new ArrayList<>();

        String sql = "SELECT o.ID, o.UserID, o.OrderNumber, o.TotalAmount, o.PaymentMethod, o.OrderDate, u.FullName "
                + "FROM orders o "
                + "INNER JOIN users u ON o.UserID = u.ID;";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("ID"),
                        rs.getInt("UserID"),
                        rs.getInt("OrderNumber"),
                        rs.getDouble("TotalAmount"),
                        rs.getString("PaymentMethod"),
                        rs.getDate("OrderDate"),
                        rs.getString("FullName")
                );
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public List<FeedbackEvaluationDTO> getFeedbackWithEvaluations() {
        List<FeedbackEvaluationDTO> feedbackList = new ArrayList<>();
        String sql = "SELECT f.FullName, f.Message, e.Rate, f.CreatedDate "
                + "FROM evaluations e "
                + "LEFT JOIN feedback f ON e.FeedbackID = f.ID";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FeedbackEvaluationDTO dto = new FeedbackEvaluationDTO(
                        rs.getString("FullName"),
                        rs.getString("Message"),
                        rs.getInt("Rate"),
                        rs.getDate("CreatedDate")
                );
                feedbackList.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return feedbackList;
    }

    // Example method to fetch areas with their most recent pending requests
    public List<AreaWithRequest> fetchAreasWithRequests() {
        List<AreaWithRequest> areasWithRequests = new ArrayList<>();
        String sql = "SELECT a.ID, a.RegionName, a.Description, r.Cost "
                + "FROM requests r, areas a "
                + "WHERE r.AreaID = a.ID and r.Status = 'Replied'";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AreaWithRequest area = new AreaWithRequest(
                        rs.getInt("ID"),
                        rs.getString("RegionName"),
                        rs.getString("Description"),
                        rs.getDouble("Cost")
                );
                areasWithRequests.add(area);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return areasWithRequests;
    }

    
    public boolean increaseUserScoreByAreaId(int areaId) {
        String sql = "UPDATE users u " +
                     "SET u.Score = u.Score + 50 " +
                     "WHERE u.ID = (SELECT UserID FROM areas WHERE ID = ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, areaId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; // Return true if a user was updated, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}
