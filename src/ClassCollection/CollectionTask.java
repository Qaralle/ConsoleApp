package ClassCollection;

import ColClass.Person;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Класс, создающий коллекцию из Json.
 * @author Maxim Antonov and Andrey Lyubkin
 * @version 1231.1231.213546.1(alpha)
 */



public class CollectionTask {

    private PersonList collection;
    private Gson serializer;
    private FieldPolice fp;
    private NullPolice np;
    private String dateInit;
    private String[] history;

    {
        //nullPolice = new NullPolice();
        serializer = new Gson();
        collection = new PersonList();
        fp=new FieldPolice();
        np=new NullPolice();

        Calendar calendar = Calendar.getInstance();
        dateInit = calendar.get(Calendar.DAY_OF_MONTH) +".";
        dateInit += (calendar.get(Calendar.MONTH) + 1) +".";
        dateInit += Integer.toString(calendar.get(Calendar.YEAR));
        history = new String[8];
    }

    /**
     * Метод, осуществляющий загрузку коллекции из файла формата Json.
     * @param pathname имя файла
     * @throws FileNotFoundException Не найден файл
     * @throws JsonSyntaxException Ошибка в синтаксисе файла Json
     */
    public void load(String pathname) throws FileNotFoundException, JsonSyntaxException {
        Scanner scanner = new Scanner(new File(pathname));
        System.out.println("Collection loading");
        StringBuffer data = new StringBuffer();
        while (scanner.hasNext()) {
            data.append(scanner.nextLine()).append("\n");
        }
        Type collectionType = new TypeToken<PersonList>() {}.getType();
        try {
            PersonList addedPerson = serializer.fromJson(data.toString(), collectionType);


            for (Person s : addedPerson) {
                Objects.requireNonNull(s.getName());
                Objects.requireNonNull(s.getCoordinates());
                Objects.requireNonNull(s.getHeight());
                Objects.requireNonNull(s.getEyeColor());
                Objects.requireNonNull(s.getHairColor());
                Objects.requireNonNull(s.getNationality());
                Objects.requireNonNull(s.getLocation());
                if (!collection.contains(s)){
                    fp.ReplaceEverything(s, s.getLocation(), s.getCoordinates());
                    collection.add(s);
                }

            }
            System.out.println("Коллекций успешно загружена");
        } catch (JsonSyntaxException e ){
            System.out.println("Ошибка синтаксиса файл json!");
            System.exit(0);
        } catch (NullPointerException e){
            //System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            PersonList addedShorty = serializer.fromJson(data.toString(), collectionType);
            for (Person s : addedShorty) {
                np.ReplaceEverything(s, s.getLocation(), s.getCoordinates());
                fp.ReplaceEverything(s, s.getLocation(), s.getCoordinates());
                if (!collection.contains(s)) collection.add(s);


            }
            System.out.println("Коллекций успешно загружена");
        }

    }

    public PersonList GetCollection(){
        return collection;
    }

    /**
     * Метод, осуществляющий запись элемента в коллекцию
     * @param p1 Объект класса Person
     */
    public void add(Person p1){
        collection.add(p1);
    }

    /**
     * Метод, осуществляющий сортировку коллекции
     */
    public void CollectionSort(){
        Collections.sort(collection,new CompareCenter());
    }

    public String getDateInit(){ return dateInit;}

    public String[] getHistory(){return history;}
}

