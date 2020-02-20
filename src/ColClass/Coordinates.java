package ColClass;

public class Coordinates implements Comparable<Coordinates> {
    private Float x; //Значение поля должно быть больше -652, Поле не может быть null
    private Double y; //Поле не может быть null

    public Coordinates(){

    }
    public Coordinates(Float _x,Double _y){
        this.x=_x;
        this.y=_y;
    }

    public Float getX(){
        return x;
    }

    public Double getY(){
        return y;
    }

    @Override
    public int compareTo(Coordinates o) {
        int compRes=0;
        if (x-o.getX()>0){
            compRes=compRes+1;
        }
        else if (x-o.getX()<0){
            compRes=compRes-1;
        }
        if (y-o.getY()>0){
            compRes=compRes+1;
        }
        else if (y-o.getY()<0){
            compRes=compRes-1;
        }
        return compRes;
    }

    public void SetX(Float x_){
        this.x=x_;
    }

    public void SetY(Double y_){
        this.y=y_;
    }
}