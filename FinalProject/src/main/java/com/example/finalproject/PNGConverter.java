package com.example.finalproject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PNGConverter implements ImageConverter {
    @Override
    public BufferedImage convertFormat(String imagePath, String outputFormat) throws ImageConverterException {
        try {
            File inputFile = new File(imagePath);
            return ImageIO.read(inputFile); // Simply return the original image for PNG
        } catch (IOException e) {
            throw new ImageConverterException("Failed to convert image to PNG", e);
        }
    }
}