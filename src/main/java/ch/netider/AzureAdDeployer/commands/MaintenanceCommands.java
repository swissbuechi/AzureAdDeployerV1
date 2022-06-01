package ch.netider.AzureAdDeployer.commands;

public class MaintenanceCommands {

    public static final String SHOW_MODULES = "Get-InstalledModule Microsoft.Graph";
    public static final String INSTALL_MODULE = "Install-Module Microsoft.Graph -Scope CurrentUser -Force";
    public static final String UNINSTALL_MSOL = "Uninstall-Module Microsoft.Graph -Force";
    public static final String UPDATE_MODULE = "Update-Module Microsoft.Graph -Force";

}
