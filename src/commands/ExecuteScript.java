package commands;

import dao.RouteDAO;
import exceptions.EmptyInputException;
import file.CSVFileReader;
import utils.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Класс команды EXECUTE SCRIPT, предназначенный для чтения и исполнения скрипта из файла
 */
public class ExecuteScript extends ACommands{

    file.CSVFileReader reader = new CSVFileReader();
    RouteDAO dao = reader.read();
    public void execute(RouteDAO routeDAO) {

        String nameOfScript = args.get(0);
        if (ExecuteReader.checkNameOfFileInList(nameOfScript)) {
            ExecuteReader.listOfNamesOfScripts.add(nameOfScript);
            try {

                List<String> listOfCommands = Files.readAllLines(Paths.get(nameOfScript + ".txt").toAbsolutePath());
                for (String lineOfFile : listOfCommands
                ) {
                    ACommands commands;
                    String command = lineOfFile.trim();
                    Map<String, String> ids = new HashMap<>();

                    if (command.isEmpty()) {
                        throw new EmptyInputException();
                    }
                    List<String> args = new ArrayList<>(Arrays.asList(command.split(" ")));
                    try {
                        commands = CommandSaver.getCommand(args);
                        commands.execute(dao);
                    } catch (RuntimeException e) {
                        System.out.println("ты норм? в скрипте параша написана, переделывай");
                    }
                }
            } catch (IOException e) {
                System.out.printf("Все пошло по пизде, чекай мать: " + System.lineSeparator());
                e.printStackTrace();
            }
            ExecuteReader.listOfNamesOfScripts.clear();
        } else {
            System.out.println("пу пу пу.... обнаружена рекурсия");
        }
    }

}

