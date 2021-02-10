package ch.netider.AzureAdDeployer.service;

import ch.netider.AzureAdDeployer.config.AppConfig;
import ch.netider.AzureAdDeployer.gui.model.Connections;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;

import java.io.*;


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
        try {
            this.reader = new JsonReader(new FileReader(configPath + AppConfig.getCONNECTIONS()));
        } catch (IOException e){
            e.printStackTrace();
        }
        Connections connections = gson.fromJson(reader, Connections.class);
        if (connections != null){
            return connections;
        }
        return new Connections();
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

    public String getConfigPath() {
        return configPath;
    }
}