package CollectionInterface.CollectionCOmmands;

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
                            //System.out.println("Опа фраерок добавить что-то решил");
                            //try{
                            userCommand_[1] = userCommand_[1].trim();
                            if ((userCommand_[1].startsWith("{")) && (userCommand_[1].endsWith("}"))) {
                                bufferStringForArgs = (userCommand_[1].substring(1, userCommand_[1].length() - 1).trim().split(" ", 2));
                                bufferMap.put("name", bufferStringForArgs[0]);
                                bufferMap.put("height", bufferStringForArgs[1]);
                                add.getTransporter().SetParams(bufferMap);
                                add.execute(res);
                            } else {
                                System.err.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                            }
                            break;

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
                                bufferStringForArgs = (userCommand_[1].trim().split(" ", 3));
                                bufferMap.put("id", bufferStringForArgs[0]);
                                bufferStringForArgs[1] = bufferStringForArgs[1].substring(1, bufferStringForArgs[1].length() - 1);
                                bufferMap.put("name", bufferStringForArgs[1]);
                                bufferStringForArgs[2] = bufferStringForArgs[2].substring(1, bufferStringForArgs[2].length() - 1);
                                bufferMap.put("height", bufferStringForArgs[2]);
                                update.getTransporter().SetParams(bufferMap);
                                update.execute(res);
                            } else {
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
                            bufferStringForArgs = (userCommand_[1].trim().split(" ", 3));
                            bufferMap.put("id", bufferStringForArgs[0]);
                            remove_by_id.getTransporter().SetParams(bufferMap);

                            remove_by_id.execute(res);
                            break;


                        case ("remove_head"):
                            removeHead.execute(res);
                            break;

                        case ("remove_any_by_nationality"):
                            //try {
                            bufferStringForArgs = (userCommand_[1].trim().split(" ", 3));
                            bufferMap.put("nationality", bufferStringForArgs[0]);
                            removeAnyByNationality.getTransporter().SetParams(bufferMap);

                            remove_by_id.execute(res);
                            break;


                        case ("count_less_than_location"):
                            //try {
                            bufferStringForArgs = (userCommand_[1].trim().split(" ", 3));
                            bufferMap.put("nameL", bufferStringForArgs[0]);
                            countLessThanLocation.getTransporter().SetParams(bufferMap);

                            countLessThanLocation.execute(res);
                            break;


                        case ("filter_starts_with_name"):
                            //try {
                            bufferStringForArgs = (userCommand_[1].trim().split(" ", 3));
                            bufferMap.put("name", bufferStringForArgs[0]);
                            filterStartsWithName.getTransporter().SetParams(bufferMap);

                            filterStartsWithName.execute(res);
                            break;


                        case ("save"):
                            save.execute(res);
                            break;
                        case ("execute_script"):
                            //try {
                            bufferStringForArgs = (userCommand_[1].trim().split(" ", 3));
                            bufferMap.put("file_name", bufferStringForArgs[0]);
                            executeScript.getTransporter().SetParams(bufferMap);
                            executeScript.execute(res);
                            break;

                        case ("exit"):
                            exit.execute(res);
                        case ("history"):
                            history.execute(res);
                            break;
                        case ("add_if_min"):
                            //try {
                            if ((userCommand_[1].startsWith("{")) && (userCommand_[1].endsWith("}"))) {
                                bufferStringForArgs = (userCommand_[1].substring(1, userCommand_[1].length() - 1).trim().split(" ", 2));
                                bufferMap.put("name", bufferStringForArgs[0]);
                                bufferMap.put("height", bufferStringForArgs[1]);
                                addIfMin.getTransporter().SetParams(bufferMap);
                                addIfMin.execute(res);
                            } else {
                                System.err.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                            }
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
