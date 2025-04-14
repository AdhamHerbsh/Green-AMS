/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Adham
 */
public class Attachements {

    private int id;
    private int area_id;
    private File[] files;

    // Image fields
    private String image_name;
    private File file;                     // For reading from disk
    private InputStream image_stream;       // For database input
    private byte[] image_bytes;             // Binary from DB
    private ImageIcon image_icon;           // For Swing GUI
    private BufferedImage buffered_image;   // For processing or display

    private Date uploaded_date;

    public Attachements() {

    }
    public Attachements(int id, int area_id, File[] files, Date uploaded_date) {
        this.id = id;
        this.area_id = area_id;
        this.files = files;
        this.uploaded_date = uploaded_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public Date getUploaded_date() {
        return uploaded_date;
    }

    public void setUploaded_date(Date uploaded_date) {
        this.uploaded_date = uploaded_date;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public InputStream getImage_stream() {
        return image_stream;
    }

    public void setImage_stream(InputStream image_stream) {
        this.image_stream = image_stream;
    }

    public byte[] getImage_bytes() {
        return image_bytes;
    }

    public void setImage_bytes(byte[] image_bytes) {
        this.image_bytes = image_bytes;
    }

    public ImageIcon getImage_icon() {
        return image_icon;
    }

    public void setImage_icon(ImageIcon image_icon) {
        this.image_icon = image_icon;
    }

    public BufferedImage getBuffered_image() {
        return buffered_image;
    }

    public void setBuffered_image(BufferedImage buffered_image) {
        this.buffered_image = buffered_image;
    } 

}
