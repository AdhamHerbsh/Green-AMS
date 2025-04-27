/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.GLOBAL;
import green.ams.models.Area;
import green.ams.models.Attachements;
import green.ams.models.Request;
import green.ams.models.Response;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private List<Attachements> attachements;
    private List<Area> areas_list;
    private List<Request> requests_list;
    private List<Response> responses_list;

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

    public boolean sendRequest(Request request) {

        try {
            String sql = "INSERT INTO requests (AreaID, UserID, Status, RequestedDate) VALUES (?, ?, ?, ?)";

            pst = conn.prepareStatement(sql);

            System.out.println(request.getArea_id());
            System.out.println(request.getUser_id());
            System.out.println(request.getRequested_date());

            pst.setInt(1, request.getArea_id());
            pst.setInt(2, request.getUser_id());
            pst.setString(3, request.getStatus());
            pst.setDate(4, new java.sql.Date(new java.util.Date().getTime()));

            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Request failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return true;
                } else {
                    throw new SQLException("Request failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error occurred", e);
        }
    }

    public List<Request> getRequests() {

        String sql = "SELECT r.ID, r.AreaID, a.ID, a.RegionName, a.Description, a.Address, a.LandArea, r.Status, r.RequestedDate "
                + "FROM requests r, areas a "
                + "WHERE r.AreaID = a.ID and r.Status = ?";

        requests_list = new ArrayList<>();

        try {

            pst = conn.prepareStatement(sql);
            pst.setString(1, "Pending");
            rs = pst.executeQuery();
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("ID"));
                request.setArea_id(rs.getInt("AreaID"));
                request.setRegion_name(rs.getString("RegionName"));
                request.setDescription(rs.getString("Description"));
                request.setAddress(rs.getString("Address"));
                request.setLand_area(rs.getString("LandArea"));
                request.setStatus(rs.getString("Status"));
                request.setRequested_date(rs.getDate("RequestedDate"));

                System.out.println(request.getArea_id());

                sql = "SELECT attachements.ID, attachements.AreaID, attachements.ImageName, attachements.ImageData, attachements.UploadedDate FROM attachements WHERE AreaID = ?";

                attachements = new ArrayList<>();

                pst = conn.prepareStatement(sql);
                pst.setInt(1, request.getArea_id());
                ResultSet attachements_rs = pst.executeQuery();

                while (attachements_rs.next()) {
                    Attachements attach = new Attachements();

                    attach.setId(attachements_rs.getInt("ID"));
                    attach.setArea_id(attachements_rs.getInt("AreaID"));
                    attach.setImage_name(attachements_rs.getString("ImageName"));
                    attach.setImage_stream(attachements_rs.getBinaryStream("ImageData"));
                    attach.setUploaded_date(attachements_rs.getDate("UploadedDate"));

                    attachements.add(attach);
                }

                request.setAttachements(attachements);

                requests_list.add(request);
            }

        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
        return requests_list;

    }

    public List<Response> getResponses() {

        String sql = "SELECT r.ID, r.AreaID, r.UserID, a.ID, a.RegionName, a.Description, a.Address, a.LandArea, r.reply, r.Cost, r.Status, r.RequestedDate "
                + "FROM requests AS r, areas AS a "
                + "WHERE r.AreaID = a.ID and r.UserID = ? and r.Status = ? or r.Status = ?";

        responses_list = new ArrayList<>();

        try {

            pst = conn.prepareStatement(sql);
            pst.setInt(1, GLOBAL.user_id);
            pst.setString(2, "Approved");
            pst.setString(3, "Rejected");
            rs = pst.executeQuery();
            while (rs.next()) {
                Response response = new Response();
                response.setId(rs.getInt("ID"));
                response.setArea_id(rs.getInt("AreaID"));
                response.setUser_id(rs.getInt("UserID"));
                response.setRegion_name(rs.getString("RegionName"));
                response.setArea_description(rs.getString("Description"));
                response.setArea_address(rs.getString("Address"));
                response.setArea_land(rs.getString("LandArea"));
                response.setReply(rs.getString("Reply"));
                response.setCost(rs.getDouble("Cost"));
                response.setStatus(rs.getString("Status"));
                response.setRequested_date(rs.getDate("RequestedDate"));

                sql = "SELECT attachements.ID, attachements.AreaID, attachements.ImageName, attachements.ImageData, attachements.UploadedDate FROM attachements WHERE AreaID = ?";

                attachements = new ArrayList<>();

                pst = conn.prepareStatement(sql);
                pst.setInt(1, response.getArea_id());
                ResultSet attachements_rs = pst.executeQuery();

                while (attachements_rs.next()) {
                    Attachements attach = new Attachements();

                    attach.setId(attachements_rs.getInt("ID"));
                    attach.setArea_id(attachements_rs.getInt("AreaID"));
                    attach.setImage_name(attachements_rs.getString("ImageName"));
                    attach.setImage_stream(attachements_rs.getBinaryStream("ImageData"));
                    attach.setUploaded_date(attachements_rs.getDate("UploadedDate"));

                    attachements.add(attach);
                }

                response.setAttachements(attachements);

                responses_list.add(response);
            }

        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
        return responses_list;

    }

    public boolean updateRequest(Request request) {
        String sql = "UPDATE requests SET Reply = ?, Cost = ?, Status = ? WHERE ID = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, request.getReply());
            pst.setDouble(2, request.getCost());
            pst.setString(3, request.getStatus());
            pst.setInt(4, request.getId());

            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update request", e);
        }
    }

    public List<Area> getAreasList() {

        areas_list = new ArrayList<>();

        String sql = "SELECT areas.ID, areas.RegionName, areas.Description, areas.Address, areas.LandArea, requests.Status, "
                + "requests.Reply, requests.RequestedDate "
                + "FROM areas "
                + "LEFT JOIN requests ON areas.ID = requests.AreaID";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Area area = new Area();
                area.setId(rs.getInt("ID"));
                area.setRegion_name(rs.getString("RegionName"));
                area.setDescription(rs.getString("Description"));
                area.setAddress(rs.getString("Address"));
                area.setLand_area(rs.getString("LandArea"));
                area.setStatus(rs.getString("Status"));
                // Fields from requests table (can be null if no request exists)
                area.setReply(rs.getString("Reply"));
                area.setRequested_date(rs.getDate("RequestedDate"));

                areas_list.add(area);
            }

        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve areas list", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return areas_list;
    }

    public boolean updateRequestCostByAreaId(int areaId, double cost) {
        String sql = "UPDATE requests SET Cost = ?, Status = ? "
                + "WHERE AreaID = ?"
                + "AND RequestedDate = (SELECT MAX(RequestedDate) FROM requests WHERE AreaID = ? AND Status = 'Replied')";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, cost);
            stmt.setString(2, "Approved");
            stmt.setInt(3, areaId);
            stmt.setInt(4, areaId);

            int affectedRows = stmt.executeUpdate();
            
            return affectedRows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
