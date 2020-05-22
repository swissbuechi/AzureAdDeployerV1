package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShell;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public class PsSession {

    private static final AtomicInteger UNIQUE_ID = new AtomicInteger();

    private final String name;
    private final int id;
    private final String type = "Ps";
    public String status = "closed";
    public String[] input;
    public String output;
    public String error;
    public String rawOutput;
    public PowerShell powerShell;

    public PsSession(String name) {
        this.name = name;
        this.id = UNIQUE_ID.getAndIncrement();
    }

    public void open() {
        try {
            if (this.status.equals("closed")) {
                this.powerShell = PowerShell.open();
                this.status = "open";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            this.status = "error";
        }
    }
}