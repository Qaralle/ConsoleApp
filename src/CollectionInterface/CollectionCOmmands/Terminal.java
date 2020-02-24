package CollectionInterface.CollectionCOmmands;

        import java.io.FileNotFoundException;
        import java.util.Map;
        import java.util.Scanner;

public abstract class Terminal implements invoker {
    //protected Transporter transporter;
    protected Scanner scan;
    protected CommandWithPars add;
    protected Command show;
    protected Command info;
    protected CommandWithPars update;
    protected Command clear;
    protected CommandWithPars remove_by_id;
    protected Command removeHead;
    protected CommandWithPars removeAnyByNationality;
    protected CommandWithPars countLessThanLocation;
    protected CommandWithPars filterStartsWithName;
    protected Command save;
    protected CommandWithPars executeScript;
    protected Command exit;
    protected Command history;
    protected CommandWithPars addIfMin;
    protected Command help;

    protected String userCommand;
    protected String[] userCommand_;
    protected receiver res;

    protected Map<String, String> KakJeUmenyaGoritJopa;
    protected String[] TypayaJava;

    public Terminal(receiver res_) {
        this.res=res_;
    }


    public Terminal(receiver rec_, Scanner scanner) {
        this.scan=scanner;
        this.res=rec_;
    }



    /*{
        transporter = new Transporter();
    }*/

    @Override
    public void interactiveMod() throws FileNotFoundException {
        while (scan.hasNextLine()) {

            KakJeUmenyaGoritJopa.clear();
            userCommand = scan.nextLine();
            userCommand_=userCommand.trim().split(" ", 2);
            switch (userCommand_[0]){
                case("add"):
                    System.out.println("Опа фраерок добавить что-то решил");
                    TypayaJava=(userCommand_[1].substring(1,userCommand_[1].length()-1).trim().split(" ", 2));
                    KakJeUmenyaGoritJopa.put("name",TypayaJava[0]);
                    KakJeUmenyaGoritJopa.put("height",TypayaJava[1]);
                    add.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    //add.SetParams(TypayaJava);
                    add.execute(res); break;
                case("show"):
                    show.execute(res); break;
                case("info"):
                    info.execute(res); break;
                case("update"):
                    System.out.println("Нахуй ты что-то меняешь? ");

                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("id",TypayaJava[0]);
                    TypayaJava[1]= TypayaJava[1].substring(1, TypayaJava[1].length()-1);
                    KakJeUmenyaGoritJopa.put("name",TypayaJava[1]);
                    TypayaJava[2]= TypayaJava[2].substring(1, TypayaJava[2].length()-1);
                    KakJeUmenyaGoritJopa.put("height",TypayaJava[2]);
                    update.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    update.execute(res); break;

                case("clear"):
                    clear.execute(res); break;

                case("remove_by_id"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("id",TypayaJava[0]);
                    remove_by_id.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    remove_by_id.execute(res); break;

                case("remove_head"):
                    removeHead.execute(res); break;

                case("remove_any_by_nationality"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("nationality",TypayaJava[0]);
                    removeAnyByNationality.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    removeAnyByNationality.execute(res); break;

                case("count_less_than_location"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("nameL",TypayaJava[0]);
                    countLessThanLocation.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    countLessThanLocation.execute(res); break;

                case("filter_starts_with_name"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("name",TypayaJava[0]);
                    filterStartsWithName.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    filterStartsWithName.execute(res); break;

                case ("save"):
                    res.addCommandToHistory("Save");
                    save.execute(res); break;
                case ("execute_script"):
                    TypayaJava=(userCommand_[1].trim().split(" ", 3));
                    KakJeUmenyaGoritJopa.put("file_name",TypayaJava[0]);
                    executeScript.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    executeScript.execute(res);break;
                case ("exit"):
                    exit.execute(res);
                case ("history"):
                    history.execute(res); break;
                case ("add_if_min"):
                    System.out.println("Опа фраерок добавить что-то решил");
                    TypayaJava=(userCommand_[1].substring(1,userCommand_[1].length()-1).trim().split(" ", 2));
                    KakJeUmenyaGoritJopa.put("name",TypayaJava[0]);
                    KakJeUmenyaGoritJopa.put("height",TypayaJava[1]);
                    addIfMin.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    addIfMin.execute(res); break;
                case ("help"):
                    help.execute(res); break;
                default:
                    System.out.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
            }

        }
    }
    //public abstract void interactiveMod();
    //public Transporter getTransporter(){return transporter;}


}
