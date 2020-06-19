package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShell;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class PsSession {

    private static final AtomicInteger UNIQUE_ID = new AtomicInteger();

    private final String name;
    private final int id;
    private String status = "closed";
    private String[] input;
    private String output;
    private String error;
    private String rawOutput;
    public PowerShell powerShell;

    public PsSession(String name) {
        this.name = name;
        this.id = UNIQUE_ID.getAndIncrement();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getInput() {
        return input;
    }

    public void setInput(String[] input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRawOutput() {
        return rawOutput;
    }

    public void setRawOutput(String rawOutput) {
        this.rawOutput = rawOutput;
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

    public abstract String run(String... input);
}