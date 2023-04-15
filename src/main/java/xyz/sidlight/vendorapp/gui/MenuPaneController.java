package xyz.sidlight.vendorapp.gui;

import javafx.fxml.FXML;
import xyz.sidlight.vendorapp.gpio.GpioService;

import java.io.IOException;

public class MenuPaneController extends BackedPaneController{

    @FXML
    protected void onExit() throws IOException {
        GpioService.getInstance().off();

        String[] cm = { "shutdown", "-s", "0" };
        Runtime.getRuntime().exec("shutdown -h now");
        //System.exit(0);

    }

}
