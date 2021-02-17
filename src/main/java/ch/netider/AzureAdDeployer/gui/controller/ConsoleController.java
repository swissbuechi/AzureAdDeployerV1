package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.config.AppConfig;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ConsoleController {
    @FXML
    private Label appName;

    @FXML
    private Label author;

    @FXML
    public void initialize() {
        appName.setText(AppConfig.getAppName() + " " + AppConfig.getVersion());
        author.setText("Developed by " + AppConfig.getAuthor());
    }
}
