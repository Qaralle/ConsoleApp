package CollectionInterface.CollectionCOmmands;

import ColClass.Color;
import ColClass.Country;
import ColClass.Location;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Transporter implements SetterParams<Map<String,String>> {
    private Scanner scan;

    private long id;
    private String name;
    private Double height; //Поле не может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Float x; //Значение поля должно быть больше -652, Поле не может быть null
    private Double y; //Поле не может быть null
    private Float x1; //Поле не может быть null
    private double y1;
    private String name1; //Длина строки не должна быть больше 222, Поле не может быть null
    private Location loc;


    private String[] buffer;
    private String catchN;

    public void setFields(receiver res){
        System.out.println("Введите параметры(имя персонажа и рост было указано при вызове команды)");

        scan=new Scanner(System.in);
        System.out.println("Дальше введи Цвет волос и глаз через пробел. Возможные цвета: "+ Arrays.toString(Color.values()));
        if (scan.hasNextLine()) {
            buffer = (scan.nextLine().trim().split(" ", 2));
            hairColor=Color.valueOf(buffer[0]);
            eyeColor=Color.valueOf(buffer[1]);
        }

        System.out.println("Введи национальность : "+Arrays.toString(Country.values()));
        nationality=Country.valueOf(scan.nextLine());


        System.out.println("Введи кооридинаты X для точного описания объекта точки ");
        if (scan.hasNextFloat()) {
            x=scan.nextFloat();
            catchN = scan.nextLine();
        }

        System.out.println("Введи кооридинаты Y для точного описания объекта точки ");
        if (scan.hasNextDouble()) {
            y=scan.nextDouble();
            catchN = scan.nextLine();
        }

        System.out.println("Перейдем к Локации для ее создания нужно назовать ее :");
        if (scan.hasNextLine()){
            name1=scan.nextLine();
        }

        System.out.println("Введи кооридинаты X для точного описания объекта Локации ");
        if (scan.hasNextFloat()) {
            x1=scan.nextFloat();
            catchN = scan.nextLine();
        }

        System.out.println("Введи кооридинаты Y для точного описания объекта Локации ");
        if (scan.hasNextDouble()) {
            y1=scan.nextDouble();
            catchN = scan.nextLine();
        }

    }
    @Override
    public void SetParams(Map<String, String> bar1) {

            this.name = bar1.getOrDefault("name","1213123");
            this.height=Double.parseDouble(bar1.getOrDefault("height","123.12"));
            this.id=Long.parseLong(bar1.getOrDefault("id","123123123"));
            this.name1=bar1.getOrDefault("nameL","123123321");
            this.nationality=Country.valueOf(bar1.getOrDefault("nationality","CHINA"));

    }




    public long getId() { return id; }
    public String getName() { return name; }
    public Color getEyeColor() { return eyeColor; }
    public Color getHairColor() { return hairColor; }
    public Country getNationality() { return nationality; }
    public Double getHeight() { return height; }
    public Double getY() { return y; }
    public double getY1() { return y1; }
    public Float getX() { return x; }
    public Float getX1() { return x1; }
    public String getName1() { return name1; }
    public Location getLoc(){ return loc;}


}
