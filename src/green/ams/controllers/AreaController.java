/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.controllers;

import green.ams.dao.AreaDAO;
import green.ams.models.Area;
import green.ams.models.Request;
import java.io.File;
import java.util.List;

/**
 *
 * @author Adham
 */
public class AreaController {
    
    AreaDAO area_dao = new AreaDAO();

    public AreaController() {
    }
       
    public boolean addArea(Area area){
        return area_dao.addArea(area);
    }   

    public List<Request> areaRequests() {
        return area_dao.getRequests();
    }
}
