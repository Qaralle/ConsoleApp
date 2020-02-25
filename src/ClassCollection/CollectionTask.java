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
 * @author Maxim Antonov and Adrey Lubkin
 * @version 1231.1231.213546.1(alpha)
 */



public class CollectionTask {
    private List<Person> collection;
    private File jsonCollection;
    private Gson serializer;
    private FieldPolice fp;
    private NullPolice np;
    //private NullPolice nullPolice;
    //private FieldPolice fieldPolice;
    private String dateInit;
    private String[] history;

    {
        //nullPolice = new NullPolice();
        serializer = new Gson();
        collection = new LinkedList<>();
        fp=new FieldPolice();
        np=new NullPolice();

        Calendar calendar = Calendar.getInstance();
        dateInit = calendar.get(Calendar.DAY_OF_MONTH) +".";
        dateInit += (calendar.get(Calendar.MONTH) + 1) +".";
        dateInit += Integer.toString(calendar.get(Calendar.YEAR));
        history = new String[8];
    }

    public void load(String pathname) throws FileNotFoundException, JsonSyntaxException {
        Scanner scanner = new Scanner(new File(pathname));
        System.out.println("Collection loading");
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
                if (!collection.contains(s)){
                    fp.PersonReplace(s);
                    fp.LocationReplace(s.getLocation());
                    fp.CoordinatesReplace(s.getCoordinates());
                    collection.add(s);
                }

            }
            System.out.println("Коллекций успешно загружена");
        } catch (JsonSyntaxException e ){
            System.out.println("Ошибка синтаксиса файл json!");
        } catch (NullPointerException e){
            //System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            LinkedList<Person> addedShorty = serializer.fromJson(data.toString(), collectionType);
            for (Person s : addedShorty) {
                np.PersonReplace(s);
                np.LocationReplace(s.getLocation());
                np.CoordinatesReplace(s.getCoordinates());
                fp.PersonReplace(s);
                fp.LocationReplace(s.getLocation());
                fp.CoordinatesReplace(s.getCoordinates());
                if (!collection.contains(s)) collection.add(s);


            }
            System.out.println("Коллекций успешно загружена");
        }

    }
    public List<Person> GetCollection(){
        //Person[] carsArray = citizens.toArray(new Person[3]);
        //System.out.println(carsArray[0].getId());
        return collection;
    }

    public void add(Person p1){
        collection.add(p1);
    }

    public void CollectionSort(){
        Collections.sort(collection,new CompareCenter());
    }

    public String getDateInit(){ return dateInit;}

    public String[] getHistory(){return history;}
}

