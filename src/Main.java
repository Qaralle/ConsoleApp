import ClassCollection.CollectionTask;
import CollectionInterface.CollectionCOmmands.ConsoleTerminal;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        CollectionTask ll = new CollectionTask();
        ll.load();
        ll.printer();


        ConsoleTerminal l1 = new ConsoleTerminal();
        l1.GetLine();
        l1.GetObjectsName();

    }
}
