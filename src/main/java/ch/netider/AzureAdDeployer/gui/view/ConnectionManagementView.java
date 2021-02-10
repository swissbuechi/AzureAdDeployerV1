//package ch.netider.AzureAdDeployer.gui.view;
//
//import ch.netider.AzureAdDeployer.gui.model.Connection;
//import ch.netider.AzureAdDeployer.service.FileService;
//import javafx.beans.property.SimpleBooleanProperty;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Pos;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.CheckBoxTableCell;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.GridPane;
//import javafx.util.Callback;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class ConnectionManagementView extends GridPane {
//
//
//    private ObservableList<Connection> playerObservableList;
//    private FileService databaseService;
//
//    private HashMap<String, Integer> permissions;
//
//    private TableView tableView;
//    private TextField tfSpielername;
//    private TextField tfLoginname;
//    private ComboBox cbPermission;
//    private CheckBox checkBoxIsActive;
//    private Button buttonSaveChange;
//
//    private Integer selectedUserID;
//
//    public ConnectionManagementView() {
//        databaseService = new FileService();
//        List<Connection> playerList = databaseService.loadConnections().getConnections();
//
//        createUserTable();
//        playerObservableList.addAll(playerList);
//
//        createAndPlaceChangeForm();
//
//        setAlignment(Pos.CENTER);
//        setVgap(10);
//        setHgap(10);
//    }
//
//    /**
//     * Erstellt eine Tabelle mit Spalten für die Benutzerverwaltung. Der Inhalt der Tabelle kann dynamisch befüllt und
//     * verändert werden. Das Boolean-Feld für "Ist Aktiv" wird als Checkbox dargestellt.
//     */
//    private void createUserTable() {
//        tableView = new TableView<>();
//        tableView.setMinHeight(320);
//        tableView.setMinWidth(320);
//
//        playerObservableList = FXCollections.observableArrayList();
//
//        tableView.getSelectionModel().selectedItemProperty().addListener(
//                (obs, oldSelection, newSelection) -> change(obs, oldSelection, newSelection));
//
//        TableColumn playerName = new TableColumn("Spielername");
//        playerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));
//
//        TableColumn loginname = new TableColumn("Username");
//        loginname.setCellValueFactory(new PropertyValueFactory<>("loginName"));
//
//        TableColumn permission = new TableColumn("Berechtigung");
//        permission.setCellValueFactory(new PropertyValueFactory<>("Permission"));
//
//
//        TableColumn active = new TableColumn("Ist Aktiv");
//        // Füllt die Checkboxen --> Kreuzt die Checkboxen an welche den Wert TRUE zugewiesen hätten/haben.
//        active.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Connection, Boolean>, ObservableValue<Boolean>>) param -> {
//            Connection connection = param.getValue();
//            SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty(connection.getActive());
//            return simpleBooleanProperty;
//        });
//        // formatiert den Inhalt der Zellen (boolean) in eine Checkbox um.
//        active.setCellFactory((Callback<TableColumn<Connection, Boolean>, TableCell<Connection, Boolean>>) p -> {
//            CheckBoxTableCell<Connection, Boolean> tableCell = new CheckBoxTableCell<>();
//            tableCell.setAlignment(Pos.CENTER);
//            return tableCell;
//        });
//
//        // Spalten der Tabelle hinzufügen
//        tableView.getColumns().addAll(playerName, loginname, permission, active);
//        // Elemente der Tabelle hinzufügen
//        tableView.setItems(playerObservableList);
//
//        add(tableView, 0, 0, 5, 1);
//    }
//
//    /**
//     * Erzeugt das Formular, ruft die entsprechenden Komponenten auf und platziert sie.
//     */
//    private void createAndPlaceChangeForm() {
//        createFormFieldSpielername();
//        createFormFieldUsername();
//        createFormFieldPermission();
//        createFormFieldIsActive();
//
//        createFormButtonSave();
//        createFormButtonCancel();
//    }
//
//    /**
//     * Erstellt ein Textfield mit Beschreibung und platziert sie auf dem Pane
//     */
//    private void createFormFieldSpielername() {
//        Label lblSpielername = new Label("Spielername");
//        tfSpielername = new TextField();
//        add(lblSpielername, 1, 1);
//        add(tfSpielername, 2, 1, 2, 1);
//    }
//
//    /**
//     * Erstellt ein Textfield mit Beschreibung und platziert sie auf dem Pane
//     */
//    private void createFormFieldUsername() {
//        Label lblUsername = new Label("Username");
//        tfLoginname = new TextField();
//        add(lblUsername, 1, 2);
//        add(tfLoginname, 2, 2, 2, 1);
//    }
//
//    /**
//     * Erstellt eine ComboBox mit Beschreibung und platziert sie auf dem Pane.
//     * Die ComboBox wird gleich befüllt
//     */
//    private void createFormFieldPermission() {
//        Label lblPermission = new Label("Berechtigung");
//        cbPermission = new ComboBox();
//        cbPermission.getItems().clear();
//        cbPermission.getItems().addAll(permissions.keySet());
//        add(lblPermission, 1, 3);
//        add(cbPermission, 2, 3, 2, 1);
//    }
//
//    /**
//     * Erstellt eine Checkbox mit Beschreibung und platziert sie auf dem Pane
//     */
//    private void createFormFieldIsActive() {
//        Label lblIsActive = new Label("Ist Aktiv");
//        checkBoxIsActive = new CheckBox();
//        add(lblIsActive, 1, 4);
//        add(checkBoxIsActive, 2, 4, 2, 1);
//    }
//
//    /**
//     * Erstellt den Save Button und platziert ihn auf dem Pane
//     */
//    private void createFormButtonSave() {
//        buttonSaveChange = new Button("Speichern");
//        buttonSaveChange.setOnAction(e -> save());
//        add(buttonSaveChange, 2, 5);
//    }
//
//    /**
//     * Erstellt den Abbrechen Button und platziert ihn auf dem Pane
//     */
//    private void createFormButtonCancel() {
//        Button buttonCancel = new Button("Abbrechen");
//        buttonCancel.setOnAction(e -> cancel());
//        add(buttonCancel, 3, 5);
//    }
//
//    /**
//     * Eventhandler der das Formularfeld beim Klick auf eine Zeile der Tabelle mit den ausgewählten Werten abfüllt.
//     *
//     * @param obs          Das ausgewählte Objekt
//     * @param oldSelection Der alte Wert/alte Auswahl
//     * @param newSelection Der neue Wert/neue Auswahl
//     */
//    private void change(ObservableValue obs, Object oldSelection, Object newSelection) {
//        Connection c = (Connection) obs.getValue();
//
//        if (c != null) {
//            selectedUserID = c.getID();
//
//            cbPermission.setValue(c.getPermission().getRecht());
//            tfSpielername.setText(c.getPlayerName());
//            tfLoginname.setText(c.getLoginName());
//            checkBoxIsActive.setSelected(c.getActive());
//        } else {
//            cancel();
//        }
//    }
//
//    /**
//     * Speichert die ausgewählte Zeile zurück in die Datenbank. Dabei werden alle manuellen Anpassungen/Änderungen
//     * übernommen.
//     */
//    private void save() {
//        String spielername = tfSpielername.getText();
//        String loginname = tfLoginname.getText();
//        Integer permissionID = permissions.get(cbPermission.getSelectionModel().getSelectedItem());
//
//        if (selectedUserID != null
//                && spielername != null && spielername.length() > 0
//                && loginname != null && loginname.length() > 0
//                && permissionID != null) {
//            databaseService.updateExistingUser(selectedUserID
//                    , spielername
//                    , loginname
//                    , checkBoxIsActive.isSelected()
//                    , permissionID);
//
//            List<Player> playerList = databaseService.getAllPlayer();
//            playerObservableList.clear();
//            playerObservableList.addAll(playerList);
//        } else {
//            System.err.println("Keine gültige Eingabe.");
//        }
//    }
//
//    /**
//     * Entfernt die komplette Auswahl. Keine Row in Tablle mehr selektiert und die Formularfelder wederden gelöscht.
//     */
//    private void cancel() {
//        // Entfernt die Auswahl
//        tableView.getSelectionModel().clearSelection();
//
//        // Entfernt alles aus den Formularfeldern.
//        selectedUserID = null;
//        cbPermission.setValue("");
//        tfSpielername.setText("");
//        tfLoginname.setText("");
//        checkBoxIsActive.setSelected(false);
//    }
//}
