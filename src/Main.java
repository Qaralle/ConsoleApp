import CollectionInterface.CollectionCOmmands.ConsoleTerminal;
import CollectionInterface.CollectionCOmmands.Terminal;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        /**CollectionTask ll = new CollectionTask();
        ll.load();
        ll.printer();
         */

        Terminal l1 = new ConsoleTerminal();
        l1.interactiveMod();


    }
}
