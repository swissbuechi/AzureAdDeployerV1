package ch.netider.AzureAdDeployer.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * CliGui for user interaction
 */
public class CliGui {
    private static final String VERSION = "1.0";

    /**
     * Clear CLI
     */
    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Wait for Enter Key
     */
    public void pressKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Wait for confirmation
     */
    public boolean waitForConfirmation() {
        System.out.println("Are you sure you want to continue?");
        System.out.println("y = Yes or n = No");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                return true;
            }
            if (input.equalsIgnoreCase("n")) {
                return false;
            }
        }
    }

    /**
     * Display Application information
     */
    public void run() {
        clearConsole();
        System.out.println(
                "\n" + "AzureAdDeployer " + VERSION + " by netider.ch\n");
    }

    /**
     * Class not used jet!
     * Input Users
     * @return users
     */
    public List<String> input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the UserPrinzipleNames (Comma separated): ");
        List<String> users = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(", ")));
        for (String user : users) {
            System.out.println(user);
        }
        return users;
    }
}