/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.models;

import java.util.Date;
/**
 *
 * @author Adham
 */
public class User {
        
    private int id;
    private String full_name;
    private String email;
    private String address;
    private String phone_number;
    private String role;
    private String password;
    private Date created_date;

    public User() {
        
    }

    public User(int id, String full_name, String email, String address, String phone_number, String role, String password, Date created_date) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.role = role;
        this.password = password;
        this.created_date = created_date;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    } 
    
}