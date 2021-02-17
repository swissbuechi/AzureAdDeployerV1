package ch.netider.AzureAdDeployer.config;

public class MaintenanceCommands {

    public static final String SHOW_MODULES = "Get-InstalledModule -Name \"MSOnline\"";
    public static final String UNINSTALL_MSOL = "Uninstall-Module -Name MsOnline -Force";

    public static String[] INSTALL_MSOL() {
        return new String[]{
                "Install-Module -Name MsOnline -AllowClobber -Scope AllUsers -Force",
                "Import-Module MsOnline"
        };
    }

}
