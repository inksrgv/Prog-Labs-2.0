package commands;

import dao.RouteDAO;
import console.Console;
import utils.Route;
import utils.RouteInfo;

import java.util.*;
/**
 * Класс команды ADD IF MIN, предназначенный для добавления элементов в коллекцию, если он является наименьшим
 */
public class AddIfMin extends ACommands{

    List<Integer> distanceList = new ArrayList<>();
    Console console = new Console();
    Scanner sc = new Scanner(System.in);
    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            System.out.println("коллекция пустая, не с чем сравнивать");
        } else {
            while (true) {
                try {
                    for (Route route : routeDAO.getAll()) {
                        distanceList.add(route.getDistance());
                    }
                    Collections.sort(distanceList);
                    if (distanceList.get(0) == 2) {
                        System.out.println("в коллекции уже содержится элемент с минимальным допустимым значением сравниваемого поля");
                        distanceList.clear();
                        break;
                    } else {
                        RouteInfo info = console.info();
                        if (info.distance < distanceList.get(0)) {
                            Route route = new Route(info.name, info.x, info.y, info.fromX,
                                    info.fromY, info.nameFrom, info.toX, info.toY, info.nameTo,
                                    info.distance);
                            routeDAO.create(route);
                            System.out.println("новый элемент успешно добавлен в коллекцию");
                            distanceList.clear();
                            break;
                        } else {
                            System.out.println("новый элемент коллекции больше чем минимальный элемент.");
                            System.out.println(" \uD83E\uDD2Cأدخل عنصرًا آخر");
                            if (Objects.equals(sc.nextLine(), "exit")) {
                                break;
                            }
                        }
                    }
                } catch (RuntimeException e) {
                    System.out.println(" невозможно добавить элемент в коллекцию");
                }
            }
        }
    }

}
