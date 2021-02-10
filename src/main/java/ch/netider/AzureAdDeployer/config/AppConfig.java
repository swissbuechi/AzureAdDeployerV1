package ch.netider.AzureAdDeployer.config;

public class AppConfig {

    private static final String APP_NAME = "AzureAdDeployer";
    private static final String AUTHOR = "netider.ch";
    private static final String VERSION = "2.0";
    private static final String HOTFIX = ".0";
    private static final String CONNECTIONS = "connections.json";

    public static String getAppName() {
        return APP_NAME;
    }

    public static String getAuthor() {
        return AUTHOR;
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getCONNECTIONS() {
        return CONNECTIONS;
    }
}
