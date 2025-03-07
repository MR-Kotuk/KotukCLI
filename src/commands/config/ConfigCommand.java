package commands.config;

import commands.interfaces.IVoidCommand;
import constants.Commands;
import constants.Paths;
import data.Data;

public class ConfigCommand implements IVoidCommand {
    public void execute() {
        Data.printData(Paths.CONFIG_FILE);
    }

    public String getCommand() {
        return Commands.CONFIG;
    }
}