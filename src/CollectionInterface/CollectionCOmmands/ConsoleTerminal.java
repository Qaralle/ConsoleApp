package CollectionInterface.CollectionCOmmands;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс, предоставляющий консоль
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class ConsoleTerminal extends Terminal {

    /**
     * @param res_ Receiver (объект класса CollectionUnit)
     */
    public ConsoleTerminal(receiver res_){
        super(res_);
    }

    {
        userCommand = "";
        scan=new Scanner(System.in);
        add=new Add(new ConsoleTranspoeter());
        show=new Show();
        info=new Info();
        update=new Update(new ConsoleTranspoeter());
        clear=new Clear();
        remove_by_id=new RemoveById(new ConsoleTranspoeter());
        removeHead=new RemoveHead();
        removeAnyByNationality=new RemoveAnyByNationality(new ConsoleTranspoeter());
        countLessThanLocation=new CountLessThanLocation(new ConsoleTranspoeter());
        filterStartsWithName=new FilterStartsWithName(new ConsoleTranspoeter());
        save=new Save();
        KakJeUmenyaGoritJopa = new HashMap<>();
        executeScript = new ExecuteScript(new ConsoleTranspoeter());
        exit=new Exit();
        history=new History();
        addIfMin = new AddIfMin(new ConsoleTranspoeter());
        help=new Help();
    }

    /*private String ObjectsName;

    public void GetLine() {
        ObjectsName=scan.nextLine();
    }

    public void GetObjectsName(){
        System.out.println(ObjectsName);
    }*/

}
