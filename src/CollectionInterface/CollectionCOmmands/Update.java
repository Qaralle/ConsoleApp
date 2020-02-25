package CollectionInterface.CollectionCOmmands;


import java.io.FileNotFoundException;

public class Update extends CommandWithPars{
    public Update(Transporter tr) {
        super(tr);
    }


    @Override
    public void execute(receiver res) throws FileNotFoundException, Ea {
        transporter.setFields(res);
        this.setFieldsFromTransporter();
        res.update(id, name, height, eyeColor, hairColor, nationality, x, y, x1, y1, name1);
        res.addCommandToHistory("update");
    }

}