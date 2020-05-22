package ch.netider.AzureAdDeployer.service.maintenance;

import ch.netider.AzureAdDeployer.console.CliGui;
import ch.netider.AzureAdDeployer.session.MaintenanceSession;

public class MaintenanceService {

    private final CliGui cliGui = new CliGui();
    private final MaintenanceSession session = new MaintenanceSession("MaintenanceSession");

    public void showModules() {
        session.run("Get-InstalledModule -Name \"MSOnline\"");
        cliGui.pressKeyToContinue();
    }

    public void installMsol() {
        session.run("Install-Module -Name MsOnline -AllowClobber -Scope AllUsers -Force",
                "Import-Module MsOnline");
        showModules();
        cliGui.pressKeyToContinue();
    }

    public void uninstallMsol() {
        session.run("Uninstall-Module -Name MsOnline -Force");
        showModules();
        cliGui.pressKeyToContinue();
    }

}
