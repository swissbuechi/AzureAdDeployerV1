package ch.netider.AzureAdDeployer;

import ch.netider.AzureAdDeployer.gui.MainGui;

public class AzureAdDeployerApplication {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
//        FileService fileService = new FileService();
//
//        Connection connection1 = new Connection("Test", "peter@peter");
//        Connections connections = new Connections();
//        connections = fileService.loadConnections();
//        connections.addConnection(connection1);
//        fileService.saveConnections(connections);

//        JsonHandler jsonHandler = new JsonHandler();
//
//        MsolService msolService = new MsolService();
//
////        String json = msolService.getAllUsers();
//
//        String json = msolService.showAllUsers();
//
//        System.out.println("JSON: " + json);
//
//        Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
//
//        Gson gson = new Gson();
//        ArrayList<User> userArray = gson.fromJson(json, userListType);
//
//        for(User user : userArray) {
//            System.out.println(user);
//        }

//        Users msolUsers = jsonHandler.toMsolUser(json);
//
//        for (User m : msolUsers.getUsers()) {
//            System.out.println(m.getDisplayName());
//        }


        MainGui mainGui = new MainGui();
        mainGui.show();
    }

}
