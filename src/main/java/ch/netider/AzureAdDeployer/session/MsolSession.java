package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.IOException;

public class MsolSession extends PsSession {

    private static final String CONNECT = "Connect-MsolService";
    private static final String ERROR = "You must call the Connect-MsolService cmdlet before calling any other cmdlets";

    public MsolSession() {
        super("MsolSession");
    }

    @Override
    public String run(String... input) {
        super.open();
        try {
            if (getStatus().equals("closed")) {
                setStatus("open");
                run(CONNECT);
            }
            setInput(input);
            setRawOutput(super.powerShell.executeCommands(input));
            setOutput(getRawOutput());
            if (getOutput() != null) {
                return getOutput();
            }
        } catch (IOException | NullPointerException ex) {
            ex.printStackTrace();
            setError(getRawOutput());
        } catch (PowerShellExecutionException e) {
            if (e.getMessage().contains(ERROR)) {
                run(CONNECT);
            }
        }
        return null;
    }
}
