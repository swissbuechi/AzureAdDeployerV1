package ch.netider.AzureAdDeployer.service.msol;

import ch.netider.AzureAdDeployer.session.MsolSession;

import java.util.List;

public class MsolService {
    private final MsolSession session = new MsolSession();
    private List<MsolUser> msolUsers;

//    public void getAllUsers() {
//        Type msolUser = new TypeToken<List<MsolUser>>() {
//        }.getType();
//        msolUsers = new Gson().fromJson(session.run("Get-MsolUser -all | ConvertTo-Json"), msolUser);
//    }

    public String getAllUsers() {
        return session.run("Get-MsolUser -all | ConvertTo-Json");
    }

    public String showAllUsersJ() {
        return session.run("Get-MsolUser -all | select DisplayName,UserPrincipalName," +
                "@{N='MFA Status'; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { 'Disabled'}}} | ConvertTo-Json");
    }

    public String showAllUsers() {
        return session.run("Get-MsolUser -all | select DisplayName,UserPrincipalName," +
                "@{N='MFA Status'; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { 'Disabled'}}} | ft");
    }

    public String checkMfa() {
        return session.run("Get-MsolUser -all | where {$_.DisplayName -NotLike \"BreakGlass*\"} | select DisplayName,UserPrincipalName," +
                "@{N=\"MFA Status\"; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
                "{ $_.StrongAuthenticationRequirements.State} else { \"Disabled\"}}}");
    }

    public String enableMfa(String userPrinzipalName) {
        return session.run("$users = " + "'" + userPrinzipalName + "'",
                "foreach ($user in $users) {",
                "$st = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement",
                "$st.RelyingParty = '*'",
                "$st.State = 'Enabled'",
                "$sta = @($st)",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements $sta }");
    }


    public String disableMfa(String userPrinzipalName) {
        return session.run("$users = " + "'" + userPrinzipalName + "'",
                "foreach ($user in $users) {",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements @() }");
    }

    public String disableMfa() {
        return session.run("Get-MsolUser -all | Set-MsolUser -StrongAuthenticationRequirements @()");
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
    }

    public String showBreakGlassAccounts() {
        return session.run("Get-MsolUser | Where-Object {$_.DisplayName -Like 'BreakGlass*'}");
    }

    public String removeBreakGlassAccounts() {
        return session.run("Get-MsolUser | Where-Object {$_.DisplayName -Like 'BreakGlass*'} | Remove-MsolUser -Force");
    }
}
