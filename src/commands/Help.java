package commands;

import dao.RouteDAO;
/**
 * Класс команды HELP, предназначенной для выведения списка команд и их возможностей
 */
public class Help extends ACommands {


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
        System.out.println("secret_command_only_for_alex_egoshin: новая попытка защиты, новый сюрприз специально только для alex_egosin!!!");

    }

}