package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;

/**
 * Класс, предоставляющий реализацию команды execute_script (выполнение скрипта)
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class ExecuteScript extends CommandWithPars{

    /**
     * @param tr FileTransporter
     */
    public ExecuteScript(Transporter tr) {
        super(tr);
    }

    /**
     * выполнение команды
     * @param res Receiver (объект класса CollectionUnit)
     * @throws FileNotFoundException файл не найден
     */
    @Override
    public void execute(receiver res) throws FileNotFoundException {

        res.addCommandToHistory("execute_script");
        res.executeScript(transporter.getFile_name());

    }

}
