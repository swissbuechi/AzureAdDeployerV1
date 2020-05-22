package ch.netider.AzureAdDeployer.service.msol;

import ch.netider.AzureAdDeployer.console.CliGui;
import ch.netider.AzureAdDeployer.session.MsolSession;

public class MsolService {
    private final CliGui cliGui = new CliGui();
    private final MsolSession session = new MsolSession("msolPsSession");

    public void getAllUsers() {
        session.run("Get-MsolUser -all | select DisplayName,UserPrincipalName");
        cliGui.pressKeyToContinue();
    }

//    public MsolUser getUsers() {
//        String[] userProperties = session.run("Get-MsolUser | fl").split(System.getProperty("line.separator"));
//        return null;
//    }

    public void checkMfa() {
        session.run("Get-MsolUser -all | select DisplayName,UserPrincipalName," +
                "@{N=\"MFA Status\"; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { \"Disabled\"}}}");
        cliGui.pressKeyToContinue();
    }

    public void enableMfa(String userPrinzipalName) {
        session.run("$users = " + "\"" + userPrinzipalName + "\"",
                "foreach ($user in $users) {",
                "$st = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement",
                "$st.RelyingParty = \"*\"",
                "$st.State = \"Enabled\"",
                "$sta = @($st)",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements $sta }");
        checkMfa();
    }

    public void disableMfa(String userPrinzipalName) {
        session.run("$users = " + "\"" + userPrinzipalName + "\"",
                "foreach ($user in $users) {",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements @() }");
        checkMfa();
    }

}

