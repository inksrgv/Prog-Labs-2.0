package utils;

import dao.*;
import file.FileWriter;

import java.util.*;

import static io.ConsoleOutputer.output;


abstract class ACommands {
    protected List<String> args;
    protected void addArgs(List<String> args) {
        this.args = args;
    }
    public void execute(RouteDAO routeDAO){ }
}


public class Commands {
    static FileWriter writer = new FileWriter();
    static Scanner sc = new Scanner(System.in);
    static Console console = new Console();

    private static class CommandSaver {
        public static final Map<String, ACommands> commandsMap = new LinkedHashMap<>();

        static {
            commandsMap.put("help", new Help());
            commandsMap.put("info", new Info());
            commandsMap.put("show", new Show());
            commandsMap.put("add", new AddElement());
            commandsMap.put("update_by_id", new UpdateById());
            commandsMap.put("remove_by_id", new RemoveById());
            commandsMap.put("clear", new Clear());
            commandsMap.put("save", new Save());
            //execute script
            commandsMap.put("exit", new Exit());
            commandsMap.put("remove_first", new RemoveFirst());
            commandsMap.put("head", new Head());
            //add_if_min
            commandsMap.put("print_unique_distance", new PrintUniqueDistance());
            //print_field_ascending_distance
            //print_field_descending_distance
        }

        public static ACommands getCommand(List<String> input) {
            ACommands command = commandsMap.get(input.get(0));
            input.remove(0);
            command.addArgs(input);
            return command;
        }
    }

    public static void runApp() {
        RouteDAO dao = new RouteDAO();
        ACommands commands;
        ConsoleReader consoleReader = new ConsoleReader();
        System.out.println("Для того чтобы начать введите команду. Чтобы увидеть список доступных команд введите help");
        while(true) {
            try {
                commands = CommandSaver.getCommand(consoleReader.reader());
                commands.execute(dao);
            } catch (RuntimeException e) {
                System.out.println("Введённой вами команды не существует. Попробуйте ввести другую команду.");
            }
        }
    }


    static class Help extends ACommands {


        @Override
        public void execute(RouteDAO routeDAO) {

            System.out.println("help : вывести справку по доступным командам ");
            System.out.println("info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) ");
            System.out.println("show: " + "вывести в стандартный поток вывода все элементы коллекции в строковом представлении ");
            System.out.println("add {element} : " + "добавить новый элемент в коллекцию ");
            System.out.println("update id {element} : " + "обновить значение элемента коллекции, id которого равен заданному ");
            System.out.println("remove_by_id id :" + "удалить элемент из коллекции по его id ");
            System.out.println("clear :  " + "очистить коллекцию ");
            System.out.println("save: " + "сохранить колекцию в файл ");
            System.out.println("execute_script file_name :" + "считать и исполнить скрипт из указанного файла.");
            System.out.println(" В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            System.out.println("exit: " + "завершить программу (без сохранения в файл) ");
            System.out.println("remove_first : " + "удалить первый элемент из коллекции ");
            System.out.println("head : " + "вывести первый элемент коллекции ");
            System.out.println("add_if_min {element} : " + "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции ");
            System.out.println("print_unique_distance : " + "вывести уникальные значения поля distance всех элементов в коллекции ");
            System.out.println("print_field_ascending_distance :  " + "вывести значения поля distance всех элементов в порядке возрастания ");
            System.out.println("print_field_descending_distance :  вывести значения поля distance всех элементов в порядке убывания ");

        }

    }

    static class Info extends ACommands {

        public void execute(RouteDAO routeDAO) {
            if (Objects.equals(routeDAO.getDescription().toString(), "{}")) {
                System.out.println("коллекция пустая. нечего показывать");
            } else {
                output(routeDAO.getDescription().toString());
            }
        }
    }

    static class Show extends ACommands {
        @Override
        public void execute(RouteDAO routeDAO) {
            if (routeDAO.getAll().size() == 0) {
                output("коллекция пустая");
            }
            System.out.println(routeDAO.getCollection().toString());
        }
    }

