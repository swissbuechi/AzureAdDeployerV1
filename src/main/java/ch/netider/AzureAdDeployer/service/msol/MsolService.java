package ch.netider.AzureAdDeployer.service.msol;

import ch.netider.AzureAdDeployer.session.PsSession;

public class MsolService {
    private final PsSession session = new PsSession("msolPsSession");

    public MsolService() {
        session.open();
//        if (session.run("Connect-Msol").contains("Connect-MsolService")) {
//            session.run("Install-Module -Name MsOnline -AllowClobber -Scope AllUsers -Force",
//                    "Import-Module MsOnline");
//        }
        session.run("Connect-MsolService");
    }

    //public MsolUser getUsers() {

    //String[] userProperties = session.run("Get-MsolUser | fl").split(System.getProperty("line.separator"));
    //}


    public void checkMfa() {
        System.out.println(session.run("Get-MsolUser -all | select DisplayName,UserPrincipalName," +
                "@{N=\"MFA Status\"; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { \"Disabled\"}}}"));
    }
}
