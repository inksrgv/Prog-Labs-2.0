package commands;

import dao.RouteDAO;
import file.CSVFileReader;

import static console.ConsoleOutputer.output;
/**
 * Класс команды SHOW, предназначенный для вывода коллекции на консоль
 */
public class Show extends ACommands {
    CSVFileReader reader = new CSVFileReader();
    @Override
    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            output("коллекция пустая");
        }
        else
            System.out.println(routeDAO.getCollection()  );

//Route{type: ArrayDeque,size: 1,initDate: 23.03.2022 : 21.51.35'}
    }
}