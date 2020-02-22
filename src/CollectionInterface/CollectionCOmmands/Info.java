package CollectionInterface.CollectionCOmmands;

import java.util.Scanner;

public class Info implements Command{
    @Override
    public void execute(receiver res) {
        res.info();
    }
}
