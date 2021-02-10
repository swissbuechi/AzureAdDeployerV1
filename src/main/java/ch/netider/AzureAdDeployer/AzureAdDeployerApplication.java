package ch.netider.AzureAdDeployer;

import ch.netider.AzureAdDeployer.gui.MainGui;
import ch.netider.AzureAdDeployer.gui.model.Connection;
import ch.netider.AzureAdDeployer.gui.model.Connections;
import ch.netider.AzureAdDeployer.service.FileService;

import java.util.ArrayList;

public class AzureAdDeployerApplication {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
//        FileService fileService = new FileService();
//
//        Connection connection1 = new Connection("Test", "peter@peter");
//        Connections connections = new Connections();
//        connections = fileService.loadConnections();
//        connections.addConnection(connection1);
//        fileService.saveConnections(connections);

        MainGui mainGui = new MainGui();
        mainGui.show();
    }

}
