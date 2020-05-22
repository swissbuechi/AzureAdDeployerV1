package ch.netider.AzureAdDeployer.console;

import java.io.IOException;

public class CliGui {
    private static final String VERSION = "0.1";

    //Clear CLI
    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    //Wait for Enter Key
    public void pressKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Display Application information
    public void run() {
        clearConsole();
        System.out.println(
                "\n" + "AzureAdDeployer " + VERSION + " by Netider.ch\n");
    }
}