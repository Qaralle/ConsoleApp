package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;

public class ExecuteScript extends CommandWithPars{
    public ExecuteScript(Transporter tr) {
        super(tr);
    }

    @Override
    public void execute(receiver res) throws FileNotFoundException {
        res.addCommandToHistory("execute_script");
        res.executeScript(transporter.getFile_name());
    }
}
