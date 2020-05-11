import ch.netider.AzureAdDeployer.session.PsSession;

public class TestPsSession {
    public static void main(String[] args) {


        //Test PsSession

        PsSession ps1 = new PsSession("testSession1");
        ps1.open();
        System.out.println(ps1.run("Get-Help"));

        System.out.println(ps1.name + ps1.id + ps1.input);

        PsSession ps2 = new PsSession("testSession2");
        //ps2.open();
        System.out.println(ps2.run("Get-Help"));

        System.out.println(ps2.name + ps2.id + ps2.input);

    }
}
