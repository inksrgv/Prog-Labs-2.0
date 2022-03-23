package commands;

import dao.RouteDAO;
import exceptions.ExitException;

import java.util.NoSuchElementException;
/**
 * Класс команды EXIT, предназначенный для выхода из выполнения программы
 */
public class Exit extends  ACommands{

    public void execute(RouteDAO routeDAO) {
        System.out.println("пока.");
        try {
            System.exit(0);
        }
        catch (NoSuchElementException e){
            throw new ExitException("пока..............");
        }
    }

}
