package ClassCollection;

/**
 * Interface, реализуемый классами, проверяющими поля элементов коллекции
 * @author Maxim Antonov and Andrey Lyubkin
 * @param <T> Person
 * @param <P> Location
 * @param <V> Coordinates
 */
public interface Police<T,P,V> {
    void PersonReplace(T p);
    void LocationReplace(P loc);
    void CoordinatesReplace(V coo);
}