package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.gui.model.Connection;
import ch.netider.AzureAdDeployer.gui.view.management.AlertHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.awt.event.ActionEvent;

public class CreateConnectionFormController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private Button submitButton;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();
        if (nameField.getText().isEmpty()) {
            new AlertHelper(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a Connection name");
            return;
        }
        if (emailField.getText().isEmpty()) {
            new AlertHelper(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }

        Connection connection = new Connection(nameField.getText(), emailField.getText());


        new AlertHelper(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + nameField.getText());
    }
}
