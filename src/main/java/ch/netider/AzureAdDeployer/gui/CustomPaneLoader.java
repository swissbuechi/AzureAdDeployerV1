package ch.netider.AzureAdDeployer.gui;

import ch.netider.AzureAdDeployer.AzureAdDeployerApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class CustomPaneLoader{
    private Pane view;
    public Pane getPane(String fileName) {
        try {
            URL fileUrl = AzureAdDeployerApplication.class.getResource("/fxml/" + fileName + ".fxml");
            view = FXMLLoader.load(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }
}
