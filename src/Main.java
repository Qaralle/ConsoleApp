import ClassCollection.CollectionTask;
import CollectionInterface.CollectionCOmmands.ConsoleTerminal;
import CollectionInterface.CollectionCOmmands.Terminal;
import CollectionInterface.CollectionCOmmands.receiver;
import CollectionInterface.CollectionUnit;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {


        CollectionTask CT = new CollectionTask();
        CT.load();
        receiver CU = new CollectionUnit(CT);

        Terminal l1 = new ConsoleTerminal(CU);
        l1.interactiveMod();




    }
}
