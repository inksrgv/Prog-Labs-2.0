package commands;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**f
 * Класс, предназначенный для добавления классов команд
 */
public class CommandSaver {
    static final Map<String, ACommands> commandsMap = new LinkedHashMap<>();
    static {
        commandsMap.put("help", new Help()); //done
        commandsMap.put("info", new Info()); //done
        commandsMap.put("show", new Show()); //done
        commandsMap.put("add", new Add()); //done
        commandsMap.put("update_by_id", new UpdateById()); //done
        commandsMap.put("remove_by_id", new RemoveById()); //done
        commandsMap.put("clear", new Clear());
        commandsMap.put("save", new Save());
        commandsMap.put("execute_script", new ExecuteScript());
        commandsMap.put("exit", new Exit());
        commandsMap.put("remove_first", new RemoveFirst());
        commandsMap.put("head", new Head());
        commandsMap.put("add_if_min", new AddIfMin()); //done
        commandsMap.put("print_unique_distance", new PrintUniqueDistance());
        commandsMap.put("print_field_ascending_distance", new PrintAscendingDistance());
        commandsMap.put("print_field_descending_distance", new PrintDescendingDistance());
        commandsMap.put("secret_command_only_for_alex_egoshin", new Rzhaka());

    }
    /**
     * Добавление на консоль команд
     *
     * @param input
     * @return command
     */
    public static ACommands getCommand(List<String> input) {
        ACommands command = commandsMap.get(input.get(0));
        input.remove(0);
        command.addArgs(input);
        return command;
    }
}

