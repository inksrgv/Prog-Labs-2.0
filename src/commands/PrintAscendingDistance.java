package commands;

import dao.RouteDAO;
import utils.Route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Класс команды PRINT ASCENDING DISTANCE, предназначенный для вывода значений поля distance в порядке возрастания
 */
public class PrintAscendingDistance extends ACommands{

    static List<Integer> distanceList = new ArrayList<>();

    public void execute(RouteDAO routeDAO) {
        for (Route route : routeDAO.getAll()) {
            distanceList.add(route.getDistance());
        }
        if (routeDAO.getAll().size() == 0) {
            System.out.println("коллекция пустая. нечего выводить");

        } else {

            Collections.sort(distanceList);
            System.out.println("значения поля distance всех элементов в порядке возрастания: ");
            System.out.println(distanceList);
            distanceList.clear();
        }

    }

}
