package utils;

import java.time.ZonedDateTime;

/**
 * Класс, в которым хранится вся информация о коллекции
 */
public class Route {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private utils.loc.Location to; //Поле может быть null
    private Integer distance; //Поле не может быть null, Значение поля должно быть больше 1

    /**
     * Метод, который позволяет пользователю дать характеристику элементу коллекции
     * @param name
     * @param coordinatesX
     * @param coordinatesY
     * @param fromX
     * @param fromY
     * @param nameFrom
     * @param toX
     * @param toY
     * @param nameTo
     * @param distance
     */
    public Route(String name, double coordinatesX, Double coordinatesY, double fromX, Long fromY, String nameFrom, int toX, float toY, String nameTo, Integer distance ){
        this.id = IdGenerator.nextId();
        this.name = name;
        this.coordinates = new Coordinates(coordinatesX, coordinatesY);
        this.from = new Location(fromX, fromY, nameFrom);
        this.to = new utils.loc.Location(toX, toY, nameTo);
        this.distance = distance;

    }

    /**
     * Метод, который выводит информацию об элементе коллекции
     * @param information
     */
    public Route(RouteInfo information){
        id = IdGenerator.nextId();
        name = information.name;
        coordinates = new Coordinates(information.x, information.y);
        creationDate = ZonedDateTime.now();
        from = new Location(information.fromX, information.fromY, information.nameFrom);
        to = new utils.loc.Location(information.toX, information.toY, information.nameTo);
        distance = information.distance;
    }

    /**
     * Метод получения id пользователя
     * @return id
     */
    public int getId() { return id++; }

    /**
     * Метод для получения имени маршрута
     * @return name
     */
    public String getName() { return name; }

    /**
     * Метод для получения начальных координат маршрута
     * @return coordinates
     */
    public Coordinates getCoordinates() { return coordinates; }

    /**
     * Метод, который позволяет получить дату
     * @return creationDate
     */

    public ZonedDateTime getCreationDate() { return creationDate; }

    /**
     * Метод для получения координаты "отправления"
     * @return from
     */

    public Location getFrom(){return from;}

    /**
     * Метод для получения координаты "прибытия"
     * @return to
     */
    public utils.loc.Location getTo(){return to;}

    /**
     * Метод для получения длины маршрута
     * @return distance
     */
    public int getDistance(){return distance;}

    /**
     * Метод для задания имени маршрута
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Метод для задания координат маршрута
     * @param coordinates
     */

    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }

    /**
     * Метод дляя задания даты
     * @param creationDate
     */
    public void setCreationDate(ZonedDateTime creationDate) { this.creationDate = creationDate; }

    /**
     * Метод для задания точки отправления
     * @param from
     */
    public void setFrom(Location from){this.from = from;}

    /**
     * Метод для задания точки прибытия
     * @param to
     */
    public void setTo(utils.loc.Location to){this.to = to;}

    /**
     * Метод для задания длины получившегося маршрута
     * @param distance
     */
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

    /**
     * Метод, который позволяет получить информацию об элементе коллекции и обновить её при добавлении новых элементов.
     * @param routeInfo
     */
    public void update(RouteInfo routeInfo){
        name = routeInfo.name;
        coordinates = new Coordinates(routeInfo.x, routeInfo.y);
        from = new Location(routeInfo.fromX, routeInfo.fromY, routeInfo.nameFrom);
        to = new utils.loc.Location(routeInfo.toX, routeInfo.toY, routeInfo.nameTo);
        distance = routeInfo.distance;
    }


}
/**
 * Класс, предназначенный для генерации id пользователя
 * @param id
 */
class IdGenerator{
    public static int id = 0;
    public static int nextId(){
        return  id++;
    }

}
