package utils;

public class Coordinates implements Validateable {
    private double x;
    private double y; //Значение поля должно быть больше -210, Поле не может быть null
    public Coordinates(double x, Double y){
        this.x = x;
        this.y = y;
    }
    /**
     * @return x coordinates
     */
    public double getX() {
        return x;
    }

    /**
     * @return y coordinates
     */
    public Double getY() {
        return y;
    }
    @Override
    public String toString(){
        String s = "";
        s += "{\"x\" : " + Double.toString(x) + ", ";
        s += "\"y\" : " + Double.toString(y) + "}";
        return s;
    }
    public boolean validate(){
        return !(Double.isNaN(y) || y.longValue()<=-210 || Double.isInfinite(x) || Double.isNaN(x)); //????????
    }
}
