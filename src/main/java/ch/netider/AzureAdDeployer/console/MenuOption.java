package ch.netider.AzureAdDeployer.console;

public abstract class MenuOption {
    public String option;
    public String name;
    public String description;

    public MenuOption(String option, String name) {
        this.option = option;
        this.name = name;
    }

    public String getOption() {
        return this.option;
    }

    public abstract void selectOption();

    @Override
    public String toString() {
        return "[" + this.option + "] - " + this.name;
    }

}