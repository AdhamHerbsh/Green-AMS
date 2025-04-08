/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.ams.components;

/**
 *
 * @author Adham
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A custom Swing component that displays a 5-star rating UI
 * and allows users to select a rating from 1 to 5.
 */
public class StarRating extends JPanel {
    private int selectedRating = 0;
    private final JButton[] stars = new JButton[5];

    public StarRating() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setBackground(new java.awt.Color(245,255,243)); // optional for modern look

        for (int i = 0; i < 5; i++) {
            final int rating = i + 1;
            JButton starButton = new JButton("☆");
            starButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 36));
            starButton.setBorderPainted(false);
            starButton.setFocusPainted(false);
            starButton.setContentAreaFilled(false);
            starButton.setForeground(Color.ORANGE);

            starButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setRating(rating);
                }
            });

            stars[i] = starButton;
            add(starButton);
        }
    }

    // Set the current rating and update star visuals
    public void setRating(int rating) {
        selectedRating = rating;
        for (int i = 0; i < 5; i++) {
            stars[i].setText(i < rating ? "★" : "☆");
        }
    }

    // Get the currently selected rating
    public int getRating() {
        return selectedRating;
    }
}
