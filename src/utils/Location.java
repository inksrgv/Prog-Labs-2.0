//МИЛЛИОН ОШИБОК СУКА
//КТО ПРИДУМАЛ ЭТУ ЛАБЫ, КОНЧЕННЫЙ ЕБАЧ
package utils;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.*;

public class Route implements Collectionable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private Location to; //Поле может быть null
    private Integer distance; //Поле не может быть null, Значение поля должно быть больше 1

    /**
     * @param name
     * @param coordinates
     * @param from
     * @param to
     * @param distance
     */
    public Route(String name, Coordinates coordinates, Location from, utils.Location to, Integer distance){
        creationDate= ZonedDateTime.now();
        this.name=name;
        this.coordinates=coordinates;
        this.from=from;
        this.to = to;
        this.distance=distance;
    }

    /**
     * @return int
     */
    public int getId(){
        return id;
    }

    /**
     * sets ID, useful for replacing elements in collection
     * @param ID
     */
    public void setId(int ID){
        id=ID;
    }

    /**
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * @return String
     */
    /*@Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strCreationDate = dateFormat.format(creationDate);
        String strEndDate = "";
        String s = "";
        s += "{\n";
        s += "  \"id\" : " + Integer.toString(id) + ",\n";
        s += "  \"name\" : " + "\"" + name + "\"" + ",\n";
        s += "  \"coordinates\" : " + coordinates.toString() + ",\n";
        s += "  \"creationDate\" : " + "\"" + strCreationDate + "\"" + ",\n";
        if (endDate!=null) s += "  \"endDate\" : " +  "\"" + strEndDate + "\"" + ",\n";
        if (position!=null) s += "  \"position\" : " + "\"" + position.toString() + "\"" + ",\n";
        s += "  \"status\" : " + "\"" + status.toString() + "\"" + ",\n";
        s += "  \"organization\" : " + organization.toString() + "\n";
        s += "}";
        return s;
    }*/
