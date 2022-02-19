package dao;



import utils.Route;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RouteDAO implements DAO {
    protected Deque<Route> collection = new ArrayDeque<Route>();
    public String initDate = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    public void create(Route route) {
        collection.add(route);
    }

    public void update(int id, Route route) {
        for (Route route1: collection){
            if (route1.getId() == id){
                route1.setName(route.getName());
                route1.setCoordinates(route.getCoordinates());
                route1.setCreationDate(route.getCreationDate());
                route1.setFrom(route.getFrom());
                route1.setTo(route.getTo());
            }
        }
    }

    public void delete(int id) {
        collection.remove(id);
    }

    public Route get(int id) {
        for (Route route : collection){
            if (route.getId() == id){
                return route;
            }
        }
        return null;
    }

    public Deque<Route> getAll() {
        return new ArrayDeque<>(collection);
    }

    public int clear(){collection.clear(); return 0;}

    public Map<String, String> getDescription() {
        Map<String, String> routes = new LinkedHashMap<String, String>();

        for (Route route : collection){
            routes.put("тип: ", collection.getClass().getSimpleName());
            routes.put("размер: ", String.valueOf(collection.size()));
            routes.put("дата иницализации: ", String.format(initDate, "dd.MM.yyy"));
            // я не знаю что еще добавить туда.
        }
        return routes;
    }

    public String printFirst(){
        return(collection.getFirst().toString());
    }


}
