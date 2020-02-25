package ClassCollection;
import ColClass.*;

public class NullPolice implements Police<Person,Location,Coordinates> {
    @Override
    public void PersonReplace(Person p){
        if (p.getName()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            p.setName("noname"+ p.getId());
        }
        if (p.getCoordinates()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            p.setCoordinates(new Coordinates(0f, 0d));
        }
        if (p.getHeight()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            p.setHeight(123.0);
        }
        if (p.getHairColor()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            p.setHairColor(Color.GREEN);
        }
        if (p.getEyeColor()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            p.setEyeColor(Color.GREEN);
        }
        if (p.getNationality()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            p.setNationality(Country.CHINA);
        }
        if (p.getLocation()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            p.setLocation(new Location(0f, 0d, "Udomlya"));
        }
    }
    @Override
    public void LocationReplace(Location loc){
        if (loc.getName()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            loc.SetName("Udomlya");
        }
        if (loc.getX()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            loc.SetX(0f);
        }
        if (Double.valueOf(loc.getY())==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            loc.SetY(0d);
        }
    }


    @Override
    public void CoordinatesReplace(Coordinates coo){
        if (coo.getX()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            coo.SetX(0f);
        }
        if (coo.getY()==null){
            System.out.println("У одного из объектов null поле будет перезаписано автоматически");
            coo.SetY(0d);
        }
    }
}
