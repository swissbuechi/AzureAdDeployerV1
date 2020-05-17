package ch.netider.AzureAdDeployer.console;

import java.util.concurrent.atomic.AtomicInteger;

public class SessionManager {
    private static final AtomicInteger UNIQUE_ID = new AtomicInteger();
    int id;

    public SessionManager() {
        this.id = UNIQUE_ID.getAndIncrement();
    }

    public void run() {

    }

}
