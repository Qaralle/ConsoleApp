package CollectionInterface.CollectionCOmmands;

import ColClass.Location;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
    protected ExecuteScript executeScript;
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
    public void interactiveMod(String del) throws FileNotFoundException {

        while (true) {
            System.out.print(del);
            if (scan.hasNextLine()) {

                try {

                    bufferMap.clear();
                    userCommand = scan.nextLine();
                    userCommand_ = userCommand.trim().split(" ", 2);

                    switch (userCommand_[0]) {
                        case ("add"):
                            if (userCommand_.length==1) {
                                add.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;

                        case ("show"):
                            if (userCommand_.length==1) {
                                show.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;

                        case ("info"):
                            if (userCommand_.length==1) {
                                info.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;

                        case ("update"):
                            if (userCommand_.length == 2) {
                            bufferMap.put("id", userCommand_[1].trim());
                                for (int i = 0; i < res.getCT().GetCollection().size(); ++i) {
                                    if (Long.parseLong(bufferMap.get("id")) == res.getCT().GetCollection().get(i).getId()) {
                                        bufferMap.put("index", String.valueOf(i));
                                        update.getTransporter().SetParams(bufferMap);
                                        update.execute(res);
                                        break;
                                    }
                                    if (i == res.getCT().GetCollection().size() - 1) {
                                        System.out.println("Объекта с таким id нет");
                                    }
                                }
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;

                        case ("clear"):
                            if (userCommand_.length==1) {
                                clear.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("remove_by_id"):
                            if(userCommand_.length == 2) {
                                bufferMap.put("file_name", userCommand_[1].trim());
                                remove_by_id.getTransporter().SetParams(bufferMap);
                                remove_by_id.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("remove_head"):
                            if (userCommand_.length==1) {
                                removeHead.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("remove_any_by_nationality"):
                            if(userCommand_.length == 2) {
                                bufferMap.put("file_name", userCommand_[1].trim());
                                removeAnyByNationality.getTransporter().SetParams(bufferMap);
                                removeAnyByNationality.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("count_less_than_location"):
                            if(userCommand_.length == 2) {
                                bufferMap.put("file_name", userCommand_[1].trim());
                                countLessThanLocation.getTransporter().SetParams(bufferMap);
                                countLessThanLocation.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("filter_starts_with_name"):
                            if(userCommand_.length == 2) {
                                bufferMap.put("file_name", userCommand_[1].trim());
                                filterStartsWithName.getTransporter().SetParams(bufferMap);
                                filterStartsWithName.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("save"):
                            if (userCommand_.length==1) {
                                save.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("execute_script"):
                            if(userCommand_.length == 2) {
                                bufferMap.put("file_name", userCommand_[1].trim());
                                executeScript.getTransporter().SetParams(bufferMap);
                                executeScript.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;

                        case ("exit"):
                            if (userCommand_.length==1) {
                                exit.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                        case ("history"):
                            if (userCommand_.length==1) {
                                history.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("add_if_min"):
                            if (userCommand_.length==1) {
                                addIfMin.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        case ("help"):
                            if (userCommand_.length==1) {
                                help.execute(res);
                            }else {
                                System.out.println("Неверный синтаксис команды. Используйте help.");
                            }
                            break;


                        default:
                            if (!userCommand_[0].equals("")) {
                                System.out.println("Кажется, что-то пошло не так. Чтобы посмотреть доступные команды, используйте 'help'");
                            }
                            break;


                    }


                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Wrong syntax. Please use 'help'");

                } catch (FileNotFoundException ex) {
                    System.out.println("Файл не найден");

                } catch (WrongTypeOfFieldException e) {
                    e.printStackTrace();
                }

            }else break;
        }


    }
}
