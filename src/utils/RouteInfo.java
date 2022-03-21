package utils;


import java.util.List;

public class RouteInfo {
    int id;
    String name;
    double x;
    Double y;
    String creationDate;
    double fromX;
    Long fromY;
    String nameFrom;
    int toX;
    float toY;
    String nameTo;
    Integer distance;

    public RouteInfo(List<String> data) {
        id = Integer.parseInt(data.get(0));
        name = data.get(1);
        x = Double.parseDouble(data.get(2));
        y = Double.parseDouble(data.get(3));
        creationDate = data.get(4);
        fromX = Double.parseDouble(data.get(5));
        fromY = Long.parseLong(data.get(6));
        nameFrom = data.get(7);
        toX = Integer.parseInt(data.get(8));
        toY = Float.parseFloat(data.get(9));
        nameTo = data.get(10);
        distance = Integer.parseInt(data.get(11));
    }

    public RouteInfo() {}
}
