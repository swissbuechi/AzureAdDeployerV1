package ch.netider.AzureAdDeployer.gui.model;

import ch.netider.AzureAdDeployer.service.FileService;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnectionModel {
    private final ObservableList<Connection> connectionsList = FXCollections.observableArrayList();

    private final ObjectProperty<Connection> currentConnection = new SimpleObjectProperty<>(null);

    public ObjectProperty<Connection> currentConnectionProperty() {
        return currentConnection;
    }

    public final Connection getCurrentConnection() {
        return currentConnection.get();
    }

    public final void setCurrentConnection(Connection connection) {
        currentConnection.set(connection);
    }

    public ObservableList<Connection> getConnectionsList() {
        return connectionsList;
    }

    public void loadConnectionList() {
        FileService fileService = new FileService();
        connectionsList.addAll(fileService.loadConnections().getConnections());
    }

}
