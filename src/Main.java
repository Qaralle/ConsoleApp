import ClassCollection.CollectionTask;
import CollectionInterface.CollectionCOmmands.ConsoleTerminal;
import CollectionInterface.CollectionCOmmands.Terminal;
import CollectionInterface.CollectionCOmmands.receiver;
import CollectionInterface.CollectionUnit;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {


        CollectionTask CT = new CollectionTask();
        try {
            CT.load(args[0]);
        }catch (Exception ex){
            System.out.println(args[0]);
            CT.load("src\\PersonClassTest.json");
        }
        receiver CU = new CollectionUnit(CT);

        Terminal l1 = new ConsoleTerminal(CU);
        l1.interactiveMod();




    }
}
