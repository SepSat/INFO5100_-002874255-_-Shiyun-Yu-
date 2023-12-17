package com.example.finalproject;

// Factory design pattern
public class ImageConverterFactory {
    public static ImageConverter getConverter(String outputFormat) throws ImageConverter.ImageConverterException {
        return switch (outputFormat.toLowerCase()) {
            case "png" -> new PNGConverter();
            case "jpg", "jpeg" -> new JPGConverter();
            default -> throw new ImageConverter.ImageConverterException("Unsupported format: " + outputFormat);
        };
    }
}

