package utils;

import java.time.ZonedDateTime;


public class Route {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private utils.loc.Location to; //Поле может быть null
    private Integer distance; //Поле не может быть null, Значение поля должно быть больше 1

    public Route(String name, double coordinatesX, Double coordinatesY, double fromX, Long fromY, String nameFrom, int toX, float toY, String nameTo, Integer distance ){
        this.id = IdGenerator.nextId();
        this.name = name;
        this.coordinates = new Coordinates(coordinatesX, coordinatesY);
        this.from = new Location(fromX, fromY, nameFrom);
        this.to = new utils.loc.Location(toX, toY, nameTo);
        this.distance = distance;

    }

    public Route(RouteInfo information){
        id = IdGenerator.nextId();
        name = information.name;
        coordinates = new Coordinates(information.x, information.y);
        creationDate = ZonedDateTime.now();
        from = new Location(information.fromX, information.fromY, information.nameFrom);
        to = new utils.loc.Location(information.toX, information.toY, information.nameTo);
        distance = information.distance;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public Coordinates getCoordinates() { return coordinates; }

    public ZonedDateTime getCreationDate() { return creationDate; }

    public Location getFrom(){return from;}

    public utils.loc.Location getTo(){return to;}

    public int getDistance(){return distance;}

    public void setName(String name) { this.name = name; }

    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }

    public void setCreationDate(ZonedDateTime creationDate) { this.creationDate = creationDate; }

    public void setFrom(Location from){this.from = from;}

    public void setTo(utils.loc.Location to){this.to = to;}

    public void setDistance(int distance){this.distance = distance;}


    @Override
    public String toString(){
        return "Route" + System.lineSeparator() +
                "id: " + id + System.lineSeparator() +
                "name: " + name + System.lineSeparator() +
                "coordinates: " + coordinates.toString() + System.lineSeparator() +
                "location (from): " + from.toString() + System.lineSeparator() +
                "location (to): " + to.toString() + System.lineSeparator() +
                "distance: " + distance.toString() ;
    }

    public void update(RouteInfo routeInfo){
        name = routeInfo.name;
        coordinates = new Coordinates(routeInfo.x, routeInfo.y);
        from = new Location(routeInfo.fromX, routeInfo.fromY, routeInfo.nameFrom);
        to = new utils.loc.Location(routeInfo.toX, routeInfo.toY, routeInfo.nameTo);
        distance = routeInfo.distance;
    }

}

class IdGenerator{
    public static int id = 1;
    public static int nextId(){
        return  id++;
    }
}
