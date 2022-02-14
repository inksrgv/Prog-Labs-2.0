package collection;

import exceptions.CannotClearCollectionException;
import utils.Route;

import java.util.*;

//этот идиотина считает что методы updateById, add, addIfMin не имплементированы)))
public class RouteCollectionManager implements  CollectionManager{ //еще пицот раз доработать

    private ArrayDeque<Route> collection;
    private java.time.ZonedDateTime initDate;
    private HashSet<Integer> uniqueId;
    public RouteCollectionManager() {
        uniqueId = new HashSet<>();
        collection = new ArrayDeque<>();
        initDate = java.time.ZonedDateTime.now();
    }

    public int IdGenerator() {
        if (collection.isEmpty()) return 1;
        else{
            Random rn = new Random();
            Integer id = rn.nextInt();//геттер надо добавить .....какой геттер я забыла(((
            // Integer id = collection.lastElement().getId() + 1;
            if (uniqueId.contains(id)){
                while (uniqueId.contains(id)) id += 1;
            }
            uniqueId.add(id);
            return id;
        }
    }


    public void sort(){
        collection.stream().sorted(); //???????
    }
    /**
     * @return Collection
     */
    public ArrayDeque<Route> getCollection(){ return collection;}

    //@Override
    public void add(Route route) {
        route.setId(IdGenerator());
        collection.add(route);
        System.out.println("добавлен элемент коллекции");
        System.out.println(route.toString());
    }

    /**
     * @return Information
     */
    public String getInfo(){
        return ""; //не знаю пока что сюда написать
    }

    /**
     * @return is it used
     */
    public boolean checkId(Integer id){
        for (Route route: collection){
            if (route.getId() == id){ return true; }

        }
        return false;
    }

    /**
     * @param id ID
     */
    public void removeById(Integer id){
        for (Route route : collection){
            if (route.getId() == id){
                collection.remove(route);
                uniqueId.remove(id);
                System.out.println("элемент " + Integer.toString(id) +  "удален");
                return;
            }
        }
    }


    /**
     *
     * @param id
     * @param newRoute
     */
    public void updateById(Integer id, Route newRoute) {
        int indx = 0;
        for (Route route : collection){
            if (route.getId() == id){
                newRoute.setId(id);
                //collection.set(indx, newRoute); у arrayDequeue нет метода set...
                System.out.println("элемент " + Integer.toString(id) + "обновлен");
                return;
            }
            indx += 1;
        }

    }


    /**
     * @return size of collection
     */
    public int getSize(){ return collection.size(); }

    public void clear() { //может быть не тут надо их ловить...хз
        try {
            if (!collection.isEmpty()) {
                collection.clear();
                uniqueId.clear();
            }
        }
        catch (CannotClearCollectionException e){
            throw new CannotClearCollectionException();
        }

    }

    public void removeFirst(){
        collection.removeFirst();
        //сообщение пусть потом напишется какое нибудь
    }


    /**
     *
     * @param route
     */
    public void addIfMin(Route route) {
        for (Route Route : collection){
            if (route.compareTo(Route) == 1){
                System.out.println("невозможно добавить");
                return;
            }
        }
        add(route);

    }

    public void startsWithName(String start){
        ArrayDeque<Route> arr = new ArrayDeque<>();
        for (Route route : collection){
            if (route.getName().startsWith(start.trim())){
                arr.add(route);
            }
        }
        if (arr.isEmpty()) System.out.println("нет элементов которые начинаются на " + start);
        else {
            System.out.println("начинается с " + start);
            for (Route route : collection){
                System.out.println(route.toString());
            }
        }
    }

    public void printDistance(){
        ArrayDeque<Integer> dist = new ArrayDeque<>();
        System.out.println("расстояние: ");
        for (Route route : collection){
            if (!dist.contains(route.getDistance())){
                System.out.println(route.getDistance());
                dist.add(route.getDistance());
            }
        }
    }
}
