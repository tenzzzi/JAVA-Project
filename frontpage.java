/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class IFrontPage extends JFrame {

    public IFrontPage() {
        // Set up the frame
        setTitle("PUPBC Smart Attendance Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null); // Center the window on screen

        // Background Panel with image
        JPanel backgroundPanel = new JPanel() {
            Image background = new ImageIcon("EFwBb0wUwAE52CB.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, 100, 200, this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Center panel for logo and title
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false); // Transparent background

        // PUP Logo
        JLabel logo = new JLabel(new ImageIcon("images.png"));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalGlue()); // Push content to vertical center
        centerPanel.add(logo);

       // Replace only your title label code with this:
        JLabel title = new JLabel(
        "<html><div style='text-align: center; color: #FF0000; font-weight: bold;'>" +
        "WELCOME TO PUP<br>BIÑAN CITE CAMPUS<br>SMART ATTENDANCE TRACKER" +
        "</div></html>"
        );
        title.setFont(new Font("Arial", Font.BOLD, 20));

        // Create a dedicated panel for perfect centering
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);
        titlePanel.add(title);

        // Replace your existing centerPanel.add(title) with:
        centerPanel.add(Box.createVerticalGlue());  // Push content up
        centerPanel.add(titlePanel);
        centerPanel.add(Box.createVerticalGlue());  // Push content down
        centerPanel.add(Box.createVerticalStrut(20)); // Space before buttons
        

        // Button Panel (at bottom)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false); // Transparent background
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 100, 20)); // Binawasan ang bottom padding

        JButton startButton = new JButton("START");
        startButton.addActionListener((ActionEvent e) -> {
            // Open the start page
            new DestinationSelector().setVisible(true);
            // Optional: hide the current window
            // IFrontPage.this.setVisible(false);
        });

        // Center buttons horizontally
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set button sizes
        Dimension buttonSize = new Dimension(100, 30);
        startButton.setPreferredSize(buttonSize);
        startButton.setMaximumSize(buttonSize);

        buttonPanel.add(Box.createVerticalGlue()); // Push buttons down
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createVerticalStrut(10));

        // Add components to background panel
        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add background panel to frame
        add(backgroundPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IFrontPage frame = new IFrontPage();
            frame.setVisible(true);
        });
    }
}
