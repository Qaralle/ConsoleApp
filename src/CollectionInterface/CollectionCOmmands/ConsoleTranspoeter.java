package CollectionInterface.CollectionCOmmands;

import ColClass.Color;
import ColClass.Country;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleTranspoeter extends Transporter {
    public void setFields(receiver res) throws Ea{


        System.out.println("Введите параметры(имя персонажа и рост было указано при вызове команды)");

        scan = new Scanner(System.in);
        System.out.println("Дальше введи Цвет волос и глаз через пробел. Возможные цвета: " + Arrays.toString(Color.values()));
        if (scan.hasNextLine()) {
            buffer = (scan.nextLine().trim().split(" ", 2));
            hairColor = Color.valueOf(buffer[0]);
            eyeColor = Color.valueOf(buffer[1]);
        }
        try {


            System.out.println("Введи национальность : " + Arrays.toString(Country.values()));
            nationality = Country.valueOf(scan.nextLine());


            System.out.println("Введи кооридинаты X для точного описания объекта точки ");

            x = scan.nextFloat();
            catchN = scan.nextLine();


            System.out.println("Введи кооридинаты Y для точного описания объекта точки ");

            y = scan.nextDouble();
            catchN = scan.nextLine();


            System.out.println("Перейдем к Локации для ее создания нужно назовать ее :");

            name1 = scan.nextLine();


            System.out.println("Введи кооридинаты X для точного описания объекта Локации ");
            x1 = scan.nextFloat();
            catchN = scan.nextLine();


            System.out.println("Введи кооридинаты Y для точного описания объекта Локации ");

            y1 = scan.nextDouble();
            catchN = scan.nextLine();
        } catch (Exception e){

            throw new Ea();
        }

    }
}
