package commands;

import dao.RouteDAO;
import exceptions.ExitException;
import console.Console;
import utils.Route;
import utils.RouteInfo;

import java.util.NoSuchElementException;

import static console.ConsoleOutputer.output;
/**
 * Класс команды ADD, предназначенный для добавления элемента в коллекцию
 */
public class Add extends ACommands{
    Console console = new Console();
    public void execute(RouteDAO routeDAO) {
        try {
            RouteInfo info = console.info();
            Route route = new Route(info.name, info.x, info.y, info.fromX,
                    info.fromY, info.nameFrom, info.toX, info.toY, info.nameTo,
                    info.distance);
            routeDAO.create(route);
        }catch (NoSuchElementException e){throw new ExitException(e.getMessage());}
        catch (RuntimeException e) {
            System.out.println("невозможно добавить элемент в коллекцию");
            return;
        }
        output("элемент добавлен в коллекцию");
    }
}
