package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.IOException;

public class MaintenanceSession extends PsSession {

    public MaintenanceSession(String name) {
        super(name);
    }

    public void run(String... input) {
        super.open();
        try {
            super.input = input;
            super.rawOutput = super.powerShell.executeCommands(input);
            super.output = super.rawOutput;
            if (super.output != null) {
                System.out.println(super.output);
            }
        } catch (PowerShellExecutionException | IOException | NullPointerException ex) {
            ex.printStackTrace();
            super.error = rawOutput;
        }
    }

}
