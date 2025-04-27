/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.dao;

import green.ams.models.Attachements;
import green.ams.services.dbhelper;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Adham
 */
public class AttachementsDAO extends JFrame {

    private dbhelper db;
    private JPanel imagePanel;
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

        setTitle("Uploaded Images");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout());

        JScrollPane scrollPane = new JScrollPane(imagePanel);
        add(scrollPane, BorderLayout.CENTER);

        showAllAttachements();

    }

    public boolean showAllAttachements() {

        try {

            String sql = "SELECT ImageName, ImageData FROM attachements";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("ImageName");
                InputStream is = rs.getBinaryStream("ImageData");

                if (is != null) {
                    BufferedImage img = ImageIO.read(is);
                    if (img != null) {
                        JLabel label = new JLabel(name, new ImageIcon(img.getScaledInstance(200, -1, Image.SCALE_SMOOTH)), JLabel.CENTER);
                        label.setHorizontalTextPosition(JLabel.CENTER);
                        label.setVerticalTextPosition(JLabel.BOTTOM);
                        imagePanel.add(label);
                    }
                    is.close();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading images: " + ex.getMessage());
        }

        revalidate();
        repaint();

        return false;
    }

    public boolean uploadAttachements(Attachements attachements) {
        try {
            String sql = "INSERT INTO attachements (AreaID, ImageName, ImageData, UploadedDate) VALUES (?, ?, ?, ?)";

            pst = conn.prepareStatement(sql);

            for (File imageFile : attachements.getFiles()) {
                try (FileInputStream fis = new FileInputStream(imageFile)) {
                    pst.setInt(1, attachements.getArea_id());
                    pst.setString(2, imageFile.getName());
                    pst.setBinaryStream(3, fis, (int) imageFile.length());
                    pst.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
                    pst.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(null, "Images uploaded successfully!");
            return true;
        } catch (HeadlessException | IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error uploading images: " + ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AttachementsDAO().setVisible(true);
        });
    }

}
