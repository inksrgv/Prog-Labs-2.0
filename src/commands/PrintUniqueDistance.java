package commands;

import dao.RouteDAO;
import utils.Route;

import java.util.HashSet;
import java.util.Set;
/**
 * Класс команды PRINT UNIQUE DISTANCE, предназначенный для вывода значения уникального поля distance
 */
public class PrintUniqueDistance extends ACommands{

    static Set<Integer> distanceSet = new HashSet<>();

    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            System.out.println("коллекция пустая. нечего выводить");
        } else {
            for (Route route1 : routeDAO.getAll()) {
                distanceSet.add(route1.getDistance());
            }
            System.out.println("уникальные значения поля distance: " + distanceSet.toString());
        }
    }

}
