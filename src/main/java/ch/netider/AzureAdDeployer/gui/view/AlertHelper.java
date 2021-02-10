package ch.netider.AzureAdDeployer.gui.view;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class AlertHelper extends Alert {

    public AlertHelper(AlertType alertType, Window owner, String title, String message) {
        super(alertType);
        this.setTitle(title);
        this.setHeaderText(null);
        this.setContentText(message);
        this.initOwner(owner);
        this.showAndWait();
    }
}
