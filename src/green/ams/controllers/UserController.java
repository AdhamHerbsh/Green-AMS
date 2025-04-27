/*
 * UserController.java
 */
package green.ams.controllers;

import green.ams.dao.ConsultationDAO;
import green.ams.dao.EvaluateDAO;
import green.ams.dao.OrderDAO;
import green.ams.dao.UserDAO;
import green.ams.models.Consultation;
import green.ams.models.Evaluate;
import green.ams.models.Feedback;
import green.ams.models.Order;
import green.ams.models.OrderItem;
import green.ams.models.User;
import java.util.List;

/**
 * Controller for User operations.
 */
public class UserController {

    private UserDAO userDAO = new UserDAO();
    private EvaluateDAO evaluateDAO = new EvaluateDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private ConsultationDAO consultationDAO = new ConsultationDAO();

    public User UserProfile(int id) {
        return userDAO.getUser(id);
    }

    public boolean Evaluate(Evaluate evaluate) {
        return evaluateDAO.addEvaluate(evaluate);
    }

    public boolean Feedback(Feedback feedback) {
        return evaluateDAO.addFeedback(feedback);
    }

    public boolean Consultation(Consultation consultation) {
        return consultationDAO.addConsultation(consultation);
    }

    public List<Consultation> getNewMessages(int id, int lastMessageId) {
        return consultationDAO.getNewMessages(id, lastMessageId);
    }

    public List<Consultation> getChatHistory(int id) {
        return consultationDAO.getChatHistory(id);
    }

    public int Order(Order order) {
        return orderDAO.makeOrder(order);
    }

    public boolean updateUserProfile(User user) {
        return userDAO.updateUser(user);
    }

    public boolean OrderItem(List<OrderItem> orderItem) {
        return orderDAO.addOrderItem(orderItem);
    }

    public boolean addFinancialTransaction(int userId, int orderId, double amount, java.util.Date transactionDate) {
        return orderDAO.addFinancialTransaction(userId, orderId, amount, transactionDate);
    }

}
