package CollectionInterface;

import ClassCollection.CollectionTask;
import CollectionInterface.CollectionCOmmands.receiver;
import CollectionInterface.FactoryPackage.CoordinatesCreater;
import CollectionInterface.FactoryPackage.LocationCreater;

public class CollectionUnit implements receiver {
    private LocationCreater lc;
    private CoordinatesCreater cc;
    private CollectionTask ct;



    @Override
    public void Add() {

    }
}
