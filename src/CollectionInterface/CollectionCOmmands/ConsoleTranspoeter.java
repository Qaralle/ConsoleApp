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

    /**
     * установка значений составных полей
     * @param res Receiver
     * @throws WrongTypeOfFieldException обработка некорректных типов полей
     */
    public void setFields(receiver res) throws WrongTypeOfFieldException {

        scan = new Scanner(System.in);

        System.out.println("Введите параметры. Сначала имя:");
        System.out.print("$");
        if(scan.hasNextLine()) {
            name = scan.nextLine();
            //catchN = scan.nextLine();
        }

        while (true) {
            try {
                System.out.println("Введите рост.");
                System.out.print("$");
                if (scan.hasNextDouble()) {
                    height = scan.nextDouble();
                    catchN=scan.nextLine();
                    break;
                }else {
                    catchN = scan.next();
                    System.err.println("Некорректное поле, try again");
                }
            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }

        while (true) {
            System.out.println("Введите Цвет волос. Возможные цвета: " + Arrays.toString(Color.values()));
            System.out.print("$");
            try {
                if (scan.hasNextLine()) {
                    hairColor = Color.valueOf(scan.nextLine().trim());
                    break;
                }
            }catch (Exception ex){
                System.err.println("Некорректное поле.");
            }
        }
        while (true) {
            System.out.println("Введите Цвет глаз. Возможные цвета: " + Arrays.toString(Color.values()));
            System.out.print("$");
            try {
                if (scan.hasNextLine()) {
                    eyeColor = Color.valueOf(scan.nextLine().trim());
                    break;
                }
            }catch (Exception ex){
                System.err.println("Некорректное поле.");

            }
        }
        while (true) {
            try {
                System.out.println("Введите национальность : " + Arrays.toString(Country.values()));
                System.out.print("$");
                nationality = Country.valueOf(scan.nextLine());
                break;
            } catch (Exception ex) {
                System.err.println("Некорректное поле.");
            }
        }
        while (true) {
            try {
                    System.out.println("Введите кооридинаты X для точного описания объекта точки ");
                System.out.print("$");
                if (scan.hasNextFloat()) {
                        x = scan.nextFloat();
                        break;
                    }else {
                        catchN = scan.next();
                        System.err.println("Некорректное поле, try again");
                    }


            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }
        while (true) {
            try {
                System.out.println("Введите кооридинаты Y для точного описания объекта точки ");
                System.out.print("$");
                if (scan.hasNextDouble()) {
                    y = scan.nextDouble();
                    catchN=scan.nextLine();
                    break;
                }else {
                    catchN = scan.next();
                    System.err.println("Некорректное поле, try again");
                }
            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }

        System.out.println("Введите название локации");
        System.out.print("$");
        if(scan.hasNextLine()) {
                    name1 = scan.nextLine();
                    //catchN = scan.nextLine();
                }
        while (true) {
            try {
                System.out.println("Введите кооридинаты X для точного описания точки локации ");
                System.out.print("$");
                if (scan.hasNextFloat()) {
                    x1 = scan.nextFloat();
                    break;
                }else {
                    catchN = scan.next();
                    System.err.println("Некорректное поле, try again");
                }
            } catch (Exception ex) {
                System.err.println("Некорректное поле, try again");
            }
        }
        while (true) {
            try {
                System.out.println("Введите кооридинаты Y для точного описания точки локации ");
                System.out.print("$");
                if (scan.hasNextFloat()) {
                    y1 = scan.nextFloat();
                    break;
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
