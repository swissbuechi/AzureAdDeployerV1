package ch.netider.AzureAdDeployer.gui.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Connection {

    private static final AtomicInteger UNIQUE_ID = new AtomicInteger();
    private final Integer id;
    private String name;
    private String status;
    private String userPrinzipalName;

    public Connection(String name, String userPrinzipalName) {
        this.name = name;
        this.userPrinzipalName = userPrinzipalName;
        this.id = UNIQUE_ID.incrementAndGet();
    }

    public Integer getID() {
        return this.id;
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
