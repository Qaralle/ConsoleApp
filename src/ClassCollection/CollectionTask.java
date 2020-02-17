package ClassCollection;

import ColClass.Person;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class CollectionTask {
    private LinkedList<Person> citizens;
    private File jsonCollection;
    private Gson serializer;
    private NullPolice Police;

    {
        Police = new NullPolice();
        serializer = new Gson();
        citizens = new LinkedList<>();
    }

    public void load() throws FileNotFoundException, JsonSyntaxException {
        Scanner scanner = new Scanner(new File("src/PersonClassTest.json"));
        System.out.println("Идёт загрузка коллекции");
        StringBuffer data = new StringBuffer();
        while (scanner.hasNext()) {
            data.append(scanner.nextLine()).append("\n");
        }
        Type collectionType = new TypeToken<LinkedList<Person> >() {}.getType();
        try {
            LinkedList<Person> addedPerson = serializer.fromJson(data.toString(), collectionType);


            for (Person s : addedPerson) {
                Objects.requireNonNull(s.getName());
                Objects.requireNonNull(s.getCoordinates());
                Objects.requireNonNull(s.getHeight());
                Objects.requireNonNull(s.getEyeColor());
                Objects.requireNonNull(s.getHairColor());
                Objects.requireNonNull(s.getNationality());
                Objects.requireNonNull(s.getLocation());
                if (!citizens.contains(s)) citizens.add(s);

            }
            System.out.println("Коллекций успешно загружена");
        } catch (JsonSyntaxException e ){
            System.out.println("Ошибка блять синтаксиса нахуй !Сука учи теорию! Код писал макс");
        } catch (NullPointerException e){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            LinkedList<Person> addedShorty = serializer.fromJson(data.toString(), collectionType);
            for (Person s : addedShorty) {
                Police.NullReplace(s);
                if (!citizens.contains(s)) citizens.add(s);


            }
            System.out.println("Коллекций успешно загружена");
        }

    }
    public void GetCollection(){
        Person[] carsArray = citizens.toArray(new Person[3]);
        System.out.println(carsArray[0].getId());
    }

    public void printer() {
        for (Person s : citizens) {
            System.out.println("Имя: "+s.getName()+" айди: "+s.getId()+" дата: "+s.getData()+" Цвет волос: "+s.getHairColor()+" локация ; "+s.location.getClass());
        }
    }

    public void CollectionSort(){
        Collections.sort(citizens,new CompareCenter());
    }
}

