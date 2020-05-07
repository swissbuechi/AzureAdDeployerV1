package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShell;
import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;


public class PsSession {

    private static final AtomicInteger uniqueId = new AtomicInteger();

    public String name;
    public int id;
    public String type;
    public String status;
    public String input;
    public String output;
    public String error;
    public String rawOutput;
    public PowerShell powerShell;

    public PsSession(String name, String type) {
        this.name = name;
        this.id = uniqueId.getAndIncrement();
        this.type = type;
    }

    public void open() {
        try {
            this.powerShell = PowerShell.open();
            this.status = "open";
        } catch (IOException ex) {
            ex.printStackTrace();
            this.status = "error";
        }
    }

    public String run(String input) {
        if (this.powerShell != null) {
            try {
                this.input = input;
                this.rawOutput = this.powerShell.executeCommands(input);
                this.output = this.rawOutput;
                if (this.output != null) {
                    return this.output;
                }
            } catch (PowerShellExecutionException ex) {
                ex.printStackTrace();
                this.error = rawOutput;
            } catch (IOException ex) {
                ex.printStackTrace();
                this.error = rawOutput;
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                this.error = rawOutput;
            }
        } else {
            System.out.println("You first need to Open a Session");
        }
        return null;
    }
}