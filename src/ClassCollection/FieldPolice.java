package ClassCollection;

import ColClass.Coordinates;
import ColClass.Location;
import ColClass.Person;

/**
 * Класс, реализующий проверку полей на корректность
 * @author Maxim Antonov and Andrey Lyubkin
 */
public class FieldPolice implements Police<Person,Location,Coordinates>{

    /**
     * проверка полей объекта класса Person
     * @param p объект класса Person
     */
    public void PersonReplace(Person p){
        if (p.getName()==""){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            p.setName("noname"+ p.getId());
        }
        if (p.getHeight()<0){
            p.setHeight(123.0);
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
        }
    }

    /**
     * проверка полей объекта класса Location
     * @param loc объект класса Location
     */
    public void LocationReplace(Location loc){
        if (loc.getName().length()>222){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            loc.SetName("Udomlya");
        }
    }

    /**
     * проверка полей объекта класса Coordinates
     * @param coo объект класса Coordinates
     */
    public void CoordinatesReplace(Coordinates coo){
        if (coo.getX()<=-652){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            coo.SetX(0f);
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
