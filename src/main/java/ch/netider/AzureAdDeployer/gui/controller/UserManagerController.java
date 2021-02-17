package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.config.AppConfig;
import ch.netider.AzureAdDeployer.service.microsoftonline.MicrosoftOnlineService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class UserManagerController {

    @FXML
    TextArea mainOutput;

    @FXML
    ProgressIndicator progress;

    private MicrosoftOnlineService microsoftOnlineService;
    @FXML
    private Label appName;
    @FXML
    private Label author;

    public UserManagerController() {
        microsoftOnlineService = new MicrosoftOnlineService();
    }


    @FXML
    public void initialize() {
        appName.setText(AppConfig.APP_NAME + " " + AppConfig.VERSION);
        author.setText("Developed by " + AppConfig.AUTHOR);
    }

    public void showAllUsersButton(ActionEvent event) {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                return microsoftOnlineService.showAllUsers();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }

}
