package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.config.AppConfig;
import ch.netider.AzureAdDeployer.gui.view.AlertHelper;
import ch.netider.AzureAdDeployer.util.CustomPaneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

public class MainNavigationController {

    private CustomPaneLoader customPaneLoader;

    @FXML
    private BorderPane mainPane;

    public MainNavigationController() {
        customPaneLoader = new CustomPaneLoader();
    }

    @FXML
    public void initialize() {
        mainPane.setCenter(customPaneLoader.getPane("welcome"));
    }

    @FXML
    public void openHomeButton() {
        mainPane.setCenter(customPaneLoader.getPane("home"));
    }

    @FXML
    public void openSettingsButton() {
        mainPane.setCenter(customPaneLoader.getPane("settings"));
    }

    @FXML
    public void openDashboardButton() {
        mainPane.setCenter(customPaneLoader.getPane("dashboard"));
    }

    @FXML
    public void openUsersManagerButton() {
        mainPane.setCenter(customPaneLoader.getPane("user_manager"));
    }

    @FXML
    public void openUsersManagerLegacyButton() {
        mainPane.setCenter(customPaneLoader.getPane("user_manager_legacy"));
    }

    @FXML
    public void openConsoleButton(){
        mainPane.setCenter(customPaneLoader.getPane("console"));
    }

    @FXML
    public void openAboutButton() {
        StringBuilder sb = new StringBuilder();
        sb.append(AppConfig.getAppName() + " " + AppConfig.getVersion());
        sb.append("\nDeveloped by ").append(AppConfig.getAuthor());
        new AlertHelper(Alert.AlertType.INFORMATION, "About", sb.toString());
    }

    @FXML
    public void openHelpButton() {
        new AlertHelper(Alert.AlertType.INFORMATION, "About", "Take a look at the Documentation " +
                "on Github: swissbuechi/AzureAdDeployer");
    }
}
