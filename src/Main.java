import Test.Car;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final String FILE_PATH = "src/testclass.json";

    public static void main(String[] args) throws FileNotFoundException {

        try {
            Scanner scanner = new Scanner(new File("src/testclass.json"));
            StringBuffer data = new StringBuffer();
            while (scanner.hasNext())
                data.append(scanner.nextLine()).append("\n");
            String json=data.toString();

            Logger log=new Logger();
            Car car1 = GSON.fromJson(json, Car.class);

            log.IntegerRecord(car1.getAge());
            log.SimpleRecord(car1.getName());
            log.SimpleRecord(car1.man.getName());

        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
