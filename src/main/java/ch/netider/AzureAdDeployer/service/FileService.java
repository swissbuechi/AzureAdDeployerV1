package ch.netider.AzureAdDeployer.service;

import ch.netider.AzureAdDeployer.config.AppConfig;
import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;

public class FileService {

    private final String path;

    public FileService() {
        final AppDirs appDirs = AppDirsFactory.getInstance();
        String path = appDirs.getUserConfigDir(AppConfig.getAppName(), "", AppConfig.getAuthor());
        this.path = path.substring(0, path.length() - 1);
    }

    public String getPath() {
        return path;
    }
}