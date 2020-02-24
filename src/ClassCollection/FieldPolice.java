package ClassCollection;

import ColClass.Coordinates;
import ColClass.Location;
import ColClass.Person;

public class FieldPolice {
    public static void FieldReplace(Person p){
        if (p.getName()=="") p.setName("noname"+ p.getId());
        if (p.getHeight()<0) p.setHeight(123.0);
    }
    public static void FieldLocationReplace(Location loc){
        if (loc.getName().length()>222) loc.SetName("Udomlya");
    }
    public static void FieldCoordinatesReplace(Coordinates coo){
        if (coo.getX()<=-652) coo.SetX(0f);
    }
}
