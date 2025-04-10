/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.models.Attachements;
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
public class AttachementsDAO {

    private dbhelper db;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public AttachementsDAO() {
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

    public boolean uploadAttachements(Attachements attachements) {
        try {
            String sql = "INSERT INTO attachements (AreaID, ImageName, ImageData, UploadedDate) VALUES (?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);

            for (File imageFile : attachements.getFiles()) {
                FileInputStream fis = new FileInputStream(imageFile);
                pst.setInt(1, attachements.getArea_id());
                pst.setString(2, imageFile.getName());
                pst.setBinaryStream(3, fis, (int) imageFile.length());
                pst.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
                pst.executeUpdate();

                fis.close();
            }

            JOptionPane.showMessageDialog(null, "Images uploaded successfully!");
        } catch (HeadlessException | IOException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error uploading images: " + ex.getMessage());
        }
        return false;
    }

}
