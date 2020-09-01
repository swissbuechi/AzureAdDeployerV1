package ch.netider.AzureAdDeployer.console;

/**
 * CLI Menu Option
 */
public abstract class MenuOption {
    private final String option;
    private final String name;
    private String description;

    public MenuOption(String option, String name) {
        this.option = option;
        this.name = name;
    }

    public MenuOption(String option, String name, String description) {
        this.option = option;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getOption() {
        return this.option;
    }

    public abstract void selectOption();

    /**
     * Print the MenuOption
     * @return MenuOption
     */
    @Override
    public String toString() {
        return "    " + this.option + ".  " + this.name;
    }
}