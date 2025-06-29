/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Adham
 */
public class Request {

    private int id;
    private int area_id;
    private int user_id;
    private String region_name;
    private String reply;
    private String description;
    private String address;
    private String land_area;
    private double cost;
    private String status;
    private Date requested_date;
    private List<Attachements> attachements;

    public Request() {
    }
    

    public Request(int id, int area_id, int user_id, String reply, double cost, String status, Date requested_date) {
        this.id = id;
        this.area_id = area_id;
        this.user_id = user_id;
        this.reply = reply;
        this.cost = cost;
        this.status = status;
        this.requested_date = requested_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequested_date() {
        return requested_date;
    }

    public void setRequested_date(Date requested_date) {
        this.requested_date = requested_date;
    }

    
    public List<Attachements> getAttachements() {
        return attachements;
    }

    public void setAttachements(List<Attachements> attachements) {
        this.attachements = attachements;
    }
}

