package xyz.sidlight.vendorapp.gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import xyz.sidlight.vendorapp.App;

public class MainPaneController {

    @FXML
    protected void onMenuMenu() {
        setScene(App.menuScene);
    }

    @FXML
    protected void onSettingsMenu() {
        setScene(App.settingsScene);
    }

    @FXML
    protected void onPowerMenu() {
        setScene(App.powerScene);
    }

    @FXML
    protected void onVoltMenu() {
        setScene(App.voltScene);
    }

    @FXML
    protected void onAmperageMenu() {
        setScene(App.amperageScene);
    }

    @FXML
    protected void onTestMenu() {

    }

    private void setScene(Scene scene) {
        App.primaryStage.setScene(scene);
        App.primaryStage.setMaximized(true);
        App.primaryStage.show();
    }


}
