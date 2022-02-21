package dao;
import utils.Route;
import utils.RouteInfo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Класс, имплементируемый от главного интерфейса,в которым мы реализуем метод для работы с коллекцией. Так же в этом классе мы инициализируем коллекцию.
 */
public class RouteDAO implements DAO {

    protected Deque<Route> collection = new ArrayDeque<>();
    public String initDate = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    RouteInfo routeInfo = new RouteInfo();
    Route route = new Route(routeInfo);

    /**
     * Метод, который осуществляет добавление в коллекцию элементов.
     * @param route
     */
    public void create(Route route) {
        collection.add(route);
    }

    /**
     * Метод, который позволяет обновить элемент коллекции по его id
     * @param id - id элемента, который пользователь хочет обновить
     * @param route - характеристики, свойственные элементы коллекции
     */
   public void update(int id, RouteInfo routeInfo) {
        for (Route route: collection){
            if (route.getId() == id){
                route.update(routeInfo);
            }
        }
    }

    /**
     * Метод, позволяющий удалить элемнт из коллекции по его id
     * @param id - id элемента, который пользователь хочет удалить
     */
    public int delete(int id) {
        if(collection.removeIf(route -> route.getId() == id)){return 15;}
        return 20;
    }

    /**
     * Метод, который позволяет получить элемент из коллекции по его id
     * @param id - id элемента, который позьзователь хочет получить
     * @return route - элемент коллекции
     */
    public Route get(int id) {
        for (Route route : collection){
            if (route.getId() == id){
                return route;
            }
        }
        return null;
    }

    /**
     * Метод, который позволяет вывести все элементы коллекции
     * @return collection
     */

    public Deque<Route> getAll() {
        return new ArrayDeque<>(collection);
    }

    /**
     * Метод, который позволяет очистить коллекцию
     * @return 0
     */

    public int clear(){collection.clear(); return 0;}

    /**
     * Метод, который позволяет получить информацию о коллекции
     * @return routes
     */
    public Map<String, String> getDescription() {
        Map<String, String> routes = new LinkedHashMap<>();
        for (Route route : collection){
            routes.put("тип: ", collection.getClass().getSimpleName());

            routes.put("размер: ", String.valueOf(collection.size()));

            routes.put("дата иницализации: ", String.format(initDate, "dd.MM.yyy: HH.mm.ss"));

            //routes.put("описание элементов: ", route.toString());

        }
        return routes;
    }

    /**
     * Метод, который позволяет вывести первый элемент коллекции
     * @return route
     */
    public String printFirst(){
        return(collection.getFirst().toString());
    }

    /**
     * Метод, который позволяет удалить первый элемнт коллекции
     * @return collection
     */
    public void removeFirst(){
        collection.remove(collection.getFirst());
    }

    /**
     * Метод, который позволяет вывести всю коллекцию
     * @return collection
     */
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
