package ch.netider.AzureAdDeployer.service.msol;

import ch.netider.AzureAdDeployer.console.CliGui;
import ch.netider.AzureAdDeployer.session.MsolSession;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MsolService {
    private final CliGui cliGui = new CliGui();
    private final MsolSession session = new MsolSession();
    private List<MsolUser> msolUsers;

    public void getAllUsers() {
        Type msolUser = new TypeToken<List<MsolUser>>() {
        }.getType();
        msolUsers = new Gson().fromJson(session.run("Get-MsolUser -all | ConvertTo-Json"), msolUser);
    }

    public void checkMfa() {
        System.out.println(session.run("Get-MsolUser -all | select DisplayName,UserPrincipalName," +
                "@{N=\"MFA Status\"; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { \"Disabled\"}}}"));
        cliGui.pressKeyToContinue();
    }

    public void enableMfa(String userPrinzipalName) {
        //String.format("$users = \"%s\"  ")
        System.out.println(session.run("$users = " + "\"" + userPrinzipalName + "\"",
                "foreach ($user in $users) {",
                "if ($user.DisplayName -NotLike \"BreakGlass*\") {",
                "$st = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement",
                "$st.RelyingParty = \"*\"",
                "$st.State = \"Enabled\"",
                "$sta = @($st)",
                "Set-MsolUser -UserPrincipalName" + "\"" + userPrinzipalName + "\"" + " -StrongAuthenticationRequirements $sta } }"));
        checkMfa();
    }

    public void enableMfa() {
        System.out.println(session.run("$users = Get-MsolUser | where {$_.DisplayName -NotLike \"BreakGlass*\"}",
                "foreach ($user in $users) {",
                "if ($user.DisplayName -NotLike \"BreakGlass*\") {",
                "$st = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement",
                "$st.RelyingParty = \"*\"",
                "$st.State = \"Enabled\"",
                "$sta = @($st)",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements $sta } }"));
        checkMfa();
    }

    public void disableMfa(String userPrinzipalName) {
        System.out.println(session.run("$users = " + "\"" + userPrinzipalName + "\"",
                "foreach ($user in $users) {",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements @() }"));
        checkMfa();
    }
}

