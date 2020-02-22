package CollectionInterface.CollectionCOmmands;

public class Clear implements Command {
    @Override
    public void execute(receiver res) {
        res.clear();
    }
}