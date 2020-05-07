package ch.netider.AzureAdDeployer;

import ch.netider.AzureAdDeployer.console.CliGui;
import ch.netider.AzureAdDeployer.console.Menu;


public class AzureAdDeployerApplication {
    public static void main(String[] args) {
        CliGui cliGui1 = new CliGui();
        cliGui1.start();
        String[] mainMenuList = {"Option1", "Option2", "Option3"};
        Menu mainMenu = new Menu("Main", mainMenuList);
        mainMenu.print();
    }
}