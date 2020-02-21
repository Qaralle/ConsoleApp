package CollectionInterface.CollectionCOmmands;

public class RemoveById implements Command{
    @Override
    public void execute(receiver res) {

    }

    @Override
    public void execute(receiver res, long id) {
        res.remove_by_id(id);
    }
}
