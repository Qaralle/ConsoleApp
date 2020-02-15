package Test;

public class Car {
    private String name;
    private Integer age;
    public Driver man;
    public Car(String name_, Integer age_,Driver d){
        this.age=age_;
        this.name=name_;
        this.man=d;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

}
