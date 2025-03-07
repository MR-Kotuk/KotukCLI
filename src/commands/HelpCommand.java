package commands;

import commands.interfaces.IVoidCommand;
import constants.Commands;
import constants.Paths;
import data.Data;

public class HelpCommand implements IVoidCommand {
    public void execute() {
        Data.printData(Paths.HELP_FILE);
    }

    public String getCommand() {
        return Commands.HELP;
    }
}