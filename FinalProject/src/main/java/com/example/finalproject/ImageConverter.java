package com.example.finalproject;

import java.awt.image.BufferedImage;

public interface ImageConverter {
    BufferedImage convertFormat(String imagePath, String outputFormat) throws ImageConverterException;
    // ImageConverterException as a nested static class
    public static class ImageConverterException extends Exception {
        public ImageConverterException(String message) {
            super(message);
        }

        public ImageConverterException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}


