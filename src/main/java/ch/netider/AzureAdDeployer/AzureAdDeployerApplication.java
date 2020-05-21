package ch.netider.AzureAdDeployer;

import ch.netider.AzureAdDeployer.console.CliSession;

public class AzureAdDeployerApplication {
    public static void main(String[] args) {
        CliSession cliSession1 = new CliSession("cliSession1");
        cliSession1.run();
    }
}