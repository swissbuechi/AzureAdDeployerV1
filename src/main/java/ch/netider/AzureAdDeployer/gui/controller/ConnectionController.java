package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.service.msol.MsolService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ConnectionController {

    @FXML
    TextArea mainOutput;

    private MsolService msolService;

    public ConnectionController() {
        msolService = new MsolService();
    }

    public void showAllUsersButton(ActionEvent event){
        mainOutput.setText(msolService.showAllUsers());
    }

    public void createBgAccountsButton(ActionEvent event){

    }

    public void showBgAccountsButton(ActionEvent event){

    }

    public void removeBgAccountsButton(ActionEvent event){

    }

    public void checkMfaStatusButton(ActionEvent event){

    }

    public void enableMfaForAllButton(ActionEvent event){

    }

    public void disableMfaForAllButton(ActionEvent event){

    }
}
