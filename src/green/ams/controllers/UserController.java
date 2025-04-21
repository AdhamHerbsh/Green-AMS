/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Adham
 */
public class UserController {

    // User Model Intialization
    User user;

    // User Data Access Object Intialization
    UserDAO user_dao = new UserDAO();

    // Evaluate Data Access Object Intialization
    EvaluateDAO evaluate_dao = new EvaluateDAO();

    // Order Data Access Object Intialization
    OrderDAO order_dao = new OrderDAO();

    // Evaluate Data Access Object Intialization
    ConsultationDAO consultation_dao = new ConsultationDAO();
    
    
    
    public UserController() {
    
    }
    
    public User UserProfile(int id) {
        return user_dao.getUser(id);
    }
    
    public boolean Evaluate(Evaluate evaluate) {
        return evaluate_dao.addEvaluate(evaluate);
    }
    
    public boolean Feedback(Feedback feedback) {
        return evaluate_dao.addFeedback(feedback);
    }

    public boolean Consultation(Consultation consultation) {
        return consultation_dao.addConsultation(consultation);
    }

    public int Order(Order order) {
        return order_dao.makeOrder(order);
    }
    
    public String getMessages(int user_id, String text) {
        return consultation_dao.getReply(user_id, text);
    }

    public boolean updateUserProfile(User user) {
        return user_dao.updateUser(user);
    }

    public List<User> UsersTable() {
        return user_dao.getUsersList();
    }

    public boolean OrderItem(List<OrderItem> order_item) {
        return order_dao.addOrderItem(order_item);
    }

    public void getConsultation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getConsultationMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
