package CollectionInterface.CollectionCOmmands;

import java.io.FileNotFoundException;

public class AddIfMin extends CommandWithPars {
    public AddIfMin(Transporter tr) {
        super(tr);
    }

    @Override
    public void execute(receiver res) throws FileNotFoundException, Ea {
        transporter.setFields(res);
        this.setFieldsFromTransporter();
        res.addIfMin(name,height,eyeColor,hairColor,nationality,x,y,x1,y1,name1);
        res.addCommandToHistory("add_if_min");
    }
}
