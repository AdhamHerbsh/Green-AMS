/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.controllers;

import green.ams.models.User;
import green.ams.dao.UserDAO;


/**
 *
 * @author Adham
 */
public class AuthController {

    // User Model Intialization
    User user = new User();

    // User Data Access Object Intialization
    UserDAO dao = new UserDAO();
    
    public AuthController() {
    
    }
    

    public boolean Login(User user) {
        
        return dao.getUser(user);
    }
    
    public boolean Register(User user) {
        
        user.getFull_name();
        user.getEmail();
        user.getAddress();
        user.getPhone_number();
        user.getPassword();
        user.getRole();
        user.getCreated_date();
            
        return dao.addUser(user);        
    }
    
    
    
}
