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
            try {

                KakJeUmenyaGoritJopa.clear();
                userCommand = scan.nextLine();
                userCommand_ = userCommand.trim().split(" ", 2);
                switch (userCommand_[0]) {
                    case ("add"):
                        //System.out.println("Опа фраерок добавить что-то решил");
                        //try{
                        userCommand_[1] = userCommand_[1].trim();
                        if ((userCommand_[1].startsWith("{")) && (userCommand_[1].endsWith("}"))) {
                            TypayaJava = (userCommand_[1].substring(1, userCommand_[1].length() - 1).trim().split(" ", 2));
                            KakJeUmenyaGoritJopa.put("name", TypayaJava[0]);
                            KakJeUmenyaGoritJopa.put("height", TypayaJava[1]);
                            add.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                            add.execute(res);
                        }else{
                            System.err.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                        } break;
                    /*}catch (ArrayIndexOutOfBoundsException ex){
                        System.err.println("Некорректный синтаксис команды. Используйте 'help'");
                        break;
                    }
                    try {*/

                    /*}catch (Exception ex){
                        System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям."); break;
                    }*/
                    case ("show"):
                        show.execute(res);
                        break;

                    case ("info"):
                        info.execute(res);
                        break;

                    case ("update"):
                        //System.out.println("Нахуй ты что-то меняешь? ");

                        // try {
                        if ((userCommand_[1].startsWith("{")) && (userCommand_[1].endsWith("}"))) {
                            TypayaJava = (userCommand_[1].trim().split(" ", 3));
                            KakJeUmenyaGoritJopa.put("id", TypayaJava[0]);
                            TypayaJava[1] = TypayaJava[1].substring(1, TypayaJava[1].length() - 1);
                            KakJeUmenyaGoritJopa.put("name", TypayaJava[1]);
                            TypayaJava[2] = TypayaJava[2].substring(1, TypayaJava[2].length() - 1);
                            KakJeUmenyaGoritJopa.put("height", TypayaJava[2]);
                            update.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                            update.execute(res);
                        }else {
                            System.err.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                        }
                        break;
                    /*}catch (Exception ex){
                        System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям."); break;
                    }*/

                    case ("clear"):
                        clear.execute(res);
                        break;

                    case ("remove_by_id"):
                        //try {
                        TypayaJava = (userCommand_[1].trim().split(" ", 3));
                        KakJeUmenyaGoritJopa.put("id", TypayaJava[0]);
                        remove_by_id.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    /*}catch (ArrayIndexOutOfBoundsException ex){
                        System.err.println("Некорректный синтаксис команды. Используйте 'help'");
                        break;
                    }
                    try {*/
                        remove_by_id.execute(res);
                        break;
                    /*}catch (Exception ex){
                        System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям."); break;
                    }*/

                    case ("remove_head"):
                        removeHead.execute(res);
                        break;

                    case ("remove_any_by_nationality"):
                        //try {
                        TypayaJava = (userCommand_[1].trim().split(" ", 3));
                        KakJeUmenyaGoritJopa.put("nationality", TypayaJava[0]);
                        removeAnyByNationality.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    /*}catch (ArrayIndexOutOfBoundsException ex){
                        System.err.println("Некорректный синтаксис команды. Используйте 'help'");
                        break;
                    }
                    try {*/
                        remove_by_id.execute(res);
                        break;
                    /*}catch (Exception ex){
                        System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям."); break;
                    }*/

                    case ("count_less_than_location"):
                        //try {
                        TypayaJava = (userCommand_[1].trim().split(" ", 3));
                        KakJeUmenyaGoritJopa.put("nameL", TypayaJava[0]);
                        countLessThanLocation.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    /*}catch (ArrayIndexOutOfBoundsException ex){
                        System.err.println("Некорректный синтаксис команды. Используйте 'help'");
                        break;
                    }
                    try {*/
                        countLessThanLocation.execute(res);
                        break;
                    /*}catch (Exception ex){
                        System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям."); break;
                    }*/

                    case ("filter_starts_with_name"):
                        //try {
                        TypayaJava = (userCommand_[1].trim().split(" ", 3));
                        KakJeUmenyaGoritJopa.put("name", TypayaJava[0]);
                        filterStartsWithName.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    /*}catch (ArrayIndexOutOfBoundsException ex){
                        System.err.println("Некорректный синтаксис команды. Используйте 'help'");
                        break;
                    }
                    try {*/
                        filterStartsWithName.execute(res);
                        break;
                   /* }catch (Exception ex){
                        System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям."); break;
                    }*/

                    case ("save"):
                        save.execute(res);
                        break;
                    case ("execute_script"):
                        //try {
                        TypayaJava = (userCommand_[1].trim().split(" ", 3));
                        KakJeUmenyaGoritJopa.put("file_name", TypayaJava[0]);
                        executeScript.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                    /*}catch (ArrayIndexOutOfBoundsException ex){
                        System.err.println("Некорректный синтаксис команды. Используйте 'help'");
                        break;
                    }
                    try {*/
                        executeScript.execute(res);
                        break;
                    /*}catch (FileNotFoundException ex){
                        System.err.println("Файл не найден"); break;
                    }*/

                    case ("exit"):
                        exit.execute(res);
                    case ("history"):
                        history.execute(res);
                        break;
                    case ("add_if_min"):
                        //try {
                        if ((userCommand_[1].startsWith("{")) && (userCommand_[1].endsWith("}"))) {
                            TypayaJava = (userCommand_[1].substring(1, userCommand_[1].length() - 1).trim().split(" ", 2));
                            KakJeUmenyaGoritJopa.put("name", TypayaJava[0]);
                            KakJeUmenyaGoritJopa.put("height", TypayaJava[1]);
                            addIfMin.getTransporter().SetParams(KakJeUmenyaGoritJopa);
                            addIfMin.execute(res);
                        }else{
                            System.err.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                        }
                        break;
                    /*}catch (Exception ex){
                        System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям."); break;
                    }*/
                    case ("help"):
                        help.execute(res);
                        break;
                    default:
                        System.err.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("Некорректный синтаксис команды. Используйте 'help'");
            } catch (FileNotFoundException ex) {
                System.err.println("Файл не найден");
            } catch (Exception ex) {
                System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям.");
            }
        }
    }
    //public abstract void interactiveMod();
    //public Transporter getTransporter(){return transporter;}


}
