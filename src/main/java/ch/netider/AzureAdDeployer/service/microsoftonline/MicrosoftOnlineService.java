package ch.netider.AzureAdDeployer.service.microsoftonline;

import ch.netider.AzureAdDeployer.commands.MicrosoftOnlineCommands;
import ch.netider.AzureAdDeployer.session.MicrosoftOnlineSession;

import java.util.List;

public class MicrosoftOnlineService {
    private final MicrosoftOnlineSession session = new MicrosoftOnlineSession();
    private List<MicrosoftOnlineUser> microsoftOnlineUsers;


    public String getAllUsers() {
        return session.execute(MicrosoftOnlineCommands.GET_ALL_USERS);
    }

    public String showAllUsersJson() {
        return session.execute(MicrosoftOnlineCommands.SHOW_ALL_USERS_JSON);
    }

    public String showAllUsers() {
        return session.execute(MicrosoftOnlineCommands.SHOW_ALL_USERS);
    }

    public String checkMfa() {
        return session.execute(MicrosoftOnlineCommands.CHECK_MFA);
    }

    public void enableMfa(String userPrinzipalName) {
        session.execute(MicrosoftOnlineCommands.ENABLE_MFA(userPrinzipalName));
    }


    public void disableMfa(String userPrinzipalName) {
        session.execute(MicrosoftOnlineCommands.DISABLE_MFA(userPrinzipalName));
    }

    public String disableMfa() {
        return session.execute(MicrosoftOnlineCommands.DISABLE_MFA);
    }

    public void createBreakGlassAccounts() {
        session.execute(MicrosoftOnlineCommands.CREATE_BREAK_GLASS_ACCOUNTS());
    }

    public String showBreakGlassAccounts() {
        return session.execute(MicrosoftOnlineCommands.SHOW_BREAK_GLASS_ACCOUNTS);
    }

    public void removeBreakGlassAccounts() {
        session.execute(MicrosoftOnlineCommands.REMOVE_BREAK_GLASS_ACCOUNTS);
    }
}
