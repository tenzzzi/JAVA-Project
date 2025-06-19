/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DestinationSelector extends JFrame {

    public DestinationSelector() {
        setTitle("Destination Selector");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Instruction label at top
        JLabel instructionLabel = new JLabel("<html><center>Hi, Please tap your<br>destination.</center></html>");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(instructionLabel, BorderLayout.NORTH);
        
        // Button panel in center
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        
        // Create buttons with different colors
        String[] buttonLabels = {"STUDENT", "FACULTY", "SECURITY PERSONNEL"};
        Color[] buttonColors = {
            new Color(128, 0, 0),    // MAROON for Student
            new Color(218, 165, 32), // YELLOW for Faculty
            new Color(0, 0, 0)  // BLACK for Security
        };
        
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = createStyledButton(buttonLabels[i], buttonColors[i]);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Space between buttons
        }
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(250, 60));
        button.setMaximumSize(new Dimension(250, 60));
        return button;
    }
    
    private class ButtonClickListener implements ActionListener {
        @Override
         public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String destination = source.getText();

            switch (destination) {
                case "STUDENT":
                    new StudentPage().setVisible(true);
                    break;
                case "FACULTY":
                    new FacultyPage().setVisible(true);
                    break;
                case "SECURITY PERSONNEL":
                    JOptionPane.showMessageDialog(null, "SecurityPage not implemented yet.");
                    break;
            }

            dispose(); // Close selector window
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DestinationSelector().setVisible(true);
        });
    }
}
