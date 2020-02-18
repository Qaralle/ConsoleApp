package CollectionInterface.CollectionCOmmands;

import java.util.Scanner;

public abstract class Terminal implements invoker {
    protected Command Add;
    protected Scanner scan;

    public abstract void GetLine();

    @Override
    public void AddElement() {
        Add.execute();
    }


}
