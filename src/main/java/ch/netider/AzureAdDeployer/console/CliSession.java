package ch.netider.AzureAdDeployer.console;

public class CliSession {
    public void run() {
        MenuStructure menuStructure = new MenuStructure();
        menuStructure.start();
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
