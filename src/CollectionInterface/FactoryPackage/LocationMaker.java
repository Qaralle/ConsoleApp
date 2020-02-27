package CollectionInterface.FactoryPackage;

import ColClass.Location;

/**
 * фабрика локаций
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class LocationMaker implements ObjectMaker<Location>{
    /**
     * создание локации
     * @return объект класса Location
     */
    @Override
    public Location create() {
        return new Location();
    }


}
