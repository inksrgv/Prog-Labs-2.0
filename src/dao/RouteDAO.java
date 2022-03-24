package dao;



import utils.Route;
import utils.RouteInfo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static console.ConsoleOutputer.output;

public class RouteDAO implements DAO {

    private final Deque<Route> collection = new ArrayDeque<>();

    public String initDate = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy : HH.mm.ss"));


    public void create(Route route) {
        collection.add(route);
    }
    /**
     * Метод, который позволяет обновить элемент коллекции по его id
     * @param id - id элемента, который пользователь хочет обновить
     * @param routeInfo - характеристики, свойственные элементы коллекции
     */
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

   public void clear(){
       collection.clear();
   }

   public String getDescription() {

       String out = initDate + System.lineSeparator() ;
       for (Route route: collection)
           out += route.getDescription() + System.lineSeparator();

       return out;
   }

   public String printFirst(){
       return(collection.getFirst().toString());
   }

   /**
    * Метод, который позволяет удалить первый элемнт коллекции
    *
    */
   public void removeFirst(){
       collection.remove(collection.getFirst());
   }

   /**
    * Метод, который позволяет вывести всю коллекцию
    * @return collection
    */
   public String getCollection() {
       String out = " ";
       for (Route route: collection)
           out += route.toString() + System.lineSeparator() ;
       return(out);
   }

    @Override
    public String toString() {
        return "Route{" + "type: "+ collection.getClass().getSimpleName() + "," + "size: "+ collection.size() +"," +
                "initDate: " + initDate + '\'' +
                '}';
    }

}
