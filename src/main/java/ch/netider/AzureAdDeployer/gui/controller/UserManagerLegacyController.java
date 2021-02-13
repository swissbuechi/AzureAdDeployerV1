package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.service.msol.MsolService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class UserManagerLegacyController {

    @FXML
    TextArea mainOutput;

    private MsolService msolService;

    public UserManagerLegacyController() {
        msolService = new MsolService();
    }

    public void showAllUsersButton(ActionEvent event){
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                return msolService.showAllUsers();
            }
            @Override
            protected void succeeded() {
                mainOutput.setText(call());
            }
        };
        new Thread(task).start();
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
