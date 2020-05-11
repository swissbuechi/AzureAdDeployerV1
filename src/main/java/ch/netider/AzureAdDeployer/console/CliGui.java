package ch.netider.AzureAdDeployer.console;

import java.io.IOException;

public class CliGui {
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void start() {
        clearConsole();
        System.out.println(
                "\n" + "AzureAdDeployer 0.1" + "\n");
    }
}