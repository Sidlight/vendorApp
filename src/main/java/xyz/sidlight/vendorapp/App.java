package xyz.sidlight.vendorapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import xyz.sidlight.vendorapp.gpio.GpioService;
import xyz.sidlight.vendorapp.gui.LogoController;

import java.io.File;
import java.io.IOException;

public class App extends Application {

    private static boolean playLogo = true;

    public static Scene mainScene;
    public static Scene menuScene;
    public static Scene voltScene;
    public static Scene powerScene;
    public static Scene amperageScene;
    public static Scene wifiScene;
    public static Scene settingsScene;
    public static Scene blueScene;
    public static Scene logoScene;
    public static MediaPlayer mediaPlayer;

    public static Stage primaryStage;

    public static void main(String[] args) {
        System.out.println("App start");
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        System.out.println("Scene loading started");
        loadScene();
        System.out.println("The scene is loaded");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        if (playLogo) {
            primaryStage.setScene(logoScene);
            primaryStage.show();
            mediaPlayer.play();
        } else {
            setMainScene();
        }
    }

    private void setMainScene() {
        primaryStage.setScene(mainScene);
        try {
            GpioService.getInstance().on();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadScene() throws IOException {

        Parent main = new FXMLLoader(App.class.getResource("main_pane.fxml")).load();
        mainScene = new Scene(main, 1366, 768);

        Parent menu = new FXMLLoader(App.class.getResource("menu_pane.fxml")).load();
        menuScene = new Scene(menu, 1366, 768);

        Parent amperage = new FXMLLoader(App.class.getResource("amperage_pane.fxml")).load();
        amperageScene = new Scene(amperage, 1366, 768);

        Parent power = new FXMLLoader(App.class.getResource("power_pane.fxml")).load();
        powerScene = new Scene(power, 1366, 768);

        Parent volt = new FXMLLoader(App.class.getResource("volt_pane.fxml")).load();
        voltScene = new Scene(volt, 1366, 768);

        Parent settings = new FXMLLoader(App.class.getResource("setting_pane.fxml")).load();
        settingsScene = new Scene(settings, 1366, 768);

        Parent wifi = new FXMLLoader(App.class.getResource("wi-fi_pane.fxml")).load();
        wifiScene = new Scene(wifi, 1366, 768);

        Parent blue = new FXMLLoader(App.class.getResource("blue_pane.fxml")).load();
        blueScene = new Scene(blue, 1366, 768);

        File mediaFile = new File("logo.mp4");

        Media media = new Media(mediaFile.toURI().toURL().toString());

        mediaPlayer = new MediaPlayer(media);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("logo.fxml"));
        Parent logo = fxmlLoader.load();
        logoScene = new Scene(logo, 1366, 768);

        LogoController controller =
                fxmlLoader.getController();

        MediaView mediaView1 = controller.getLogo();
        mediaView1.setMediaPlayer(mediaPlayer);
        mediaPlayer.setOnEndOfMedia(
                this::setMainScene
        );

    }
}
