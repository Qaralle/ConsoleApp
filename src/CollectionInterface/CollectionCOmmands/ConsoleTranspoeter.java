package CollectionInterface.CollectionCOmmands;

import ColClass.Color;
import ColClass.Country;

import javax.tools.DocumentationTool;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Tansporter, используемый при работе с консольным вводом
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class ConsoleTranspoeter extends Transporter {
    private Integer i=0;
    private Boolean FlagType=false;
    public void setFlagType(boolean b){
        FlagType=b;
    }

    /**
     * установка значений составных полей
     * @param res Receiver
     * @throws WrongTypeOfFieldException обработка некорректных типов полей
     */
    public void setFields(receiver res) throws WrongTypeOfFieldException {


        System.out.println("Введите параметры(имя персонажа и рост было указано при вызове команды)");

        scan = new Scanner(System.in);

        while (!FlagType) {
            System.out.println("Дальше введи Цвет волос. Возможные цвета: " + Arrays.toString(Color.values()));
            System.out.print("$");
            try {
                if (scan.hasNextLine()) {
                    hairColor = Color.valueOf(scan.nextLine().trim());
                    setFlagType(true);
                }
            }catch (Exception ex){
                System.err.println("Некорректное поле.");
            }
        }
        setFlagType(false);
        while (!FlagType) {
            System.out.println("Дальше введи Цвет глаз. Возможные цвета: " + Arrays.toString(Color.values()));
            System.out.print("$");
            try {
                if (scan.hasNextLine()) {
                    eyeColor = Color.valueOf(scan.nextLine().trim());
                    setFlagType(true);
                }
            }catch (Exception ex){
                System.err.println("Некорректное поле.");

            }
        }
        setFlagType(false);
        while (!FlagType) {
            try {
                System.out.println("Введи национальность : " + Arrays.toString(Country.values()));
                System.out.print("$");
                nationality = Country.valueOf(scan.nextLine());
                setFlagType(true);
            } catch (Exception ex) {
                System.err.println("Некорректное поле.");
            }
        }
        setFlagType(false);

        while (!FlagType) {
            try {
                    System.out.println("Введи кооридинаты X для точного описания объекта точки ");
                System.out.print("$");
                if (scan.hasNextFloat()) {
                        x = scan.nextFloat();
                        setFlagType(true);
                    }else {
                        catchN = scan.next();
                        System.err.println("Некорректное поле, try again");
                    }


            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }
        setFlagType(false);
        while (!FlagType) {
            try {
                System.out.println("Введи кооридинаты Y для точного описания объекта точки ");
                System.out.print("$");
                if (scan.hasNextDouble()) {
                    y = scan.nextDouble();
                    catchN=scan.nextLine();
                    setFlagType(true);
                }else {
                    catchN = scan.next();
                    System.err.println("Некорректное поле, try again");
                }
            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }

        System.out.println("Введи название локации");
        System.out.print("$");
        if(scan.hasNextLine()) {
                    name1 = scan.nextLine();
                    //catchN = scan.nextLine();
                }
        setFlagType(false);
        while (!FlagType) {
            try {
                System.out.println("Введи кооридинаты X для точного описания точки локации ");
                System.out.print("$");
                if (scan.hasNextFloat()) {
                    x1 = scan.nextFloat();
                    setFlagType(true);
                }else {
                    catchN = scan.next();
                    System.err.println("Некорректное поле, try again");
                }
            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }
        setFlagType(false);
        while (!FlagType) {
            try {
                System.out.println("Введи кооридинаты Y для точного описания точки локации ");
                System.out.print("$");
                if (scan.hasNextFloat()) {
                    y1 = scan.nextFloat();
                    setFlagType(true);
                }else {
                    catchN = scan.next();
                    System.err.println("Некорректное поле, try again");
                }
            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }
    }
}
