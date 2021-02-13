package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.service.maintenance.MaintenanceService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class SettingsController {

    @FXML
    TextArea mainOutput;

    @FXML
    ProgressIndicator progress;

    private MaintenanceService maintenanceService;

    public SettingsController() {
        maintenanceService = new MaintenanceService();
    }

    public void showInstalledModulesButton(ActionEvent event) {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                return maintenanceService.showModules();
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


    public void installMsOnButton(ActionEvent event) {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                maintenanceService.installMsol();
                return maintenanceService.showModules();
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

    public void uninstallMsOnButton(ActionEvent event) {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                maintenanceService.uninstallMsol();
                return maintenanceService.showModules();
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
