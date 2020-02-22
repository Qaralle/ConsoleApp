package CollectionInterface.CollectionCOmmands;

public class RemoveHead implements Command {
    @Override
    public void execute(receiver res) {
        res.removeHead();
    }
}
