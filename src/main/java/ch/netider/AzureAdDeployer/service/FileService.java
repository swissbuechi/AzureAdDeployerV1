package ch.netider.AzureAdDeployer.service;

import ch.netider.AzureAdDeployer.config.AppConfig;
import ch.netider.AzureAdDeployer.gui.model.Connection;
import ch.netider.AzureAdDeployer.gui.model.Connections;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;

import java.io.*;
import java.util.List;


public class FileService {

    private final String configPath;
    private final Gson gson;
    private JsonReader reader;

    public FileService() {
        final AppDirs appDirs = AppDirsFactory.getInstance();
        this.configPath = appDirs.getUserConfigDir(AppConfig.getAppName(), "", AppConfig.getAuthor());
        this.gson = new Gson();
    }

    public Connections loadConnections() {
        Connections connections = new Connections();
        try {
            this.reader = new JsonReader(new FileReader(configPath + AppConfig.getCONNECTIONS()));
            connections = gson.fromJson(reader, Connections.class);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        if (!connections.getConnections().isEmpty()) {
            return connections;
        }
        connections.addConnection(new Connection("Default", "examle@example.com", true));
        saveConnections(connections);
        return connections;
    }

    public void saveConnections(Connections connections) {
        try {
            File file = new File(configPath + AppConfig.getCONNECTIONS());
            file.getParentFile().mkdirs();
            String connectionsData = gson.toJson(connections);
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(configPath + AppConfig.getCONNECTIONS())));
            printWriter.print(connectionsData);
            printWriter.close();
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public void updateConnection(Connection connection) {
        List<Connection> connectionList = loadConnections().getConnections();
        System.out.println(connectionList);
        List<Connection> newConnectionList = loadConnections().getConnections();
        for (Connection c : connectionList) {
            if (c.getID().equals(connection.getID())) {
                System.out.println(c.getID());
                newConnectionList.set(connectionList.indexOf(c), connection);
            }
        }
        System.out.println(connectionList);
        System.out.println(newConnectionList);
        Connections newConnections = new Connections();
        newConnections.setConnections(newConnectionList);
        saveConnections(newConnections);
    }

    public void addConnection(Connection c) {
        List<Connection> connectionList = loadConnections().getConnections();
        connectionList.add(c);
        saveConnections(new Connections(connectionList));
    }

    public void removeConnection(Connection connection) {
        List<Connection> connectionList = loadConnections().getConnections();
        System.out.println(connectionList);
        List<Connection> newConnectionList = loadConnections().getConnections();
        for (Connection c : connectionList) {
            if (c.getID().equals(connection.getID())) {
                System.out.println(c.getID());
                newConnectionList.remove(connectionList.indexOf(c));
            }
        }
        System.out.println(connectionList);
        System.out.println(newConnectionList);
        Connections newConnections = new Connections();
        newConnections.setConnections(newConnectionList);
        saveConnections(newConnections);
    }

    public String getConfigPath() {
        return configPath;
    }
}