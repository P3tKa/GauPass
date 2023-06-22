package com.GauPass.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    private static Clip clip;

    public static void playSound(String resourcePath) {
        try {
            // Get the URL of the resource file
            URL resourceURL = SoundPlayer.class.getResource(resourcePath);
            if (resourceURL == null) {
                System.err.println("Sound resource not found: " + resourcePath);
                return;
            }

            // Create an audio input stream from the URL
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resourceURL);

            // Get a clip to play the audio
            clip = AudioSystem.getClip();

            // Open the audio stream in the clip
            clip.open(audioInputStream);

            // Enable looping of the clip
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start playing the audio
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
