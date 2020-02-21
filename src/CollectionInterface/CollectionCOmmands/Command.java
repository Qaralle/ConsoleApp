package CollectionInterface.CollectionCOmmands;

public interface Command {
     void execute(receiver res);
     void execute(receiver res, long id);
}
