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
public class FeedbackEvaluationDTO {
    private String fullName;
    private String message;
    private int rate;
    private Date createdDate;

    public FeedbackEvaluationDTO(String fullName, String message, int rate, Date createdDate) {
        this.fullName = fullName;
        this.message = message;
        this.rate = rate;
        this.createdDate = createdDate;
    }

    public String getFullName() { return fullName; }
    public String getMessage() { return message; }
    public int getRate() { return rate; }
    public Date getCreatedDate() { return createdDate; }
}