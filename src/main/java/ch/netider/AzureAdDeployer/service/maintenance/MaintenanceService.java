package ch.netider.AzureAdDeployer.service.maintenance;

import ch.netider.AzureAdDeployer.console.Cli;
import ch.netider.AzureAdDeployer.session.MaintenanceSession;

public class MaintenanceService {

    private final MaintenanceSession session = new MaintenanceSession();

    public String showModules() {
        return session.run("Get-InstalledModule -Name \"MSOnline\"");
    }

    public void installMsol() {
        session.run("Install-Module -Name MsOnline -AllowClobber -Scope AllUsers -Force",
                "Import-Module MsOnline");
        showModules();
    }

    public void uninstallMsol() {
        session.run("Uninstall-Module -Name MsOnline -Force");
        showModules();
    }
}
