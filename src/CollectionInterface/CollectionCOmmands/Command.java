package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;

public interface Command {
     void execute(receiver res) throws FileNotFoundException;
}
