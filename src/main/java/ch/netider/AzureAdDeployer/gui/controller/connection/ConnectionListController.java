package ch.netider.AzureAdDeployer.gui.controller.connection;

import ch.netider.AzureAdDeployer.gui.model.Connection;
import ch.netider.AzureAdDeployer.gui.model.ConnectionModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ConnectionListController {

    @FXML
    private ListView<Connection> listView;

    private ConnectionModel model;

    public void initModel(ConnectionModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }

        this.model = model;
        listView.setItems(model.getConnectionsList());

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
                model.setCurrentConnection(newSelection));

        model.currentConnectionProperty().addListener((obs, oldConnection, newConnection) -> {
            if (newConnection == null) {
                listView.getSelectionModel().clearSelection();
            } else {
                listView.getSelectionModel().select(newConnection);
            }
        });
    }
}
