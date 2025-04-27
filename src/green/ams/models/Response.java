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
public class Response {

    private int id;
    private int area_id;
    private int user_id;
    private String region_name;
    private String area_description;
    private String area_address;

    private String area_land;
    private String reply;
    private double cost;
    private String status;
    private Date responsed_date;
    private List<Attachements> attachements;

    public Response() {
    }
    

    public Response(int id, int area_id, int user_id, String reply, double cost, String status, Date responsed_date) {
        this.id = id;
        this.area_id = area_id;
        this.user_id = user_id;
        this.reply = reply;
        this.cost = cost;
        this.status = status;
        this.responsed_date = responsed_date;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
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
        return responsed_date;
    }

    public void setRequested_date(Date responsed_date) {
        this.responsed_date = responsed_date;
    }

    
    public List<Attachements> getAttachements() {
        return attachements;
    }

    public void setAttachements(List<Attachements> attachements) {
        this.attachements = attachements;
    }
    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getArea_description() {
        return area_description;
    }

    public void setArea_description(String area_descrition) {
        this.area_description = area_descrition;
    }

    public Date getResponsed_date() {
        return responsed_date;
    }

    public void setResponsed_date(Date responsed_date) {
        this.responsed_date = responsed_date;
    }
    public String getArea_address() {
        return area_address;
    }

    public void setArea_address(String area_address) {
        this.area_address = area_address;
    }

    public String getArea_land() {
        return area_land;
    }

    public void setArea_land(String area_land) {
        this.area_land = area_land;
    }
}

