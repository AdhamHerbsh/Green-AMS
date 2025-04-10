/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.GLOBAL;
import green.ams.models.Area;
import green.ams.services.dbhelper;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Adham
 */
public class AreaDAO {

    private dbhelper db;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public AreaDAO() {
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

    public boolean addArea(Area area) {
        try {
            String sql = "INSERT INTO areas (UserID, RegionName, Description, Address, LandArea, Status) VALUES (?, ?, ?, ?, ?, ?)";
            
            pst = conn.prepareStatement(sql);
            
            System.out.println(area.getUser_id());
            System.out.println(area.getRegion_name());
            System.out.println(area.getDescription());
            System.out.println(area.getAddress());
            System.out.println(area.getLand_area());
            System.out.println(area.getStatus());
            
            pst.setInt(1, area.getUser_id());
            pst.setString(2, area.getRegion_name());
            pst.setString(3, area.getDescription());
            pst.setString(4, area.getAddress());
            pst.setString(5, area.getLand_area());
            pst.setString(6, area.getStatus());

            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating area failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    GLOBAL.area_id = generatedKeys.getInt(1);
                    return true;
                } else {
                    throw new SQLException("Creating area failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error occurred", e);
        }
    }

}
