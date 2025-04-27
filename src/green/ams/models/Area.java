/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.models;

import java.sql.Date;

/**
 *
 * @author Adham
 */
public class Area {

    
    private int id;
    private int user_id;
    private String region_name;
    private String description;
    private String address;
    private String land_area;
    private String status;
    private String reply;
    private Date requested_date;

    
    
    public Area() {
    }

    public Area(int id, int user_id, String region_name, String description, String address, String land_area, String status) {
        this.id = id;
        this.user_id = user_id;
        this.region_name = region_name;
        this.description = description;
        this.address = address;
        this.land_area = land_area;
        this.status = status;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLand_area() {
        return land_area;
    }

    public void setLand_area(String land_area) {
        this.land_area = land_area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getRequested_date() {
        return requested_date;
    }

    public void setRequested_date(Date requested_date) {
        this.requested_date = requested_date;
    }   
}
