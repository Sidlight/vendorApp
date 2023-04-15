package xyz.sidlight.vendorapp.gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import xyz.sidlight.vendorapp.App;

public abstract class BackedPaneController {

    @FXML
    protected void onBack(){
        setScene(App.mainScene);
    }

    protected void setScene(Scene scene){
        App.primaryStage.setScene(scene);
        App.primaryStage.setMaximized(true);
        App.primaryStage.show();
    }
}
