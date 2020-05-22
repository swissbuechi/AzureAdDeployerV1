package ch.netider.AzureAdDeployer.console;

import java.util.concurrent.atomic.AtomicInteger;

public class CliSession {
    private static final AtomicInteger UNIQUE_ID = new AtomicInteger();
    private final String name;
    private final int id;

    public CliSession(String name) {
        this.id = UNIQUE_ID.getAndIncrement();
        this.name = name;
    }

    public void run() {
        MenuStructure menuStructure = new MenuStructure();
        menuStructure.run();
        close();
    }

    private void close() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.println("Shutting down AzureAdDeployer");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
    }
}
