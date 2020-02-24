package CollectionInterface.CollectionCOmmands;

public class CountLessThanLocation extends CommandWithPars {
    public CountLessThanLocation(Transporter tr) {
        super(tr);
    }

    @Override
    public void execute(receiver res) {
        res.countLessThanLocation(transporter.getName1());
    }
}
