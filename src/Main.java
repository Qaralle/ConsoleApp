import Test.Car;
import Test.Driver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args){
        Logger log = new Logger();
        Driver driver = new Driver("Valentin");
        Car car = new Car("VALERA",12, driver);
        String json= GSON.toJson(car);


        Car car1 = GSON.fromJson(json, Car.class);
        log.IntegerRecord(car1.getAge());
        log.SimpleRecord(car1.getName());

        log.SimpleRecord(GSON.toJson(car1));
    }
}
