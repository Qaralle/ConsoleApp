package CollectionInterface.CollectionCOmmands;

public interface CommandALT<T> {
    void execute(receiver res);
    void  SetParams(T ... bar1);
    void execute(receiver res, long id);
}
