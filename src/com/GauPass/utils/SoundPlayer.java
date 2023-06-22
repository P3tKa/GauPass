package com.GauPass.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class SoundPlayer {
    private static Clip clip;

    public static void playSound(String resourcePath) {
        try {
            // Get the input stream of the resource file
            InputStream inputStream = SoundPlayer.class.getResourceAsStream(resourcePath);
            if (inputStream == null) {
                System.err.println("Sound resource not found: " + resourcePath);
                return;
            }

            // Create an audio input stream from the input stream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);

            // Get a clip to play the audio
            clip = AudioSystem.getClip();

            // Open the audio stream in the clip
            clip.open(audioInputStream);

            // Enable looping of the clip
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start playing the audio
            clip.start();
        } catch (Exception e) {
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
