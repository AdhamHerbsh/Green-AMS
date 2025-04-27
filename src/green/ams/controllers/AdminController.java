/*
 * AdminController.java
 */
package green.ams.controllers;

import green.ams.dao.AdminDAO;
import green.ams.dao.ConsultationDAO;
import green.ams.dao.OrderDAO;
import green.ams.dao.SampleDAO;
import green.ams.dao.UserDAO;
import green.ams.models.AreaWithRequest;
import green.ams.models.Consultation;
import green.ams.models.Evaluate;
import green.ams.models.FeedbackEvaluationDTO;
import green.ams.models.Order;
import green.ams.models.Sample;
import green.ams.models.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller for Admin operations.
 */
public class AdminController {

    private UserDAO userDAO = new UserDAO();
    private SampleDAO sampleDAO = new SampleDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private ConsultationDAO consultationDAO = new ConsultationDAO();
    private AdminDAO adminDAO = new AdminDAO();

    public List<User> UsersTable() {
        return userDAO.getUsersList();
    }

    public List<Order> OrdersTable() {
        return adminDAO.getOrdersWithUserDetails();
    }

    public List<Sample> SamplesTable() {
        return sampleDAO.getSamplesList();
    }

    public List<User> getUsersWithConsultations() throws SQLException {
        return adminDAO.getUsersWithConsultations();
    }

    public boolean sendMessage(Consultation message) {
        if (message == null || message.getMessage() == null || message.getUser_id() < 0) {
            return false;
        }
        return consultationDAO.addConsultation(message);
    }

    public boolean createSample(Sample sample) {
        try {
            return sampleDAO.addSample(sample);
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean createConsultation(Consultation message) {
        return consultationDAO.addConsultation(message);
    }

    public List<Consultation> getChatHistory(int userId) {
        return consultationDAO.getChatHistory(userId);
    }

    public List<Consultation> getNewMessages(int userId, int lastMessageId) {
        return consultationDAO.getNewMessages(userId, lastMessageId);
    }

    public String getLastMessagePreview(int userId) {
        return consultationDAO.getLastMessagePreview(userId);
    }

    public String getMessagesCount(int id) {
        return consultationDAO.getMessagesCount(id);
    }

    public List<FeedbackEvaluationDTO> getFeedbackWithEvaluations() {
        return adminDAO.getFeedbackWithEvaluations();
    }

    public List<AreaWithRequest> fetchAreasWithRequests() {
        return adminDAO.fetchAreasWithRequests();
    }

    public boolean updateUserScore(int areaId) {
       return adminDAO.increaseUserScoreByAreaId(areaId);
    }
    
}
