package CollectionInterface.CollectionCOmmands;;

public class Help implements Command {
    @Override
    public void execute(receiver res) {
        res.help();
        res.addCommandToHistory("help");
    }
}
