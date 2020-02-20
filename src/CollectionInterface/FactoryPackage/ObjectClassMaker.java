package CollectionInterface.FactoryPackage;

import ColClass.Person;

public class ObjectClassMaker implements ObjectMaker<Person> {
    @Override
    public Person create() {
        return new Person();
    }
}
