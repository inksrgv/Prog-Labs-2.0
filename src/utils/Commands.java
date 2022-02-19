package utils;

import dao.*;
import file.FileSaver;

import java.util.*;

import static io.ConsoleOutputer.output;


abstract class ACommands {
    protected List<String> args;
    protected void addArgs(List<String> args) {
        this.args = args;
    }
    public int execute(RouteDAO routeDAO){ return 0;}
}


public class Commands {
    FileSaver saver = new FileSaver();

    private class CommandSaver{
        private final Map<String, ACommands> commandsMap = new LinkedHashMap<>();

        public CommandSaver() {
            commandsMap.put("help", new Help());
            commandsMap.put("info", new Info());
            commandsMap.put("show", new Show());
            commandsMap.put("add", new AddElement());
            commandsMap.put("update_by_id", new UpdateById());
            commandsMap.put("remove_by_id", new RemoveById());
            commandsMap.put("clear", new Clear());
            commandsMap.put("save", new Save()); //я вообще не знаю можно ли args в скобки написать))0)
            //execute script
            //exit
            commandsMap.put("remove_first", new RemoveFirst());
            commandsMap.put("head", new Head());
            //add_if_min
            //print_unique_distance
            //print_field_ascending_distance
            //print_field_descending_distance
        }

        public ACommands getCommand(List<String> input) {
            ACommands command = commandsMap.get(input.get(0));
            input.remove(0);
            command.addArgs(input);
            return command;
        }
    }


    static class Help extends ACommands {


        @Override
        public int execute(RouteDAO routeDAO) {

            System.out.println("help : вывести справку по доступным командам ");
            System.out.println("info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) ");
            System.out.println("show: " +"вывести в стандартный поток вывода все элементы коллекции в строковом представлении ");
            System.out.println("add {element} : "+ "добавить новый элемент в коллекцию ");
            System.out.println("update id {element} : "+"обновить значение элемента коллекции, id которого равен заданному ");
            System.out.println("remove_by_id id :"+"удалить элемент из коллекции по его id ");
            System.out.println("clear :  "+"очистить коллекцию ");
            System.out.println("save: "+ "сохранить колекцию в файл ");
            System.out.println("execute_script file_name :"+"считать и исполнить скрипт из указанного файла.");
            System.out.println(" В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            System.out.println("exit: "+"завершить программу (без сохранения в файл) ");
            System.out.println("remove_first : "+"удалить первый элемент из коллекции ");
            System.out.println("head : "+"вывести первый элемент коллекции ");
            System.out.println("add_if_min {element} : "+"добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции ");
            System.out.println("print_unique_distance : "+"вывести уникальные значения поля distance всех элементов в коллекции ");
            System.out.println("print_field_ascending_distance :  "+"вывести значения поля distance всех элементов в порядке возрастания ");
            System.out.println("print_field_descending_distance :  вывести значения поля distance всех элементов в порядке убывания ");
            return 0;
        }

    }


    class Info extends ACommands {


        @Override
        public int execute(RouteDAO routeDAO) {
            output(routeDAO.getDescription().toString()); // попробуем....
            return 0;
        }
    }

    class Show extends ACommands {


        @Override
        public int execute(RouteDAO routeDAO) {

            if (routeDAO.getAll().size() == 0){
                output("коллекция пустая");
                return 0;
            }
            for (Route route : routeDAO.getAll())
                output(route);

            return 0;
        }
    }


    class AddElement extends ACommands {


        public int execute(RouteDAO routeDAO) {

            try{
                RouteInfo info = new RouteInfo();

                info.name = args.get(0);
                info.x = Double.parseDouble(args.get(1));
                info.y = Double.parseDouble(args.get(2));
                if(info.y < -210){
                    output("значение поля Y недопустимо");
                    return -1;}

                info.fromX = Double.parseDouble(args.get(3));
                info.fromY = Long.parseLong(args.get(4));
                info.nameFrom = args.get(5);

                info.toX = Integer.parseInt(args.get(6));
                info.toY = Float.parseFloat(args.get(7));
                info.nameTo = args.get(8);

                info.distance = Integer.parseInt(args.get(9));
                Route route = new Route(info.name, info.x, info.y, info.fromX,
                        info.fromY, info.nameFrom, info.toX, info.toY, info.nameTo,
                        info.distance);
                routeDAO.create(route);
            } catch (RuntimeException e){
                output(" невозможно добавить элемент в коллекцию");
                return -1;
            }
            output("элемент добавлен в коллекцию");
            return 0;
        }
    }


    class UpdateById extends ACommands {

        //исключения урааааааааааааааааааааааа
        public int execute(RouteDAO routeDAO) {
            int id;
            try{
                id = Integer.parseInt(args.get(0));
            }
            catch (RuntimeException e){
                output("введите тип данных int");
                return -1;
            }

            boolean flag = false;
            for (Route route: routeDAO.getAll()){
                if (route.getId() == id){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                output("элемента с таким id нет");
            }
            try{
                RouteInfo info = new RouteInfo();

                info.name = args.get(1);
                info.x = Double.parseDouble(args.get(2));
                info.y = Double.parseDouble(args.get(3));
                if(info.y < -210){
                    output("значение поля Y недопустимо");
                    return -1;}

                info.fromX = Double.parseDouble(args.get(4));
                info.fromY = Long.parseLong(args.get(5));
                info.nameFrom = args.get(6);

                info.toX = Integer.parseInt(args.get(7));
                info.toY = Float.parseFloat(args.get(8));
                info.nameTo = args.get(9);

                info.distance = Integer.parseInt(args.get(10));
                Route route = new Route(info.name, info.x, info.y, info.fromX,
                        info.fromY, info.nameFrom, info.toX, info.toY, info.nameTo,
                        info.distance);
                routeDAO.update(id, route);
            }
            catch (RuntimeException e){
                output("типы данных полей не совпали");
                return -1;
            }
            output("элемент коллекции обновлен");
            return 0;
        }
    }


    class RemoveById extends ACommands{

        public int execute(RouteDAO routeDAO){
            output("введите id");
            try {
                int id = Integer.parseInt(args.get(0));
                for (Route route : routeDAO.getAll()){
                    if (route.getId() == id){
                        routeDAO.delete(id);
                        output("элемент удален");
                    }
                    else{
                        output("нет элемента с таким id");
                        return -1;
                    }
                }
            }
            catch (RuntimeException e){
                output("введите число типа int");
                return -1;
            }
            return 0;
        }
    }

    class Clear extends ACommands{

        public int execute(RouteDAO routeDAO){
            routeDAO.clear(); // /neg
            output("коллекция очищена");
            return 0;}
    }

    class Save extends ACommands{

        public int execute(RouteDAO routeDAO){
            try{
                saver.save(routeDAO);
                output("коллекция успешно сохранена");
                return 0;
            }
            catch (RuntimeException e){
                output("не удалось сохранить коллекцию" + e.getMessage());
            }
            return -1;
        }
    }

    class RemoveFirst extends ACommands{

        public int execute(RouteDAO routeDAO){
            int toDeleteId = routeDAO.toDelete().getId();

            routeDAO.delete(toDeleteId);

            output("первый элемент коллекции успешно удален");

            return 0;
        }
    }

    class Head extends ACommands{

        public int execute(RouteDAO routeDAO){
            routeDAO.printFirst();
            return 0;
        }

    }
}




