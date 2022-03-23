package commands;

import dao.RouteDAO;
import utils.Route;
import java.util.HashSet;
import java.util.Set;

import static console.ConsoleOutputer.output;
/**
 * Класс команды CLEAR, предназначенный для очистки коллекции
 */
public class Clear extends ACommands{
    static Set<Integer> distanceSet = new HashSet<>();

    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            System.out.println("невозможно очистить пустую коллекцию");
        } else {
            for (Route route : routeDAO.getAll()) {
                distanceSet.add(route.getDistance());
            }
            for (int i = 1; i < routeDAO.getAll().size() + 1; i++)
                routeDAO.delete(i);
            routeDAO.clear();
            distanceSet.clear();
            output("коллекция очищена");
        }
    }
}
