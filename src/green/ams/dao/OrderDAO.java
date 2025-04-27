/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.models.Order;
import green.ams.models.OrderItem;
import green.ams.services.dbhelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adham
 */
public class OrderDAO {

    private dbhelper db;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderDAO() {
        this.db = new dbhelper();
        try {
            this.conn = db.getConnection();
            if (conn == null) {
                System.out.println("Error: Database connection is null.");
            }
        } catch (Exception e) {
            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }

// 1. Make a new order
    public int makeOrder(Order order) {
        String sql = "INSERT INTO orders (UserID, OrderNumber, TotalAmount, PaymentMethod, OrderDate) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, order.getUser_id());
            stmt.setInt(2, order.getOrder_number());
            stmt.setDouble(3, order.getTotal_amount());
            stmt.setString(4, order.getPayment_method());
            stmt.setDate(5, new java.sql.Date(order.getOrder_date().getTime()));

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // return generated order ID
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 2. Get all orders
    public List<Order> getOrdersList() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("ID"),
                        rs.getInt("UserId"),
                        rs.getInt("OrderNumber"),
                        rs.getDouble("TotalAmount"),
                        rs.getString("PaymentMethod"),
                        rs.getDate("OrderDate")
                );
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public boolean addOrderItem(List<OrderItem> items) {
        String sql = "INSERT INTO order_items (OrderID, SampleItemID, OrderNumber) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (OrderItem item : items) {
                stmt.setInt(1, item.getOrder_id());
                stmt.setInt(2, item.getSample_item_id());
                stmt.setInt(3, item.getOrder_number());
                stmt.addBatch(); // Add to batch for efficiency
            }
            int[] affectedRows = stmt.executeBatch();
            for (int rows : affectedRows) {
                if (rows <= 0) {
                    return false; // At least one insert failed
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addFinancialTransaction(int userId, int orderId, double amount, java.util.Date transactionDate) {
        String sql = "INSERT INTO financial_transactions (UserID, OrderID, Amount, TransactionDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, orderId);
            stmt.setDouble(3, amount);
            stmt.setDate(4, new java.sql.Date(transactionDate.getTime()));

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
