package CollectionInterface.CollectionCOmmands;

import java.util.Scanner;

public class ConsoleTerminal extends Terminal {
    private String userCommand;
    private String[] userCommand_;
    public String name_;

    {
        userCommand = "";
        scan=new Scanner(System.in);
        add=new Add();
    }

    private String ObjectsName;

    public void GetLine() {
        ObjectsName=scan.nextLine();
    }

    public void GetObjectsName(){
        System.out.println(ObjectsName);
    }

    @Override
    public void interactiveMod() {
        while (!userCommand.equals("exit")) {
            userCommand = scan.nextLine();
            userCommand_=userCommand.trim().split(" ",2);
            switch (userCommand_[0]){
                case("Add"):
                    System.out.println("Опа фраерок добавить что-то решил");
                    name_=userCommand_[1].substring(1,userCommand_[1].length()-1);
                    add.SetParam(name_);
                    add.execute();

            }

        }
    }


}
