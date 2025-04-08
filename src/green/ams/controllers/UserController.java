/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.controllers;

import green.ams.dao.EvaluateDAO;
import green.ams.dao.UserDAO;
import green.ams.models.Evaluate;
import green.ams.models.Feedback;
import green.ams.models.User;

/**
 *
 * @author Adham
 */
public class UserController {

    // User Model Intialization
    User user = new User();

    // User Data Access Object Intialization
    UserDAO dao = new UserDAO();

    // Evaluate Data Access Object Intialization
    EvaluateDAO evaluate_dao = new EvaluateDAO();
    
    
    public UserController() {
    
    }
    
    public boolean Evaluate(Evaluate evaluate) {
        return evaluate_dao.addEvaluate(evaluate);
    }
    
    public boolean Feedback(Feedback feedback) {
        return evaluate_dao.addFeedback(feedback);
    }
    
}
