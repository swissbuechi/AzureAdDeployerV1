package ch.netider.AzureAdDeployer.gui.controller.connection;

import ch.netider.AzureAdDeployer.util.CustomPaneLoader;
import com.jfoenix.controls.JFXMasonryPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class ConnectionOverviewController {

    private CustomPaneLoader customPaneLoader;
    private FXMLLoader loader;

    @FXML
    private JFXMasonryPane grid;

    public ConnectionOverviewController() {
        customPaneLoader = new CustomPaneLoader();
        loader = new FXMLLoader();
    }

    public void initialize() {
    }
}
