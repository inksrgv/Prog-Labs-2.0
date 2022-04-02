package commands;

import dao.RouteDAO;
import exceptions.EmptyInputException;
import exceptions.ExitException;
import file.CSVFileReader;
import console.ConsoleReader;
import utils.IdGenerator;

import java.util.NoSuchElementException;

public class Commands {
    static CSVFileReader reader = new CSVFileReader();
    static RouteDAO dao = reader.read();
    /**
     * Метод для запуска программы. Вывод на консоль начала работы программы.
     */
    public static void run() {
        IdGenerator.reloadId(dao);
        ACommands commands;
        ConsoleReader consoleReader = new ConsoleReader();
        System.out.println("\t\t\t\t\t▒██░░░─░▄█▀▄─░▐█▀▄──░▄█▀▄─     ▒█▀▀ \n" +
                "\t\t\t\t\t▒██░░░░▐█▄▄▐█░▐█▀▀▄░▐█▄▄▐█     ▒▀▀▄ \n" +
                "\t\t\t\t\t▒██▄▄█░▐█─░▐█░▐█▄▄▀░▐█─░▐█     ▒▄▄▀ ");
        System.out.println("\t\t\t\t\t\tNika and Sofia production\n");
        System.out.println("Для того чтобы начать введите команду. Чтобы увидеть список доступных команд введите help");
        while (true) {
            try {
                commands = CommandSaver.getCommand(consoleReader.reader());
                commands.execute(dao);
            } catch (NullPointerException e) {
                System.out.println("Введённой вами команды не существует. Попробуйте ввести другую команду.");
            }
            catch (NoSuchElementException e){ throw new ExitException("пока............");}
            catch (EmptyInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Метод, который предназначен для обработки исключения бесконечного вывода потока
     */

    public static void runApp(){
        while (true){
            try{
                run();
            }
            catch (ExitException e){
                System.out.println(e.getMessage());
                break;
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}