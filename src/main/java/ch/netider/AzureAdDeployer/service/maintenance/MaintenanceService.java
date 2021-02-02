package ch.netider.AzureAdDeployer.service.maintenance;

import ch.netider.AzureAdDeployer.console.Cli;
import ch.netider.AzureAdDeployer.session.MaintenanceSession;

public class MaintenanceService {

    private final Cli cli = new Cli();
    private final MaintenanceSession session = new MaintenanceSession();

    public void showModules() {
        System.out.println(session.run("Get-InstalledModule -Name \"MSOnline\""));
        cli.pressKeyToContinue();
    }

    public void installMsol() {
        session.run("Install-Module -Name MsOnline -AllowClobber -Scope AllUsers -Force",
                "Import-Module MsOnline");
        showModules();
        cli.pressKeyToContinue();
    }

    public void uninstallMsol() {
        session.run("Uninstall-Module -Name MsOnline -Force");
        showModules();
        cli.pressKeyToContinue();
    }
}
