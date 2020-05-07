package ch.netider.AzureAdDeployer.console;

public class Menu {
    String name;
    String[] options;

    public Menu(String name, String[] options) {
        this.name = name;
        this.options = options;
    }

    public void print() {
        System.out.println(this.name + "\n");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ")" + "\t" + options[i]);
        }
        System.out.println(0 + ")" + "\t" + "exit");
    }
}