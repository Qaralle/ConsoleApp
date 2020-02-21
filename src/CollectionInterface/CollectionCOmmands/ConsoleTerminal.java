package CollectionInterface.CollectionCOmmands;

import java.util.Scanner;

public class ConsoleTerminal extends Terminal {

    private receiver res;
    private String userCommand;
    private String[] userCommand_;
    public String name_;

    private Object[] TypayaJava;

    public ConsoleTerminal(receiver res_){
        this.res=res_;
    }

    {
        userCommand = "";
        scan=new Scanner(System.in);
        add=new Add();
        show=new Show();
        info=new Info();
        update=new Update();
        clear=new Clear();
        remove_by_id=new RemoveById();

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
            userCommand_=userCommand.trim().split(" ");
            switch (userCommand_[0]){
                case("Add"):
                    System.out.println("Опа фраерок добавить что-то решил");
                    System.out.println(userCommand_[1]);
                    TypayaJava=(userCommand_[1].substring(1,userCommand_[1].length()-1).split(";", 2));
                    add.SetParams(TypayaJava);
                    add.execute(res); break;
                case("Show"):
                    show.execute(res); break;
                case("Info"):
                    info.execute(res); break;
                case("Update"):
                    System.out.println("Нахуй ты что-то меняешь? ");
                    System.out.println(userCommand_[1]);
                    TypayaJava=(userCommand_[2].substring(1,userCommand_[2].length()-1).split(";", 2));
                    update.execute(res, Long.parseLong(userCommand_[1]));
                    update.SetParams(TypayaJava);
                    break;
                case("Clear"):
                    clear.execute(res); break;
                case("Remove_by_id"):
                    remove_by_id.execute(res, Long.parseLong(userCommand_[1])); break;

            }

        }
    }


}
