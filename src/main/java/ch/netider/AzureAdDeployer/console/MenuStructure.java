package ch.netider.AzureAdDeployer.console;

import ch.netider.AzureAdDeployer.service.maintenance.MaintenanceService;
import ch.netider.AzureAdDeployer.service.msol.MsolService;

public class MenuStructure {

    public void run() {

        final MsolService msolService = new MsolService();
        final MaintenanceService maintenanceService = new MaintenanceService();

        //Menus
        final Menu mainMenu = new Menu("Main Menu");
        final Menu userMenu = new Menu("Global User Manager");
        final Menu glassMenu = new Menu(1, "Break Glass Account Manager");
        final Menu mfaMenu = new Menu(1, "MFA Manager");
        final Menu maintenanceMenu = new Menu(1, "Maintenance");

        //MainMenu

        mainMenu.addOption(new MenuOption("1", "Global User Manager") {
            @Override
            public void selectOption() {
                userMenu.run();
            }
        });

        mainMenu.addOption(new MenuOption("2", "Break Glass Account Manager") {
            @Override
            public void selectOption() {
                glassMenu.run();
            }
        });

        mainMenu.addOption(new MenuOption("3", "MFA Manager") {
            @Override
            public void selectOption() {
                mfaMenu.run();
            }
        });

        mainMenu.addOption(new MenuOption("4", "Maintenance") {
            @Override
            public void selectOption() {
                maintenanceMenu.run();
            }
        });

        //UserMenu

        userMenu.addOption(new MenuOption("1", "Show All Users") {
            @Override
            public void selectOption() {
                msolService.showAllUsers();
            }
        });

        //GlassMenu
        glassMenu.addOption(new MenuOption("1", "Create BG Accounts") {
            @Override
            public void selectOption() {
                msolService.createBreakGlassAccounts();
            }
        });

        glassMenu.addOption(new MenuOption("2", "Show BG Accounts") {
            @Override
            public void selectOption() {
                msolService.showBreakGlassAccounts();
            }
        });

        glassMenu.addOption(new MenuOption("3", "Delete BG Accounts") {
            @Override
            public void selectOption() {
                msolService.removeBreakGlassAccounts();
            }
        });

        //MfaMenu
        mfaMenu.addOption(new MenuOption("1", "Check MFA status") {
            @Override
            public void selectOption() {
                msolService.checkMfa();
            }
        });

        mfaMenu.addOption(new MenuOption("2", "Enable MFA for specific User") {
            @Override
            public void selectOption() {
                msolService.enableMfa("raphael.buechi@netider.ch");
            }
        });

        mfaMenu.addOption(new MenuOption("3", "Enable MFA for all Users") {
            @Override
            public void selectOption() {
                msolService.enableMfa();
            }
        });

        mfaMenu.addOption(new MenuOption("4", "Disable MFA for specific User") {
            @Override
            public void selectOption() {
                msolService.disableMfa("raphael.buechi@netider.ch");
            }
        });

        mfaMenu.addOption(new MenuOption("5", "Disable MFA for all Users") {
            @Override
            public void selectOption() {
                msolService.disableMfa();
            }
        });

        //MaintenanceMenu
        maintenanceMenu.addOption(new MenuOption("1", "Show installed Modules") {
            @Override
            public void selectOption() {
                maintenanceService.showModules();
            }
        });

        maintenanceMenu.addOption(new MenuOption("2", "Install/Update Ms-Online Module") {
            @Override
            public void selectOption() {
                maintenanceService.installMsol();
            }
        });

        maintenanceMenu.addOption(new MenuOption("3", "Uninstall Ms-Online Module") {
            @Override
            public void selectOption() {
                maintenanceService.uninstallMsol();
            }
        });

        mainMenu.run();
    }

}
