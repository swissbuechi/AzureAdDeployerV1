package ch.netider.AzureAdDeployer;

import ch.netider.AzureAdDeployer.console.CliSession;

public class AzureAdDeployerApplication {
    public static void main(String[] args) {
        CliSession cliSession = new CliSession();
        cliSession.run();
    }
}