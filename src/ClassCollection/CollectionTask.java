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

    {
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
            LinkedList<Person> addedShorty = serializer.fromJson(data.toString(), collectionType);



            for (Person s : addedShorty) {
                Objects.requireNonNull(s.getName(), "bar must not be null");
                Objects.requireNonNull(s.getCoordinates(), "bar must not be null");
                Objects.requireNonNull(s.getHeight(), "bar must not be null");
                Objects.requireNonNull(s.getEyeColor(), "bar must not be null");
                Objects.requireNonNull(s.getHairColor(), "bar must not be null");
                Objects.requireNonNull(s.getNationality(), "bar must not be null");
                Objects.requireNonNull(s.getLocation(), "bar must not be null");
                if (!citizens.contains(s)) citizens.add(s);
            }
            System.out.println("Коллекций успешно загружена");
        } catch (JsonSyntaxException e){
            System.out.println("Ошибка блять синтаксиса нахуй !Сука учи теорию ");
        }

    }
    public void GetCollection(){
        Person[] carsArray = citizens.toArray(new Person[3]);
        System.out.println(carsArray[0].getId());
    }

    public void printer() {
        for (Person s : citizens) {
            System.out.println("Имя: "+s.getName()+" айди: "+s.getId()+" дата: "+s.getData()+" Цвет волос: "+s.getHairColor());
        }
    }

    public void CollectionSort(){
        Collections.sort(citizens,new CompareCenter());
    }
}

