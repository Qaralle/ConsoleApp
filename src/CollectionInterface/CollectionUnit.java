package CollectionInterface;

import ClassCollection.CollectionTask;
import ColClass.*;
import CollectionInterface.CollectionCOmmands.receiver;
import CollectionInterface.FactoryPackage.CoordinatesMaker;
import CollectionInterface.FactoryPackage.LocationMaker;
import CollectionInterface.FactoryPackage.ObjectClassMaker;

import java.util.LinkedList;
import java.util.stream.Stream;

public class    CollectionUnit implements receiver {

    private CollectionTask ct;
    private CoordinatesMaker cm;
    private LocationMaker lm;
    private ObjectClassMaker om;

    private Coordinates coo;
    private Location loc;
    private Person per;

    public CollectionUnit(CollectionTask CT){ this.ct=CT; }

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
        /*per.setName(name_);
        per.setCoordinates(coo);
        per.setHeight(height_);
        per.setEyeColor(eyeColor_);
        per.setHairColor(hairColor_);
        per.setNationality(nationality_);
        per.setLocation(loc);*/

        per.setEverything(name_, coo, height_, eyeColor_, hairColor_, nationality_, loc);

        ct.add(per);
        System.out.println("Элемент добавлен");
        this.show();

    }

    @Override
    public void show() {
        for (Person s : ct.GetCollection()) {
            System.out.println("Имя: "+s.getName()+" айди: "+s.getId()+" дата: "+s.getData()+" Цвет волос: "+s.getHairColor()+" локация: "+s.location.getName());
        }
    }

    @Override
    public void info() {
        System.out.println("Тип коллекции: "+ct.GetCollection().getClass()+
                            " Дата иницализации: "+ct.getDateInit()+
                            " Количество элементов: "+ct.GetCollection().size());
    }

    @Override
    public void update(long id, String nameP_, Double height_, Color eyeColor_, Color hairColor_, Country nationality_, Float x_, Double y_, Float x1_, double y1_, String nameL_) {
        coo=cm.create();
        coo.SetX(x_);
        coo.SetY(y_);

        loc=lm.create();
        loc.SetX(x1_);
        loc.SetY(y1_);
        loc.SetName(nameL_);

        Stream<Person> personStream = ct.GetCollection().stream();
        personStream.filter(person -> person.getId() == id).forEach(person -> person.setEverything(nameP_, coo, height_, eyeColor_, hairColor_, nationality_, loc));

        System.out.println("Господи хоть бы сработало");
        this.show();
    }

    @Override
    public void clear() {
        ct.GetCollection().clear();
        System.out.println("Коллекция очищена.");
        this.show();
    }

    @Override
    public void remove_by_id(long id) {
        for (int i=0; i<ct.GetCollection().size(); ++i){
            if(ct.GetCollection().get(i).getId() == id){
                ct.GetCollection().remove(i);
                System.out.println("Удален объект с айди = "+id);
            }
        }
    }


}
