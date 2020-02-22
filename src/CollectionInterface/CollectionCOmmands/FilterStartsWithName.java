package CollectionInterface.CollectionCOmmands;

public class FilterStartsWithName extends CommandWithPars {
    @Override
    public void execute(receiver res) {
        this.setFieldsFromTransporter();
        res.filterStartsWithName(name);
    }
}
