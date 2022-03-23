package commands;

import dao.RouteDAO;

import static console.ConsoleOutputer.output;
/**
 * Класс команды SHOW, предназначенный для вывода коллекции на консоль
 */
public class Show extends ACommands {
    @Override
    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            output("коллекция пустая");
        }
        else
            System.out.println(routeDAO.getCollection());
    }
}