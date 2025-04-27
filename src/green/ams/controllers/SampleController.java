/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.controllers;

import green.ams.dao.SampleDAO;
import green.ams.models.Sample;
import green.ams.models.SampleItem;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Adham
 */
public class SampleController {

    SampleDAO sample_dao = new SampleDAO();

    public boolean Sample(Sample sample) {
        try {
            return sample_dao.addSample(sample);
        } catch (IOException ex) {
            Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Sample> showSamples(String type) {

        List<Sample> samples_list;

        samples_list = sample_dao.getSamples(type);

        // 1. Print all details to console
        for (Sample s : samples_list) {
            System.out.println("ID: " + s.getId());
            System.out.println("User ID: " + s.getUser_id());
            System.out.println("Name: " + s.getName());
            System.out.println("Category: " + s.getCategory());
            System.out.println("Description: " + s.getDescription());
            System.out.println("Price: " + s.getPrice());
            System.out.println("Image Name: " + s.getImageName());
            System.out.println("------------------------------");
        }

        return samples_list;
    }

    public Sample getSamples() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Sample> SamplesTable() {
        return sample_dao.getSamplesList();
    }

    public boolean SampleItem(SampleItem sample_item) {
        return sample_dao.addSampleItem(sample_item);
    }

    public List<SampleItem> getSampleItems() {
        return sample_dao.getCartItems();
    }

    public void removeSampleItem(int item_id) {
        sample_dao.deleteItem(item_id);
    }

    public boolean removeAll() {
        return sample_dao.deleteItems();
    }

}
