import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonGenerator {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public String JsonClass(Object o1){
        String json = GSON.toJson(o1);
        return json;
    }
}
