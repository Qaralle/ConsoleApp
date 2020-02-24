package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileTerminal extends Terminal  {
    private Scanner scan;
    private String file_name;

    public FileTerminal(String file_name_,Scanner scan,receiver rec_ ) throws FileNotFoundException {
        super(rec_,scan);
        this.file_name=file_name_;
        add=new Add(new FileTransporter(file_name));
        show=new Show();
        info=new Info();
        update=new Update(new FileTransporter(file_name));
        clear=new Clear();
        remove_by_id=new RemoveById(new FileTransporter(file_name));
        removeHead=new RemoveHead();
        removeAnyByNationality=new RemoveAnyByNationality(new FileTransporter(file_name));
        countLessThanLocation=new CountLessThanLocation(new FileTransporter(file_name));
        filterStartsWithName=new FilterStartsWithName(new FileTransporter(file_name));
        save=new Save();
        KakJeUmenyaGoritJopa = new HashMap<>();
        executeScript = new ExecuteScript(new FileTransporter(file_name));
        this.interactiveMod();
        exit=new Exit();
        history=new History();
        addIfMin = new AddIfMin(new ConsoleTranspoeter());
        help=new Help();
    }
    {
        userCommand = "";
    }

}
