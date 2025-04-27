/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.controllers;

import green.ams.dao.AreaDAO;
import green.ams.models.Area;
import green.ams.models.Request;
import green.ams.models.Response;
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

    public boolean addArea(Area area) {
        return area_dao.addArea(area);
    }

    public boolean sendRequest(Request request) {
        return area_dao.sendRequest(request);
    }

    public List<Request> areaRequests() {
        return area_dao.getRequests();
    }

    public List<Response> areaResponses() {
        return area_dao.getResponses();
    }

    public boolean updateRequest(Request request) {
        return area_dao.updateRequest(request);
    }

    public List<Area> areasTable() {
        return area_dao.getAreasList();
    }

    public boolean updateRequestCostByAreaId(int areaId, double cost) {
        return area_dao.updateRequestCostByAreaId(areaId, cost);
    }

}
