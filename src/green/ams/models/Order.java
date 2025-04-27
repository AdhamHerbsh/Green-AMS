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
public class Order {

    private int id;
    private int userId;
    private int orderNumber;
    private double totalAmount;
    private String paymentMethod;
    private Date orderDate;
    private String fullName; // New field for user's full name

    public Order() {
    }

    // Constructor used in getOrdersList
    public Order(int id, int userId, int orderNumber, double totalAmount, String paymentMethod, Date orderDate) {
        this.id = id;
        this.userId = userId;
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
    }

    // Constructor for joined data
    public Order(int id, int userId, int orderNumber, double totalAmount, String paymentMethod, Date orderDate, String fullName) {
        this(id, userId, orderNumber, totalAmount, paymentMethod, orderDate);
        this.fullName = fullName;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }

    public int getOrder_number() {
        return orderNumber;
    }

    public void setOrder_number(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotal_amount() {
        return totalAmount;
    }

    public void setTotal_amount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPayment_method() {
        return paymentMethod;
    }

    public void setPayment_method(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getOrder_date() {
        return orderDate;
    }

    public void setOrder_date(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
