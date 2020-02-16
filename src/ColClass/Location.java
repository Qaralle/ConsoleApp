package ColClass;

public class Location implements Comparable<Location>{
    private Float x; //Поле не может быть null
    private double y;
    private String name; //Длина строки не должна быть больше 222, Поле не может быть null

    public Location(Float x_,double y_,String name_){
        this.x=x_;
        this.y=y_;
        this.name=name_;
    }
    public String getName(){
        return name;
    }
    @Override
    public int compareTo(Location o) {
        return name.compareTo(o.getName());

    }
}