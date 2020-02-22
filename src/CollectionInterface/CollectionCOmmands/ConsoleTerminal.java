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
 //       transporter = add.getTransporter();
        show=new Show();
        info=new Info();
        update=new Update();
        clear=new Clear();
        remove_by_id=new RemoveById();
        removeHead=new RemoveHead();
        removeAnyByNationality=new RemoveAnyByNationality();
        countLessThanLocation=new CountLessThanLocation();
        filterStartsWithName=new FilterStartsWithName();
        save=new Save();
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
            userCommand_=userCommand.trim().split(" ", 2);
            switch (userCommand_[0]){
                case("Add"):
                    System.out.println("Опа фраерок добавить что-то решил");
                    System.out.println(userCommand_[1]);
                    TypayaJava=(userCommand_[1].substring(1,userCommand_[1].length()-1).split(" ", 2));
                    add.getTransporter().SetParams(TypayaJava);
                    //add.SetParams(TypayaJava);
                    add.execute(res); break;
                case("Show"):
                    show.execute(res); break;
                case("Info"):
                    info.execute(res); break;
                case("Update"):
                    System.out.println("Нахуй ты что-то меняешь? ");
                    System.out.println(userCommand_[1]);
                    TypayaJava=(userCommand_[1].split(" ", 3));
                    TypayaJava[1]=((String)TypayaJava[1]).substring(1,((String)TypayaJava[1]).length()-1);
                    TypayaJava[2]=((String)TypayaJava[2]).substring(1,((String)TypayaJava[2]).length()-1);
                    update.getTransporter().SetParams(TypayaJava);
                    //Transporter.SetParams(TypayaJava);
                    update.execute(res); break;
                case("Clear"):
                    clear.execute(res); break;
                case("Remove_by_id"):
                    TypayaJava=(userCommand_[1].split(" ", 3));
                    remove_by_id.getTransporter().SetParams(TypayaJava);
                    remove_by_id.execute(res); break;
                case("Remove_head"):
                    removeHead.execute(res); break;
                case("Remove_any_by_nationality"):
                    TypayaJava=(userCommand_[1].split(" ", 3));
                    removeAnyByNationality.getTransporter().SetParams(TypayaJava);
                    removeAnyByNationality.execute(res);
                case("Count_less_than_location"):
                    TypayaJava=(userCommand_[1].split(" ", 3));
                    countLessThanLocation.getTransporter().SetParams(TypayaJava);
                    countLessThanLocation.execute(res);
                case("Filter_starts_with_name"):
                    TypayaJava=(userCommand_[1].split(" ", 3));
                    filterStartsWithName.getTransporter().SetParams(TypayaJava);
                    filterStartsWithName.execute(res);
                case ("Save"):
                    save.execute(res);
            }

        }
    }


}
