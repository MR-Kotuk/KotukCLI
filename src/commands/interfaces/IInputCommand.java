package commands.interfaces;

public interface IInputCommand extends ICommand {
    public void execute(String input);
    public String getCommand();
}