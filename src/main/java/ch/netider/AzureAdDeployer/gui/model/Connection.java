package ch.netider.AzureAdDeployer.gui.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Connection {

    private static final AtomicInteger UNIQUE_ID = new AtomicInteger();
    private final Integer id;
    private String name;
    private boolean status;
    private String userPrinzipalName;

    public Connection(String name, String userPrinzipalName) {
        this.name = name;
        this.userPrinzipalName = userPrinzipalName;
        this.id = UNIQUE_ID.incrementAndGet();
    }

    public Connection(String name, String userPrinzipalName, boolean status) {
        this.name = name;
        this.userPrinzipalName = userPrinzipalName;
        this.status = status;
        this.id = UNIQUE_ID.incrementAndGet();
    }

    public Connection(int id, String name, String userPrinzipalName, boolean status) {
        this.id = id;
        this.name = name;
        this.userPrinzipalName = userPrinzipalName;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserPrinzipalName() {
        return userPrinzipalName;
    }

    public void setUserPrinzipalName(String userPrinzipalName) {
        this.userPrinzipalName = userPrinzipalName;
    }

    @Override
    public String toString() {
        return name;
    }
}
