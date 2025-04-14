package green.ams.models;

import java.io.File;
import java.io.InputStream;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

public class Sample {

    private int id;
    private int user_id;
    private String name;
    private String category;
    private String description;
    private float price;

    // Image fields
    private String image_name;
    private File file;                     // For reading from disk
    private InputStream image_stream;       // For database input
    private byte[] image_bytes;             // Binary from DB
    private ImageIcon image_icon;           // For Swing GUI
    private BufferedImage buffered_image;   // For processing or display

    public Sample() {
    }

    // Constructor with main fields (optional)
    public Sample(int id, int user_id, String name, String category, String description, float price, String image_name) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.image_name = image_name;
    }

    // --- Getters and Setters ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageName() {
        return image_name;
    }

    public void setImageName(String image_name) {
        this.image_name = image_name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public InputStream getImageStream() {
        return image_stream;
    }

    public void setImageStream(InputStream image_stream) {
        this.image_stream = image_stream;
    }

    public byte[] getImageBytes() {
        return image_bytes;
    }

    public void setImageBytes(byte[] image_bytes) {
        this.image_bytes = image_bytes;
    }

    public ImageIcon getImageIcon() {
        return image_icon;
    }

    public void setImageIcon(ImageIcon image_icon) {
        this.image_icon = image_icon;
    }

    public BufferedImage getBufferedImage() {
        return buffered_image;
    }

    public void setBufferedImage(BufferedImage buffered_image) {
        this.buffered_image = buffered_image;
    }
}