    static class AddElement extends ACommands {

        public void execute(RouteDAO routeDAO) {

            try {
                RouteInfo info = console.info();
                Route route = new Route(info.name, info.x, info.y, info.fromX,
                        info.fromY, info.nameFrom, info.toX, info.toY, info.nameTo,
                        info.distance);
                routeDAO.create(route);
            } catch (RuntimeException e) {
                System.out.println(" невозможно добавить элемент в коллекцию");
            }
            output("элемент добавлен в коллекцию");
        }
    }


    static class UpdateById extends ACommands {

        public void execute(RouteDAO routeDAO) {
            if (routeDAO.getAll().size() == 0) {
                System.out.println("коллекция пустая. нечего обновлять");
            } else {
                System.out.println("введите параметры для обновления");
                int id = sc.nextInt();
                try {
                    id = Integer.parseInt(args.get(0));
                } catch (RuntimeException e) {
                    output("введите тип данных int");
                }
                boolean flag = false;
                for (Route route : routeDAO.getAll()) {
                    if (route.getId() == id) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("элемента с таким id нет");
                }
                try {
                    RouteInfo info = console.info();

                    Route route = new Route(info.name, info.x, info.y, info.fromX,
                            info.fromY, info.nameFrom, info.toX, info.toY, info.nameTo,
                            info.distance);
                    routeDAO.update(id, route);
                } catch (RuntimeException e) {
                    output("типы данных полей не совпали");
                }
                output("элемент коллекции обновлен");
            }
        }
    }


    static class RemoveById extends ACommands {
        public void execute(RouteDAO routeDAO) {
            if (routeDAO.getAll().size() == 0) {
                System.out.println("коллекция пустая. нечего удалять");}
            else {
                System.out.println("введите id");
                try {
                    int id = sc.nextInt();
                    for (Route route : routeDAO.getAll()) {
                        if (route.getId() == id) {
                            routeDAO.delete(route);
                            System.out.println("элемент удален");
                            break;
                        } else {
                            System.out.println("нет элемента с таким id");
                            break;
                        }
                    }
                } catch (RuntimeException e) {
                    System.out.println("невозможно удалить элемент");
                }
            }
        }
    }

    static class Clear extends ACommands {

            public void execute(RouteDAO routeDAO) {
                if (routeDAO.getAll().size() == 0) {
                    System.out.println("невозможно очистить пустую коллекцию");
                } else {
                    routeDAO.clear();
                    output("коллекция очищена");
                }
            }
        }

    static class Save extends ACommands {
            public void execute(RouteDAO routeDAO) {
                if (routeDAO.getAll().size() == 0) {
                    System.out.println("коллекция пустая. нечего сохранять");
                } else {
                    try {
                        writer.write(routeDAO);
                        output("коллекция успешно сохранена");

                    } catch (RuntimeException e) {
                        output("не удалось сохранить коллекцию " + e.getMessage());
                    }
                }
            }
        }

    static class RemoveFirst extends ACommands {

            public void execute(RouteDAO routeDAO) {
                if (routeDAO.getAll().size() == 0) {
                    System.out.println("коллекция пустая. нечего удалять");
                } else {
                    Route toDelete = routeDAO.toDelete();

                    routeDAO.delete(toDelete);

                    output("первый элемент коллекции успешно удален");
                }
            }
        }

    static class Head extends ACommands {
        public void execute(RouteDAO routeDAO){
            System.out.println(routeDAO.printFirst());
        }
    }
//TODO у дву элементов коллекции айди одинаковые еб твою мать)

    static class PrintUniqueDistance extends ACommands {
        public void execute(RouteDAO routeDAO) {
            if (routeDAO.getAll().size() == 0) {
                System.out.println("коллекция пустая. нечего выводить");
            } else {
                for (Route route : routeDAO.getAll()) {
                    System.out.println("distance: " + route.getDistance());
                }
            }
        }
    }

    static class Exit extends ACommands{
        public void execute(RouteDAO routeDAO){
            System.exit(0);
        }
    }
}




