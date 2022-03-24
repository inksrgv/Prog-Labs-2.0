package commands;

import dao.RouteDAO;
import file.FileWriter;

import static console.ConsoleOutputer.output;
/**
 * Класс команды SAVE, предназначенный для сохранения элементов в коллекцию
 */
public class Save extends ACommands{
    FileWriter writer = new FileWriter();
    public void execute(RouteDAO routeDAO) {
        try {
            writer.write(routeDAO);

        } catch (RuntimeException e) {
            System.out.println("не удалось сохранить коллекцию " + e.getMessage() + System.lineSeparator());
            e.printStackTrace();
        }
    }
}
