package ClassCollection;

import Test.Car;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Scanner;

public class CollectionTask {
    private LinkedList<Car> citizens;
    private File jsonCollection;
    private Gson serializer;

    {
        serializer = new Gson();
        citizens = new LinkedList<>();
    }

    public void load() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/testclass.json"));
        System.out.println("Идёт загрузка коллекции");
        StringBuffer data = new StringBuffer();
        while (scanner.hasNext()) {
            data.append(scanner.nextLine()).append("\n");
        }
        Type collectionType = new TypeToken<LinkedList<Car> >() {}.getType();
        LinkedList<Car> addedShorty = serializer.fromJson(data.toString(), collectionType);
        for (Car s: addedShorty) {
            if (!citizens.contains(s)) citizens.add(s);
        }
        System.out.println("Коллекций успешно загружена");
    }
    public void GetCollection(){
        Car[] carsArray = citizens.toArray(new Car[3]);
        System.out.println(carsArray[0].man.getName());
    }
}

