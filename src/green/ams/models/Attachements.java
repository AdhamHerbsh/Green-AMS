/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.models;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Adham
 */
public class Attachements {

    private int id;
    private int area_id;
    private File[] files;
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
    
    

}
