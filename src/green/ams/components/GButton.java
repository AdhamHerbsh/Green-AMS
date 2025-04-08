package green.ams.components;

import javax.swing.*;
import java.awt.*;

public class GButton extends JButton {

    public GButton() {
        super("Button");
        setFont(new Font("Tahoma", Font.BOLD, 18)); // Set font
        setForeground(Color.BLACK); // Set text color
        setContentAreaFilled(false); // Remove default button background
        setFocusPainted(false); // Remove focus outline
        setBorderPainted(false); // Remove default border
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Button background color
        g2.setColor(new Color(240, 255, 240)); // Light greenish-white
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40); // Rounded corners

        // Border
        g2.setColor(new Color(0, 80, 0)); // Dark green
        g2.setStroke(new BasicStroke(3)); // Thick border
        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 40, 40);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No default border painting
    }
}
