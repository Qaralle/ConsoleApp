package ClassCollection;
import ColClass.Person;
public class NullPolice {
    public void NullReplace(Person p){
        if (p.getName()==null) p.setName("noname"+ p.getId());

    }



}
