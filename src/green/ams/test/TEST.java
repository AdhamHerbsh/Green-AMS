package green.ams.test;

import javax.swing.*;
import java.awt.*;

public class TEST {

    private void image() {
        JFrame frame = new JFrame("Resized Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\Adham\\Documents\\NetBeansProjects\\Green (AMS)\\src\\green\\ams\\test\\green.png"); // Change to your image path
        Image scaledImage = originalIcon.getImage().getScaledInstance(600, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(resizedIcon);
        frame.add(label);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

    }
}
