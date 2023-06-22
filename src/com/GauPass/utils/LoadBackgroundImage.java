package com.GauPass.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadBackgroundImage {

    public BufferedImage loadImage(String imgPath) {
        /* Jar supported font loading */
        InputStream is = LoadBackgroundImage.class.getResourceAsStream(imgPath);
        try {
            return ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
