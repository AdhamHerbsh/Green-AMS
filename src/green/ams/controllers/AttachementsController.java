/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.controllers;

import green.ams.dao.AttachementsDAO;
import green.ams.models.Attachements;

/**
 *
 * @author Adham
 */
public class AttachementsController {
    
    // Attachements Data Access Object
    AttachementsDAO attachements_dao = new AttachementsDAO();

    public AttachementsController() {
    }
    
    
    
    public boolean uploadAttachements(Attachements attachements){
        return attachements_dao.uploadAttachements(attachements);
    }
}
