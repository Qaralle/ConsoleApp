package CollectionInterface.FactoryPackage;
public abstract class ObjectsCreater {
    private void addElements(){
        PersonsBars bar = createObject();
    }
    public abstract PersonsBars createObject();


}
