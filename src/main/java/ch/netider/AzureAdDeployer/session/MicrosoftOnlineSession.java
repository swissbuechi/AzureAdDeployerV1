package ch.netider.AzureAdDeployer.session;

import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.IOException;

public class MicrosoftOnlineSession extends PoweShellSession {

    private static final String CONNECT = "Connect-MsolService";
    private static final String ERROR = "You must call the Connect-MsolService cmdlet before calling any other cmdlets";

    public MicrosoftOnlineSession() {
        super("MsolSession");
    }

    @Override
    public String execute(String... input) {
        super.open();
        try {
            if (getStatus().equals("closed")) {
                setStatus("open");
                execute(CONNECT);
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
                execute(CONNECT);
            }
        }
        return null;
    }
}
