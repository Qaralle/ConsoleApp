package CollectionInterface.CollectionCOmmands;

import ColClass.Color;
import ColClass.Country;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTransporter extends Transporter {
    private String file_name;
    private String catchV;
    private Scanner scan;

    public  FileTransporter(Scanner scan_){

        this.scan=scan_;
    }
    public void setFields(receiver res) throws FileNotFoundException, Ea {

        if (scan.hasNextLine()) {

            buffer = (scan.nextLine().trim().split(" ", 2));
            hairColor=Color.valueOf(buffer[0]);
            eyeColor=Color.valueOf(buffer[1]);
        }
        nationality=Country.valueOf(scan.nextLine());

     try {

         x = scan.nextFloat();
         catchN = scan.nextLine();

         y = scan.nextDouble();
         catchN = scan.nextLine();

         name1 = scan.nextLine();

         x1 = scan.nextFloat();
         catchN = scan.nextLine();

         y1 = scan.nextDouble();
         if (scan.hasNextLine()) {
             catchN = scan.nextLine();
         }
     }catch (Exception e){
         throw new Ea();
     }


    }
}
