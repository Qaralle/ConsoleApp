package CollectionInterface.CollectionCOmmands;


import java.io.FileNotFoundException;

/**
 * Класс, предоставляющий реализацию команды update, (обновление элемента с заданным id)
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class Update extends CommandWithPars{
    /**
     * @param tr Transporter
     */
    public Update(Transporter tr) {
        super(tr);
    }

    /**
     * выполнение команы
     * @param res Receiver (объект класса CollectionUnit)
     * @throws FileNotFoundException файл не найден
     * @throws WrongTypeOfFieldException обработка некорректных типов полей
     */
    @Override
    public void execute(receiver res) throws FileNotFoundException, WrongTypeOfFieldException {
        transporter.setFields(res);
        this.setFieldsFromTransporter();
        res.update(id, name, height, eyeColor, hairColor, nationality, x, y, x1, y1, name1);
        res.addCommandToHistory("update");
    }

}