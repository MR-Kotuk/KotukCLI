package commands;

import commands.interfaces.IVoidCommand;
import constants.Commands;
import constants.DataNames;

import static data.Data.readData;

public class GreetCommand implements IVoidCommand {
    private final static String defaultNameMessage = "Hi Kotuk :3\n*to change default name use ktk " + Commands.CONFIG_USERNAME + "\"username\"";

    public void execute() {
        String username = readData(DataNames.USERNAME);
        System.out.println(username != null
                ? "Hi " + username + " :3"
                : defaultNameMessage);
    }

    public String getCommand() {
        return Commands.GREET;
    }
}