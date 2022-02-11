package commands;

public class HelpCommand implements Commands {

    public static String helpCommand; {
        System.out.println("help : вывести справку по доступным командам \n " +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д. \n " +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n add {element} : добавить новый элемент в коллекцию \n " +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному \n " +
                "remove_by_id id : удалить элемент из коллекции по его id \n" +
                "clear : очистить коллекцию \n save : сохранить коллекцию в файл \n " +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме \n" +
                "exit : завершить программу (без сохранения в файл) \n remove_first : удалить первый элемент из коллекции \n " +
                "head : вывести первый элемент коллекции \n add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции \n" +
                " print_unique_distance : вывести уникальные значения поля distance всех элементов в коллекции \n" +
                "print_field_ascending_distance : вывести значения поля distance всех элементов в порядке возрастания \n" +
                "print_field_descending_distance : вывести значения поля distance всех элементов в порядке убывания");
    }

    public String describe() {
        return helpCommand;
    }
}

