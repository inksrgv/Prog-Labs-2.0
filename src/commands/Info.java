package commands;

import dao.RouteDAO;
import file.CSVFileReader;

import static console.ConsoleOutputer.output;
/**
 * Класс команды INFO, предназначенный для вывода информации об элементах коллекции. Вывод осуществляется с помощью команды getDescription.
 */
public class Info extends ACommands {
    CSVFileReader reader = new CSVFileReader();
    public void execute(RouteDAO routeDAO) {
        //System.out.println(reader.read());
        System.out.println(routeDAO.toString());
    }
}
