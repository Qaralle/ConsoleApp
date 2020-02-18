package CollectionInterface.CollectionCOmmands;

import java.util.Scanner;

public class ConsoleTerminal extends Terminal {
    {
        scan=new Scanner(System.in);
    }
    private String ObjectsName;
    @Override
    public void GetLine() {
        ObjectsName=scan.nextLine();
    }
    public void GetObjectsName(){
        System.out.println(ObjectsName);
    }



}
