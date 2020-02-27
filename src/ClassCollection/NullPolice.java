package ClassCollection;
import ColClass.*;

/**
 * Класс, реализующий проверку полей на заполненность
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class NullPolice implements Police<Person,Location,Coordinates> {
    /**
     * проверка полей объекта класса Person
     * @param p объект класса Person
     */
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
    /**
     * проверка полей объекта класса Location
     * @param loc объект класса Location
     */
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

    /**
     * проверка полей объекта класса Coordinates
     * @param coo объект класса Coordinates
     */
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
    /**
     * проверка всех полей
     * @param p объект класса Person
     * @param loc объект класса Location
     * @param coo объект класса Coordinates
     */
    public void ReplaceEverything(Person p, Location loc, Coordinates coo){
        this.PersonReplace(p);
        this.LocationReplace(loc);
        this.CoordinatesReplace(coo);
    }
}
