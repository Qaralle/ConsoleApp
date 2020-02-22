package CollectionInterface.CollectionCOmmands;

public class CountLessThanLocation extends CommandWithPars {
    @Override
    public void execute(receiver res) {
        res.countLessThanLocation(transporter.getLoc());
    }
}
