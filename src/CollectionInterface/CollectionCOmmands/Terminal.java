package CollectionInterface.CollectionCOmmands;

        import java.util.Scanner;

public abstract class Terminal implements invoker {
    protected CommandALT add;
    protected Scanner scan;
    protected Command show;
    protected Command info;
    protected CommandALT update;
    protected Command clear;
    protected Command remove_by_id;

    public abstract void interactiveMod();



}
