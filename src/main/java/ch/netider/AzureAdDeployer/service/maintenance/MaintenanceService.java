package ch.netider.AzureAdDeployer.service.maintenance;

import ch.netider.AzureAdDeployer.commands.MaintenanceCommands;
import ch.netider.AzureAdDeployer.session.MaintenanceSession;

public class MaintenanceService {

    private final MaintenanceSession session = new MaintenanceSession();

    public String showModule() {
        return session.execute(MaintenanceCommands.SHOW_MODULES);
    }

    public void installModule() {
        session.execute(MaintenanceCommands.INSTALL_MODULE);
    }

    public void uninstallModule() {
        session.execute(MaintenanceCommands.UNINSTALL_MSOL);
    }
}
