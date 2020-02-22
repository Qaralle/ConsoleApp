package CollectionInterface.CollectionCOmmands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleTerminal extends Terminal {

    private receiver res;
    private String userCommand;
    private String[] userCommand_;
    private String name_;

    private Map<String, String> KakJeUmenyaGoritJopa;
    private String[] TypayaJava;
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
        KakJeUmenyaGoritJopa = new HashMap<>();

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
            KakJeUmenyaGoritJopa.clear();
            userCommand = scan.nextLine();
            userCommand_=userCommand.trim().split(" ", 2);
            switch (userCommand_[0]){
                case("Add"):
                    System.out.println("Опа фраерок добавить что-то решил");
                    System.out.println(userCommand_[1]);
                    TypayaJava=(userCommand_[1].substring(1,userCommand_[1].length()-1).trim().split(" ", 2));
                    KakJeUmenyaGoritJopa.put("name",TypayaJava[0]);
                    KakJeUmenyaGoritJopa.put("height",TypayaJava[1]);
                    add.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    //add.SetParams(TypayaJava);
                    add.execute(res); break;

                case("Show"):
                    show.execute(res); break;

                case("Info"):
                    info.execute(res); break;

                case("Update"):
                    System.out.println("Нахуй ты что-то меняешь? ");
                    System.out.println(userCommand_[1]);
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("id",TypayaJava[0]);
                    TypayaJava[1]=((String)TypayaJava[1]).substring(1,((String)TypayaJava[1]).length()-1);
                    KakJeUmenyaGoritJopa.put("name",TypayaJava[1]);
                    TypayaJava[2]=((String)TypayaJava[2]).substring(1,((String)TypayaJava[2]).length()-1);
                    KakJeUmenyaGoritJopa.put("height",TypayaJava[2]);
                    update.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    //Transporter.SetParams(TypayaJava);
                    update.execute(res); break;

                case("Clear"):
                    clear.execute(res); break;

                case("Remove_by_id"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("id",TypayaJava[0]);
                    remove_by_id.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    remove_by_id.execute(res); break;

                case("Remove_head"):
                    removeHead.execute(res); break;

                case("Remove_any_by_nationality"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("nationality",TypayaJava[0]);
                    removeAnyByNationality.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    removeAnyByNationality.execute(res); break;

                case("Count_less_than_location"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("nameL",TypayaJava[0]);
                    countLessThanLocation.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    countLessThanLocation.execute(res); break;

                case("Filter_starts_with_name"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("name",TypayaJava[0]);
                    filterStartsWithName.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    filterStartsWithName.execute(res); break;

                case ("Save"):
                    save.execute(res); break;
            }

        }
    }


}
