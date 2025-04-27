/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.models;

/**
 *
 * @author Adham
 */
// Helper class to hold area and request data
public class AreaWithRequest {

    private int areaId;
    private String regionName;
    private String description;
    private double currentCost;

    public AreaWithRequest(int areaId, String regionName, String description, double currentCost) {
        this.areaId = areaId;
        this.regionName = regionName;
        this.description = description;
        this.currentCost = currentCost;
    }

    public int getAreaId() {
        return areaId;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getDescription() {
        return description;
    }

    public double getCurrentCost() {
        return currentCost;
    }
}
