package ch.netider.AzureAdDeployer.console;

import ch.netider.AzureAdDeployer.service.maintenance.MaintenanceService;
import ch.netider.AzureAdDeployer.service.msol.MsolService;

public class MenuStructure {

    public void run() {

        final MsolService msolService = new MsolService();
        final MaintenanceService maintenanceService = new MaintenanceService();

        //Menus
        final Menu mainMenu = new Menu("Main Menu");
        final Menu mfaMenu = new Menu(1, "MFA Manager");
        final Menu sessionMenu = new Menu(1, "Session Manager");
        final Menu maintenanceMenu = new Menu(1, "Maintenance");
        final Menu newSessionMenu = new Menu(2, "Create new Session");

        //MainMenu
        mainMenu.addOption(new MenuOption("1", "Session Manager") {
            @Override
            public void selectOption() {
                sessionMenu.run();
            }
        });

        mainMenu.addOption(new MenuOption("2", "MFA Manager") {
            @Override
            public void selectOption() {
                mfaMenu.run();
            }
        });

        mainMenu.addOption(new MenuOption("3", "Maintenance") {
            @Override
            public void selectOption() {
                maintenanceMenu.run();
            }
        });

        //MfaMenu
        mfaMenu.addOption(new MenuOption("1", "Check MFA Status") {
            @Override
            public void selectOption() {
                msolService.checkMfa();
            }
        });

        mfaMenu.addOption(new MenuOption("2", "Enable MFA") {
            @Override
            public void selectOption() {
                msolService.enableMfa("raphael.buechi@netider.ch");
            }
        });

        mfaMenu.addOption(new MenuOption("3", "Disable MFA") {
            @Override
            public void selectOption() {
                msolService.disableMfa("raphael.buechi@netider.ch");
            }
        });

        mfaMenu.addOption(new MenuOption("4", "Show all Users") {
            @Override
            public void selectOption() {
                msolService.getAllUsers();
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


        //SessionMenu
        sessionMenu.addOption(new MenuOption("1", "Create new Session") {
            @Override
            public void selectOption() {
                newSessionMenu.run();
            }
        });

        //NewSessionMenu
        newSessionMenu.addOption(new MenuOption("1", "MsolSession") {
            @Override
            public void selectOption() {
            }
        });

        newSessionMenu.addOption(new MenuOption("2", "AzAd Session") {
            @Override
            public void selectOption() {
            }
        });

        mainMenu.run();
    }

}
