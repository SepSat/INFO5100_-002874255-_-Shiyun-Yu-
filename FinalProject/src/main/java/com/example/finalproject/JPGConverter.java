package com.example.finalproject;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class JPGConverter implements ImageConverter {
    @Override
    public BufferedImage convertFormat(String imagePath, String outputFormat) throws ImageConverterException {
        try {
            File inputFile = new File(imagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);

            // Create a new buffered image with a white background to handle transparency
            BufferedImage newImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = newImage.createGraphics();
            graphics.drawImage(inputImage, 0, 0, Color.WHITE, null);
            graphics.dispose();

            return newImage; // Return the new image instead of writing it to a file
        } catch (IOException e) {
            throw new ImageConverterException("Failed to convert image to JPG", e);
        }
    }
}
//    private String getOutputFilePath(String originalPath, String newFormat) {
//        return originalPath.substring(0, originalPath.lastIndexOf('.')) + "_converted." + newFormat;
//    }
