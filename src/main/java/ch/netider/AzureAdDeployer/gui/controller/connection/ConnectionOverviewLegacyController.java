package ch.netider.AzureAdDeployer.gui.controller.connection;

import ch.netider.AzureAdDeployer.gui.model.ConnectionModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ConnectionOverviewLegacyController {

    private ConnectionModel model;

    @FXML
    private BorderPane pane;

    public void initialize() {
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("/fxml/connection_list.fxml"));
        try {
            pane.setCenter(listLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConnectionListController listController = listLoader.getController();
        model = new ConnectionModel();
        listController.initModel(model);
        model.loadConnectionList();
    }
}
