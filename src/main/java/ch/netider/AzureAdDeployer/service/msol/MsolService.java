package ch.netider.AzureAdDeployer.service.msol;

import ch.netider.AzureAdDeployer.console.Cli;
import ch.netider.AzureAdDeployer.session.MsolSession;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MsolService {
    private final Cli cli = new Cli();
    private final MsolSession session = new MsolSession();
    private List<MsolUser> msolUsers;

    public void getAllUsers() {
        Type msolUser = new TypeToken<List<MsolUser>>() {
        }.getType();
        msolUsers = new Gson().fromJson(session.run("Get-MsolUser -all | ConvertTo-Json"), msolUser);
    }

    public String showAllUsers() {
        return session.run("Get-MsolUser -all | select DisplayName,UserPrincipalName," +
                "@{N='MFA Status'; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { 'Disabled'}}} | ft");
    }

    public void checkMfa() {
        System.out.println(session.run("Get-MsolUser -all | where {$_.DisplayName -NotLike \"BreakGlass*\"} | select DisplayName,UserPrincipalName," +
                "@{N=\"MFA Status\"; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { \"Disabled\"}}}"));
        cli.pressKeyToContinue();
    }

    public void enableMfa(String userPrinzipalName) {
        //String.format("$users = \"%s\"  ")
        session.run("$users = " + "'" + userPrinzipalName + "'",
                "foreach ($user in $users) {",
                "$st = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement",
                "$st.RelyingParty = '*'",
                "$st.State = 'Enabled'",
                "$sta = @($st)",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements $sta }");
        checkMfa();
    }

    public void enableMfa() {
        if (cli.waitForConfirmation()) {
            session.run("$users = Get-MsolUser | where {$_.DisplayName -NotLike \"BreakGlass*\"} | select -Expand UserPrincipalName",
                    "foreach ($user in $users) {",
                    "$st = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement",
                    "$st.RelyingParty = \"*\"",
                    "$st.State = 'Enabled'",
                    "$sta = @($st)",
                    "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements $sta }");
            checkMfa();
        }
    }

    public void disableMfa(String userPrinzipalName) {
        session.run("$users = " + "'" + userPrinzipalName + "'",
                "foreach ($user in $users) {",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements @() }");
        checkMfa();
    }

    public void disableMfa() {
        if (cli.waitForConfirmation()) {
            session.run("Get-MsolUser -all | Set-MsolUser -StrongAuthenticationRequirements @()");
            checkMfa();
        }
    }

    public void createBreakGlassAccounts() {
        System.out.println(session.run("if (Get-MsolUser | Where-Object {$_.DisplayName -Like \"BreakGlass*\"}) {",
                "Write-Output \"Break Glass accounts are already created. Please verify manually!\"",
                "} else {",
                "Add-Type -AssemblyName System.Web",
                "$DefaultDomain=(Get-MsolDomain  |Where-Object { $_.isdefault }).name",
                "$name1=-join ((97..122) | Get-Random -Count 64 | % {[char]$_})",
                "$pass1=[System.Web.Security.Membership]::GeneratePassword(64,4)",
                "$UPN1=\"$name1@$DefaultDomain\"",
                "$DisplayName1=\"BreakGlass $name1\"",
                "New-MsolUser -UserPrincipalName $UPN1 -DisplayName $DisplayName1 -ForceChangePassword $false -StrongPasswordRequired $true -Password $pass1 -PasswordNeverExpires $true",
                "Add-MsolRoleMember -RoleMemberEmailAddress $UPN1 -RoleName \"Company Administrator\"",
                "$MsDomain=(Get-MsolDomain | Where-Object {$_.name -Like \"*.onmicrosoft.com\"}).name",
                "$name2=-join ((97..122) | Get-Random -Count 64 | % {[char]$_})",
                "$pass2=[System.Web.Security.Membership]::GeneratePassword(64,4)",
                "$UPN2=\"$name2@$MsDomain\"",
                "$DisplayName2=\"BreakGlass $name2\"",
                "New-MsolUser -UserPrincipalName $UPN2 -DisplayName $DisplayName2 -ForceChangePassword $false -StrongPasswordRequired $true -Password $pass2 -PasswordNeverExpires $true",
                "Add-MsolRoleMember -RoleMemberEmailAddress $UPN2 -RoleName \"Company Administrator\" }"));
        cli.pressKeyToContinue();
    }

    public void showBreakGlassAccounts() {
        System.out.println(session.run("Get-MsolUser | Where-Object {$_.DisplayName -Like 'BreakGlass*'}"));
        cli.pressKeyToContinue();
    }

    public void removeBreakGlassAccounts() {
        if (cli.waitForConfirmation()) {
            session.run("Get-MsolUser | Where-Object {$_.DisplayName -Like 'BreakGlass*'} | Remove-MsolUser -Force");
            cli.pressKeyToContinue();
        }
    }
}
