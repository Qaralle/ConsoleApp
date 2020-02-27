package CollectionInterface.FactoryPackage;

import ColClass.Coordinates;

/**
 * фабрика координат
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class CoordinatesMaker implements ObjectMaker<Coordinates> {
    /**
     * создание координат
     * @return объект класса Coordinates
     */
    @Override
    public Coordinates create() {
        return new Coordinates();
    }


}
