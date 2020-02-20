package CollectionInterface.FactoryPackage;

import ColClass.Coordinates;

public class CoordinatesMaker implements ObjectMaker<Coordinates> {

    @Override
    public Coordinates create() {
        return new Coordinates();
    }


}
