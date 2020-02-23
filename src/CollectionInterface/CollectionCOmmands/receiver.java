package CollectionInterface.CollectionCOmmands;

import ColClass.Color;
import ColClass.Country;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface receiver {
    void Add(String name_, Double height_, Color eyeColor_, Color hairColor_, Country nationality_,Float x_,Double y_,Float x1_,double y1_,String name1_);
    void show();
    void info();
    void update(long id, String name_, Double height_, Color eyeColor_, Color hairColor_, Country nationality_,Float x_,Double y_,Float x1_,double y1_,String name1_);
    void clear();
    void remove_by_id(long id);
    void removeHead();
    void removeAnyByNationality(Country nationality); //разработчики осуждают нацизм в любых его проявлениях
    void countLessThanLocation(String namel);
    void filterStartsWithName(String name);
    void save() throws IOException;
    void executeScript(String file_name) throws FileNotFoundException;
}
