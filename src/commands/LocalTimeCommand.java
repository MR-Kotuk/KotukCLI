package commands;

import commands.interfaces.IVoidCommand;
import constants.Commands;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeCommand implements IVoidCommand {
    public void execute() {
        System.out.println("Local time is: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public String getCommand() {
        return Commands.TIME;
    }
}