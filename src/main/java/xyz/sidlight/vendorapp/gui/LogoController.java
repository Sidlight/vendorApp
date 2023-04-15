package xyz.sidlight.vendorapp.gui;

import javafx.fxml.FXML;
import javafx.scene.media.MediaView;

public class LogoController {
    @FXML
    private MediaView logo;

    public MediaView getLogo(){
        return this.logo;
    }
}
