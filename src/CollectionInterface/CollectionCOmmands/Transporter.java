package CollectionInterface.CollectionCOmmands;

import ColClass.Color;
import ColClass.Country;
import ColClass.Location;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public abstract class Transporter implements SetterParams<Map<String,String>> {
    protected Scanner scan;

    protected long id;
    protected String name;
    protected Double height; //Поле не может быть null, Значение поля должно быть больше 0
    protected Color eyeColor; //Поле может быть null
    protected Color hairColor; //Поле не может быть null
    protected Country nationality; //Поле может быть null
    protected Float x; //Значение поля должно быть больше -652, Поле не может быть null
    protected Double y; //Поле не может быть null
    protected Float x1; //Поле не может быть null
    protected double y1;
    protected String name1; //Длина строки не должна быть больше 222, Поле не может быть null
    protected Location loc;
    protected String file_name;


    protected String[] buffer;
    protected String catchN;

    public abstract void setFields(receiver res) throws FileNotFoundException;

    @Override
    public void SetParams(Map<String, String> bar1) {

            this.name = bar1.getOrDefault("name","1213123");
            this.height=Double.parseDouble(bar1.getOrDefault("height","123.12"));
            this.id=Long.parseLong(bar1.getOrDefault("id","123123123"));
            this.name1=bar1.getOrDefault("nameL","123123321");
            this.nationality=Country.valueOf(bar1.getOrDefault("nationality","CHINA"));
            this.file_name=bar1.getOrDefault("file_name", "dd.txt");
    }




    public long getId() { return id; }
    public String getName() { return name; }
    public Color getEyeColor() { return eyeColor; }
    public Color getHairColor() { return hairColor; }
    public Country getNationality() { return nationality; }
    public Double getHeight() { return height; }
    public Double getY() { return y; }
    public double getY1() { return y1; }
    public Float getX() { return x; }
    public Float getX1() { return x1; }
    public String getName1() { return name1; }
    public Location getLoc(){ return loc;}
    public String getFile_name() { return file_name; }


}
