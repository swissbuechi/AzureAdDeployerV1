package ch.netider.AzureAdDeployer.service.microsoftonline;

import java.util.List;

public class Users {

    private List<MicrosoftOnlineUser> microsoftOnlineUsers;

    public List<MicrosoftOnlineUser> getUsers() {
        return microsoftOnlineUsers;
    }

    public void setUsers(List<MicrosoftOnlineUser> microsoftOnlineUsers) {
        this.microsoftOnlineUsers = microsoftOnlineUsers;
    }
}
