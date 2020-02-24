package ClassCollection;

import ColClass.Coordinates;
import ColClass.Location;
import ColClass.Person;

public class FieldPolice {
    public static void FieldReplace(Person p){
        if (p.getName()==""){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            p.setName("noname"+ p.getId());
        }
        if (p.getHeight()<0){
            p.setHeight(123.0);
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
        }
    }
    public static void FieldLocationReplace(Location loc){
        if (loc.getName().length()>222){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            loc.SetName("Udomlya");
        }
    }
    public static void FieldCoordinatesReplace(Coordinates coo){
        if (coo.getX()<=-652){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            coo.SetX(0f);
        }
    }
}
