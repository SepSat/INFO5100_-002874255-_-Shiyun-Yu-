package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Inheritance demonstration.
public class HomeController extends VBox {
    // Encapsulation demonstration.
    private ListView<HBox> imageListView;
    private List<ImageData> imageDataList; // List to hold image data
    private Button uploadButton;
    private Button convertButton;
    private Button saveButton;
    private BufferedImage convertedImage; // To hold the converted image in memory
    private String targetFormat; // Add this line
    private FileChooser fileChooser;
    private ComboBox<String> formatComboBox;
    private ObservableList<String> availableFormats;
    private Label feedbackLabel;

    public HomeController() {
        initializeComponents();
        setupLayout();
        setupActions();
    }

    private void initializeComponents() {
        imageListView = new ListView<>();
        imageDataList = new ArrayList<>();
        uploadButton = new Button("Upload Image");
        convertButton = new Button("Convert Format");
        saveButton = new Button("Save Converted Image");
        fileChooser = new FileChooser();
        fileChooserSetup();
        availableFormats = FXCollections.observableArrayList("PNG", "JPG");
        formatComboBox = new ComboBox<>(availableFormats);
        formatComboBox.setPromptText("Select Format");
        feedbackLabel = new Label();
    }

    private void fileChooserSetup() {
        fileChooser.setTitle("Select Images");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    private void setupLayout() {
        HBox buttonBar = new HBox(10, uploadButton, convertButton, formatComboBox, saveButton);
        buttonBar.setPadding(new Insets(10));
        this.getChildren().addAll(buttonBar, imageListView, feedbackLabel);
    }

    private void setupActions() {
        uploadButton.setOnAction(event -> handleUploadAction());
        convertButton.setOnAction(event -> handleConvertAction());
        saveButton.setOnAction(event -> handleSaveAction());
    }

    private void handleConvertAction() {
        String selectedImagePath = getSelectedImagePath();
        this.targetFormat = formatComboBox.getValue(); // Store the selected target format

        if (selectedImagePath != null && targetFormat != null) {
            try {
                // Perform the conversion and store the result in 'convertedImage'
                ImageConverter converter = ImageConverterFactory.getConverter(targetFormat);
                convertedImage = converter.convertFormat(selectedImagePath, targetFormat);
                feedbackLabel.setText("Conversion successful. Choose a location to save the image.");
            } catch (ImageConverter.ImageConverterException e) {
                feedbackLabel.setText("Error during conversion: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            feedbackLabel.setText("Please select an image and format.");
        }
    }

    private void handleSaveAction() {
        if (convertedImage == null) {
            feedbackLabel.setText("No converted image to save.");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        String fileExtension = targetFormat.toLowerCase();

        // Set the file extension filters based on the target format
        switch (fileExtension) {
            case "png":
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
                break;
            case "jpg":
            case "jpeg": // Assuming jpeg as well, adjust as needed
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG Files", "*.jpg"));
                break;
            // Add other format cases as needed
        }

        // Set the initial filename with the correct extension
        fileChooser.setInitialFileName("converted_image." + fileExtension);

        File fileToSave = fileChooser.showSaveDialog(null);
        if (fileToSave != null) {
            try {
                ImageIO.write(convertedImage, fileExtension, fileToSave);
                feedbackLabel.setText("Image saved to: " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                feedbackLabel.setText("Error saving image: " + e.getMessage());
            }
        }
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        } else {
            return ""; // Default or error handling
        }
    }

    private void handleUploadAction() {
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(this.getScene().getWindow());
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                displayImage(file);
            }
        }
    }

    private void displayImage(File file) {
        ImageData imageData = new ImageData(file.getAbsolutePath());
        imageDataList.add(imageData);
        Image image = new Image(file.toURI().toString(), 100, 100, true, true);
        ImageView imageView = new ImageView(image);
        Label imageInfo = new Label("Name: " + file.getName() + "\nSize: " + file.length() + " bytes");
        HBox hbox = new HBox(10, imageView, imageInfo);
        hbox.setPadding(new Insets(5));
        imageListView.getItems().add(hbox);
    }
    private String getSelectedImagePath() {
        HBox selectedHBox = imageListView.getSelectionModel().getSelectedItem();
        if (selectedHBox != null) {
            int selectedIndex = imageListView.getSelectionModel().getSelectedIndex();
            ImageData selectedImageData = imageDataList.get(selectedIndex);
            return selectedImageData.getFilePath();
        }
        return null;
    }

    private String getOutputFilePath(String originalPath, String newFormat) {
        return originalPath.substring(0, originalPath.lastIndexOf('.')) + "_converted." + newFormat;
    }
}
