//package ch.netider.AzureAdDeployer.gui.view;
//
//import ch.swe.privat.services.DatabaseService;
//import javafx.geometry.Pos;
//import javafx.scene.control.*;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.GridPane;
//import javafx.scene.text.Text;
//
//public class RegisterNewConnectionView extends GridPane {
//
//    private DatabaseService databaseService;
//
//    private TextField tfLastName;
//    private TextField tfUserName;
//    private PasswordField pwfPasswort;
//    private Label lblFeedback;
//
//    public RegisterNewConnectionView() {
//        databaseService = new DatabaseService();
//
//        setHgap(6);
//        setVgap(10);
//        setAlignment(Pos.CENTER);
//
//        Text txt = new Text("Bitte alle Felder ausfüllen um einen neuen Benutzer zu erstellen:");
//        add(txt, 0, 0, 2, 1);
//
//
//        Label lblName = new Label("Nachname*:");
//        add(lblName, 0, 1);
//
//        tfLastName = new TextField();
//        addEnterKeyListenerToFormElements(tfLastName);
//        add(tfLastName, 1, 1);
//
//
//        Label lblUserName = new Label("Username*:");
//        add(lblUserName, 0, 2);
//
//        tfUserName = new TextField();
//        addEnterKeyListenerToFormElements(tfUserName);
//        add(tfUserName, 1, 2);
//
//
//        Label lblPasswort = new Label("Password*:");
//        add(lblPasswort, 0, 3);
//
//        pwfPasswort = new PasswordField();
//        addEnterKeyListenerToFormElements(pwfPasswort);
//        add(pwfPasswort, 1, 3);
//
//
//        Button create = new Button("Neuer Account");
//        create.setOnAction(e -> createNewUser());
//        add(create, 0, 4);
//
//
//        lblFeedback = new Label("");
//        lblFeedback.setVisible(false);
//        add(lblFeedback, 0, 6, 2, 1);
//    }
//
//    /**
//     * Fügt den Controleelementen einen Listener hinzu, der hört auf ENTER-Eingaben. Mit Enter soll das Formular validiert
//     * werden und ggf. eingeloggt werden ohne, dass der Button mit der Maus angeklickt wurde.
//     *
//     * @param control  Das Controlelement
//     */
//    private void addEnterKeyListenerToFormElements(Control control) {
//        control.setOnKeyPressed(ke -> {
//            lblFeedback.setVisible(false); // entfernt die Meldung wieder, wenn angefangen wird zu schreiben.
//            if (ke.getCode().equals(KeyCode.ENTER))
//                createNewUser();
//        });
//    }
//
//    /**
//     * Versucht einen neuen Benutzer anzulegen. Gibt Feedback, wenn etwas nicht stimmt oder der User angelegt wurde.
//     */
//    private void createNewUser() {
//        boolean isLastNameSet = false;
//        boolean isUserNameSet = false;
//        boolean isPwdNameSet = false;
//
//        if (tfLastName.getText() != null && tfLastName.getText().trim().length() > 0) {
//            isLastNameSet = true;
//        }
//
//        if (tfUserName.getText() != null && tfUserName.getText().trim().length() > 0) {
//            isUserNameSet = true;
//        }
//
//        if (pwfPasswort.getText() != null && pwfPasswort.getText().trim().length() > 0) {
//            isPwdNameSet = true;
//        }
//
//        if (isLastNameSet && isUserNameSet && isPwdNameSet) {
//            if (databaseService.checkIfNewUserCanBeCreated(tfUserName.getText())) {
//                databaseService.createNewUser(tfLastName.getText(), tfUserName.getText(), pwfPasswort.getText());
//                lblFeedback.setText("Nachname: " + tfLastName.getText() + "\n"
//                        + "Benutzername: " + tfUserName.getText() + "\n"
//                        + "wurde erstellt");
//            } else {
//                lblFeedback.setText("Nachname: " + tfLastName.getText() + "\n"
//                        + "Benutzername: " + tfUserName.getText() + "\n"
//                        + "konnte nicht erstellt werden.\n" +
//                        "Der Benutzername wird bereits verwendet.");
//            }
//            clearTestFields();
//        } else {
//            lblFeedback.setText("Bitte alle Felder ausfüllen!");
//        }
//        lblFeedback.setVisible(true);
//    }
//
//    /**
//     * Leert die Felder
//     */
//    private void clearTestFields() {
//        tfLastName.setText("");
//        tfUserName.setText("");
//        pwfPasswort.setText("");
//    }
//}
