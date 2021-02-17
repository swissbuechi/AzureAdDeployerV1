package ch.netider.AzureAdDeployer.gui.view;

import ch.netider.AzureAdDeployer.gui.model.Connection;
import ch.netider.AzureAdDeployer.service.FileService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.List;

public class ConnectionManagementView extends GridPane {


    private ObservableList<Connection> connectionObservableList;
    private FileService fileService;

    private TableView tableView;
    private TextField tfConnectionName;
    private TextField tfUserPrinzipalName;
    private CheckBox checkBoxIsActive;
    private Button buttonSaveChange;

    private Integer selectedID;

    public ConnectionManagementView() {
        fileService = new FileService();
        List<Connection> connectionList = fileService.loadConnections().getConnections();

        createUserTable();

        if (!connectionList.isEmpty()) {
            connectionObservableList.addAll(connectionList);
        }
        createAndPlaceChangeForm();

        setAlignment(Pos.CENTER);
        setVgap(10);
        setHgap(10);
    }

    private void createUserTable() {
        tableView = new TableView<>();
        tableView.setMinHeight(320);
        tableView.setMinWidth(320);

        connectionObservableList = FXCollections.observableArrayList();

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> change(obs, oldSelection, newSelection));

        TableColumn connectionName = new TableColumn("Name");
        connectionName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn userPrinzipalName = new TableColumn("Username");
        userPrinzipalName.setCellValueFactory(new PropertyValueFactory<>("userPrinzipalName"));


        TableColumn status = new TableColumn("Active");

        status.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Connection, Boolean>, ObservableValue<Boolean>>) param -> {
            Connection connection = param.getValue();
            SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty(connection.isStatus());
            return simpleBooleanProperty;
        });

        status.setCellFactory((Callback<TableColumn<Connection, Boolean>, TableCell<Connection, Boolean>>) p -> {
            CheckBoxTableCell<Connection, Boolean> tableCell = new CheckBoxTableCell<>();
            tableCell.setAlignment(Pos.CENTER);
            return tableCell;
        });

        tableView.getColumns().addAll(connectionName, userPrinzipalName, status);

        tableView.setItems(connectionObservableList);

        add(tableView, 0, 0, 5, 1);
    }

    private void createAndPlaceChangeForm() {
        createFormFieldConnectioName();
        createFormFieldUserPrinzipalName();
        createFormFieldIsActive();

        createFormButtonSave();
        createFormButtonCancel();
        createFormButtonAdd();
        createFormButtonDel();
    }


    private void createFormFieldConnectioName() {
        Label lblConnectionName = new Label("Name");
        tfConnectionName = new TextField();
        add(lblConnectionName, 1, 1);
        add(tfConnectionName, 2, 1, 2, 1);
    }

    private void createFormFieldUserPrinzipalName() {
        Label lblUserPrinzipalName = new Label("Username");
        tfUserPrinzipalName = new TextField();
        add(lblUserPrinzipalName, 1, 2);
        add(tfUserPrinzipalName, 2, 2, 2, 1);
    }


    private void createFormFieldIsActive() {
        Label lblIsActive = new Label("Active");
        checkBoxIsActive = new CheckBox();
        add(lblIsActive, 1, 4);
        add(checkBoxIsActive, 2, 4, 2, 1);
    }

    /**
     * Erstellt den Save Button und platziert ihn auf dem Pane
     */
    private void createFormButtonSave() {
        buttonSaveChange = new Button("Save");
        buttonSaveChange.setOnAction(e -> save());
        add(buttonSaveChange, 2, 5);
    }

    /**
     * Erstellt den Abbrechen Button und platziert ihn auf dem Pane
     */
    private void createFormButtonCancel() {
        Button buttonCancel = new Button("Cancel");
        buttonCancel.setOnAction(e -> cancel());
        add(buttonCancel, 3, 5);
    }

    private void createFormButtonAdd() {
        buttonSaveChange = new Button("Add");
        buttonSaveChange.setOnAction(e -> add());
        add(buttonSaveChange, 4, 5);
    }

    private void createFormButtonDel() {
        buttonSaveChange = new Button("Delete");
        buttonSaveChange.setOnAction(e -> delete());
        add(buttonSaveChange, 5, 5);
    }


    private void change(ObservableValue obs, Object oldSelection, Object newSelection) {
        Connection c = (Connection) obs.getValue();

        if (c != null) {
            selectedID = c.getID();

            tfConnectionName.setText(c.getName());
            tfUserPrinzipalName.setText(c.getUserPrinzipalName());
            checkBoxIsActive.setSelected(c.isStatus());
        } else {
            cancel();
        }
    }

    private void save() {
        String connectionName = tfConnectionName.getText();
        String userPrinzipalName = tfUserPrinzipalName.getText();

        if (selectedID != null
                && connectionName != null && connectionName.length() > 0
                && userPrinzipalName != null && userPrinzipalName.length() > 0) {
            fileService.updateConnection(new Connection(selectedID, connectionName, userPrinzipalName, checkBoxIsActive.isSelected()));

            List<Connection> connectionList = fileService.loadConnections().getConnections();
            connectionObservableList.clear();
            connectionObservableList.addAll(connectionList);
        } else {
            System.err.println("No valid input");
        }
    }


    private void add() {
        String connectionName = tfConnectionName.getText();
        String userPrinzipalName = tfUserPrinzipalName.getText();

        if (selectedID == null
                && connectionName != null && connectionName.length() > 0
                && userPrinzipalName != null && userPrinzipalName.length() > 0) {
            fileService.addConnection(new Connection(connectionName, userPrinzipalName, checkBoxIsActive.isSelected()));

            List<Connection> connectionList = fileService.loadConnections().getConnections();
            connectionObservableList.clear();
            connectionObservableList.addAll(connectionList);
        } else {
            System.err.println("No valid input");
        }
    }

    private void delete() {
        String connectionName = tfConnectionName.getText();
        String userPrinzipalName = tfUserPrinzipalName.getText();

        if (selectedID != null
                && connectionName != null && connectionName.length() > 0
                && userPrinzipalName != null && userPrinzipalName.length() > 0) {
            fileService.removeConnection(new Connection(selectedID, connectionName, userPrinzipalName, checkBoxIsActive.isSelected()));

            List<Connection> connectionList = fileService.loadConnections().getConnections();
            connectionObservableList.clear();
            connectionObservableList.addAll(connectionList);
        } else {
            System.err.println("No valid input");
        }
    }

    private void cancel() {
        tableView.getSelectionModel().clearSelection();
        selectedID = null;
        tfConnectionName.setText("");
        tfUserPrinzipalName.setText("");
        checkBoxIsActive.setSelected(false);
    }
}
