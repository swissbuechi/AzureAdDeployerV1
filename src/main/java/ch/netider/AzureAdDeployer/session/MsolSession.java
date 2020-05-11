package ch.netider.AzureAdDeployer.session;

public class MsolSession extends PsSession {
    public PsSession psSession;

    public MsolSession(String name) {
        super(name);
        this.type = "Msol";
    }

    public void connect() {
        psSession.open();
        psSession.run("Connect-MsolService");
    }
}
