package ch.netider.AzureAdDeployer;

import ch.netider.AzureAdDeployer.gui.MainGui;

public class AzureAdDeployerApplication {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        MainGui mainGui = new MainGui();
        mainGui.show();
    }
}
