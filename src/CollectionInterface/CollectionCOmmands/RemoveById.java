package CollectionInterface.CollectionCOmmands;

public class RemoveById extends CommandWithPars{

    @Override
    public void execute(receiver res) {
        this.setFieldsFromTransporter();
        res.remove_by_id(id);
    }

   /* @Override
    public void SetParams(Object[] bar1) {
        //this.id=Long.parseLong(String.valueOf(bar1[0]));
    }*/

}
