package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;

/**
 * Interface, реализуемый всеми командами
 * @author Maxim Antonov and Andrey Lyubkin
 */
public interface Command {
     /**
      * Выполнение команды
      * @param res Receiver (объект класса CollectionUnit)
      * @throws FileNotFoundException Не найден файл
      * @throws WrongTypeOfFieldException обработка некорректных типов полей
      */
     void execute(receiver res) throws FileNotFoundException, WrongTypeOfFieldException;
}
