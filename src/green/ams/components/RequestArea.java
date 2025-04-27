package green.ams.components;

import green.ams.GLOBAL;
import green.ams.controllers.AreaController;
import green.ams.models.Attachements;
import green.ams.models.Request;

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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestArea extends JPanel {

    private int item_id;
    private Request request;
    private JLabel lbRequest;
    private JPanel picturesBox;
    private JButton viewDetailsButton;
    private JScrollPane scrollImagesPane;

    public RequestArea() {
        initComponents();
    }

    public RequestArea(Request request) {
        this.request = request;
        initComponents();
    }

    public Request getRequest() {
        return request;
    }

    public void setData(Request request) {
        if (request == null) {
            return;
        }
        this.request = request;
        this.item_id = request.getId();

        lbRequest.setText("\u062A\u0627\u0631\u064A\u062E \u0625\u0631\u0633\u0627\u0644 \u0627\u0644\u0637\u0644\u0628: " + request.getRequested_date());
        setAttachmentImages(request);
    }

    public void setAttachmentImages(Request request) {
        try {
            picturesBox.removeAll();
            List<Attachements> attachments = request.getAttachements();

            if (attachments != null && !attachments.isEmpty()) {
                for (Attachements attachment : attachments) {
                    if (attachment.getImage_stream() != null) {
                        BufferedImage img = ImageIO.read(attachment.getImage_stream());
                        attachment.setBuffered_image(img);
                        Image scaled = img.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
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
                JLabel noImagesLabel = new JLabel("\u0644\u0627 \u064A\u0648\u062C\u062F \u0635\u0648\u0631");
                noImagesLabel.setHorizontalAlignment(SwingConstants.CENTER);
                picturesBox.add(noImagesLabel);
            }

            picturesBox.revalidate();
            picturesBox.repaint();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "\u062E\u0637\u0623 \u0641\u064A \u062A\u062D\u0645\u064A\u0644 \u0627\u0644\u0635\u0648\u0631", ex);
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

        lbRequest = new JLabel("", SwingConstants.RIGHT);
        lbRequest.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbRequest.setForeground(new Color(60, 60, 60));
        headerPanel.add(lbRequest, BorderLayout.CENTER);

        // Images Section
        picturesBox = new JPanel();
        picturesBox.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        picturesBox.setBackground(new Color(240, 240, 240));
        picturesBox.setOpaque(true);

        scrollImagesPane = new JScrollPane(picturesBox);
        scrollImagesPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollImagesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollImagesPane.setPreferredSize(new Dimension(0, 200)); // Smaller height for preview

        // View Details Button
        viewDetailsButton = new JButton(GLOBAL.currentLocale.getLanguage().equals("en") ? "View Details" : "عرض التفاصيل");
        viewDetailsButton.setBackground(new Color(100, 150, 200));
        viewDetailsButton.setForeground(Color.WHITE);
        viewDetailsButton.setFont(new Font("SansSerif", Font.BOLD, 12));
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
            GLOBAL.currentLocale.getLanguage().equals("en") ? "Request Details" : "تفاصيل الطلب",
            Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(600, 500));

        // Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        detailsPanel.setBackground(new Color(250, 250, 250));

        // Request Info
        JLabel regionLabel = new JLabel("Region: " + request.getRegion_name());
        regionLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        regionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel addressLabel = new JLabel("Address: " + request.getAddress());
        addressLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel landAreaLabel = new JLabel("Land Area: " + request.getLand_area());
        landAreaLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        landAreaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel dateLabel = new JLabel("Requested Date: " + request.getRequested_date());
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        dateLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Images Section
        JPanel imagesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        imagesPanel.setBackground(new Color(240, 240, 240));
        List<Attachements> attachments = request.getAttachements();
        if (attachments != null && !attachments.isEmpty()) {
            for (Attachements attachment : attachments) {
                if (attachment.getImage_icon() != null) {
                    JLabel imageLabel = new JLabel(attachment.getImage_icon());
                    imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    imageLabel.setPreferredSize(new Dimension(200, 150));
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
                new Font("SansSerif", Font.PLAIN, 12)
        ));

        // Description Section
        JTextArea taDescription = new JTextArea(3, 20);
        taDescription.setLineWrap(true);
        taDescription.setWrapStyleWord(true);
        taDescription.setFont(new Font("SansSerif", Font.PLAIN, 14));
        taDescription.setText(String.valueOf(request.getDescription())); // Adjust if using a description field
        taDescription.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        JScrollPane descriptionScrollPane = new JScrollPane(taDescription);
        descriptionScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Description",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 12)
        ));

        // Reply Section
        JTextArea taReply = new JTextArea(4, 20);
        taReply.setLineWrap(true);
        taReply.setWrapStyleWord(true);
        taReply.setFont(new Font("SansSerif", Font.PLAIN, 14));
        taReply.setText(request.getReply());
        taReply.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        JScrollPane replyScrollPane = new JScrollPane(taReply);
        replyScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        replyScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Reply",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.PLAIN, 12)
        ));

        // Add components to details panel
        detailsPanel.add(regionLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(addressLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(landAreaLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(dateLabel);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(imagesScrollPane);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(descriptionScrollPane);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(replyScrollPane);

        // Buttons Section
        JButton approveButton = new JButton(GLOBAL.currentLocale.getLanguage().equals("en") ? "Approve" : "موافقة");
        approveButton.setBackground(new Color(34, 139, 34));
        approveButton.setForeground(Color.WHITE);
        approveButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        approveButton.setFocusPainted(false);
        addHoverEffect(approveButton);

        JButton rejectButton = new JButton(GLOBAL.currentLocale.getLanguage().equals("en") ? "Reject" : "رفض");
        rejectButton.setBackground(new Color(220, 20, 60));
        rejectButton.setForeground(Color.WHITE);
        rejectButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        rejectButton.setFocusPainted(false);
        addHoverEffect(rejectButton);

        JButton closeButton = new JButton(GLOBAL.currentLocale.getLanguage().equals("en") ? "Close" : "إغلاق");
        closeButton.setBackground(new Color(150, 150, 150));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        closeButton.setFocusPainted(false);
        addHoverEffect(closeButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(closeButton);

        // Add components to dialog
        dialog.add(new JScrollPane(detailsPanel), BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        approveButton.addActionListener(e -> {
            request.setUser_id(GLOBAL.user_id);
            request.setReply(taReply.getText().trim());
            request.setCost(Double.parseDouble("0.0")); // Adjust if using a description field
            request.setStatus("Replied");

            AreaController area_controller = new AreaController();
            boolean success = area_controller.updateRequest(request);
            JOptionPane.showMessageDialog(dialog, success ? "Request updated successfully." : "Failed to update the request.");
            if (success) dialog.dispose();
        });

        rejectButton.addActionListener(e -> {
            request.setUser_id(GLOBAL.user_id);
            request.setReply(taReply.getText().trim());
            request.setCost(Double.parseDouble("0.0")); // Adjust if using a description field
            request.setStatus("Rejected");

            AreaController area_controller = new AreaController();
            boolean success = area_controller.updateRequest(request);
            JOptionPane.showMessageDialog(dialog, success ? "Request updated successfully." : "Failed to update the request.");
            if (success) dialog.dispose();
        });

        closeButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
        dialog.setVisible(true);
    }
}