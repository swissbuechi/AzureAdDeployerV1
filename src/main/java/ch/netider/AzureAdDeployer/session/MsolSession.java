package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.IOException;

public class MsolSession extends PsSession {

    private static final String CONNECT = "Connect-MsolService";
    public String status = "closed";

    public MsolSession(String name) {
        super(name);
    }

    public String run(String... input) {
        super.open();
        try {
            if (this.status.equals("closed")) {
                this.status = "open";
                run(CONNECT);
                super.status = "open";
            }
            super.input = input;
            super.rawOutput = super.powerShell.executeCommands(input);
            super.output = super.rawOutput;
            if (super.output != null) {
                return super.output;
            }
        } catch (PowerShellExecutionException | IOException | NullPointerException ex) {
            ex.printStackTrace();
            super.error = rawOutput;
        }
        return null;
    }
}
