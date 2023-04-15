module vendorApp {
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.controls;


    opens xyz.sidlight.vendorapp.gui to javafx.fxml;
    opens xyz.sidlight.vendorapp to javafx.fxml;
    exports xyz.sidlight.vendorapp;
}