package ch.netider.AzureAdDeployer.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void addOption(MenuOption menuOption) {
        this.menuOptions.add(menuOption);
    }

    public void run() {
        String input;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(this);
            input = scanner.nextLine();
            if (input.equals(EXIT)) {
                return;
            }
            for (MenuOption menuOption : menuOptions) {
                if (menuOption.getOption().equalsIgnoreCase(input)) {
                    menuOption.selectOption();
                }
            }
        }
    }

    @Override
    public String toString() {
        CliGui cliGui1 = new CliGui();
        cliGui1.start();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------" + "\n");
        stringBuilder.append(this.name).append(":" + "\n");
        stringBuilder.append("------------------------------" + "\n");
        for (MenuOption menuOption : menuOptions) {
            stringBuilder.append(menuOption).append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("[" + EXIT + "] - exit" + "\n");
        stringBuilder.append("------------------------------");
        return stringBuilder.toString();
    }
}