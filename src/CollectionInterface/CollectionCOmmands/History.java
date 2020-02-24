package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;

public class History implements Command {
    @Override
    public void execute(receiver res) throws FileNotFoundException {
        res.addCommandToHistory("history");
        res.history();
    }
}
