package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.config.AppConfig;
import ch.netider.AzureAdDeployer.gui.view.AlertHelper;
import ch.netider.AzureAdDeployer.gui.view.ConnectionManagementView;
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


    public void initialize() {
        mainPane.setCenter(customPaneLoader.getPane("welcome"));
    }


    public void openHomeButton() {
        mainPane.setCenter(customPaneLoader.getPane("home"));
    }


    public void openConnectionOverviewButton() {
        mainPane.setCenter(customPaneLoader.getPane("connection_overview_legacy"));
    }


    public void openSettingsButton() {
        mainPane.setCenter(customPaneLoader.getPane("settings"));
    }


    public void openUsersManagerButton() {
        mainPane.setCenter(customPaneLoader.getPane("user_manager"));
    }


    public void openUsersManagerLegacyButton() {
        mainPane.setCenter(customPaneLoader.getPane("user_manager_legacy"));
    }


    public void openConsoleButton() {
        mainPane.setCenter(customPaneLoader.getPane("console"));
    }


    public void openEditButton() {
        mainPane.setCenter(new ConnectionManagementView());
    }


    public void openAboutButton() {
        StringBuilder sb = new StringBuilder();
        sb.append(AppConfig.APP_NAME + " " + AppConfig.VERSION);
        sb.append("\nDeveloped by ").append(AppConfig.AUTHOR);
        new AlertHelper(Alert.AlertType.INFORMATION, "About", sb.toString());
    }


    public void openHelpButton() {
        new AlertHelper(Alert.AlertType.INFORMATION, "About", "Take a look at the Documentation " +
                "on Github: swissbuechi/AzureAdDeployer");
    }
}
