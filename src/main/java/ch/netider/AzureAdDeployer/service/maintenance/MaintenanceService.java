package ch.netider.AzureAdDeployer.service.maintenance;

import ch.netider.AzureAdDeployer.config.MaintenanceCommands;
import ch.netider.AzureAdDeployer.session.MaintenanceSession;

public class MaintenanceService {

    private final MaintenanceSession session = new MaintenanceSession();

    public String showModules() {
        return session.execute(MaintenanceCommands.SHOW_MODULES);
    }

    public void installMsol() {
        session.execute(MaintenanceCommands.INSTALL_MSOL());
    }

    public void uninstallMsol() {
        session.execute(MaintenanceCommands.UNINSTALL_MSOL);
    }
}
