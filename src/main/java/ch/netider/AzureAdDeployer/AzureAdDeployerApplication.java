package ch.netider.AzureAdDeployer;

import ch.netider.AzureAdDeployer.console.SessionManager;

public class AzureAdDeployerApplication {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("Session Manager");
        sessionManager.run();
    }
}