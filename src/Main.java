import ClassCollection.CollectionTask;
import ColClass.*;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        Coordinates coordinates = new Coordinates(35.45F,78.56);
        Location location = new Location(22.5F,65.3,"Uhan'");
        Person person = new Person("Andrew",coordinates,174.5, Color.GREEN,Color.GREEN, Country.CHINA,location);

        JsonGenerator jg = new JsonGenerator();
        System.out.println(jg.JsonClass(person));



        CollectionTask ll = new CollectionTask();
        ll.load();
        ll.GetCollection();
    }
}
