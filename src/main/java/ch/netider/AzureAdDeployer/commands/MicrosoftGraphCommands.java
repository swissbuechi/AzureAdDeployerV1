package ch.netider.AzureAdDeployer.commands;

public class MicrosoftGraphCommands {

    public static final String CONNECT = "Connect-MgGraph -Scopes \"User.Read.All\",\"Group.ReadWrite.All\"";

    public static final String GET_ALL_USERS = "Get-MgUser -All -Filter \"UserType eq 'Member'\" -Property ID, " +
            "DisplayName, Mail, UserPrincipalName| ConvertTo-Json";

    public static String getUserById(String id) {
        return "Get-MgUser -UserId " + id +
                " -Property DisplayName, UserPrincipalName, AccountEnabled, AssignedLicenses | ConvertTo-Json -Depth 2";
    }

    public static String getAuthMethodById(String id) {
        return "Get-MgUserAuthenticationMethod -UserId " + id + " | ConvertTo-Json";
    }
}
