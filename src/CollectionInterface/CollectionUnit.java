package CollectionInterface;

import ClassCollection.CollectionTask;
import ColClass.*;
import CollectionInterface.CollectionCOmmands.receiver;
import CollectionInterface.FactoryPackage.CoordinatesMaker;
import CollectionInterface.FactoryPackage.LocationMaker;
import CollectionInterface.FactoryPackage.ObjectClassMaker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Stream;

public class CollectionUnit implements receiver {

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
        Iterator<Person> it = ct.GetCollection().iterator();
        while (it.hasNext()){
            Person p = it.next();
            if(p.getId() == id){
                it.remove();
                System.out.println("Удален объект с айди = "+id); break;
            }
        }
    }

    @Override
    public void removeHead() {
        System.out.println("Имя: "+ct.GetCollection().get(0).getName()+
                            " айди: "+ct.GetCollection().get(0).getId()+
                            " дата: "+ct.GetCollection().get(0).getData()+
                            " Цвет волос: "+ct.GetCollection().get(0).getHairColor()+
                            " локация: "+ct.GetCollection().get(0).location.getName());
        ct.GetCollection().remove(0);
    }

    @Override
    public void removeAnyByNationality(Country nationality) {
        Iterator<Person> it = ct.GetCollection().iterator();
        while (it.hasNext()){
            Person p = it.next();
            if(p.getNationality() == nationality){
                it.remove();
                System.out.println("Удален объект по национальности = "+nationality); break;
            }
        }
    }

    @Override
    public void countLessThanLocation(Location loc) {
        Stream<Person> personStream = ct.GetCollection().stream();
        System.out.println(personStream.filter(person -> person.getLocation().compareTo(loc) > 0).count());
    }

    @Override
    public void filterStartsWithName(String name) {
        Iterator<Person> it = ct.GetCollection().iterator();
        while (it.hasNext()){
            Person p = it.next();
            if(p.getName().startsWith(name)){
                System.out.println(p.getName());
            }
        }
    }

    @Override
    public void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\user\\Documents\\ConsoleApp\\src\\SaveCollection");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        for (int i=0; i<ct.GetCollection().size(); ++i) {
            fileOutputStream.write(gson.toJson(ct.GetCollection().get(i)).getBytes());
        }
        fileOutputStream.close();
    }


}
