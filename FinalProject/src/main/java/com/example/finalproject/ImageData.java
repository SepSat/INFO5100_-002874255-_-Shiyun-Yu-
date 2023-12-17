package com.example.finalproject;

import org.apache.commons.imaging.*;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ImageData {
    private final String filePath;
    private int width;
    private int height;
    private String cameraModel;
    private String gpsInfo;

    public ImageData(String filePath) {
        this.filePath = filePath;
        extractImageInfo();
    }
    // Extract image information, e.g. size/dimensions/location/camera.
    private void extractImageInfo() {
        File imageFile = new File(this.filePath);
        try {
            BufferedImage image = ImageIO.read(imageFile);
            this.width = image.getWidth();
            this.height = image.getHeight();

            final ImageMetadata metadata = Imaging.getMetadata(imageFile);
            if (metadata instanceof TiffImageMetadata tiffMetadata) {
                if (tiffMetadata.getGPS() != null) {
                    TiffImageMetadata.GPSInfo gpsInfo = tiffMetadata.getGPS();
                    this.gpsInfo = "Lat: " + gpsInfo.getLatitudeAsDegreesNorth() + ", Lon: " + gpsInfo.getLongitudeAsDegreesEast();
                }
                this.cameraModel = extractCameraModel(tiffMetadata);
            }
        } catch (ImageReadException | IOException e) {
            // Log or handle the error
        }
    }
    // Extract camera model info if any.
    private String extractCameraModel(TiffImageMetadata metadata) {
        if (metadata != null) {
            try {
                for (TiffField field : metadata.getAllFields()) {
                    if (field.getTagName().equals("Model")) {
                        return field.getStringValue();
                    }
                }
            } catch (ImageReadException e) {
                e.printStackTrace(); // Replace with appropriate logging
            }
        }
        return "Unknown";
    }

    // Getters for the fields
    public String getFilePath() { return filePath; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getCameraModel() { return cameraModel; }
    public String getGpsInfo() { return gpsInfo; }
}

