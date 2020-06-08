package ch.netider.AzureAdDeployer.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CliGui {
    private static final String VERSION = "0.2";

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

    public List<String> input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the UserPrinzipleNames (Comma separated): ");
        List<String> users = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(", ")));
        for (String user : users) {
            System.out.println(user);
        }
        return users;
    }

    //Display Application information
    public void run() {
        clearConsole();
        System.out.println(
                "\n" + "AzureAdDeployer " + VERSION + " by Netider.ch\n");
    }
}