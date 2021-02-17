package ch.netider.AzureAdDeployer.gui.controller;

import ch.netider.AzureAdDeployer.service.microsoftonline.MicrosoftOnlineService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class UserManagerLegacyController {

    @FXML
    TextArea mainOutput;

    @FXML
    ProgressIndicator progress;

    private MicrosoftOnlineService microsoftOnlineService;

    public UserManagerLegacyController() {
        microsoftOnlineService = new MicrosoftOnlineService();
    }

    public void showAllUsersButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                return microsoftOnlineService.showAllUsers();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }

    public void createBgAccountsButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                microsoftOnlineService.createBreakGlassAccounts();
                return microsoftOnlineService.showBreakGlassAccounts();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }

    public void showBgAccountsButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                return microsoftOnlineService.showBreakGlassAccounts();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }

    public void removeBgAccountsButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                microsoftOnlineService.removeBreakGlassAccounts();
                return microsoftOnlineService.showBreakGlassAccounts();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }

    public void checkMfaStatusButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                return microsoftOnlineService.checkMfa();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }

    public void enableMfaForAllButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                microsoftOnlineService.enableMfa("raphael.buechi@netider.ch");
                return microsoftOnlineService.checkMfa();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }

    public void disableMfaForAllButton() {
        Task<String> task = new Task<>() {
            @Override
            protected String call() {
                progress.setStyle("visibility: visible");
                microsoftOnlineService.disableMfa("raphael.buechi@netider.ch");
                return microsoftOnlineService.checkMfa();
            }

            @Override
            protected void succeeded() {
                mainOutput.setText(call());
                updateProgress(1, 1);
                progress.setStyle("visibility: hidden");
            }
        };
        progress.progressProperty().bind(task.progressProperty());
        new Thread(task).start();
    }
}
