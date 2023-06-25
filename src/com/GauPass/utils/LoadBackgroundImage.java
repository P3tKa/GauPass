package com.GauPass.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class LoadBackgroundImage {

    private HashMap<String, BufferedImage> imageCache = new HashMap<>();

    public BufferedImage loadImage(String imgPath) {
        /* Check if the image is already in cache */
        if (imageCache.containsKey(imgPath)) {
            return imageCache.get(imgPath);
        }

        /* Jar supported image loading */
        InputStream is = LoadBackgroundImage.class.getResourceAsStream(imgPath);
        try {
            BufferedImage image = ImageIO.read(is);

            /* Add the image to cache */
            imageCache.put(imgPath, image);

            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
