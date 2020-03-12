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
            receiver CU = new CollectionUnit(CT,args[0]);
            Terminal l1 = new ConsoleTerminal(CU);
            l1.interactiveMod("$");
        }catch (Exception ex){
            System.err.print("Файл не найден");
            CT.load("C:\\Users\\user\\Documents\\ConsoleApp\\src\\PersonClassTest.json");
            receiver CU = new CollectionUnit(CT,"C:\\Users\\user\\Documents\\ConsoleApp\\src\\PersonClassTest.json");
            Terminal l1 = new ConsoleTerminal(CU);
            l1.interactiveMod("$");
        }







    }
}
