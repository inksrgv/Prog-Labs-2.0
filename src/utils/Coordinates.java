package utils;

public class Coordinates {
    private double x;
    private Double y; //Значение поля должно быть больше -210, Поле не может быть null

    public Coordinates(double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public double getCoorX() {return x;};

    public Double getCoorY(){return y;}

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}