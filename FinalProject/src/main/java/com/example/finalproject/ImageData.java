package com.example.finalproject;

import java.io.File;

public class ImageData {
    private final String filePath;
    private final String displayName;
    private final long fileSize;

    public ImageData(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        this.displayName = file.getName();
        this.fileSize = file.length();
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDisplayName() {
        return displayName;
    }

    public long getFileSize() {
        return fileSize;
    }
}
