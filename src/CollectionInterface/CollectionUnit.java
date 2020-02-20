package CollectionInterface;

import ClassCollection.CollectionTask;
import ColClass.*;
import CollectionInterface.CollectionCOmmands.receiver;
import CollectionInterface.FactoryPackage.CoordinatesMaker;
import CollectionInterface.FactoryPackage.LocationMaker;
import CollectionInterface.FactoryPackage.ObjectClassMaker;

public class CollectionUnit implements receiver {

    private CollectionTask ct;
    private CoordinatesMaker cm;
    private LocationMaker lm;
    private ObjectClassMaker om;

    private Coordinates coo;
    private Location loc;
    private Person per;

    public CollectionUnit(CollectionTask CT){
        this.ct=CT;
    }

    {

        cm=new CoordinatesMaker();
        lm=new LocationMaker();
        om=new ObjectClassMaker();
    }


    @Override
    public void Add(String name_, Double height_, Color eyeColor_, Color hairColor_, Country nationality_, Float x_, Double y_, Float x1_, double y1_, String name1_){
        coo=cm.create();
        coo.SetX(x_);
        coo.SetY(y_);

        loc=lm.create();
        loc.SetX(x1_);
        loc.SetY(y1_);
        loc.SetName(name1_);

        per=om.create();
        per.setName(name_);
        per.setCoordinates(coo);
        per.setHeight(height_);
        per.setEyeColor(eyeColor_);
        per.setHairColor(hairColor_);
        per.setNationality(nationality_);
        per.setLocation(loc);

        ct.add(per);
        System.out.println("Элемент добавлен");
        ct.printer();

    }


}
