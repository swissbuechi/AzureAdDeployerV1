package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.util.CustomPaneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

public class DashboardController {

    private CustomPaneLoader customPaneLoader;

    @FXML
    private BorderPane mainPane;

    @FXML
    private MenuBar topMenu;

    public DashboardController(){
        customPaneLoader = new CustomPaneLoader();
    }

    @FXML
    public void initialize() {
        mainPane.setCenter(customPaneLoader.getPane("welcome"));
    }

    @FXML
    public void openSettingsButton() {
        mainPane.setCenter(customPaneLoader.getPane("settings"));
    }

    @FXML
    public void openDashboardButton() {
        mainPane.setCenter(customPaneLoader.getPane("welcome"));
    }

    @FXML
    public void openConnectionsButton() {
        mainPane.setCenter(customPaneLoader.getPane("connection"));
    }

}
