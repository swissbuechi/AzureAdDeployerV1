package ch.netider.AzureAdDeployer.config;

public class MicrosoftOnlineCommands {

    public static final String GET_ALL_USERS = "Get-MsolUser -all | ConvertTo-Json";

    public static final String SHOW_ALL_USERS_JSON = "Get-MsolUser -all | select DisplayName,UserPrincipalName," +
            "@{N='MFA Status'; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
            "{ $_.StrongAuthenticationRequirements.State} else { 'Disabled'}}} | ConvertTo-Json";

    public static final String SHOW_ALL_USERS = "Get-MsolUser -all | select DisplayName,UserPrincipalName," +
            "@{N='MFA Status'; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
            "{ $_.StrongAuthenticationRequirements.State} else { 'Disabled'}}} | ft";

    public static final String CHECK_MFA = "Get-MsolUser -all | where {$_.DisplayName -NotLike \"BreakGlass*\"} | select DisplayName,UserPrincipalName," +
            "@{N=\"MFA Status\"; E={ if( $_.StrongAuthenticationRequirements.State -ne $null)" +
            "{ $_.StrongAuthenticationRequirements.State} else { \"Disabled\"}}}";
    public static final String DISABLE_MFA = "Get-MsolUser -all | Set-MsolUser -StrongAuthenticationRequirements @()";
    public static final String SHOW_BREAK_GLASS_ACCOUNTS = "Get-MsolUser | Where-Object {$_.DisplayName -Like 'BreakGlass*'}";
    public static final String REMOVE_BREAK_GLASS_ACCOUNTS = "Get-MsolUser | Where-Object {$_.DisplayName -Like 'BreakGlass*'} | Remove-MsolUser -Force";

    public static String[] ENABLE_MFA(String userPrinzipalName) {
        return new String[]{
                "$users = " + "'" + userPrinzipalName + "'",
                "foreach ($user in $users) {",
                "$st = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationRequirement",
                "$st.RelyingParty = '*'",
                "$st.State = 'Enabled'",
                "$sta = @($st)",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements $sta }"};
    }

    public static String[] DISABLE_MFA(String userPrinzipalName) {
        return new String[]{
                "$users = " + "'" + userPrinzipalName + "'",
                "foreach ($user in $users) {",
                "Set-MsolUser -UserPrincipalName $user -StrongAuthenticationRequirements @() }"
        };
    }

    public static String[] CREATE_BREAK_GLASS_ACCOUNTS() {
        return new String[]{
                "if (Get-MsolUser | Where-Object {$_.DisplayName -Like \"BreakGlass*\"}) {",
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
                "Add-MsolRoleMember -RoleMemberEmailAddress $UPN2 -RoleName \"Company Administrator\" }"
        };
    }


}
