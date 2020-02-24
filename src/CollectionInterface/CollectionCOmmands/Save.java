package CollectionInterface.CollectionCOmmands;

import java.io.IOException;

public class Save implements Command {
    @Override
    public void execute(receiver res) {
        try {
            res.save();
            res.addCommandToHistory("save");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
