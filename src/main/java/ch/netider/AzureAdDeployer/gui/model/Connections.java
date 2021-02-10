package ch.netider.AzureAdDeployer.gui.model;

import java.util.ArrayList;
import java.util.List;

public class Connections {

    private List<Connection> connections;

    public Connections() {
        this.connections = new ArrayList<>();
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }

    public void removeConnection(int id) {
        this.connections.removeIf(c -> c.getID().equals(id));
    }
}
