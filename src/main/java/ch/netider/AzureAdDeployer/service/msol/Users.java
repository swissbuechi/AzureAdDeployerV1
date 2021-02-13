package ch.netider.AzureAdDeployer.service.msol;

import java.util.List;

public class Users {

    private List<MsolUser> msolUsers;

    public List<MsolUser> getUsers() {
        return msolUsers;
    }

    public void setUsers(List<MsolUser> msolUsers) {
        this.msolUsers = msolUsers;
    }
}
