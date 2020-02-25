package ClassCollection;

import ColClass.Coordinates;
import ColClass.Location;
import ColClass.Person;

public class FieldPolice implements Police<Person,Location,Coordinates>{
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
    public void LocationReplace(Location loc){
        if (loc.getName().length()>222){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            loc.SetName("Udomlya");
        }
    }
    public void CoordinatesReplace(Coordinates coo){
        if (coo.getX()<=-652){
            System.out.println("У одного из объектов некорректное поле будет перезаписано автоматически");
            coo.SetX(0f);
        }
    }
}
