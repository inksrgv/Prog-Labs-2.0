package commands;

import dao.RouteDAO;

import static console.ConsoleOutputer.output;
/**
 * Класс команды REMOVE FIRST, предназначенный для удаления первого элемента из коллекции
 */
public class RemoveFirst extends ACommands{

    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            System.out.println("коллекция пустая. нечего удалять");
        } else {
            routeDAO.removeFirst();
            output("первый элемент коллекции успешно удален");
        }
    }

}
