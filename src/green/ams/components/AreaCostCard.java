package green.ams.components;

import green.ams.controllers.AdminController;
import green.ams.controllers.AreaController;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AreaCostCard extends JPanel {

    private int areaId;
    private String regionName;
    private String description;
    private double currentCost; // Current cost of the request

    private JLabel lblRegionName;
    private JLabel lblDescription;
    private JTextField tfCost;
    private JButton btnUpdateCost;

    public AreaCostCard(int areaId, String regionName, String description, double currentCost) {
        this.areaId = areaId;
        this.regionName = regionName;
        this.description = description;
        this.currentCost = currentCost;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(250, 250, 250));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(10, 10, 10, 10)
        ));

        // Area Details Section
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setOpaque(false);

        lblRegionName = new JLabel("Region: " + regionName);
        lblRegionName.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblRegionName.setForeground(new Color(60, 60, 60));
        lblRegionName.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblDescription = new JLabel("Description: " + description);
        lblDescription.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblDescription.setForeground(new Color(60, 60, 60));
        lblDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        detailsPanel.add(lblRegionName);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(lblDescription);
        detailsPanel.add(Box.createVerticalStrut(10));

        // Cost Input Section
        JPanel costPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        costPanel.setOpaque(false);

        JLabel lblCost = new JLabel("Cost: ");
        lblCost.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tfCost = new JTextField(String.valueOf(currentCost), 10);
        tfCost.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tfCost.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        costPanel.add(lblCost);
        costPanel.add(tfCost);

        // Button Section
        btnUpdateCost = new JButton("Update Cost");
        btnUpdateCost.setBackground(new Color(34, 139, 34));
        btnUpdateCost.setForeground(Color.WHITE);
        btnUpdateCost.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnUpdateCost.setFocusPainted(false);
        addHoverEffect(btnUpdateCost);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnUpdateCost);

        // Assemble the card
        add(detailsPanel, BorderLayout.NORTH);
        add(costPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Ensure responsiveness
        setPreferredSize(new Dimension(300, 150));

        // Add action listener for the button
        btnUpdateCost.addActionListener(e -> updateCostActionPerformed());
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

    private void updateCostActionPerformed() {
        try {
            double newCost = Double.parseDouble(tfCost.getText().trim());
            if (newCost < 0) {
                JOptionPane.showMessageDialog(this, "Cost cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            AreaController area_controller = new AreaController();
            boolean success = area_controller.updateRequestCostByAreaId(areaId, newCost);

            if (success) {
                JOptionPane.showMessageDialog(this, "Cost updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                currentCost = newCost;
                int choice = JOptionPane.showConfirmDialog(this, "You want to increase the user by 50 points");

                switch (choice) {
                    case 0:
                        AdminController admin_controller = new AdminController();

                        if (admin_controller.updateUserScore(areaId)) {
                            JOptionPane.showMessageDialog(null, "User Score Updated");
                        } else {
                            JOptionPane.showMessageDialog(null, "User Score Doesn't Updated");
                        }

                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Thanks For Your Work");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Good Bye");
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Failed to update cost.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the cost.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
