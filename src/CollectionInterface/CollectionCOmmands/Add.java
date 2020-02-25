package CollectionInterface.CollectionCOmmands;


import java.io.FileNotFoundException;

public class Add extends CommandWithPars{


    @Override
    public void execute(receiver res) throws FileNotFoundException, Ea {
        transporter.setFields(res);
        this.setFieldsFromTransporter();
        res.add(name,height,eyeColor,hairColor,nationality,x,y,x1,y1,name1);
        res.addCommandToHistory("add");
    }

    public Add(Transporter tr){
        super(tr);
    }

}
