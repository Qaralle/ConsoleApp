package CollectionInterface.CollectionCOmmands;

public class FilterStartsWithName extends CommandWithPars {
    public FilterStartsWithName(Transporter tr) {
        super(tr);
    }

    @Override
    public void execute(receiver res) {
        this.setFieldsFromTransporter();
        res.filterStartsWithName(name);
        res.addCommandToHistory("filter_starts_with_name");
    }
}
