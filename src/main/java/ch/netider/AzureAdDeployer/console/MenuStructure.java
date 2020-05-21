package ch.netider.AzureAdDeployer.console;

import ch.netider.AzureAdDeployer.service.msol.MsolService;
import ch.netider.AzureAdDeployer.session.PsSession;

public class MenuStructure {

    public void start() {
        //Menus
        final Menu mainMenu = new Menu("Main Menu");
        final Menu sessionMenu = new Menu(1, "Session Manager");
        final Menu newSessionMenu = new Menu(2, "Create new Session");

        //MainMenu
        mainMenu.addOption(new MenuOption("1", "Session Manager") {
            @Override
            public void selectOption() {
                sessionMenu.run();
            }
        });

        mainMenu.addOption(new MenuOption("2", "Check MFA") {
            @Override
            public void selectOption() {
                MsolService msolService = new MsolService();
                msolService.checkMfa();
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
                PsSession psSession = new PsSession("PsSession");
                psSession.open();
                psSession.run("Get-Help");
            }
        });

        mainMenu.run();
    }

}
