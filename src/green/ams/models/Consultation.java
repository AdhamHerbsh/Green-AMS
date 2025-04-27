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
public class Consultation {

    private int id;
    private int user_id;
    private int received_id;

    private String topic;
    private String message;
    private String reply;
    private String status;
    private Date sended_date;
    private String sender_role;


    public Consultation() {
    }

    public Consultation(int id, int user_id, String topic, String message, String reply, String status, Date sended_date) {
        this.id = id;
        this.user_id = user_id;
        this.topic = topic;
        this.message = message;
        this.reply = reply;
        this.status = status;
        this.sended_date = sended_date;
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

    public int getReceived_id() {
        return received_id;
    }

    public void setReceived_id(int received_id) {
        this.received_id = received_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSended_date() {
        return sended_date;
    }

    public void setSended_date(Date sended_date) {
        this.sended_date = sended_date;
    }

    public String getSender_role() {
        return sender_role;
    }

    public void setSender_role(String sender_role) {
        this.sender_role = sender_role;
    }

}
