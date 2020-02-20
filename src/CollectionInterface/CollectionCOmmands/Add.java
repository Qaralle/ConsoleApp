package CollectionInterface.CollectionCOmmands;


import ColClass.Color;
import ColClass.Country;

import java.util.Arrays;
import java.util.Scanner;

public class Add implements CommandALT<Object>{
    private Scanner scan;


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


    private String[] buffer;
    private String catchN;

    {
        scan=new Scanner(System.in);

    }

    @Override
    public void execute(receiver res) {
        System.out.println("Введите параметры(имя персонажа и рост было указано при вызове команды)");
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

        System.out.println("Введи кооридинаты Y для точного описания объекта Локаци ");
        if (scan.hasNextDouble()) {
            y1=scan.nextDouble();
            catchN = scan.nextLine();
        }

        res.Add(name,height,eyeColor,hairColor,nationality,x,y,x1,y1,name1);

    }

    @Override
    public void SetParams(Object[] bar1) {
        if (bar1[0] instanceof String) {
            this.name = String.valueOf(bar1[0]);
            this.height = Double.parseDouble((String) bar1[1]);
        }else {
            this.name = String.valueOf(bar1[1]);
            this.height = Double.parseDouble(String.valueOf(bar1[0]));
        }
    }


}
