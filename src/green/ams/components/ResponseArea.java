package green.ams.components;

import green.ams.models.Attachements;
import green.ams.models.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResponseArea extends JPanel {

    private int item_id;
    private Response response;

    private JLabel lbRequestDate;
    private JPanel picturesBox;
    private JButton viewDetailsButton;
    private JScrollPane scrollImagesPane;

    public ResponseArea() {
        initComponents();
    }

    public ResponseArea(Response response) {
        this.response = response;
        initComponents();
    }

    public Response getResponse() {
        return response;
    }

    public void setData(Response response) {
        if (response == null) return;

        this.response = response;
        this.item_id = response.getId();

        lbRequestDate.setText("Requested Date: " + response.getRequested_date());
        setAttachmentImages(response);
    }

    public void setAttachmentImages(Response response) {
        try {
            picturesBox.removeAll();
            List<Attachements> attachments = response.getAttachements();

            if (attachments != null && !attachments.isEmpty()) {
                for (Attachements attachment : attachments) {
                    if (attachment.getImage_stream() != null) {
                        BufferedImage img = ImageIO.read(attachment.getImage_stream());
                        attachment.setBuffered_image(img);
                        Image scaled = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                        attachment.setImage_icon(new ImageIcon(scaled));

                        JLabel imageLabel = new JLabel(attachment.getImage_icon());
                        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        imageLabel.setPreferredSize(new Dimension(150, 100));
                        picturesBox.add(imageLabel);
                    }

                    File[] files = attachment.getFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file != null && file.exists()) {
                                attachment.setFile(file);
                            }
                        }
                    }
                }
            } else {
                JLabel noImagesLabel = new JLabel("No images available");
                noImagesLabel.setHorizontalAlignment(SwingConstants.CENTER);
                picturesBox.add(noImagesLabel);
            }

            picturesBox.revalidate();
            picturesBox.repaint();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error loading images", ex);
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(250, 250, 250));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(10, 10, 10, 10)
        ));

        // Header Section: Request Date
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(new EmptyBorder(0, 0, 10, 0));

        lbRequestDate = new JLabel("", SwingConstants.RIGHT);
        lbRequestDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbRequestDate.setForeground(new Color(33, 37, 41));
        headerPanel.add(lbRequestDate, BorderLayout.CENTER);

        // Images Section
        picturesBox = new JPanel();
        picturesBox.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        picturesBox.setBackground(new Color(245, 245, 245));
        picturesBox.setOpaque(true);

        scrollImagesPane = new JScrollPane(picturesBox);
        scrollImagesPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollImagesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollImagesPane.setPreferredSize(new Dimension(0, 120)); // Smaller height for preview

        // View Details Button
        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.setBackground(new Color(100, 150, 200));
        viewDetailsButton.setForeground(Color.WHITE);
        viewDetailsButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        viewDetailsButton.setFocusPainted(false);
        addHoverEffect(viewDetailsButton);
        viewDetailsButton.addActionListener(e -> showDetailsDialog());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(viewDetailsButton);

        // Main Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.add(headerPanel);
        contentPanel.add(scrollImagesPane);
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(buttonPanel);

        add(contentPanel, BorderLayout.CENTER);

        // Ensure responsiveness
        setPreferredSize(new Dimension(300, 300)); // Smaller preview card
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                adjustComponentSizes();
            }
        });
    }

    private void addHoverEffect(JButton button) {
        Color originalColor = button.getBackground();
        Color hoverColor = originalColor.brighter();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }

    private void adjustComponentSizes() {
        int width = getWidth() - 40; // Account for borders and padding
        scrollImagesPane.setPreferredSize(new Dimension(width, 200));
        revalidate();
        repaint();
    }

    private void showDetailsDialog() {
        JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(this), 
            "Response Details",
            Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(600, 500));

        // Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        detailsPanel.setBackground(new Color(250, 250, 250));

        // Response Info
        JLabel regionLabel = new JLabel("Region: " + response.getRegion_name());
        regionLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        regionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel descLabel = new JLabel("Description: " + response.getArea_description());
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel addressLabel = new JLabel("Address: " + response.getArea_address());
        addressLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel landAreaLabel = new JLabel("Land Area: " + response.getArea_land());
        landAreaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        landAreaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel dateLabel = new JLabel("Requested Date: " + response.getRequested_date());
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel statusLabel = new JLabel("Status: " + response.getStatus());
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statusLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        DecimalFormat df = new DecimalFormat("$#,##0.00");
        JLabel costLabel = new JLabel("Cost: " + df.format(response.getCost()));
        costLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        costLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Images Section
        JPanel imagesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        imagesPanel.setBackground(new Color(245, 245, 245));
        List<Attachements> attachments = response.getAttachements();
        if (attachments != null && !attachments.isEmpty()) {
            for (Attachements attachment : attachments) {
                if (attachment.getImage_icon() != null) {
                    JLabel imageLabel = new JLabel(attachment.getImage_icon());
                    imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    imageLabel.setPreferredSize(new Dimension(150, 100));
                    imagesPanel.add(imageLabel);
                }
            }
        } else {
            imagesPanel.add(new JLabel("No images available"));
        }

        JScrollPane imagesScrollPane = new JScrollPane(imagesPanel);
        imagesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        imagesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        imagesScrollPane.setPreferredSize(new Dimension(0, 200));
        imagesScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        imagesScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Attachments",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.PLAIN, 12)
        ));

        // Reply Section
        JTextArea replyArea = new JTextArea(4, 20);
        replyArea.setLineWrap(true);
        replyArea.setWrapStyleWord(true);
        replyArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        replyArea.setText(response.getReply());
        replyArea.setEditable(false);
        replyArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        JScrollPane replyScrollPane = new JScrollPane(replyArea);
        replyScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        replyScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Reply",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.PLAIN, 12)
        ));

        // Add components to details panel
        detailsPanel.add(regionLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(descLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(addressLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(landAreaLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(dateLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(statusLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(costLabel);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(imagesScrollPane);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(replyScrollPane);

        // Close Button
        JButton closeButton = new JButton("Close");
        closeButton.setBackground(new Color(150, 150, 150));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeButton.setFocusPainted(false);
        addHoverEffect(closeButton);
        closeButton.addActionListener(e -> dialog.dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(closeButton);

        // Add components to dialog
        dialog.add(new JScrollPane(detailsPanel), BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }
}