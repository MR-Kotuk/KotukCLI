package commands.interfaces;

public interface IVoidCommand extends ICommand {
    public void execute();
    public String getCommand();
}