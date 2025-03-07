package commands.config;

import commands.interfaces.IInputCommand;
import constants.Commands;
import constants.DataNames;
import data.Data;

public class ConfigUsernameCommand implements IInputCommand {
    public void execute(String input) {
        Data.saveData(DataNames.USERNAME, input);
        System.out.println("Username set to " + input);
    }

    public String getCommand() {
        return Commands.CONFIG_USERNAME;
    }
}