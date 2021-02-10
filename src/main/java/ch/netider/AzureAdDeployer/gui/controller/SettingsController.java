package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.service.maintenance.MaintenanceService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SettingsController {

    @FXML
    TextArea mainOutput;

    private MaintenanceService maintenanceService;

    public SettingsController(){
        maintenanceService = new MaintenanceService();
    }

    public void showInstalledModulesButton(ActionEvent event){
        mainOutput.setText(maintenanceService.showModules());
    }


    public void installMsOnButton(ActionEvent event){
        maintenanceService.installMsol();
        mainOutput.setText(maintenanceService.showModules());
    }

    public void uninstallMsOnButton(ActionEvent event){
        maintenanceService.uninstallMsol();
        mainOutput.setText(maintenanceService.showModules());
    }
}
