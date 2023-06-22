package com.GauPass.easterEgg;

import java.awt.Color;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.MouseEvent;

import com.GauPass.MainFrame;
import com.GauPass.constants.UI_icon_path;
import com.GauPass.constants.UI_sound_path;
import com.GauPass.utils.IconSizeChanger;
import com.GauPass.utils.SoundPlayer;

public class SecretFrame extends JFrame {
    private MainFrame mainFrame;
    private JLabel imageLabel;

    public SecretFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void initialize() {

        // Create a transparent frame
        setUndecorated(true); // Remove frame decorations
        setBackground(new Color(0, 0, 0, 0)); // Set transparent background
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the PNG image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(UI_icon_path.APP_ICON));

        /* Resize the icons if necessary */
        imageIcon = new IconSizeChanger().ChangeIconSize(imageIcon, 256, 256);

        imageLabel = new JLabel(imageIcon);

        // Add the image to the frame
        getContentPane().add(imageLabel);

        // Set the frame size based on the desired width and height
        setSize(256, 256);

        // Set the frame position
        setLocationRelativeTo(null); // Center the frame on the screen

        // Add mouse listeners to make the frame draggable
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                closeFrame();
                mainFrame.resume();
            }
        });

        // Make the frame visible
        setVisible(true);
        SoundPlayer.playSound(UI_sound_path.SUS_SOUND);

        // Start the animation to move the frame to the left
        startAnimation();
    }

    private void startAnimation() {
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int startX = getLocation().x;
        int startY = getLocation().y;

        // Calculate the final X and Y coordinates where the frame should stop
        int targetX = screenWidth - frameWidth;
        int targetY = screenHeight - frameHeight;

        // Calculate the total distance to be covered
        int totalDistanceX = Math.abs(startX - targetX);
        int totalDistanceY = Math.abs(startY - targetY);

        // Set the duration of the animation (in milliseconds)
        int animationDuration = 5000; // Adjust this value as needed

        // Calculate the distance to move in each step of the animation
        int stepDistanceX = totalDistanceX / (animationDuration / 20); // 20 milliseconds per step
        int stepDistanceY = totalDistanceY / (animationDuration / 20); // 20 milliseconds per step

        // Variables to keep track of the current direction
        final int[] directionX = { 1 }; // 1 indicates moving towards the right, -1 indicates moving towards the left
        final int[] directionY = { 1 }; // 1 indicates moving towards the bottom, -1 indicates moving towards the top

        // Create a Timer to update the frame's location at regular intervals
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentX = getLocation().x;
                int currentY = getLocation().y;

                // Check if the frame has reached the target X coordinate
                if (currentX <= 0 || currentX >= targetX) {
                    directionX[0] *= -1; // Reverse the direction
                }

                // Check if the frame has reached the target Y coordinate
                if (currentY <= 0 || currentY >= targetY) {
                    directionY[0] *= -1; // Reverse the direction
                }

                // Calculate the new X coordinate
                int newX = currentX + (stepDistanceX * directionX[0]);

                // Calculate the new Y coordinate
                int newY = currentY + (stepDistanceY * directionY[0]);

                // Set the new location of the frame
                setLocation(newX, newY);
            }
        });

        // Start the timer
        timer.start();
    }

    public void closeFrame() {
        SoundPlayer.stopSound();
        setVisible(false); // Hide the frame
        dispose(); // Release system resources associated with the frame

    }
}
