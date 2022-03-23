package commands;

import dao.RouteDAO;
import console.Console;
import utils.Route;
import utils.RouteInfo;

import static console.ConsoleOutputer.output;
/**
 * Класс команды UPDATE BY ID, предназначенный для обновления элемента по его id.
 *
 * @param
 */
public class UpdateById extends ACommands {
    Console console = new Console();
    public void execute(RouteDAO routeDAO) {

        int idFromConcole = Integer.parseInt(args.get(0));

        if (routeDAO.getAll().size() == 0) {
            System.out.println("коллекция пустая. нечего обновлять");
        } else {

            boolean flag = false;

            for (Route route : routeDAO.getAll()) {
                if (route.getId() == idFromConcole) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println("элемента с таким id нет. ведите другой id");
            else {
                try {
                    RouteInfo info = console.info();
                    routeDAO.update(idFromConcole, info);
                } catch (RuntimeException e) {
                    output("неверный ввод");
                }
                output("элемент коллекции обновлен");
            }

        }
    }

}
