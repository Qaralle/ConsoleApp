package ColClass;

import java.time.LocalDateTime;

public class Person{
    private static final long LIMIT = 10000000000L;
    private static long last = 0;


    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double height; //Поле не может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    private static long getID() {

        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }

    public Person()  {

        this.id = getID();
        this.creationDate = LocalDateTime.now();


    }
    public LocalDateTime getData(){
        return creationDate;
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public Double getHeight(){
        return height;
    }
    public Color getEyeColor(){
        return eyeColor;
    }
    public Color getHairColor(){
        return hairColor;
    }
    public Country getNationality(){
        return nationality;
    }
    public  Location getLocation(){
        return location;
    }

}