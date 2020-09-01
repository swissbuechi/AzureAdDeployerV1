package ch.netider.AzureAdDeployer.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLI Menu
 */
public class Menu {
    private static final String EXIT = "0";
    private final String name;
    private final List<MenuOption> menuOptions = new ArrayList<>();
    private String description;
    private int level = 0;

    public Menu(int level, String name, String description) {
        this.description = description;
        this.level = level;
        this.name = name;
    }

    public Menu(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public Menu(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void addOption(MenuOption option) {
        this.menuOptions.add(option);
    }

    /**
     * Run the Menu
     */
    public void run() {
        try {
            String input;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println(this);
                input = scanner.nextLine();
                if (input.equals(EXIT)) {
                    return;
                }
                final String finalInput = input;
                for (MenuOption menuOption : menuOptions) {
                    if (menuOption.getOption().equalsIgnoreCase(input)) {
                        menuOption.selectOption();
                    }
                }
            }
        } catch (java.util.NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Print the Menu
     * @return Menu structure
     */
    @Override
    public String toString() {
        CliGui cliGui1 = new CliGui();
        cliGui1.run();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append("\n\n");
        for (MenuOption menuOption : menuOptions) {
            stringBuilder.append(menuOption).append("\n");
        }
        stringBuilder.append("    " + EXIT + ".  Exit\n\n");
        stringBuilder.append("    Select Menu Number [" + EXIT + "-" + menuOptions.size() + "]");
        return stringBuilder.toString();
    }
}