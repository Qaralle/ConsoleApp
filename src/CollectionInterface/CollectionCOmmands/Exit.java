package CollectionInterface.CollectionCOmmands;

public class Exit implements Command {
    @Override
    public void execute(receiver res) {
        res.exit();
        res.addCommandToHistory("exit");
    }
}
