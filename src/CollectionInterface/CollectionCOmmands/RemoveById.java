package CollectionInterface.CollectionCOmmands;

public class RemoveById extends CommandWithPars{

    public RemoveById(Transporter tr) {
        super(tr);
    }

    @Override
    public void execute(receiver res) {
        this.setFieldsFromTransporter();
        res.remove_by_id(id);
        res.addCommandToHistory("remove_by_id");
    }

   /* @Override
    public void SetParams(Object[] bar1) {
        //this.id=Long.parseLong(String.valueOf(bar1[0]));
    }*/

}
