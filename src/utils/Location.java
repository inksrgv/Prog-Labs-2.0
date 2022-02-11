package utils;

public class Location implements Validateable{
        private double x;
        private long y; //Поле не может быть null
        private String name; //Строка не может быть пустой, Поле не может быть null
    public Location(double x, Long y){
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
    public Long getY() {
        return y;
    }
    @Override
    public String toString(){
        String s = "";
        s += "{\"x\" : " + Double.toString(x) + ", ";
        s += "\"y\" : " + Long.toString(y) + "}";
        return s;
    }
    public boolean validate(){
        return !(Double.isNaN(y)); //Прописать условие с ненулевой строкой
    }
}

