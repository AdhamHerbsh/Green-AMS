package green.ams.components;

import green.ams.models.Attachements;
import green.ams.models.Request;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestArea extends JPanel {

    private int item_id;
    private Request request;

    private JLabel lbItemID;
    private JTextArea lbDescription;
    private JLabel lbRequest;
    private JLabel lbCost;
    private JTextArea lbReply;
    private JPanel picturesBox;
    private JButton Agree;
    private JButton Cancel;
    private JScrollPane ScrollImagesPane;

    public RequestArea() {
        initComponents();
    }

    public void setData(Request request) {
        if (request == null) {
            return;
        }
        this.request = request;
        this.item_id = request.getId();

        if (lbRequest != null) {
            lbRequest.setText(request.getReply());
        }

        if (lbDescription != null) {
            lbDescription.setText(request.getReply());
        }

        if (lbCost != null) {
            DecimalFormat df = new DecimalFormat("$#,##0.00");
            lbCost.setText(df.format(request.getCost()));
        }

        setAttachmentImages(request);
    }

    public void setAttachmentImages(Request request) {
        try {
            picturesBox.removeAll(); // Clear old images

            List<Attachements> attachments = request.getAttachements();
            if (attachments != null && !attachments.isEmpty()) {
                for (Attachements attachement : attachments) {
                    if (attachement.getImage_stream() != null) {
                        BufferedImage img = ImageIO.read(attachement.getImage_stream());
                        attachement.setBuffered_image(img);
                        Image scaled = img.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
                        attachement.setImage_icon(new ImageIcon(scaled));

                        JLabel imageLabel = new JLabel(attachement.getImage_icon());
                        imageLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                        imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        picturesBox.add(imageLabel);
                    }

                    // File handling (optional)
                    File[] files = attachement.getFiles();
                    if (files != null && files.length > 0) {
                        for (File file : files) {
                            if (file != null && file.exists()) {
                                attachement.setFile(file);
                            }
                        }
                    }
                }
            } else {
                JLabel noImageLabel = new JLabel("No images available");
                picturesBox.add(noImageLabel);
            }

            picturesBox.revalidate();
            picturesBox.repaint();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error loading images", ex);
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 255, 243));

        // Info Panel
        JPanel PanelRequestInfo = new JPanel(new GridLayout(2, 1));
        PanelRequestInfo.setOpaque(false);
        PanelRequestInfo.setBorder(new EmptyBorder(10, 10, 10, 10));

        lbRequest = new JLabel("Item Name", SwingConstants.CENTER);
        lbRequest.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lbRequest.setForeground(new Color(76, 76, 76));
        lbRequest.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
        PanelRequestInfo.add(lbRequest);

        lbCost = new JLabel("$0.00", SwingConstants.CENTER);
        lbCost.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lbCost.setForeground(new Color(76, 76, 76));
        PanelRequestInfo.add(lbCost);

        // Images Scroll Pane
        picturesBox = new JPanel();
        picturesBox.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        picturesBox.setBackground(new Color(237, 239, 230));

        ScrollImagesPane = new JScrollPane(picturesBox);
        ScrollImagesPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ScrollImagesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollImagesPane.setPreferredSize(new Dimension(460, 220));

        // Description Area
        lbDescription = new JTextArea(4, 20);
        lbDescription.setLineWrap(true);
        lbDescription.setWrapStyleWord(true);
        lbDescription.setOpaque(false);
        lbDescription.setFont(new Font("Traditional Arabic", Font.PLAIN, 14));
        JScrollPane ScrollTextAreaPane = new JScrollPane(lbDescription);
        ScrollTextAreaPane.setBorder(null);
        ScrollTextAreaPane.setOpaque(false);
        ScrollTextAreaPane.setPreferredSize(new Dimension(460, 120));

        // Buttons
        Agree = new JButton("Send");
        Agree.setBackground(new Color(102, 153, 0));
        Agree.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
        Agree.setBorder(new EmptyBorder(5, 30, 5, 30));

        Cancel = new JButton("Hold");
        Cancel.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
        Cancel.setBorder(new EmptyBorder(5, 30, 5, 30));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(Agree);
        buttonPanel.add(Cancel);

        // Add all to main layout
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.add(PanelRequestInfo);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(ScrollImagesPane);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(ScrollTextAreaPane);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(buttonPanel);

        add(contentPanel, BorderLayout.CENTER);
    }
}
