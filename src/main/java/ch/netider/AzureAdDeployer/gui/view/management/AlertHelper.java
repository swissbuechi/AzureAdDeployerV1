package ch.netider.AzureAdDeployer.gui.view.management;

import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Window;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class AlertHelper extends Alert {

//    public AlertHelper(AlertType alertType, Window owner, String title, String message, Hyperlink link) {
//        super(alertType);
//        this.setTitle(title);
//        this.setHeaderText(null);
//        this.initOwner(owner);
//        FlowPane fp = new FlowPane();
//        Label lbl = new Label(message);
//        link.setOnAction(actionEvent -> {
//            try {
//                URL url = new URL(link.toString());
//                Desktop.getDesktop().browse(url.toURI());
//            } catch (IOException | URISyntaxException e) {
//                e.printStackTrace();
//            }
//        });
//        fp.getChildren().addAll(lbl, link);
//        this.getDialogPane().contentProperty().set(fp);
//        this.showAndWait();
//    }

    public AlertHelper(AlertType alertType, Window owner, String title, String message) {
        super(alertType);
        this.setTitle(title);
        this.setHeaderText(null);
        this.setContentText(message);
        this.initOwner(owner);
        this.showAndWait();
    }

}
