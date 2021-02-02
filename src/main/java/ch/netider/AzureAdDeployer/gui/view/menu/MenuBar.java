package ch.netider.AzureAdDeployer.gui.view.menu;

import ch.netider.AzureAdDeployer.gui.view.management.AlertHelper;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuBar extends BorderPane {

    public MenuBar() throws IOException {
        createMainMenu();
    }

    private void createMainMenu() throws IOException {
        javafx.scene.control.MenuBar menuBar = new javafx.scene.control.MenuBar();
        menuBar.getMenus().addAll(createMenus());
        setTop(menuBar);
    }

    private List<Menu> createMenus() {
        List<Menu> menuList = new ArrayList<>();

        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(createFileMenuItems());
        menuList.add(fileMenu);

        Menu help = new Menu("?");
        help.getItems().addAll(createHelpMenuItems());
        menuList.add(help);

        return menuList;
    }

    private List<MenuItem> createFileMenuItems() {
        List<MenuItem> menuItemList = new ArrayList<>();

        MenuItem loadMi = new MenuItem("Load Connections");
        loadMi.setOnAction(e -> {
            try {
                openLoadConnectionsView();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        menuItemList.add(loadMi);

        MenuItem saveMi = new MenuItem("Save Connections");
        saveMi.setOnAction(e -> SaveConnectionsView());
        menuItemList.add(saveMi);

        return menuItemList;
    }

    private List<MenuItem> createHelpMenuItems() {
        List<MenuItem> menuItemList = new ArrayList<>();

        MenuItem helpMi = new MenuItem("Help");
        helpMi.setOnAction(e -> openHelp());
        menuItemList.add(helpMi);

        MenuItem infoMi = new MenuItem("Info");
        infoMi.setOnAction(e -> openInfo());
        menuItemList.add(infoMi);

        return menuItemList;
    }

    private void openLoadConnectionsView() throws IOException {

        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/create_connection_form.fxml"));
        //setCenter(root);
    }


    private void SaveConnectionsView() {
        //LoginView login = new LoginView(this);
        //setCenter(login);
    }

    private void openHelp() {

        String text = "Take a look at the Documentation: ";
        Hyperlink hyperlink = new Hyperlink("https://onenote.com");
        Window owner = getScene().getWindow();
        new AlertHelper(Alert.AlertType.INFORMATION, owner, "Hilfe", text, hyperlink);
    }

    private void openInfo() {
        String text = "(c) BBH AG\nAutoren L. Barmettler, R. Büchi, A. Hildebrandt\n\nLizenziert für ABB Technikerschule, Baden\n\nVersion: 1.0.0";
        Window owner = getScene().getWindow();
        new AlertHelper(Alert.AlertType.INFORMATION, owner, "Info", text);
    }
}

