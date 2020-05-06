package ch.netider.AzureAdDeployer;

import com.github.tuupertunut.powershelllibjava.PowerShell;
import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;

import java.io.*;
import java.util.Scanner;

public class AzureAdDeployerApplication {
    public static void main(String[] args) throws IOException, PowerShellExecutionException {
        PowerShell powerShell = PowerShell.open();
        powerShell.executeCommands("Connect-MsolService");
        System.out.println(powerShell.executeCommands("Get-MsolUser"));
    }
}