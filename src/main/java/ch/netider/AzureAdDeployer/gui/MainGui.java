package ch.netider.AzureAdDeployer.gui;

import ch.netider.AzureAdDeployer.gui.view.menu.MenuBar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGui extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        MenuBar menuBar = new MenuBar();
        buildMainView(primaryStage, menuBar);
    }

    public void show() {
        launch();
    }

    private void buildMainView(Stage primaryStage, MenuBar menuBar) throws IOException {
        AnchorPane mainView = FXMLLoader.load(getClass().getResource("/fxml/mainMenu.fxml"));
        menuBar.setLeft(mainView);
        Scene scene = new Scene(menuBar, 1600, 850);
        scene.getStylesheets().add("stylesheet.css");
        primaryStage.setTitle("AzureAdDeployer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
