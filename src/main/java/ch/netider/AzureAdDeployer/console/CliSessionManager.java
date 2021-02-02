package ch.netider.AzureAdDeployer.console;

import java.util.ArrayList;
import java.util.List;

public class CliSessionManager {
    private final String name;
    private final List<CliSession> sessions = new ArrayList<>();

    public CliSessionManager(String name) {
        this.name = name;
    }

    private void createSession(String name) {
        this.sessions.add(new CliSession(name));
    }

    public void run() {
        createSession("Cli Session 1");
        sessions.get(0).start();
    }
}
