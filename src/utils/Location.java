package utils;

public class Location {
    private double x;
    private Long y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле не может быть null

    public Location(double fromX, Long fromY, String name) {
        this.x = fromX;
        this.y = fromY;
        this.name = name;
    }

    public double getFromX(){return x;}

    public Long getFromY(){return y;}

}