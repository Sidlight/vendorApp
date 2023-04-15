package xyz.sidlight.vendorapp.gui;

import javafx.scene.input.MouseEvent;
import xyz.sidlight.vendorapp.App;

public class SettingController extends BackedPaneController{
    public void onWifi(MouseEvent mouseEvent) {
        setScene(App.wifiScene);
    }

    public void onBlue(MouseEvent mouseEvent) {
        setScene(App.blueScene);
    }
}
