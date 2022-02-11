package exceptions;

public class InvalidNameException extends  RuntimeException{
    public InvalidNameException() {super ("строка не может быть пустой");}
}
