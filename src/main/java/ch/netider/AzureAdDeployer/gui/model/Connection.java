package ch.netider.AzureAdDeployer.gui.model;

public class Connection {

    private String name;
    private String status;
    private String userPrinzipalName;

    public Connection(String name, String userPrinzipalName) {
        this.name = name;
        this.userPrinzipalName = userPrinzipalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserPrinzipalName() {
        return userPrinzipalName;
    }

    public void setUserPrinzipalName(String userPrinzipalName) {
        this.userPrinzipalName = userPrinzipalName;
    }
}
