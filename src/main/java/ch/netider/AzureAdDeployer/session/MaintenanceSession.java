package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.IOException;

public class MaintenanceSession extends PsSession {

    public MaintenanceSession() {
        super("MaintenanceSession");
    }

    public String run(String... input) {
        super.open();
        try {
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
