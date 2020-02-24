package CollectionInterface;

import ClassCollection.CollectionTask;
import ClassCollection.CompareCenter;
import ColClass.*;
import CollectionInterface.CollectionCOmmands.FileTerminal;
import CollectionInterface.CollectionCOmmands.receiver;
import CollectionInterface.FactoryPackage.CoordinatesMaker;
import CollectionInterface.FactoryPackage.LocationMaker;
import CollectionInterface.FactoryPackage.ObjectClassMaker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class CollectionUnit implements receiver {

    private CollectionTask ct;
    private CompareCenter compareCenter;
    private CoordinatesMaker cm;
    private LocationMaker lm;
    private ObjectClassMaker om;

    private Coordinates coo;
    private Location loc;
    private Person per;

    public CollectionUnit(CollectionTask CT){ this.ct=CT; }

    {
        compareCenter=new CompareCenter();
        cm=new CoordinatesMaker();
        lm=new LocationMaker();
        om=new ObjectClassMaker();
    }


    @Override
    public void add(String name_, Double height_, Color eyeColor_, Color hairColor_, Country nationality_, Float x_, Double y_, Float x1_, double y1_, String name1_){
        coo=cm.create();
        coo.SetX(x_);
        coo.SetY(y_);

        loc=lm.create();
        loc.SetX(x1_);
        loc.SetY(y1_);
        loc.SetName(name1_);

        per=om.create();

        per.setEverything(name_, coo, height_, eyeColor_, hairColor_, nationality_, loc);

        ct.add(per);
        System.out.println("Элемент добавлен");

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

        System.out.println("Обновлен элемент с id = "+id);
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
    public void countLessThanLocation(String namel) {

        loc = lm.create();
        loc.SetX(1f);
        loc.SetY(1);
        loc.SetName(namel);
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
        FileOutputStream fileOutputStream = new FileOutputStream("saveCollection.json");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        fileOutputStream.write("[".getBytes());
        for (int i=0; i<ct.GetCollection().size(); ++i) {
            fileOutputStream.write(gson.toJson(ct.GetCollection().get(i)).getBytes());
            if(ct.GetCollection().size()-i!=1) {
                fileOutputStream.write(",".getBytes());
            }
        }
        fileOutputStream.write("]".getBytes());
        System.out.println("Коллекция сохранена в файл");
        fileOutputStream.close();
    }

    @Override
    public void executeScript(String file_name) throws FileNotFoundException {
        Scanner scan =new Scanner(new File(file_name));
        FileTerminal ft = new FileTerminal(file_name,scan,this);
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public void history() {
        for (String s: ct.getHistory()) {
            if(s!=null) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void addIfMin(String name_, Double height_, Color eyeColor_, Color hairColor_, Country nationality_, Float x_, Double y_, Float x1_, double y1_, String name1_) {
        coo=cm.create();
        coo.SetX(x_);
        coo.SetY(y_);

        loc=lm.create();
        loc.SetX(x1_);
        loc.SetY(y1_);
        loc.SetName(name1_);

        per=om.create();

        per.setEverything(name_, coo, height_, eyeColor_, hairColor_, nationality_, loc);

        if (ct.GetCollection().size() != 0) {
            ct.CollectionSort();
        }

        if((ct.GetCollection().size() == 0) || (compareCenter.compare(per, ct.GetCollection().getFirst()) < 0)){
            ct.GetCollection().add(per);
        }
    }

    @Override
    public void help() {
        System.out.println("Доступные команды: help, info, show, add, update, remove_by_id, clear, save, execute_script," +
                " exit, remove_head, add_if_min, history, remove_any_by_nationality, count_less_than_location, filter_starts_with_name");
        System.out.println("help: Вывести информацию по доступным командам");
        System.out.println("info: Вывести информацию о коллекции");
        System.out.println("show: Вывести все элементы коллекции");
        System.out.println("add: Добавить элемент в коллекцию. Синтаксис: add {name height}");
        System.out.println("update: Обновить данные элемента с заданным id коллекции. Синтаксис: update id {name height}");
        System.out.println("remove_by_id: Удалить элемент с заданным id из коллекции. Синтаксис: remove_by_id id");
        System.out.println("clear: Очистить коллекцию");
        System.out.println("save: Сохранить коллекцию в файл");
        System.out.println("execute_script: Выполнить скрипт, записанный в файл. Синтаксис: execute_script filename");
        System.out.println("exit: Завершить программу");
        System.out.println("remove_head: Удалить первый элемент коллекции");
        System.out.println("add_if_min: Добавлить элемент в коллекцию, если он меньше, чем все имеющиеся элементы коллекции. Синтаксис: add_if_min {name height}");
        System.out.println("history: Вывести последние 8 команд (если их было меньше 8, то выведет меньше 8)");
        System.out.println("remove_any_by_nationality: Удалить один элемент коллекции, с заданной национальностью. Синтаксис: remove_any_by_nationality nationality");
        System.out.println("count_less_than_location: Вывести количество элементов коллекции, значения поля location которых меньше заданного. Синтаксис: count_less_than_location location");
        System.out.println("filter_starts_with_name: Вывести элементы коллекции, имя которых начинается с заданной подстроки. Синтаксис: filter_starts_with_name string");
    }

    public void addCommandToHistory(String userCommand){
        for (int i=0; i<ct.getHistory().length; ++i){
            if(i!=ct.getHistory().length-1){
                ct.getHistory()[i] = ct.getHistory()[i+1];
            }else{
                ct.getHistory()[i] = userCommand;
            }
        }
    }
}
