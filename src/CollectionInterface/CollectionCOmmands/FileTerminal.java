package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс, предоставляющий терминал для работы с файлами
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class FileTerminal extends Terminal  {
    private Scanner scan;
    private String file_name;

    /**
     * @param file_name_ имя фалйа
     * @param scan объект класса Scanner
     * @param rec_ Receiver
     * @throws FileNotFoundException файл не найден
     */
    public FileTerminal(String file_name_,Scanner scan,receiver rec_ ) throws FileNotFoundException {
        super(rec_,scan);

        this.file_name=file_name_;
        this.scan=scan;
        add=new Add(new FileTransporter(scan));
        show=new Show();
        info=new Info();
        update=new Update(new FileTransporter(scan));
        clear=new Clear();
        remove_by_id=new RemoveById(new FileTransporter(scan));
        removeHead=new RemoveHead();
        removeAnyByNationality=new RemoveAnyByNationality(new FileTransporter(scan));
        countLessThanLocation=new CountLessThanLocation(new FileTransporter(scan));
        filterStartsWithName=new FilterStartsWithName(new FileTransporter(scan));
        save=new Save();
        bufferMap = new HashMap<>();
        executeScript = new ExecuteScript(new FileTransporter(scan));
        exit=new Exit();
        history=new History();
        addIfMin = new AddIfMin(new FileTransporter(scan));
        help=new Help();
        try {
            this.interactiveMod();
        }catch (StackOverflowError e){
            System.err.println("Скорее всего вы создали рекурсию  \\_(ツ)_/");
        }


    }

}
