package CollectionInterface.CollectionCOmmands;

public class RemoveAnyByNationality extends CommandWithPars {
    @Override
    public void execute(receiver res) {
        this.setFieldsFromTransporter();
        res.removeAnyByNationality(nationality);
    }
}
