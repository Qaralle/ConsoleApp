package CollectionInterface.CollectionCOmmands;

public class Show implements Command {
    @Override
    public void execute(receiver res) {
        res.show();
    }

}
