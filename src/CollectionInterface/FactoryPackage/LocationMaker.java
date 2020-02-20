package CollectionInterface.FactoryPackage;

import ColClass.Location;

public class LocationMaker implements ObjectMaker<Location>{

    @Override
    public Location create() {
        return new Location();
    }


}
