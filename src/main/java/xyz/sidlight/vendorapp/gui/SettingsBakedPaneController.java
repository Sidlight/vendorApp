package xyz.sidlight.vendorapp.gui;

import xyz.sidlight.vendorapp.App;

public abstract class SettingsBakedPaneController extends BackedPaneController{

    @Override
    protected void onBack(){
        App.primaryStage.setScene(App.settingsScene);
        App.primaryStage.setMaximized(true);
        App.primaryStage.show();
    }
}
