package commands;

import dao.RouteDAO;
/**
 * Класс команды HEAD, предназначенный для вывода первого элемента коллекции
 */
public class Head extends ACommands{

    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            System.out.println("пусто...");
        } else {
            System.out.println(routeDAO.printFirst());
        }
    }

}
