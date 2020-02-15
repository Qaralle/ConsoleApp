import java.io.PrintStream;

public final class Logger {
    private final static PrintStream stream = System.out;

    public static void SimpleRecord(String text){
        stream.println(text);
    }
    public static void IntegerRecord(Integer o) {
        stream.println(o);
    }

    public static PrintStream GetStream() {
        return stream;
    }


    public String toString() {
        return this.getClass().getName() + "[stream=" + stream.toString() + "]";
    }
}