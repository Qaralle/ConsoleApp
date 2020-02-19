package CollectionInterface.CollectionCOmmands;


import ColClass.Color;
import ColClass.Country;

import java.util.Arrays;
import java.util.Scanner;

public class Add implements CommandALT<String>{
    private Scanner scan;

    private receiver res;
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
    public void execute() {
        System.out.println("Введите параметры(имя персонажа было указано при вызове команды)");
        System.out.println("Начнем! Что по росту ?");
        if (scan.hasNextDouble()) {
           height = scan.nextDouble();
           catchN=scan.nextLine(); //ЕСЛИ ЮЗАТЬ НЕКСТДАБЛ ТО ОН ОСТАВЛЯЕТ \N И СЛЕДУЮЩИЙ НЕКСТ ЛАЙН ПУСТОЙ
        }
        System.out.println("Дальше введи Цвет волос и глаз через пробел. Возможные цвета: "+ Arrays.toString(Color.values()));
        if (scan.hasNextLine()) {

            buffer = (scan.nextLine().trim().split(" ", 2));
        }
        System.out.println(buffer[0]);
        hairColor=Color.valueOf(buffer[0]);
        eyeColor=Color.valueOf(buffer[1]);
        System.out.println("Введи национальность : "+Arrays.toString(Country.values()));
        nationality=Country.valueOf(scan.nextLine());
        System.out.println(nationality);
        System.out.println("Введи кооридинаты1");
        x=scan.nextFloat();
        catchN=scan.nextLine();

    }

    @Override
    public void SetParam(String bar1) {
        this.name=bar1;
    }


}
