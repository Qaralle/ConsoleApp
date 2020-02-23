package CollectionInterface.CollectionCOmmands;

public class RemoveAnyByNationality extends CommandWithPars {
    public RemoveAnyByNationality(Transporter tr) {
        super(tr);
    }

    @Override
    public void execute(receiver res) {
        this.setFieldsFromTransporter();
        res.removeAnyByNationality(nationality);
    }
}
