package ClassCollection;
import ColClass.*;

public class NullPolice {
    public static void NullReplace(Person p){
        if (p.getName()==null) p.setName("noname"+ p.getId());
        if (p.getCoordinates()==null) p.setCoordinates(new Coordinates(0f, 0d));
        if (p.getHeight()==null) p.setHeight(123.0);
        if (p.getHairColor()==null) p.setHairColor(Color.GREEN);
        if (p.getEyeColor()==null) p.setEyeColor(Color.GREEN);
        if (p.getNationality()==null) p.setNationality(Country.CHINA);
        if (p.getLocation()==null) p.setLocation(new Location(0f, 0d, "Udomlya"));
    }
    public static void NullLocationReplace(Location loc){
        if (loc.getName()==null) loc.SetName("Udomlya");
        if (loc.getX()==null) loc.SetX(0f);
        if (Double.valueOf(loc.getY())==null) loc.SetY(0d);
    }
    public static void NullCoordinatesReplace(Coordinates coo){
        if (coo.getX()==null) coo.SetX(0f);
        if (coo.getY()==null) coo.SetY(0d);
    }
}
