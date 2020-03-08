package CollectionInterface.CollectionCOmmands;

import ColClass.Location;

import java.io.FileNotFoundException;
        import java.util.Map;
        import java.util.Scanner;

/**
 * Абстрактный класс, выполняющий функци инвокера
 * @author Maxim Antonov and Andrey Lyubkin
 */
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


    protected Map<String, String> bufferMap;
    protected String[] bufferStringForArgs;

    /**
     * @param res_ Receiver
     */
    public Terminal(receiver res_) {
        this.res=res_;
    }

    /**
     * @param rec_ Receiver
     * @param scanner Scanner
     */
    public Terminal(receiver rec_, Scanner scanner) {
        this.scan=scanner;
        this.res=rec_;
    }

    /**
     * перейти в интерактивный режим
     * @throws FileNotFoundException файл не найден
     */
    @Override
    public void interactiveMod() throws FileNotFoundException {
        while (true) {
            System.out.print("$");
            if (scan.hasNextLine()) {

                try {

                    bufferMap.clear();
                    userCommand = scan.nextLine();
                    userCommand_ = userCommand.trim().split(" ", 2);

                    switch (userCommand_[0]) {
                        case ("add"):
                            add.execute(res);
                            break;

                        case ("show"):
                            show.execute(res);
                            break;

                        case ("info"):
                            info.execute(res);
                            break;

                        case ("update"):
                            bufferMap.put("id", userCommand_[1].trim());
                            for (int i=0;i<res.getCT().GetCollection().size();++i){
                                if(Long.parseLong(bufferMap.get("id")) == res.getCT().GetCollection().get(i).getId()) {
                                    bufferMap.put("index", String.valueOf(i));
                                    update.getTransporter().SetParams(bufferMap);
                                    update.execute(res);
                                    break;
                                }if (i == res.getCT().GetCollection().size() - 1){
                                    System.out.println("Объекта с таким id нет");
                                }
                            }
                            break;

                        case ("clear"):
                            clear.execute(res);
                            break;

                        case ("remove_by_id"):
                            //try {
                            bufferMap.put("id", userCommand_[1].trim());
                            remove_by_id.getTransporter().SetParams(bufferMap);
                            remove_by_id.execute(res);
                            break;


                        case ("remove_head"):
                            removeHead.execute(res);
                            break;

                        case ("remove_any_by_nationality"):
                            //try {
                            bufferMap.put("nationality", userCommand_[1].trim());
                            removeAnyByNationality.getTransporter().SetParams(bufferMap);

                            removeAnyByNationality.execute(res);
                            break;


                        case ("count_less_than_location"):
                            //try {
                            bufferMap.put("nameL", userCommand_[1].trim());
                            countLessThanLocation.getTransporter().SetParams(bufferMap);

                            countLessThanLocation.execute(res);
                            break;


                        case ("filter_starts_with_name"):
                            //try {
                            bufferMap.put("name", userCommand_[1].trim());
                            filterStartsWithName.getTransporter().SetParams(bufferMap);

                            filterStartsWithName.execute(res);
                            break;


                        case ("save"):
                            save.execute(res);
                            break;
                        case ("execute_script"):
                            //try {
                            bufferMap.put("file_name", userCommand_[1].trim());
                            executeScript.getTransporter().SetParams(bufferMap);
                            executeScript.execute(res);
                            break;

                        case ("exit"):
                            exit.execute(res);
                        case ("history"):
                            history.execute(res);
                            break;
                        case ("add_if_min"):
                            addIfMin.execute(res);
                            break;
                        case ("help"):
                            help.execute(res);
                            break;
                        default:
                            if (!userCommand_[0].equals("")) {
                                System.err.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                            }
                            break;


                    }


                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.err.println("Wrong syntax. Please use 'help'");

                } catch (FileNotFoundException ex) {
                    System.err.println("Файл не найден");

                } catch (IllegalArgumentException | WrongTypeOfFieldException ex) {
                    System.err.println("Некорректное заполнение полей. Попробуйте ещё раз, следуя инструкциям.");
                }
            }else break;
        }


    }
}
