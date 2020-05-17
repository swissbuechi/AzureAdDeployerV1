package ch.netider.AzureAdDeployer.console;

import ch.netider.AzureAdDeployer.session.MsolSession;
import ch.netider.AzureAdDeployer.session.PsSession;

public class MenuStructure {

    public void start() {
        final Menu mainMenu = new Menu("Main Menu");
        final Menu sessionMenu = new Menu(1, "Session Manager");
        final Menu newSessionMenu = new Menu(2, "Create new Session");

        mainMenu.addOption(new MenuOption("1", "Session Manager") {
            @Override
            public void selectOption() {
                sessionMenu.run();
            }
        });

        sessionMenu.addOption(new MenuOption("1", "Create new Session") {
            @Override
            public void selectOption() {
                newSessionMenu.run();
            }
        });

        newSessionMenu.addOption(new MenuOption("1", "MsolSession") {
            @Override
            public void selectOption() {
                MsolSession msolSession = new MsolSession("MsolSession");
                msolSession.connect();
                PsSession psSession = new PsSession("PsSession");
                psSession.open();
                psSession.run("Connect-MsolService");
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
