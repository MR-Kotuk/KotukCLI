package commands;

import commands.interfaces.IVoidCommand;
import constants.Commands;
import data.Data;

public class VersionCommand implements IVoidCommand {
    public void execute() {
        System.out.println("KotukCLI v" + Data.readData(Commands.VERSION));
    }

    public String getCommand() {
        return Commands.VERSION;
    }
}