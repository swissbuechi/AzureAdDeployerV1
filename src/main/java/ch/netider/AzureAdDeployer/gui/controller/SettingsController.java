package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.service.maintenance.MaintenanceService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class SettingsController {

    @FXML
    private TextArea mainOutput;

    @FXML
    private ProgressIndicator progress;

    private MaintenanceService maintenanceService;

    public SettingsController() {
        maintenanceService = new MaintenanceService();
    }

    public void showInstalledModulesButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                return maintenanceService.showModule();
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


    public void installMsOnButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                maintenanceService.installModule();
                return maintenanceService.showModule();
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

    public void uninstallMsOnButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                maintenanceService.uninstallModule();
                return maintenanceService.showModule();
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
