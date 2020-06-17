package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.IOException;

public class MsolSession extends PsSession {

    private static final String CONNECT = "Connect-MsolService";
    public String status = "closed";

    public MsolSession() {
        super("MsolSession");
    }

    @Override
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
        } catch (IOException | NullPointerException ex) {
            ex.printStackTrace();
            super.error = rawOutput;
        } catch (PowerShellExecutionException e) {
            if (e.getMessage().contains("You must call the Connect-MsolService cmdlet before calling any other cmdlets")) {
                run(CONNECT);
            }
        }
        return null;
    }
}
