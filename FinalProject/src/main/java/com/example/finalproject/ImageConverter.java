package com.example.finalproject;

import java.awt.image.BufferedImage;

// Interface demonstration.
public interface ImageConverter {
    BufferedImage convertFormat(String imagePath, String outputFormat) throws ImageConverterException;
    // ImageConverterException as a nested static class
    class ImageConverterException extends Exception {
        public ImageConverterException(String message) {
            super(message);
        }

        public ImageConverterException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}


