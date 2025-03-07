import commands.VersionCommand;
import commands.config.ConfigCommand;
import commands.HelpCommand;
import commands.GreetCommand;
import commands.LocalTimeCommand;
import commands.config.ConfigUsernameCommand;
import commands.interfaces.ICommand;
import commands.interfaces.IInputCommand;
import commands.interfaces.IVoidCommand;
import constants.Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, ICommand> commands = new HashMap<>();

    public CommandFactory() {
        registerCommand(new GreetCommand());
        registerCommand(new VersionCommand());
        registerCommand(new LocalTimeCommand());
        registerCommand(new HelpCommand());

        registerCommand(new ConfigCommand());
        registerCommand(new ConfigUsernameCommand());
    }

    private void registerCommand(ICommand command) {
        commands.put(command.getCommand(), command);
    }

    public void command(String[] parts) {
        if (parts.length == 0) {
            IVoidCommand command = (IVoidCommand) commands.get(Commands.GREET);
            command.execute();
            return;
        }

        ICommand command = commands.get(parts.length == 1 ? parts[0] : parts[0] + " " + parts[1]);
        if (command != null) {
            if (command instanceof IVoidCommand voidCommand)
                voidCommand.execute();
            else if (command instanceof IInputCommand inputCommand)
                inputCommand.execute(parts[2]);
        }
        else
            System.out.println("Unknown command \n*Type \"ktk " + Commands.HELP + "\" for list of commands");
    }
}