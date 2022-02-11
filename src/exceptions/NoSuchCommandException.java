package exceptions;

public class NoSuchCommandException extends RuntimeException{
    public NoSuchCommandException(){
        super("Введённой вами команды не существует. Попробуйте ввести другую команду.");
    }
}
