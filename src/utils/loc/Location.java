package utils.loc;

public class Location {
    private int x;
    private float y;
    private String name; //Поле может быть null

    public Location(int toX, float toY, String name) {
        this.x = toX;
        this.y = toY;
        this.name = name; //зачем написала не знаю
    }

    public int getToX(){return x;}

    public float getToY() {return  y;}

    @Override
    public String toString() {
        return
                "x=" + x +
                ", y=" + y +
                ", name='" + name;
    }
}