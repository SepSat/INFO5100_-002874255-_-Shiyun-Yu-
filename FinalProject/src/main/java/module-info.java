module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires org.apache.commons.imaging;

    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
}