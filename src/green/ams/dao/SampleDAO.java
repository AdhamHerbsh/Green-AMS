/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.GLOBAL;
import green.ams.models.Sample;
import green.ams.models.SampleItem;
import green.ams.services.dbhelper;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Adham
 */
public class SampleDAO {

    private dbhelper db;
    private JPanel imagePanel;
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public SampleDAO() {
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

    public List<Sample> getSamples(String type) {

        String sql = "SELECT ID, UserID, SampleName, SampleCategory, Description, Price, ImageName, ImageData FROM samples WHERE SampleCategory = ?";
        List<Sample> samples_list = new ArrayList<>();

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, type);  // Set the value for '?'
            rs = pst.executeQuery();  // ✅ Correct way

            while (rs.next()) {
                Sample sample = new Sample();
                sample.setId(rs.getInt("ID"));
                sample.setUser_id(rs.getInt("UserID"));
                sample.setName(rs.getString("SampleName"));
                sample.setCategory(rs.getString("SampleCategory"));
                sample.setDescription(rs.getString("Description"));
                sample.setPrice(rs.getFloat("Price"));
                sample.setImageName(rs.getString("ImageName"));
                sample.setImageStream(rs.getBinaryStream("ImageData"));

                samples_list.add(sample);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching samples: " + e.getMessage());
        } finally {
            closeResources(null, st, rs);
        }

        return samples_list;
    }

    public List<Sample> getSamplesList() {
        String sql = "SELECT ID, UserID, SampleName, SampleCategory, Description, Price, ImageName, ImageData FROM samples ";
        List<Sample> samples_list = new ArrayList<>();

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            rs = pst.executeQuery();  // ✅ Correct way

            while (rs.next()) {
                Sample sample = new Sample();
                sample.setId(rs.getInt("ID"));
                sample.setUser_id(rs.getInt("UserID"));
                sample.setName(rs.getString("SampleName"));
                sample.setCategory(rs.getString("SampleCategory"));
                sample.setDescription(rs.getString("Description"));
                sample.setPrice(rs.getFloat("Price"));
                sample.setImageName(rs.getString("ImageName"));
                sample.setImageStream(rs.getBinaryStream("ImageData"));

                samples_list.add(sample);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching samples: " + e.getMessage());
        } finally {
            closeResources(null, st, rs);
        }

        return samples_list;
    }

    public boolean addSample(Sample sample) throws IOException, SQLException {
        String sql = "INSERT INTO samples (UserID, SampleName, SampleCategory, Description, Price, ImageName, ImageData) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (FileInputStream fis = new FileInputStream(sample.getFile());
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, sample.getUser_id());
            pst.setString(2, sample.getName());
            pst.setString(3, sample.getCategory());
            pst.setString(4, sample.getDescription());
            pst.setFloat(5, sample.getPrice());
            pst.setString(6, sample.getFile().getName());
            pst.setBinaryStream(7, fis, (int) sample.getFile().length());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SampleItem> getCartItems() {

        List<SampleItem> sample_items_list = new ArrayList<>();

        String SQL = "SELECT sample_items.ID, sample_items.UserID, sample_items.SampleID, samples.SampleName, samples.SampleCategory, samples.Description, samples.Price, samples.ImageData, sample_items.Quantity FROM samples INNER JOIN sample_items ON samples.ID = sample_items.SampleID";

        try (PreparedStatement pst = conn.prepareStatement(SQL)) {
//            pst.setInt(1, GLOBAL.user_id);
            rs = pst.executeQuery();

            while (rs.next()) {

                SampleItem sample = new SampleItem();
                System.out.println("_______________DB____________________");

                System.out.println(rs.getInt("ID"));
                System.out.println(rs.getInt("UserID"));
                System.out.println(rs.getString("SampleName"));
                System.out.println(rs.getString("SampleCategory"));
                System.out.println(rs.getString("Description"));
                System.out.println(rs.getFloat("Price"));
                System.out.println(rs.getBinaryStream("ImageData"));
                System.out.println(rs.getString("Quantity"));

                System.out.println("_______________DB____________________");
//                

                sample.setId(rs.getInt("ID"));
                sample.setItem_id(rs.getInt("ID"));
                sample.setUser_id(rs.getInt("UserID"));
                sample.setName(rs.getString("SampleName"));
                sample.setCategory(rs.getString("SampleCategory"));
                sample.setDescription(rs.getString("Description"));
                sample.setPrice(rs.getFloat("Price"));
                sample.setImageStream(rs.getBinaryStream("ImageData"));
                sample.setQuantity(rs.getInt("Quantity"));

                sample_items_list.add(sample);
            }

            for (SampleItem sampleItem : sample_items_list) {

                System.out.println("______________Objetct______________");

                System.out.println(sampleItem.getId());
                System.out.println(sampleItem.getItem_id());
                System.out.println(sampleItem.getUser_id());
                System.out.println(sampleItem.getName());
                System.out.println(sampleItem.getCategory());
                System.out.println(sampleItem.getPrice());
                System.out.println(sampleItem.getDescription());
                System.out.println(sampleItem.getQuantity());

                System.out.println("_____________Object_______________");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pst, st, rs);
        }

        return sample_items_list;
    }

    public boolean addSampleItem(SampleItem sample_item) {

        String sql = "INSERT INTO sample_items (SampleID, UserID, Quantity) VALUES (?, ?, ?)";

        boolean success = false;

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, sample_item.getItem_id());
            pst.setInt(2, sample_item.getUser_id());
            pst.setInt(3, sample_item.getQuantity());
            pst.executeUpdate();

            success = true;

        } catch (Exception e) {
            System.out.println("Error: Message → " + e.getMessage());
        }
        return success;
    }

    public void deleteItem(int item_id) {
        String  sql =   "DELETE FROM sample_items WHERE ID = ?";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, item_id);
            pst.executeUpdate();
                       
            
        } catch (Exception e) {
            System.out.println("Error: Message → " + e.getMessage());
        }
    }

    public boolean deleteItems() {
        String  sql =   "DELETE FROM sample_items";
        
        boolean success = false;
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.executeUpdate();
                     success = true;
        } catch (Exception e) {
            System.out.println("Error: Message → " + e.getMessage());
        }
        return success;
    }
    
    
    private void closeResources(PreparedStatement prepStmt, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepStmt != null) {
                prepStmt.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }



}
