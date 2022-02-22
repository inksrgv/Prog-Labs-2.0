package dao;



import utils.Route;
import utils.RouteInfo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.ConsoleOutputer.output;

public class RouteDAO implements DAO {

    public Deque<Route> collection = new ArrayDeque<>();
    public String initDate = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy : HH.mm.ss"));


    public void create(Route route) {
        collection.add(route);
    }

    public void update(int id, RouteInfo routeInfo) {
        for (Route route: collection){
            if (route.getId() == id){
                route.update(routeInfo);
            }
        }
    }

    public int delete(int id) {
        if(collection.removeIf(route -> route.getId() == id)){return 15;}
        return 20;
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
        Map<String, String> routes = new LinkedHashMap<>();
        for (Route route : collection){
            routes.put("тип:", collection.getClass().getSimpleName());

            routes.put("размер:", String.valueOf(collection.size()));

            routes.put("дата иницализации:", initDate);

            //routes.put("описание элементов: ", routeDAO.getCollection());

        }
        return routes;
    }

    public String printFirst(){
        return(collection.getFirst().toString());
    }

    public void removeFirst(){
        collection.remove(collection.getFirst());
    }
    public String getCollection() {
        return collection.toString();
    }

    @Override
    public String toString() {
        return  "RouteDAO{" +
                "collection=" + collection +
                '}' ;
    }
}
