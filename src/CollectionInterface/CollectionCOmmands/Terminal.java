package CollectionInterface.CollectionCOmmands;

        import java.util.Scanner;

public abstract class Terminal implements invoker {
    protected Transporter transporter;
    protected CommandWithPars add;
    protected Scanner scan;
    protected Command show;
    protected Command info;
    protected CommandWithPars update;
    protected Command clear;
    protected CommandWithPars remove_by_id;

    /*{
        transporter = new Transporter();
    }*/

    public abstract void interactiveMod();
    //public Transporter getTransporter(){return transporter;}



}
