package CollectionInterface.CollectionCOmmands;

public interface CommandALT<T> {
    void execute(receiver res);
    void  SetParams(T ... bar1);

}
