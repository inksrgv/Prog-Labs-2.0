package commands;

import dao.RouteDAO;

import static console.ConsoleOutputer.output;
/**
 * Класс команды INFO, предназначенный для вывода информации об элементах коллекции. Вывод осуществляется с помощью команды getDescription.
 */
public class Info extends ACommands {
    public void execute(RouteDAO routeDAO) {
        output(routeDAO.toString());
    }
}
